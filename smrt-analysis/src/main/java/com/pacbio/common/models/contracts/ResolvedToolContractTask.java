/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.pacbio.common.models.contracts;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ResolvedToolContractTask extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -3257477129460986837L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ResolvedToolContractTask\",\"namespace\":\"com.pacbio.common.models.contracts\",\"fields\":[{\"name\":\"input_files\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"output_files\",\"type\":{\"type\":\"array\",\"items\":\"string\"}},{\"name\":\"options\",\"type\":{\"type\":\"map\",\"values\":[\"long\",\"boolean\",\"string\",\"int\"]},\"doc\":\"Resolved Task Options\"},{\"name\":\"nproc\",\"type\":\"int\"},{\"name\":\"is_distributed\",\"type\":\"boolean\"},{\"name\":\"task_type\",\"type\":\"string\"},{\"name\":\"tool_contract_id\",\"type\":\"string\"},{\"name\":\"log_level\",\"type\":\"string\"},{\"name\":\"resources\",\"type\":{\"type\":\"array\",\"items\":\"string\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public java.util.List<java.lang.CharSequence> input_files;
  @Deprecated public java.util.List<java.lang.CharSequence> output_files;
  /** Resolved Task Options */
  @Deprecated public java.util.Map<java.lang.CharSequence,java.lang.Object> options;
  @Deprecated public int nproc;
  @Deprecated public boolean is_distributed;
  @Deprecated public java.lang.CharSequence task_type;
  @Deprecated public java.lang.CharSequence tool_contract_id;
  @Deprecated public java.lang.CharSequence log_level;
  @Deprecated public java.util.List<java.lang.CharSequence> resources;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public ResolvedToolContractTask() {}

  /**
   * All-args constructor.
   * @param options Resolved Task Options
   */
  public ResolvedToolContractTask(java.util.List<java.lang.CharSequence> input_files, java.util.List<java.lang.CharSequence> output_files, java.util.Map<java.lang.CharSequence,java.lang.Object> options, java.lang.Integer nproc, java.lang.Boolean is_distributed, java.lang.CharSequence task_type, java.lang.CharSequence tool_contract_id, java.lang.CharSequence log_level, java.util.List<java.lang.CharSequence> resources) {
    this.input_files = input_files;
    this.output_files = output_files;
    this.options = options;
    this.nproc = nproc;
    this.is_distributed = is_distributed;
    this.task_type = task_type;
    this.tool_contract_id = tool_contract_id;
    this.log_level = log_level;
    this.resources = resources;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return input_files;
    case 1: return output_files;
    case 2: return options;
    case 3: return nproc;
    case 4: return is_distributed;
    case 5: return task_type;
    case 6: return tool_contract_id;
    case 7: return log_level;
    case 8: return resources;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: input_files = (java.util.List<java.lang.CharSequence>)value$; break;
    case 1: output_files = (java.util.List<java.lang.CharSequence>)value$; break;
    case 2: options = (java.util.Map<java.lang.CharSequence,java.lang.Object>)value$; break;
    case 3: nproc = (java.lang.Integer)value$; break;
    case 4: is_distributed = (java.lang.Boolean)value$; break;
    case 5: task_type = (java.lang.CharSequence)value$; break;
    case 6: tool_contract_id = (java.lang.CharSequence)value$; break;
    case 7: log_level = (java.lang.CharSequence)value$; break;
    case 8: resources = (java.util.List<java.lang.CharSequence>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'input_files' field.
   */
  public java.util.List<java.lang.CharSequence> getInputFiles() {
    return input_files;
  }

  /**
   * Sets the value of the 'input_files' field.
   * @param value the value to set.
   */
  public void setInputFiles(java.util.List<java.lang.CharSequence> value) {
    this.input_files = value;
  }

  /**
   * Gets the value of the 'output_files' field.
   */
  public java.util.List<java.lang.CharSequence> getOutputFiles() {
    return output_files;
  }

  /**
   * Sets the value of the 'output_files' field.
   * @param value the value to set.
   */
  public void setOutputFiles(java.util.List<java.lang.CharSequence> value) {
    this.output_files = value;
  }

  /**
   * Gets the value of the 'options' field.
   * @return Resolved Task Options
   */
  public java.util.Map<java.lang.CharSequence,java.lang.Object> getOptions() {
    return options;
  }

  /**
   * Sets the value of the 'options' field.
   * Resolved Task Options
   * @param value the value to set.
   */
  public void setOptions(java.util.Map<java.lang.CharSequence,java.lang.Object> value) {
    this.options = value;
  }

  /**
   * Gets the value of the 'nproc' field.
   */
  public java.lang.Integer getNproc() {
    return nproc;
  }

  /**
   * Sets the value of the 'nproc' field.
   * @param value the value to set.
   */
  public void setNproc(java.lang.Integer value) {
    this.nproc = value;
  }

  /**
   * Gets the value of the 'is_distributed' field.
   */
  public java.lang.Boolean getIsDistributed() {
    return is_distributed;
  }

  /**
   * Sets the value of the 'is_distributed' field.
   * @param value the value to set.
   */
  public void setIsDistributed(java.lang.Boolean value) {
    this.is_distributed = value;
  }

  /**
   * Gets the value of the 'task_type' field.
   */
  public java.lang.CharSequence getTaskType() {
    return task_type;
  }

  /**
   * Sets the value of the 'task_type' field.
   * @param value the value to set.
   */
  public void setTaskType(java.lang.CharSequence value) {
    this.task_type = value;
  }

  /**
   * Gets the value of the 'tool_contract_id' field.
   */
  public java.lang.CharSequence getToolContractId() {
    return tool_contract_id;
  }

  /**
   * Sets the value of the 'tool_contract_id' field.
   * @param value the value to set.
   */
  public void setToolContractId(java.lang.CharSequence value) {
    this.tool_contract_id = value;
  }

  /**
   * Gets the value of the 'log_level' field.
   */
  public java.lang.CharSequence getLogLevel() {
    return log_level;
  }

  /**
   * Sets the value of the 'log_level' field.
   * @param value the value to set.
   */
  public void setLogLevel(java.lang.CharSequence value) {
    this.log_level = value;
  }

  /**
   * Gets the value of the 'resources' field.
   */
  public java.util.List<java.lang.CharSequence> getResources() {
    return resources;
  }

  /**
   * Sets the value of the 'resources' field.
   * @param value the value to set.
   */
  public void setResources(java.util.List<java.lang.CharSequence> value) {
    this.resources = value;
  }

  /**
   * Creates a new ResolvedToolContractTask RecordBuilder.
   * @return A new ResolvedToolContractTask RecordBuilder
   */
  public static com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder newBuilder() {
    return new com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder();
  }
  
  /**
   * Creates a new ResolvedToolContractTask RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new ResolvedToolContractTask RecordBuilder
   */
  public static com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder newBuilder(com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder other) {
    return new com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder(other);
  }
  
  /**
   * Creates a new ResolvedToolContractTask RecordBuilder by copying an existing ResolvedToolContractTask instance.
   * @param other The existing instance to copy.
   * @return A new ResolvedToolContractTask RecordBuilder
   */
  public static com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder newBuilder(com.pacbio.common.models.contracts.ResolvedToolContractTask other) {
    return new com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder(other);
  }
  
  /**
   * RecordBuilder for ResolvedToolContractTask instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ResolvedToolContractTask>
    implements org.apache.avro.data.RecordBuilder<ResolvedToolContractTask> {

    private java.util.List<java.lang.CharSequence> input_files;
    private java.util.List<java.lang.CharSequence> output_files;
    /** Resolved Task Options */
    private java.util.Map<java.lang.CharSequence,java.lang.Object> options;
    private int nproc;
    private boolean is_distributed;
    private java.lang.CharSequence task_type;
    private java.lang.CharSequence tool_contract_id;
    private java.lang.CharSequence log_level;
    private java.util.List<java.lang.CharSequence> resources;

    /** Creates a new Builder */
    private Builder() {
      super(com.pacbio.common.models.contracts.ResolvedToolContractTask.SCHEMA$);
    }
    
    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.input_files)) {
        this.input_files = data().deepCopy(fields()[0].schema(), other.input_files);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.output_files)) {
        this.output_files = data().deepCopy(fields()[1].schema(), other.output_files);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.options)) {
        this.options = data().deepCopy(fields()[2].schema(), other.options);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.nproc)) {
        this.nproc = data().deepCopy(fields()[3].schema(), other.nproc);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.is_distributed)) {
        this.is_distributed = data().deepCopy(fields()[4].schema(), other.is_distributed);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.task_type)) {
        this.task_type = data().deepCopy(fields()[5].schema(), other.task_type);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.tool_contract_id)) {
        this.tool_contract_id = data().deepCopy(fields()[6].schema(), other.tool_contract_id);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.log_level)) {
        this.log_level = data().deepCopy(fields()[7].schema(), other.log_level);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.resources)) {
        this.resources = data().deepCopy(fields()[8].schema(), other.resources);
        fieldSetFlags()[8] = true;
      }
    }
    
    /**
     * Creates a Builder by copying an existing ResolvedToolContractTask instance
     * @param other The existing instance to copy.
     */
    private Builder(com.pacbio.common.models.contracts.ResolvedToolContractTask other) {
            super(com.pacbio.common.models.contracts.ResolvedToolContractTask.SCHEMA$);
      if (isValidValue(fields()[0], other.input_files)) {
        this.input_files = data().deepCopy(fields()[0].schema(), other.input_files);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.output_files)) {
        this.output_files = data().deepCopy(fields()[1].schema(), other.output_files);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.options)) {
        this.options = data().deepCopy(fields()[2].schema(), other.options);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.nproc)) {
        this.nproc = data().deepCopy(fields()[3].schema(), other.nproc);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.is_distributed)) {
        this.is_distributed = data().deepCopy(fields()[4].schema(), other.is_distributed);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.task_type)) {
        this.task_type = data().deepCopy(fields()[5].schema(), other.task_type);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.tool_contract_id)) {
        this.tool_contract_id = data().deepCopy(fields()[6].schema(), other.tool_contract_id);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.log_level)) {
        this.log_level = data().deepCopy(fields()[7].schema(), other.log_level);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.resources)) {
        this.resources = data().deepCopy(fields()[8].schema(), other.resources);
        fieldSetFlags()[8] = true;
      }
    }

    /**
      * Gets the value of the 'input_files' field.
      * @return The value.
      */
    public java.util.List<java.lang.CharSequence> getInputFiles() {
      return input_files;
    }

    /**
      * Sets the value of the 'input_files' field.
      * @param value The value of 'input_files'.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder setInputFiles(java.util.List<java.lang.CharSequence> value) {
      validate(fields()[0], value);
      this.input_files = value;
      fieldSetFlags()[0] = true;
      return this; 
    }

    /**
      * Checks whether the 'input_files' field has been set.
      * @return True if the 'input_files' field has been set, false otherwise.
      */
    public boolean hasInputFiles() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'input_files' field.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder clearInputFiles() {
      input_files = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'output_files' field.
      * @return The value.
      */
    public java.util.List<java.lang.CharSequence> getOutputFiles() {
      return output_files;
    }

    /**
      * Sets the value of the 'output_files' field.
      * @param value The value of 'output_files'.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder setOutputFiles(java.util.List<java.lang.CharSequence> value) {
      validate(fields()[1], value);
      this.output_files = value;
      fieldSetFlags()[1] = true;
      return this; 
    }

    /**
      * Checks whether the 'output_files' field has been set.
      * @return True if the 'output_files' field has been set, false otherwise.
      */
    public boolean hasOutputFiles() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'output_files' field.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder clearOutputFiles() {
      output_files = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'options' field.
      * Resolved Task Options
      * @return The value.
      */
    public java.util.Map<java.lang.CharSequence,java.lang.Object> getOptions() {
      return options;
    }

    /**
      * Sets the value of the 'options' field.
      * Resolved Task Options
      * @param value The value of 'options'.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder setOptions(java.util.Map<java.lang.CharSequence,java.lang.Object> value) {
      validate(fields()[2], value);
      this.options = value;
      fieldSetFlags()[2] = true;
      return this; 
    }

    /**
      * Checks whether the 'options' field has been set.
      * Resolved Task Options
      * @return True if the 'options' field has been set, false otherwise.
      */
    public boolean hasOptions() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'options' field.
      * Resolved Task Options
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder clearOptions() {
      options = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'nproc' field.
      * @return The value.
      */
    public java.lang.Integer getNproc() {
      return nproc;
    }

    /**
      * Sets the value of the 'nproc' field.
      * @param value The value of 'nproc'.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder setNproc(int value) {
      validate(fields()[3], value);
      this.nproc = value;
      fieldSetFlags()[3] = true;
      return this; 
    }

    /**
      * Checks whether the 'nproc' field has been set.
      * @return True if the 'nproc' field has been set, false otherwise.
      */
    public boolean hasNproc() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'nproc' field.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder clearNproc() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'is_distributed' field.
      * @return The value.
      */
    public java.lang.Boolean getIsDistributed() {
      return is_distributed;
    }

    /**
      * Sets the value of the 'is_distributed' field.
      * @param value The value of 'is_distributed'.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder setIsDistributed(boolean value) {
      validate(fields()[4], value);
      this.is_distributed = value;
      fieldSetFlags()[4] = true;
      return this; 
    }

    /**
      * Checks whether the 'is_distributed' field has been set.
      * @return True if the 'is_distributed' field has been set, false otherwise.
      */
    public boolean hasIsDistributed() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'is_distributed' field.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder clearIsDistributed() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'task_type' field.
      * @return The value.
      */
    public java.lang.CharSequence getTaskType() {
      return task_type;
    }

    /**
      * Sets the value of the 'task_type' field.
      * @param value The value of 'task_type'.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder setTaskType(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.task_type = value;
      fieldSetFlags()[5] = true;
      return this; 
    }

    /**
      * Checks whether the 'task_type' field has been set.
      * @return True if the 'task_type' field has been set, false otherwise.
      */
    public boolean hasTaskType() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'task_type' field.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder clearTaskType() {
      task_type = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'tool_contract_id' field.
      * @return The value.
      */
    public java.lang.CharSequence getToolContractId() {
      return tool_contract_id;
    }

    /**
      * Sets the value of the 'tool_contract_id' field.
      * @param value The value of 'tool_contract_id'.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder setToolContractId(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.tool_contract_id = value;
      fieldSetFlags()[6] = true;
      return this; 
    }

    /**
      * Checks whether the 'tool_contract_id' field has been set.
      * @return True if the 'tool_contract_id' field has been set, false otherwise.
      */
    public boolean hasToolContractId() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'tool_contract_id' field.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder clearToolContractId() {
      tool_contract_id = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'log_level' field.
      * @return The value.
      */
    public java.lang.CharSequence getLogLevel() {
      return log_level;
    }

    /**
      * Sets the value of the 'log_level' field.
      * @param value The value of 'log_level'.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder setLogLevel(java.lang.CharSequence value) {
      validate(fields()[7], value);
      this.log_level = value;
      fieldSetFlags()[7] = true;
      return this; 
    }

    /**
      * Checks whether the 'log_level' field has been set.
      * @return True if the 'log_level' field has been set, false otherwise.
      */
    public boolean hasLogLevel() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'log_level' field.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder clearLogLevel() {
      log_level = null;
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'resources' field.
      * @return The value.
      */
    public java.util.List<java.lang.CharSequence> getResources() {
      return resources;
    }

    /**
      * Sets the value of the 'resources' field.
      * @param value The value of 'resources'.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder setResources(java.util.List<java.lang.CharSequence> value) {
      validate(fields()[8], value);
      this.resources = value;
      fieldSetFlags()[8] = true;
      return this; 
    }

    /**
      * Checks whether the 'resources' field has been set.
      * @return True if the 'resources' field has been set, false otherwise.
      */
    public boolean hasResources() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'resources' field.
      * @return This builder.
      */
    public com.pacbio.common.models.contracts.ResolvedToolContractTask.Builder clearResources() {
      resources = null;
      fieldSetFlags()[8] = false;
      return this;
    }

    @Override
    public ResolvedToolContractTask build() {
      try {
        ResolvedToolContractTask record = new ResolvedToolContractTask();
        record.input_files = fieldSetFlags()[0] ? this.input_files : (java.util.List<java.lang.CharSequence>) defaultValue(fields()[0]);
        record.output_files = fieldSetFlags()[1] ? this.output_files : (java.util.List<java.lang.CharSequence>) defaultValue(fields()[1]);
        record.options = fieldSetFlags()[2] ? this.options : (java.util.Map<java.lang.CharSequence,java.lang.Object>) defaultValue(fields()[2]);
        record.nproc = fieldSetFlags()[3] ? this.nproc : (java.lang.Integer) defaultValue(fields()[3]);
        record.is_distributed = fieldSetFlags()[4] ? this.is_distributed : (java.lang.Boolean) defaultValue(fields()[4]);
        record.task_type = fieldSetFlags()[5] ? this.task_type : (java.lang.CharSequence) defaultValue(fields()[5]);
        record.tool_contract_id = fieldSetFlags()[6] ? this.tool_contract_id : (java.lang.CharSequence) defaultValue(fields()[6]);
        record.log_level = fieldSetFlags()[7] ? this.log_level : (java.lang.CharSequence) defaultValue(fields()[7]);
        record.resources = fieldSetFlags()[8] ? this.resources : (java.util.List<java.lang.CharSequence>) defaultValue(fields()[8]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  private static final org.apache.avro.io.DatumWriter
    WRITER$ = new org.apache.avro.specific.SpecificDatumWriter(SCHEMA$);  

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, org.apache.avro.specific.SpecificData.getEncoder(out));
  }

  private static final org.apache.avro.io.DatumReader
    READER$ = new org.apache.avro.specific.SpecificDatumReader(SCHEMA$);  

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, org.apache.avro.specific.SpecificData.getDecoder(in));
  }

}
