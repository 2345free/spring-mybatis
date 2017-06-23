/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package thrift.example;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-06-23")
public class BeanExample implements org.apache.thrift.TBase<BeanExample, BeanExample._Fields>, java.io.Serializable, Cloneable, Comparable<BeanExample> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BeanExample");

  private static final org.apache.thrift.protocol.TField BOOLEAN_PRIMIVE_FIELD_DESC = new org.apache.thrift.protocol.TField("booleanPrimive", org.apache.thrift.protocol.TType.BOOL, (short)1);
  private static final org.apache.thrift.protocol.TField BYTE_PRIMIVE_FIELD_DESC = new org.apache.thrift.protocol.TField("bytePrimive", org.apache.thrift.protocol.TType.BYTE, (short)2);
  private static final org.apache.thrift.protocol.TField SHORT_PRIMIVE_FIELD_DESC = new org.apache.thrift.protocol.TField("shortPrimive", org.apache.thrift.protocol.TType.I16, (short)3);
  private static final org.apache.thrift.protocol.TField INT_PRIMIVE_FIELD_DESC = new org.apache.thrift.protocol.TField("intPrimive", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField LONG_PRIMIVE_FIELD_DESC = new org.apache.thrift.protocol.TField("longPrimive", org.apache.thrift.protocol.TType.I64, (short)5);
  private static final org.apache.thrift.protocol.TField DOUBLE_PRIMIVE_FIELD_DESC = new org.apache.thrift.protocol.TField("doublePrimive", org.apache.thrift.protocol.TType.DOUBLE, (short)6);
  private static final org.apache.thrift.protocol.TField STRING_OBJECT_FIELD_DESC = new org.apache.thrift.protocol.TField("stringObject", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField BYTE_ARRAY_FIELD_DESC = new org.apache.thrift.protocol.TField("byteArray", org.apache.thrift.protocol.TType.STRING, (short)8);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new BeanExampleStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new BeanExampleTupleSchemeFactory();

  public boolean booleanPrimive; // required
  public byte bytePrimive; // required
  public short shortPrimive; // required
  public int intPrimive; // required
  public long longPrimive; // required
  public double doublePrimive; // required
  public java.lang.String stringObject; // required
  public java.nio.ByteBuffer byteArray; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BOOLEAN_PRIMIVE((short)1, "booleanPrimive"),
    BYTE_PRIMIVE((short)2, "bytePrimive"),
    SHORT_PRIMIVE((short)3, "shortPrimive"),
    INT_PRIMIVE((short)4, "intPrimive"),
    LONG_PRIMIVE((short)5, "longPrimive"),
    DOUBLE_PRIMIVE((short)6, "doublePrimive"),
    STRING_OBJECT((short)7, "stringObject"),
    BYTE_ARRAY((short)8, "byteArray");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // BOOLEAN_PRIMIVE
          return BOOLEAN_PRIMIVE;
        case 2: // BYTE_PRIMIVE
          return BYTE_PRIMIVE;
        case 3: // SHORT_PRIMIVE
          return SHORT_PRIMIVE;
        case 4: // INT_PRIMIVE
          return INT_PRIMIVE;
        case 5: // LONG_PRIMIVE
          return LONG_PRIMIVE;
        case 6: // DOUBLE_PRIMIVE
          return DOUBLE_PRIMIVE;
        case 7: // STRING_OBJECT
          return STRING_OBJECT;
        case 8: // BYTE_ARRAY
          return BYTE_ARRAY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __BOOLEANPRIMIVE_ISSET_ID = 0;
  private static final int __BYTEPRIMIVE_ISSET_ID = 1;
  private static final int __SHORTPRIMIVE_ISSET_ID = 2;
  private static final int __INTPRIMIVE_ISSET_ID = 3;
  private static final int __LONGPRIMIVE_ISSET_ID = 4;
  private static final int __DOUBLEPRIMIVE_ISSET_ID = 5;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BOOLEAN_PRIMIVE, new org.apache.thrift.meta_data.FieldMetaData("booleanPrimive", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    tmpMap.put(_Fields.BYTE_PRIMIVE, new org.apache.thrift.meta_data.FieldMetaData("bytePrimive", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BYTE)));
    tmpMap.put(_Fields.SHORT_PRIMIVE, new org.apache.thrift.meta_data.FieldMetaData("shortPrimive", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I16)));
    tmpMap.put(_Fields.INT_PRIMIVE, new org.apache.thrift.meta_data.FieldMetaData("intPrimive", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.LONG_PRIMIVE, new org.apache.thrift.meta_data.FieldMetaData("longPrimive", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.DOUBLE_PRIMIVE, new org.apache.thrift.meta_data.FieldMetaData("doublePrimive", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    tmpMap.put(_Fields.STRING_OBJECT, new org.apache.thrift.meta_data.FieldMetaData("stringObject", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BYTE_ARRAY, new org.apache.thrift.meta_data.FieldMetaData("byteArray", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BeanExample.class, metaDataMap);
  }

  public BeanExample() {
  }

  public BeanExample(
    boolean booleanPrimive,
    byte bytePrimive,
    short shortPrimive,
    int intPrimive,
    long longPrimive,
    double doublePrimive,
    java.lang.String stringObject,
    java.nio.ByteBuffer byteArray)
  {
    this();
    this.booleanPrimive = booleanPrimive;
    setBooleanPrimiveIsSet(true);
    this.bytePrimive = bytePrimive;
    setBytePrimiveIsSet(true);
    this.shortPrimive = shortPrimive;
    setShortPrimiveIsSet(true);
    this.intPrimive = intPrimive;
    setIntPrimiveIsSet(true);
    this.longPrimive = longPrimive;
    setLongPrimiveIsSet(true);
    this.doublePrimive = doublePrimive;
    setDoublePrimiveIsSet(true);
    this.stringObject = stringObject;
    this.byteArray = org.apache.thrift.TBaseHelper.copyBinary(byteArray);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BeanExample(BeanExample other) {
    __isset_bitfield = other.__isset_bitfield;
    this.booleanPrimive = other.booleanPrimive;
    this.bytePrimive = other.bytePrimive;
    this.shortPrimive = other.shortPrimive;
    this.intPrimive = other.intPrimive;
    this.longPrimive = other.longPrimive;
    this.doublePrimive = other.doublePrimive;
    if (other.isSetStringObject()) {
      this.stringObject = other.stringObject;
    }
    if (other.isSetByteArray()) {
      this.byteArray = org.apache.thrift.TBaseHelper.copyBinary(other.byteArray);
    }
  }

  public BeanExample deepCopy() {
    return new BeanExample(this);
  }

  @Override
  public void clear() {
    setBooleanPrimiveIsSet(false);
    this.booleanPrimive = false;
    setBytePrimiveIsSet(false);
    this.bytePrimive = 0;
    setShortPrimiveIsSet(false);
    this.shortPrimive = 0;
    setIntPrimiveIsSet(false);
    this.intPrimive = 0;
    setLongPrimiveIsSet(false);
    this.longPrimive = 0;
    setDoublePrimiveIsSet(false);
    this.doublePrimive = 0.0;
    this.stringObject = null;
    this.byteArray = null;
  }

  public boolean isBooleanPrimive() {
    return this.booleanPrimive;
  }

  public BeanExample setBooleanPrimive(boolean booleanPrimive) {
    this.booleanPrimive = booleanPrimive;
    setBooleanPrimiveIsSet(true);
    return this;
  }

  public void unsetBooleanPrimive() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __BOOLEANPRIMIVE_ISSET_ID);
  }

  /** Returns true if field booleanPrimive is set (has been assigned a value) and false otherwise */
  public boolean isSetBooleanPrimive() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __BOOLEANPRIMIVE_ISSET_ID);
  }

  public void setBooleanPrimiveIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __BOOLEANPRIMIVE_ISSET_ID, value);
  }

  public byte getBytePrimive() {
    return this.bytePrimive;
  }

  public BeanExample setBytePrimive(byte bytePrimive) {
    this.bytePrimive = bytePrimive;
    setBytePrimiveIsSet(true);
    return this;
  }

  public void unsetBytePrimive() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __BYTEPRIMIVE_ISSET_ID);
  }

  /** Returns true if field bytePrimive is set (has been assigned a value) and false otherwise */
  public boolean isSetBytePrimive() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __BYTEPRIMIVE_ISSET_ID);
  }

  public void setBytePrimiveIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __BYTEPRIMIVE_ISSET_ID, value);
  }

  public short getShortPrimive() {
    return this.shortPrimive;
  }

  public BeanExample setShortPrimive(short shortPrimive) {
    this.shortPrimive = shortPrimive;
    setShortPrimiveIsSet(true);
    return this;
  }

  public void unsetShortPrimive() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __SHORTPRIMIVE_ISSET_ID);
  }

  /** Returns true if field shortPrimive is set (has been assigned a value) and false otherwise */
  public boolean isSetShortPrimive() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __SHORTPRIMIVE_ISSET_ID);
  }

  public void setShortPrimiveIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __SHORTPRIMIVE_ISSET_ID, value);
  }

  public int getIntPrimive() {
    return this.intPrimive;
  }

  public BeanExample setIntPrimive(int intPrimive) {
    this.intPrimive = intPrimive;
    setIntPrimiveIsSet(true);
    return this;
  }

  public void unsetIntPrimive() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __INTPRIMIVE_ISSET_ID);
  }

  /** Returns true if field intPrimive is set (has been assigned a value) and false otherwise */
  public boolean isSetIntPrimive() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __INTPRIMIVE_ISSET_ID);
  }

  public void setIntPrimiveIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __INTPRIMIVE_ISSET_ID, value);
  }

  public long getLongPrimive() {
    return this.longPrimive;
  }

  public BeanExample setLongPrimive(long longPrimive) {
    this.longPrimive = longPrimive;
    setLongPrimiveIsSet(true);
    return this;
  }

  public void unsetLongPrimive() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __LONGPRIMIVE_ISSET_ID);
  }

  /** Returns true if field longPrimive is set (has been assigned a value) and false otherwise */
  public boolean isSetLongPrimive() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __LONGPRIMIVE_ISSET_ID);
  }

  public void setLongPrimiveIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __LONGPRIMIVE_ISSET_ID, value);
  }

  public double getDoublePrimive() {
    return this.doublePrimive;
  }

  public BeanExample setDoublePrimive(double doublePrimive) {
    this.doublePrimive = doublePrimive;
    setDoublePrimiveIsSet(true);
    return this;
  }

  public void unsetDoublePrimive() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __DOUBLEPRIMIVE_ISSET_ID);
  }

  /** Returns true if field doublePrimive is set (has been assigned a value) and false otherwise */
  public boolean isSetDoublePrimive() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __DOUBLEPRIMIVE_ISSET_ID);
  }

  public void setDoublePrimiveIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __DOUBLEPRIMIVE_ISSET_ID, value);
  }

  public java.lang.String getStringObject() {
    return this.stringObject;
  }

  public BeanExample setStringObject(java.lang.String stringObject) {
    this.stringObject = stringObject;
    return this;
  }

  public void unsetStringObject() {
    this.stringObject = null;
  }

  /** Returns true if field stringObject is set (has been assigned a value) and false otherwise */
  public boolean isSetStringObject() {
    return this.stringObject != null;
  }

  public void setStringObjectIsSet(boolean value) {
    if (!value) {
      this.stringObject = null;
    }
  }

  public byte[] getByteArray() {
    setByteArray(org.apache.thrift.TBaseHelper.rightSize(byteArray));
    return byteArray == null ? null : byteArray.array();
  }

  public java.nio.ByteBuffer bufferForByteArray() {
    return org.apache.thrift.TBaseHelper.copyBinary(byteArray);
  }

  public BeanExample setByteArray(byte[] byteArray) {
    this.byteArray = byteArray == null ? (java.nio.ByteBuffer)null : java.nio.ByteBuffer.wrap(byteArray.clone());
    return this;
  }

  public BeanExample setByteArray(java.nio.ByteBuffer byteArray) {
    this.byteArray = org.apache.thrift.TBaseHelper.copyBinary(byteArray);
    return this;
  }

  public void unsetByteArray() {
    this.byteArray = null;
  }

  /** Returns true if field byteArray is set (has been assigned a value) and false otherwise */
  public boolean isSetByteArray() {
    return this.byteArray != null;
  }

  public void setByteArrayIsSet(boolean value) {
    if (!value) {
      this.byteArray = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case BOOLEAN_PRIMIVE:
      if (value == null) {
        unsetBooleanPrimive();
      } else {
        setBooleanPrimive((java.lang.Boolean)value);
      }
      break;

    case BYTE_PRIMIVE:
      if (value == null) {
        unsetBytePrimive();
      } else {
        setBytePrimive((java.lang.Byte)value);
      }
      break;

    case SHORT_PRIMIVE:
      if (value == null) {
        unsetShortPrimive();
      } else {
        setShortPrimive((java.lang.Short)value);
      }
      break;

    case INT_PRIMIVE:
      if (value == null) {
        unsetIntPrimive();
      } else {
        setIntPrimive((java.lang.Integer)value);
      }
      break;

    case LONG_PRIMIVE:
      if (value == null) {
        unsetLongPrimive();
      } else {
        setLongPrimive((java.lang.Long)value);
      }
      break;

    case DOUBLE_PRIMIVE:
      if (value == null) {
        unsetDoublePrimive();
      } else {
        setDoublePrimive((java.lang.Double)value);
      }
      break;

    case STRING_OBJECT:
      if (value == null) {
        unsetStringObject();
      } else {
        setStringObject((java.lang.String)value);
      }
      break;

    case BYTE_ARRAY:
      if (value == null) {
        unsetByteArray();
      } else {
        if (value instanceof byte[]) {
          setByteArray((byte[])value);
        } else {
          setByteArray((java.nio.ByteBuffer)value);
        }
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case BOOLEAN_PRIMIVE:
      return isBooleanPrimive();

    case BYTE_PRIMIVE:
      return getBytePrimive();

    case SHORT_PRIMIVE:
      return getShortPrimive();

    case INT_PRIMIVE:
      return getIntPrimive();

    case LONG_PRIMIVE:
      return getLongPrimive();

    case DOUBLE_PRIMIVE:
      return getDoublePrimive();

    case STRING_OBJECT:
      return getStringObject();

    case BYTE_ARRAY:
      return getByteArray();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case BOOLEAN_PRIMIVE:
      return isSetBooleanPrimive();
    case BYTE_PRIMIVE:
      return isSetBytePrimive();
    case SHORT_PRIMIVE:
      return isSetShortPrimive();
    case INT_PRIMIVE:
      return isSetIntPrimive();
    case LONG_PRIMIVE:
      return isSetLongPrimive();
    case DOUBLE_PRIMIVE:
      return isSetDoublePrimive();
    case STRING_OBJECT:
      return isSetStringObject();
    case BYTE_ARRAY:
      return isSetByteArray();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof BeanExample)
      return this.equals((BeanExample)that);
    return false;
  }

  public boolean equals(BeanExample that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_booleanPrimive = true;
    boolean that_present_booleanPrimive = true;
    if (this_present_booleanPrimive || that_present_booleanPrimive) {
      if (!(this_present_booleanPrimive && that_present_booleanPrimive))
        return false;
      if (this.booleanPrimive != that.booleanPrimive)
        return false;
    }

    boolean this_present_bytePrimive = true;
    boolean that_present_bytePrimive = true;
    if (this_present_bytePrimive || that_present_bytePrimive) {
      if (!(this_present_bytePrimive && that_present_bytePrimive))
        return false;
      if (this.bytePrimive != that.bytePrimive)
        return false;
    }

    boolean this_present_shortPrimive = true;
    boolean that_present_shortPrimive = true;
    if (this_present_shortPrimive || that_present_shortPrimive) {
      if (!(this_present_shortPrimive && that_present_shortPrimive))
        return false;
      if (this.shortPrimive != that.shortPrimive)
        return false;
    }

    boolean this_present_intPrimive = true;
    boolean that_present_intPrimive = true;
    if (this_present_intPrimive || that_present_intPrimive) {
      if (!(this_present_intPrimive && that_present_intPrimive))
        return false;
      if (this.intPrimive != that.intPrimive)
        return false;
    }

    boolean this_present_longPrimive = true;
    boolean that_present_longPrimive = true;
    if (this_present_longPrimive || that_present_longPrimive) {
      if (!(this_present_longPrimive && that_present_longPrimive))
        return false;
      if (this.longPrimive != that.longPrimive)
        return false;
    }

    boolean this_present_doublePrimive = true;
    boolean that_present_doublePrimive = true;
    if (this_present_doublePrimive || that_present_doublePrimive) {
      if (!(this_present_doublePrimive && that_present_doublePrimive))
        return false;
      if (this.doublePrimive != that.doublePrimive)
        return false;
    }

    boolean this_present_stringObject = true && this.isSetStringObject();
    boolean that_present_stringObject = true && that.isSetStringObject();
    if (this_present_stringObject || that_present_stringObject) {
      if (!(this_present_stringObject && that_present_stringObject))
        return false;
      if (!this.stringObject.equals(that.stringObject))
        return false;
    }

    boolean this_present_byteArray = true && this.isSetByteArray();
    boolean that_present_byteArray = true && that.isSetByteArray();
    if (this_present_byteArray || that_present_byteArray) {
      if (!(this_present_byteArray && that_present_byteArray))
        return false;
      if (!this.byteArray.equals(that.byteArray))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((booleanPrimive) ? 131071 : 524287);

    hashCode = hashCode * 8191 + (int) (bytePrimive);

    hashCode = hashCode * 8191 + shortPrimive;

    hashCode = hashCode * 8191 + intPrimive;

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(longPrimive);

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(doublePrimive);

    hashCode = hashCode * 8191 + ((isSetStringObject()) ? 131071 : 524287);
    if (isSetStringObject())
      hashCode = hashCode * 8191 + stringObject.hashCode();

    hashCode = hashCode * 8191 + ((isSetByteArray()) ? 131071 : 524287);
    if (isSetByteArray())
      hashCode = hashCode * 8191 + byteArray.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(BeanExample other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetBooleanPrimive()).compareTo(other.isSetBooleanPrimive());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBooleanPrimive()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.booleanPrimive, other.booleanPrimive);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetBytePrimive()).compareTo(other.isSetBytePrimive());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBytePrimive()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bytePrimive, other.bytePrimive);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetShortPrimive()).compareTo(other.isSetShortPrimive());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetShortPrimive()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.shortPrimive, other.shortPrimive);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetIntPrimive()).compareTo(other.isSetIntPrimive());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIntPrimive()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.intPrimive, other.intPrimive);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetLongPrimive()).compareTo(other.isSetLongPrimive());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLongPrimive()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.longPrimive, other.longPrimive);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetDoublePrimive()).compareTo(other.isSetDoublePrimive());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDoublePrimive()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.doublePrimive, other.doublePrimive);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetStringObject()).compareTo(other.isSetStringObject());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStringObject()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.stringObject, other.stringObject);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetByteArray()).compareTo(other.isSetByteArray());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetByteArray()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.byteArray, other.byteArray);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("BeanExample(");
    boolean first = true;

    sb.append("booleanPrimive:");
    sb.append(this.booleanPrimive);
    first = false;
    if (!first) sb.append(", ");
    sb.append("bytePrimive:");
    sb.append(this.bytePrimive);
    first = false;
    if (!first) sb.append(", ");
    sb.append("shortPrimive:");
    sb.append(this.shortPrimive);
    first = false;
    if (!first) sb.append(", ");
    sb.append("intPrimive:");
    sb.append(this.intPrimive);
    first = false;
    if (!first) sb.append(", ");
    sb.append("longPrimive:");
    sb.append(this.longPrimive);
    first = false;
    if (!first) sb.append(", ");
    sb.append("doublePrimive:");
    sb.append(this.doublePrimive);
    first = false;
    if (!first) sb.append(", ");
    sb.append("stringObject:");
    if (this.stringObject == null) {
      sb.append("null");
    } else {
      sb.append(this.stringObject);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("byteArray:");
    if (this.byteArray == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.byteArray, sb);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BeanExampleStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public BeanExampleStandardScheme getScheme() {
      return new BeanExampleStandardScheme();
    }
  }

  private static class BeanExampleStandardScheme extends org.apache.thrift.scheme.StandardScheme<BeanExample> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BeanExample struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BOOLEAN_PRIMIVE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.booleanPrimive = iprot.readBool();
              struct.setBooleanPrimiveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // BYTE_PRIMIVE
            if (schemeField.type == org.apache.thrift.protocol.TType.BYTE) {
              struct.bytePrimive = iprot.readByte();
              struct.setBytePrimiveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // SHORT_PRIMIVE
            if (schemeField.type == org.apache.thrift.protocol.TType.I16) {
              struct.shortPrimive = iprot.readI16();
              struct.setShortPrimiveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // INT_PRIMIVE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.intPrimive = iprot.readI32();
              struct.setIntPrimiveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // LONG_PRIMIVE
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.longPrimive = iprot.readI64();
              struct.setLongPrimiveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // DOUBLE_PRIMIVE
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.doublePrimive = iprot.readDouble();
              struct.setDoublePrimiveIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // STRING_OBJECT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.stringObject = iprot.readString();
              struct.setStringObjectIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // BYTE_ARRAY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.byteArray = iprot.readBinary();
              struct.setByteArrayIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, BeanExample struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(BOOLEAN_PRIMIVE_FIELD_DESC);
      oprot.writeBool(struct.booleanPrimive);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(BYTE_PRIMIVE_FIELD_DESC);
      oprot.writeByte(struct.bytePrimive);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(SHORT_PRIMIVE_FIELD_DESC);
      oprot.writeI16(struct.shortPrimive);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(INT_PRIMIVE_FIELD_DESC);
      oprot.writeI32(struct.intPrimive);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(LONG_PRIMIVE_FIELD_DESC);
      oprot.writeI64(struct.longPrimive);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(DOUBLE_PRIMIVE_FIELD_DESC);
      oprot.writeDouble(struct.doublePrimive);
      oprot.writeFieldEnd();
      if (struct.stringObject != null) {
        oprot.writeFieldBegin(STRING_OBJECT_FIELD_DESC);
        oprot.writeString(struct.stringObject);
        oprot.writeFieldEnd();
      }
      if (struct.byteArray != null) {
        oprot.writeFieldBegin(BYTE_ARRAY_FIELD_DESC);
        oprot.writeBinary(struct.byteArray);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BeanExampleTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public BeanExampleTupleScheme getScheme() {
      return new BeanExampleTupleScheme();
    }
  }

  private static class BeanExampleTupleScheme extends org.apache.thrift.scheme.TupleScheme<BeanExample> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BeanExample struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetBooleanPrimive()) {
        optionals.set(0);
      }
      if (struct.isSetBytePrimive()) {
        optionals.set(1);
      }
      if (struct.isSetShortPrimive()) {
        optionals.set(2);
      }
      if (struct.isSetIntPrimive()) {
        optionals.set(3);
      }
      if (struct.isSetLongPrimive()) {
        optionals.set(4);
      }
      if (struct.isSetDoublePrimive()) {
        optionals.set(5);
      }
      if (struct.isSetStringObject()) {
        optionals.set(6);
      }
      if (struct.isSetByteArray()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetBooleanPrimive()) {
        oprot.writeBool(struct.booleanPrimive);
      }
      if (struct.isSetBytePrimive()) {
        oprot.writeByte(struct.bytePrimive);
      }
      if (struct.isSetShortPrimive()) {
        oprot.writeI16(struct.shortPrimive);
      }
      if (struct.isSetIntPrimive()) {
        oprot.writeI32(struct.intPrimive);
      }
      if (struct.isSetLongPrimive()) {
        oprot.writeI64(struct.longPrimive);
      }
      if (struct.isSetDoublePrimive()) {
        oprot.writeDouble(struct.doublePrimive);
      }
      if (struct.isSetStringObject()) {
        oprot.writeString(struct.stringObject);
      }
      if (struct.isSetByteArray()) {
        oprot.writeBinary(struct.byteArray);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BeanExample struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.booleanPrimive = iprot.readBool();
        struct.setBooleanPrimiveIsSet(true);
      }
      if (incoming.get(1)) {
        struct.bytePrimive = iprot.readByte();
        struct.setBytePrimiveIsSet(true);
      }
      if (incoming.get(2)) {
        struct.shortPrimive = iprot.readI16();
        struct.setShortPrimiveIsSet(true);
      }
      if (incoming.get(3)) {
        struct.intPrimive = iprot.readI32();
        struct.setIntPrimiveIsSet(true);
      }
      if (incoming.get(4)) {
        struct.longPrimive = iprot.readI64();
        struct.setLongPrimiveIsSet(true);
      }
      if (incoming.get(5)) {
        struct.doublePrimive = iprot.readDouble();
        struct.setDoublePrimiveIsSet(true);
      }
      if (incoming.get(6)) {
        struct.stringObject = iprot.readString();
        struct.setStringObjectIsSet(true);
      }
      if (incoming.get(7)) {
        struct.byteArray = iprot.readBinary();
        struct.setByteArrayIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

