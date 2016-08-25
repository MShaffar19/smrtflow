package com.pacbio.secondary.smrtserver.models

import com.pacbio.secondary.analysis.engine.EngineConfig
import com.pacbio.secondary.analysis.pbsmrtpipe.{CommandTemplate, PbsmrtpipeEngineOptions}

object SecondaryModels {

  // Secondary Analysis System Configuration
  case class SecondaryAnalysisConfig(
      engineConfig: EngineConfig,
      pbsmrtpipeEngineOptions: PbsmrtpipeEngineOptions,
      dbURI: String,
      cmdTemplate: Option[CommandTemplate])

  // POST creation of a job event
  case class JobEventRecord(
      state: String,
      message: String)

  // Need to find a better way to do this
  case class PacBioSchema(id: String, content: String)

  case class ReportAttributeViewRule(id: String, name: String)

  case class ReportViewRule(id: String, name: String, attributes: Seq[ReportAttributeViewRule])

  case class DataSetExportServiceOptions(datasetType: String, ids: Seq[Int],
                                         outputPath: String)
}
