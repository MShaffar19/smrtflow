package com.pacbio.secondary.smrtlink.app

import java.nio.file.{Files, Path, Paths}

import com.pacbio.common.dependency.Singleton
import com.pacbio.common.loaders.ManifestLoader
import com.pacbio.secondary.analysis.configloaders.{EngineCoreConfigLoader, PbsmrtpipeConfigLoader}
import com.pacbio.secondary.analysis.engine.EngineConfig
import com.pacbio.secondary.analysis.jobs.{JobResourceResolver, PacBioIntJobResolver}
import com.pacbio.secondary.analysis.pbsmrtpipe.{CommandTemplate, PbsmrtpipeEngineOptions}
import com.pacbio.secondary.smrtlink.loaders.PacBioAutomationConstraintsLoader
import com.pacbio.secondary.smrtlink.models.PacBioBundle
import com.pacbio.secondary.smrtlink.services.BundleUtils
import com.pacificbiosciences.pacbioautomationconstraints.PacBioAutomationConstraints
import com.typesafe.scalalogging.LazyLogging


trait SmrtLinkConfigProvider extends LazyLogging {
  this: PbsmrtpipeConfigLoader with EngineCoreConfigLoader =>

  /**
    * Create a Directory if it doesn't exist.
    *
    * @param p
    * @return
    */
  def createDirIfNotExist(p: Path): Path = {
    if (!Files.exists(p)) {
      Files.createDirectory(p)
      logger.info(s"created dir $p")
    }
    p
  }

  val port: Singleton[Int] = Singleton(() => conf.getInt("smrtflow.server.port"))
  val host: Singleton[String] = Singleton(() => conf.getString("smrtflow.server.host"))

  val jobEngineConfig: Singleton[EngineConfig] = Singleton(() => engineConfig)
  val cmdTemplate: Singleton[Option[CommandTemplate]] = Singleton(() => loadCmdTemplate)
  val pbsmrtpipeEngineOptions: Singleton[PbsmrtpipeEngineOptions] =
    Singleton(() => loadPbsmrtpipeEngineConfigOrDefaults)
  val jobResolver: Singleton[JobResourceResolver] =
    Singleton(() => new PacBioIntJobResolver(jobEngineConfig().pbRootJobDir))

  // Unfortunately this is duplicated in the Manifest service
  val smrtLinkVersion: Singleton[Option[String]] =
    Singleton(() => ManifestLoader.loadFromConfig(conf).toList.find(_.id == ManifestLoader.SMRTLINK_ID).map(_.version))
  val smrtLinkToolsVersion: Singleton[Option[String]] =
    Singleton(() => ManifestLoader.loadFromConfig(conf).toList.find(_.id == ManifestLoader.SMRT_LINK_TOOLS_ID).map(_.version))

  val pacBioBundleRoot: Singleton[Path] =
    Singleton(() => createDirIfNotExist(Paths.get(conf.getString("smrtflow.server.bundleDir")).toRealPath()))

  val pacBioBundles: Singleton[Seq[PacBioBundle]] =
    Singleton(() => BundleUtils.loadBundlesFromRoot(pacBioBundleRoot()))

  // Load PacBio Automation Constraints Chemistry Bundle
  val pacBioAutomationConstraints: Singleton[PacBioAutomationConstraints] =
    Singleton(() => PacBioAutomationConstraintsLoader.loadExample())
}