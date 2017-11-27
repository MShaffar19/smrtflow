package com.pacbio.simulator.steps

import java.util.UUID
import java.nio.file.Path

import com.pacbio.common.models.CommonModels.{IdAble, IntIdAble, UUIDIdAble}

import scala.concurrent.Future
import scala.concurrent.duration._
import scala.util.control.NonFatal
import com.pacbio.common.models._
import com.pacbio.secondary.smrtlink.analysis.datasets.DataSetFileUtils
import com.pacbio.secondary.smrtlink.analysis.datasets.DataSetMetaTypes.DataSetMetaType
import com.pacificbiosciences.pacbiodatasets._
import com.pacbio.secondary.smrtlink.analysis.reports.ReportModels
import com.pacbio.secondary.smrtlink.analysis.jobs.JobModels._
import com.pacbio.secondary.smrtlink.analysis.jobs.OptionTypes.{BOOL, INT}
import com.pacbio.secondary.smrtlink.client.SmrtLinkServiceAccessLayer
import com.pacbio.secondary.smrtlink.models._
import com.pacbio.simulator.Scenario
import com.pacbio.simulator.StepResult._
import com.typesafe.scalalogging.LazyLogging

trait SmrtLinkSteps extends LazyLogging { this: Scenario with VarSteps =>

  import CommonModelImplicits._
  import ReportModels._

  val smrtLinkClient: SmrtLinkServiceAccessLayer

  def andLog(sx: String): Future[String] = Future {
    logger.info(sx)
    sx
  }

  case object GetStatus extends VarStep[Int] {
    override val name = "GetStatus"
    override def runWith = smrtLinkClient.getStatus.map(_ => 0)
  }

  case object GetRuns extends VarStep[Seq[RunSummary]] {
    override val name = "GetRuns"
    override def runWith = smrtLinkClient.getRuns

  }

  case class GetRun(runId: Var[UUID]) extends VarStep[Run] {
    override val name = "GetRun"
    override def runWith = smrtLinkClient.getRun(runId.get)
  }

  case class GetCollections(runId: Var[UUID])
      extends VarStep[Seq[CollectionMetadata]] {
    override val name = "GetCollections"
    override def runWith = smrtLinkClient.getCollections(runId.get)
  }

  case class GetCollection(runId: Var[UUID], collectionId: Var[UUID])
      extends VarStep[CollectionMetadata] {
    override val name = "GetCollection"
    override def runWith =
      smrtLinkClient.getCollection(runId.get, collectionId.get)

  }

  case class CreateRun(dataModel: Var[String]) extends VarStep[UUID] {
    override val name = "CreateRun"
    override def runWith =
      smrtLinkClient.createRun(dataModel.get).map(_.uniqueId)
  }

  case class UpdateRun(runId: Var[UUID],
                       dataModel: Option[Var[String]] = None,
                       reserved: Option[Var[Boolean]] = None)
      extends Step {
    override val name = "GetRun"

    override def run: Future[Result] =
      smrtLinkClient
        .updateRun(runId.get, dataModel.map(_.get), reserved.map(_.get))
        .map(_ => SUCCEEDED)
  }

  case class DeleteRun(runId: Var[UUID]) extends Step {
    override val name = "GetRun"

    override def run: Future[Result] =
      smrtLinkClient.deleteRun(runId.get).map(_ => SUCCEEDED)
  }

  case class GetDataSet(dsId: Var[UUID]) extends VarStep[DataSetMetaDataSet] {
    override val name = "GetDataSet"
    override def runWith = smrtLinkClient.getDataSet(dsId.get)

  }

  case class GetDataSetId(dsId: Var[UUID]) extends VarStep[Int] {
    override val name = "GetDataSetId"
    override def runWith = smrtLinkClient.getDataSet(dsId.get).map(_.id)

  }

  case class DeleteDataSet(dsId: Var[UUID]) extends VarStep[String] {
    override val name = "DeleteDataSet"
    override def runWith =
      smrtLinkClient.deleteDataSet(dsId.get).map(_.message)
  }

  case object GetSubreadSets extends VarStep[Seq[SubreadServiceDataSet]] {
    override val name = "GetSubreadSets"
    override def runWith =
      smrtLinkClient.getSubreadSets.map(sx => sx.sortBy(_.id))
  }

  case class GetSubreadSet(dsId: Var[UUID])
      extends VarStep[SubreadServiceDataSet] {
    override val name = "GetSubreadSet"
    override def runWith = smrtLinkClient.getSubreadSet(dsId.get)
  }

  case class GetSubreadSetDetails(dsId: Var[UUID])
      extends VarStep[SubreadSet] {
    override val name = "GetSubreadSetDetails"
    override def runWith = smrtLinkClient.getSubreadSetDetails(dsId.get)
  }

  case object GetHdfSubreadSets
      extends VarStep[Seq[HdfSubreadServiceDataSet]] {
    override val name = "GetHdfSubreadSets"
    override def runWith =
      smrtLinkClient.getHdfSubreadSets.map(sx => sx.sortBy(_.id))
  }

  case class GetHdfSubreadSet(dsId: Var[UUID])
      extends VarStep[HdfSubreadServiceDataSet] {
    override val name = "GetHdfSubreadSet"
    override def runWith = smrtLinkClient.getHdfSubreadSet(dsId.get)
  }

  case class GetHdfSubreadSetDetails(dsId: Var[UUID])
      extends VarStep[HdfSubreadSet] {
    override val name = "GetHdfSubreadSetDetails"
    override def runWith = smrtLinkClient.getHdfSubreadSetDetails(dsId.get)
  }

  case object GetReferenceSets extends VarStep[Seq[ReferenceServiceDataSet]] {
    override val name = "GetReferenceSets"
    override def runWith =
      smrtLinkClient.getReferenceSets.map(sx => sx.sortBy(_.id))
  }

  case class GetReferenceSet(dsId: Var[UUID])
      extends VarStep[ReferenceServiceDataSet] {
    override val name = "GetReferenceSet"
    override def runWith = smrtLinkClient.getReferenceSet(dsId.get)
  }

  case class GetReferenceSetDetails(dsId: Var[UUID])
      extends VarStep[ReferenceSet] {
    override val name = "GetReferenceSetDetails"
    override def runWith = smrtLinkClient.getReferenceSetDetails(dsId.get)
  }

  case object GetBarcodeSets extends VarStep[Seq[BarcodeServiceDataSet]] {
    override val name = "GetBarcodeSets"
    override def runWith =
      smrtLinkClient.getBarcodeSets.map(sx => sx.sortBy(_.id))
  }

  case class GetBarcodeSet(dsId: Var[UUID])
      extends VarStep[BarcodeServiceDataSet] {
    override val name = "GetBarcodeSet"
    override def runWith = smrtLinkClient.getBarcodeSet(dsId.get)
  }

  case class GetBarcodeSetDetails(dsId: Var[UUID])
      extends VarStep[BarcodeSet] {
    override val name = "GetBarcodeSetDetails"
    override def runWith = smrtLinkClient.getBarcodeSetDetails(dsId.get)

  }

  case object GetAlignmentSets extends VarStep[Seq[AlignmentServiceDataSet]] {
    override val name = "GetAlignmentSets"
    override def runWith =
      smrtLinkClient.getAlignmentSets.map(sx => sx.sortBy(_.id))
  }

  case class GetAlignmentSet(dsId: Var[UUID])
      extends VarStep[AlignmentServiceDataSet] {
    override val name = "GetAlignmentSet"
    override def runWith = smrtLinkClient.getAlignmentSet(dsId.get)
  }

  case class GetAlignmentSetDetails(dsId: Var[UUID])
      extends VarStep[AlignmentSet] {
    override val name = "GetAlignmentSetDetails"
    override def runWith = smrtLinkClient.getAlignmentSetDetails(dsId.get)
  }

  case object GetConsensusReadSets
      extends VarStep[Seq[ConsensusReadServiceDataSet]] {
    override val name = "GetConsensusReadSets"
    override def runWith =
      smrtLinkClient.getConsensusReadSets.map(sx => sx.sortBy(_.id))
  }

  case class GetConsensusReadSet(dsId: Var[UUID])
      extends VarStep[ConsensusReadServiceDataSet] {
    override val name = "GetConsensusReadSet"
    override def runWith = smrtLinkClient.getConsensusReadSet(dsId.get)
  }

  case class GetConsensusReadSetDetails(dsId: Var[UUID])
      extends VarStep[ConsensusReadSet] {
    override val name = "GetConsensusReadSetDetails"
    override def runWith = smrtLinkClient.getConsensusReadSetDetails(dsId.get)
  }

  case object GetConsensusAlignmentSets
      extends VarStep[Seq[ConsensusAlignmentServiceDataSet]] {
    override val name = "GetConsensusAlignmentSets"
    override def runWith =
      smrtLinkClient.getConsensusAlignmentSets.map(sx => sx.sortBy(_.id))
  }

  case class GetConsensusAlignmentSet(dsId: Var[UUID])
      extends VarStep[ConsensusAlignmentServiceDataSet] {
    override val name = "GetConsensusAlignmentSet"
    override def runWith = smrtLinkClient.getConsensusAlignmentSet(dsId.get)
  }

  case class GetConsensusAlignmentSetDetails(dsId: Var[UUID])
      extends VarStep[ConsensusAlignmentSet] {
    override val name = "GetConsensusAlignmentSetDetails"
    override def runWith =
      smrtLinkClient.getConsensusAlignmentSetDetails(dsId.get)
  }

  case object GetContigSets extends VarStep[Seq[ContigServiceDataSet]] {
    override val name = "GetContigSets"
    override def runWith =
      smrtLinkClient.getContigSets.map(sx => sx.sortBy(_.id))
  }

  case class GetContigSet(dsId: Var[UUID])
      extends VarStep[ContigServiceDataSet] {
    override val name = "GetContigSet"
    override def runWith = smrtLinkClient.getContigSet(dsId.get)
  }

  case class GetContigSetDetails(dsId: Var[UUID]) extends VarStep[ContigSet] {
    override val name = "GetContigSetDetails"
    override def runWith = smrtLinkClient.getContigSetDetails(dsId.get)
  }

  case object GetGmapReferenceSets
      extends VarStep[Seq[GmapReferenceServiceDataSet]] {
    override val name = "GetGmapReferenceSets"
    override def runWith =
      smrtLinkClient.getGmapReferenceSets.map(sx => sx.sortBy(_.id))
  }

  case class GetGmapReferenceSet(dsId: Var[UUID])
      extends VarStep[GmapReferenceServiceDataSet] {
    override val name = "GetGmapReferenceSet"
    override def runWith = smrtLinkClient.getGmapReferenceSet(dsId.get)
  }

  case class GetGmapReferenceSetDetails(dsId: Var[UUID])
      extends VarStep[GmapReferenceSet] {
    override val name = "GetGmapReferenceSetDetails"
    override def runWith = smrtLinkClient.getGmapReferenceSetDetails(dsId.get)
  }

  case class GetSubreadSetReports(dsId: Var[UUID])
      extends VarStep[Seq[DataStoreReportFile]] {
    override val name = "GetSubreadSetReports"
    override def runWith = smrtLinkClient.getSubreadSetReports(dsId.get)
  }

  case class GetReport(reportId: Var[UUID]) extends VarStep[Report] {
    override val name = "GetReport"
    override def runWith = smrtLinkClient.getReport(reportId.get)
  }

  case class GetImportJobDataStore(jobId: Var[UUID])
      extends VarStep[Seq[DataStoreServiceFile]] {
    override val name = "GetImportJobDataStore"
    override def runWith =
      smrtLinkClient.getImportDatasetJobDataStore(jobId.get)
  }

  case class GetMergeJobDataStore(jobId: Var[UUID])
      extends VarStep[Seq[DataStoreServiceFile]] {
    override val name = "GetMergeJobDataStore"
    override def runWith =
      smrtLinkClient.getMergeDatasetJobDataStore(jobId.get)
  }

  case class GetDataStoreFileResource(fileId: Var[UUID], relpath: Var[String])
      extends VarStep[Int] {
    override val name = "GetDataStoreFileResource"
    override def runWith =
      smrtLinkClient.getDataStoreFileResource(fileId.get, relpath.get).map {
        a =>
          // 'a' is Array[Byte], all we test for is the size
          a.entity.data.toByteArray.size
      }
  }

  case object GetProjects extends VarStep[Seq[Project]] {
    override val name = "GetProjects"
    override def runWith = smrtLinkClient.getProjects
  }

  case class GetProject(projectId: Var[Int]) extends VarStep[FullProject] {
    override val name = "GetProject"
    override def runWith = smrtLinkClient.getProject(projectId.get)
  }

  case class CreateProject(projectName: Var[String], description: Var[String])
      extends VarStep[Int] {
    override val name = "CreateProject"
    override def runWith =
      smrtLinkClient.createProject(projectName.get, description.get).map(_.id)
  }

  case class UpdateProject(projectId: Var[Int], request: Var[ProjectRequest])
      extends VarStep[FullProject] {
    override val name = "UpdateProject"
    override def runWith =
      smrtLinkClient.updateProject(projectId.get, request.get)
  }

  /**
    * These cases often (never?) depend on the Var. There's no need to wrap them in the Var layer
    *
    * Given how frequent this is ued, this should load the dataset metadata determination from path of the file and
    * only supply the local path of the file to simply this interface.
    *
    * If Scenarios are only interested in getting a path (i.e., not explicitly testing import functionality, then
    * It's recommended to use GetOrImportData Step
    *
    * @param path   DataSet Path
    * @param dsType Dataset MetaType
    */
  case class ImportDataSet(path: Var[Path], dsType: Var[DataSetMetaType])
      extends VarStep[UUID] {
    override val name = "ImportDataSet"
    override def runWith =
      smrtLinkClient.importDataSet(path.get, dsType.get).map(_.uuid)
  }

  case class WaitForJob(jobId: Var[UUID],
                        maxTime: Var[FiniteDuration] = Var(1800.seconds),
                        sleepTime: Var[Int] = Var(5000))
      extends VarStep[Int] {
    override val name = "WaitForJob"
    override def runWith =
      Future {
        // Return non-zero exit code. This probably needs to be refactored at the Sim level
        logger.info(s"Starting to poll for Job ${jobId.get}")
        smrtLinkClient
          .pollForSuccessfulJob(jobId.get, Some(maxTime.get), sleepTime.get)
          .map(_ => 0)
          .getOrElse(1)
      }.recoverWith {
        case NonFatal(ex) =>
          logger.error(s"Failed to wait for job $jobId")
          Future.failed(ex)
      }
  }
  case class WaitForSuccessfulJob(jobId: Var[UUID],
                                  maxTime: Var[FiniteDuration] = Var(
                                    1800.seconds))
      extends VarStep[EngineJob] {
    override val name = "WaitForSuccessfulJob"
    override def runWith =
      Future
        .fromTry {
          logger.info(s"Start to poll for Successful Job ${jobId.get}")
          smrtLinkClient.pollForSuccessfulJob(jobId.get, Some(maxTime.get))
        }
        .recoverWith {
          case NonFatal(ex) =>
            logger.error(s"Failed to wait for Successful job $jobId")
            Future.failed(ex)
        }
  }

  case class ImportFasta(path: Var[Path], dsName: Var[String])
      extends VarStep[UUID] {
    override val name = "ImportFasta"
    override def runWith =
      smrtLinkClient
        .importFasta(path.get, dsName.get, "lambda", "haploid")
        .map(_.uuid)
  }

  case class ImportFastaBarcodes(path: Var[Path], dsName: Var[String])
      extends VarStep[UUID] {
    override val name = "ImportFastaBarcodes"
    override def runWith =
      smrtLinkClient.importFastaBarcodes(path.get, dsName.get).map(_.uuid)
  }

  case class MergeDataSets(dsType: Var[DataSetMetaType],
                           ids: Var[Seq[Int]],
                           dsName: Var[String])
      extends VarStep[UUID] {
    override val name = "MergeDataSets"
    override def runWith =
      smrtLinkClient
        .mergeDataSets(dsType.get, ids.get.map(IntIdAble), dsName.get)
        .map(_.uuid)
  }

  // XXX this isn't ideal, but I can't figure out another way to convert from
  // Seq[Var[Int]] to Var[Seq[Int]] at the appropriate time (i.e. not at
  // program startup)
  case class MergeDataSetsMany(dsType: Var[DataSetMetaType],
                               ids: Var[Seq[IdAble]],
                               dsName: Var[String])
      extends VarStep[UUID] {
    override val name = "MergeDataSets"
    override def runWith =
      smrtLinkClient.mergeDataSets(dsType.get, ids.get, dsName.get).map(_.uuid)
  }

  case class ConvertRsMovie(path: Var[Path]) extends VarStep[UUID] {
    override val name = "ConvertRsMovie"
    override def runWith =
      smrtLinkClient
        .convertRsMovie(path.get, "sim-convert-rs-movie")
        .map(_.uuid)
  }

  case class ExportDataSets(dsType: Var[DataSetMetaType],
                            ids: Var[Seq[Int]],
                            outputPath: Var[Path],
                            deleteAfterExport: Var[Boolean] = Var(false))
      extends VarStep[UUID] {
    override val name = "ExportDataSets"
    override def runWith =
      smrtLinkClient
        .exportDataSets(dsType.get,
                        ids.get,
                        outputPath.get,
                        deleteAfterExport.get)
        .map(_.uuid)
  }

  case class ExportJobs(ids: Var[Seq[Int]], outputPath: Var[Path])
      extends VarStep[UUID] {
    override val name = "ExportJobs"
    override def runWith =
      smrtLinkClient
        .exportJobs(ids.get.map(IntIdAble), outputPath.get, true)
        .map(_.uuid)
  }

  case class ImportJob(zipPath: Var[Path], mockJobId: Var[Boolean] = Var(true))
      extends VarStep[UUID] {
    override val name = "ImportJob"
    override def runWith =
      smrtLinkClient
        .importJob(zipPath.get, mockJobId = mockJobId.get)
        .map(_.uuid)
  }

  case class RunAnalysisPipeline(
      pipelineOptions: Var[PbSmrtPipeServiceOptions])
      extends VarStep[UUID] {
    override val name = "RunAnalysisPipeline"
    override def runWith =
      smrtLinkClient.runAnalysisPipeline(pipelineOptions.get).map(_.uuid)
  }

  case class GetJob(jobId: Var[UUID]) extends VarStep[EngineJob] {
    override val name = "GetJob"
    override def runWith = smrtLinkClient.getJob(jobId.get)
  }

  case object GetAnalysisJobs extends VarStep[Seq[EngineJob]] {
    override val name = "GetAnalysisJobs"
    override def runWith =
      smrtLinkClient.getAnalysisJobs.map(j => j.sortBy(_.id))
  }

  case class GetAnalysisJobsForProject(projectId: Var[Int])
      extends VarStep[Seq[EngineJob]] {
    override val name = "GetAnalysisJobsForProject"
    override def runWith =
      smrtLinkClient.getAnalysisJobsForProject(projectId.get)
  }

  case object GetLastAnalysisJobId extends VarStep[UUID] {
    override val name = "GetLastAnalysisJobId"
    override def runWith =
      smrtLinkClient.getAnalysisJobs.map(j => j.sortBy(_.id).last.uuid)
  }

  case class GetJobById(jobId: Var[Int]) extends VarStep[EngineJob] {
    override val name = "GetJobById"
    override def runWith = smrtLinkClient.getJob(jobId.get)
  }

  case class GetPipelineTemplateViewRule(pipelineId: Var[String])
      extends VarStep[PipelineTemplateViewRule] {
    override val name = "GetPipelineTemplateViewRule"
    override def runWith =
      smrtLinkClient.getPipelineTemplateViewRule(pipelineId.get)
  }

  case class GetDataStoreViewRules(pipelineId: Var[String])
      extends VarStep[PipelineDataStoreViewRules] {
    override val name = "GetDataStoreViewRules"
    override def runWith =
      smrtLinkClient.getPipelineDataStoreViewRules(pipelineId.get)
  }

  case class GetAnalysisJobDataStore(jobId: Var[UUID])
      extends VarStep[Seq[DataStoreServiceFile]] {
    override val name = "GetAnalysisJobDataStore"
    override def runWith = smrtLinkClient.getAnalysisJobDataStore(jobId.get)
  }

  case class GetAnalysisJobReports(jobId: Var[UUID])
      extends VarStep[Seq[DataStoreReportFile]] {
    override val name = "GetAnalysisJobReports"
    override def runWith = smrtLinkClient.getAnalysisJobReports(jobId.get)
  }

  // XXX this only works with Int
  case class GetAnalysisJobEntryPoints(jobId: Var[Int])
      extends VarStep[Seq[EngineJobEntryPoint]] {
    override val name = "GetAnalysisJobEntryPoints"
    override def runWith = smrtLinkClient.getAnalysisJobEntryPoints(jobId.get)
  }

  case class GetAnalysisJobEvents(jobId: Var[Int])
      extends VarStep[Seq[JobEvent]] {
    override val name = "GetAnalysisJobEvents"
    override def runWith = smrtLinkClient.getAnalysisJobEvents(jobId.get)
  }

  case class GetAnalysisJobTasks(jobId: Var[Int])
      extends VarStep[Seq[JobTask]] {
    override val name = "GetAnalysisJobTasks"
    override def runWith = smrtLinkClient.getAnalysisJobTasks(jobId.get)
  }

  case class GetAnalysisJobOptions(jobId: Var[Int])
      extends VarStep[PipelineTemplatePreset] {
    override val name = "GetAnalysisJobOptions"
    override def runWith = smrtLinkClient.getAnalysisJobOptions(jobId.get)
  }

  case class GetJobChildren(jobId: Var[UUID]) extends VarStep[Seq[EngineJob]] {
    override val name = "GetJobChildren"
    override def runWith = smrtLinkClient.getJobChildren(jobId.get)
  }

  case class DeleteJob(jobId: Var[UUID], dryRun: Var[Boolean])
      extends VarStep[UUID] {
    override val name = "DeleteJob"
    override def runWith =
      smrtLinkClient.deleteJob(jobId.get, dryRun = dryRun.get).map(_.uuid)
  }

  case class DeleteDataSets(dsType: Var[DataSetMetaType],
                            ids: Var[Seq[Int]],
                            removeFiles: Var[Boolean] = Var(true))
      extends VarStep[UUID] {
    override val name = "DeleteDataSets"
    override def runWith =
      smrtLinkClient
        .deleteDataSets(dsType.get, ids.get, removeFiles.get)
        .map(_.uuid)
  }

  case object GetDatasetDeleteJobs extends VarStep[Seq[EngineJob]] {
    override val name = "GetDatasetDeleteJobs"
    override def runWith =
      smrtLinkClient.getDatasetDeleteJobs.map(j => j.sortBy(_.id))
  }

  case class GetBundle(typeId: Var[String]) extends VarStep[PacBioDataBundle] {
    override val name = "GetBundle"
    override def runWith =
      smrtLinkClient
        .getPacBioDataBundleByTypeId(typeId.get)
        .map(b => b.filter(_.isActive == true).head)
  }

  case class CreateTsSystemStatusJob(user: Var[String], comment: Var[String])
      extends VarStep[UUID] {
    override val name = "CreateTsSystemStatusJob"
    override val runWith =
      smrtLinkClient.runTsSystemStatus(user.get, comment.get).map(_.uuid)
  }

  case class CreateTsFailedJob(jobId: Var[UUID],
                               user: Var[String],
                               comment: Var[String])
      extends VarStep[UUID] {
    override val name = "CreateTsFailedJob"
    override def runWith = {
      for {
        failedJob <- smrtLinkClient.getJob(jobId.get)
        tsJob <- smrtLinkClient.runTsJobBundle(failedJob.id,
                                               user.get,
                                               comment.get)
      } yield tsJob.uuid
    }
  }

  case class UpdateSubreadSetDetails(dsId: Var[UUID],
                                     isActive: Var[Option[Boolean]],
                                     bioSampleName: Var[Option[String]],
                                     wellSampleName: Var[Option[String]])
      extends VarStep[String] {
    override val name = "UpdateSubreadSetDetails"
    override def runWith = {
      smrtLinkClient
        .updateSubreadSetDetails(dsId.get,
                                 isActive.get,
                                 bioSampleName.get,
                                 wellSampleName.get)
        .map(_.message)
    }
  }

  /**
    * Gets the dataset if already imported, or will import and run the job successfully
    *
    * Returns the Imported DataSet UUID
    *
    * @param path       Path to the DataSet
    * @param dsMetaType DataSet Metatype
    */
  case class GetOrImportDataSet(path: Path, dsMetaType: DataSetMetaType)
      extends VarStep[UUID] {
    override val name = "ImportOrGetDataSet"

    /**
      * 1. Load dataset mini-metadata from Path
      * 2. Try to get DataSet by UUID
      * 3. Create a new Import DataSet job if failed to find dataset and poll for successful import dataset job
      *
      */
    override def runWith = {

      val f1 = for {
        miniMeta <- Future.successful(
          DataSetFileUtils.getDataSetMiniMeta(path))
        dataset <- smrtLinkClient.getDataSet(miniMeta.uuid)
      } yield dataset.uuid

      val f2 = for {
        miniMeta <- Future.successful(
          DataSetFileUtils.getDataSetMiniMeta(path))
        job <- smrtLinkClient.importDataSet(path, dsMetaType)
        successfulJob <- Future.fromTry(
          smrtLinkClient.pollForSuccessfulJob(job.id))
        _ <- andLog(
          s"Completed Successful Job ${successfulJob.id} for dataset UUID: ${miniMeta.uuid}")
        dataset <- smrtLinkClient.getDataSet(miniMeta.uuid)
      } yield dataset.uuid

      f1.recoverWith { case NonFatal(_) => f2 }
    }
  }

  case class CreateDbBackUpJob(user: String, comment: String)
      extends VarStep[UUID] {
    override val name = "CreateDbBackUpJob"
    override def runWith =
      smrtLinkClient.runDbBackUpJob(user, comment).map(_.uuid)

  }

}
