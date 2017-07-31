package com.pacbio.secondary.smrtlink.mail

import java.net.URL
import javax.mail.internet.InternetAddress

import courier._
import com.pacbio.secondary.analysis.jobs.JobModels.{EngineJob, JobTypeIds}
import com.pacbio.secondary.smrtlink.mail.MailTemplates.{EmailJobFailedTemplate, EmailJobSuccessTemplate}
import com.typesafe.scalalogging.LazyLogging

import scala.util.control.NonFatal
import scala.concurrent.Future

/**
  * Created by mkocher on 7/21/17.
  */
trait PbMailer extends LazyLogging{
  import Defaults._

  /**
    * Thin layer around the courier lib to send an email
    *
    * @param result      Email Template result
    * @param toAddress   To Address
    * @param fromAddress From Address
    * @return
    */
  private def sender(result: EmailTemplateResult, toAddress: InternetAddress, fromAddress: InternetAddress = new InternetAddress("noreply@pacb.com")):Future[Unit] = {
    val mailer = Mailer()

    val f = mailer(Envelope.from(fromAddress)
        .to(toAddress)
        .subject(result.subject)
        .content(Multipart().html(result.html)))

    f.onSuccess { case _ => logger.info(s"Successfully Sent Email $toAddress")}
    f.onFailure { case NonFatal(ex) => logger.error(s"Failed to send Email. Error ${ex.getMessage}")}

    f
  }

  /**
    * Send email (if possible)
    *
    * The Job must have the required files defined (i.e., non-optional) and the job must be in a completed state
    *
    * @param job Engine Job
    * @param jobsBaseUrl Base Job URL Example: https://smrtlink-bihourly.nanofluidics.com:8243/sl/#/analysis/jobs
    */
  def sendEmail(job: EngineJob, jobsBaseUrl: URL): Unit = {

    Tuple2(job.createdByEmail, job.jobTypeId) match {
      case Tuple2(Some(email), JobTypeIds.PBSMRTPIPE.id) if job.isComplete =>
        // Note, because of the js "#" the URL or URI resolving doesn't work as expected.
        val jobIdUrl = new URL(jobsBaseUrl.toString() + s"/${job.id}")
        val toAddress = new InternetAddress(email)

        val emailInput = SmrtLinkEmailInput(toAddress, job.id, job.name, job.state, job.createdAt, job.updatedAt, jobIdUrl, job.smrtlinkVersion)
        val result = if (job.isSuccessful) EmailJobSuccessTemplate(emailInput) else EmailJobFailedTemplate(emailInput)
        logger.info(s"Attempting to send email with input $emailInput")
        sender(result, toAddress)
      case _ =>
        val msg = s"Unable to send email. BaseUrl:$jobsBaseUrl Address:${job.createdByEmail} JobType:${job.jobTypeId} JobId: ${job.id} state: ${job.state}"
        logger.debug(msg)
    }
  }
}
