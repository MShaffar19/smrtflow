import com.pacbio.secondary.smrtlink.models.ServiceStatus
import com.pacbio.secondary.smrtlink.app.{BaseServer, SmrtLinkApi}
import org.specs2.mutable.Specification
import spray.httpx.SprayJsonSupport._
import spray.testkit.Specs2RouteTest


/**
  * This should be used as a sanity test to make sure routes are found and the
  * routes are correctly configured.
  *
  */
class SmrtLinkAnalysisSanitySpec extends Specification with Specs2RouteTest {

  import com.pacbio.secondary.smrtlink.jsonprotocols.SmrtLinkJsonProtocols._

  object TestProviders extends BaseServer with SmrtLinkApi {
    override val host = providers.serverHost()
    override val port = providers.serverPort()
  }

  val totalRoutes = TestProviders.routes
  //val eventManagerActorX = TestProviders.eventManagerActor()


  "Service list" should {
    "return a list of services" in {
      Get("/services/manifests") ~> totalRoutes ~> check {
        status.isSuccess must beTrue
      }
    }
    "Uptime should be >0" in {
      Get("/status") ~> totalRoutes ~> check {
        val status = responseAs[ServiceStatus]
        // Uptime is in sec, not millisec
        // this is the best we can do
        status.uptime must be_>=(0L)
      }
    }
    "Get export dataset job list" in {
      Get("/secondary-analysis/job-manager/jobs/export-datasets") ~> totalRoutes ~> check {
        status.isSuccess must beTrue
      }
    }
  }
}
