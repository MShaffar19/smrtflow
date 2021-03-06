import akka.actor.{ActorRefFactory, ActorSystem}
import akka.http.scaladsl.testkit.{RouteTestTimeout, Specs2RouteTest}
import com.pacbio.secondary.smrtlink.actors._
import com.pacbio.secondary.smrtlink.auth._
import com.pacbio.secondary.smrtlink.dependency.{
  ConfigProvider,
  SetBindings,
  Singleton
}
import com.pacbio.secondary.smrtlink.models.UserRecord
import com.pacbio.secondary.smrtlink.services.utils.StatusGeneratorProvider
import com.pacbio.secondary.smrtlink.time.FakeClockProvider
import com.pacbio.secondary.smrtlink.analysis.configloaders.{
  EngineCoreConfigLoader,
  PbsmrtpipeConfigLoader
}
import com.pacbio.secondary.smrtlink.JobServiceConstants
import com.pacbio.secondary.smrtlink.actors._
import com.pacbio.secondary.smrtlink.app.SmrtLinkConfigProvider
import com.pacbio.secondary.smrtlink.services.{
  JobsServiceProvider,
  ServiceComposer
}
import com.pacbio.secondary.smrtlink.testkit.TestUtils
import com.pacbio.secondary.smrtlink.tools.SetupMockData
import com.typesafe.config.Config
import org.specs2.mutable.Specification

import scala.concurrent.duration.FiniteDuration
import slick.jdbc.PostgresProfile.api._

class SecondaryJobSpec
    extends Specification
    with Specs2RouteTest
    with SetupMockData
    with JobServiceConstants
    with TestUtils {

  sequential

  implicit val routeTestTimeout = RouteTestTimeout(FiniteDuration(5, "sec"))

  val INVALID_JWT = "invalid.jwt"

  object TestProviders
      extends ServiceComposer
      with JobsServiceProvider
      with StatusGeneratorProvider
      with EventManagerActorProvider
      with JobsDaoProvider
      with SmrtLinkTestDalProvider
      with SmrtLinkConfigProvider
      with PbsmrtpipeConfigLoader
      with EngineCoreConfigLoader
      with JwtUtilsProvider
      with ActorSystemProvider
      with ConfigProvider
      with FakeClockProvider
      with SetBindings {

    override final val jwtUtils: Singleton[JwtUtils] = Singleton(() =>
      new JwtUtils {
        override def parse(jwt: String): Option[UserRecord] =
          if (jwt == INVALID_JWT) None else Some(UserRecord(jwt))
    })

    override val config: Singleton[Config] = Singleton(testConfig)
    override val actorSystem: Singleton[ActorSystem] = Singleton(system)
    override val actorRefFactory: Singleton[ActorRefFactory] = actorSystem
    override val baseServiceId: Singleton[String] = Singleton("test-service")
    override val buildPackage: Singleton[Package] = Singleton(
      getClass.getPackage)
  }

  override val dao: JobsDao = TestProviders.jobsDao()
  override val db: Database = dao.db
  val totalRoutes = TestProviders.routes()
  val eventManagerActorX = TestProviders.eventManagerActor()

  def toJobType(x: String) = s"/$ROOT_SA_PREFIX/job-manager/jobs/$x"
  def toJobTypeById(x: String, i: Int) = s"${toJobType(x)}/$i"
  def toJobTypeByIdWithRest(x: String, i: Int, rest: String) =
    s"${toJobTypeById(x, i)}/$rest"

  lazy val rootJobDir = TestProviders.jobEngineConfig().pbRootJobDir

  step(setupJobDir(rootJobDir))
  step(setupDb(TestProviders.dbConfig))
  step(runInsertAllMockData(dao))

  "Service list" should {
    "Secondary analysis access job by id" in {
      Get(toJobTypeById("mock-pbsmrtpipe", 1)) ~> totalRoutes ~> check {
        status.isSuccess must beTrue
      }
    }
    "Secondary analysis access job datastore" in {
      Get(toJobTypeByIdWithRest("mock-pbsmrtpipe", 1, "datastore")) ~> totalRoutes ~> check {
        status.isSuccess must beTrue
      }
    }
    "Secondary analysis access job reports" in {
      Get(toJobTypeByIdWithRest("mock-pbsmrtpipe", 1, "reports")) ~> totalRoutes ~> check {
        status.isSuccess must beTrue
      }
    }
    "Secondary analysis access job events by job id" in {
      Get(toJobTypeByIdWithRest("mock-pbsmrtpipe", 1, "events")) ~> totalRoutes ~> check {
        status.isSuccess must beTrue
      }
    }
  }

}
