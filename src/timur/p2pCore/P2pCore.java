// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: P2pCore.proto

package timur.p2pCore;

public final class P2pCore {
  private P2pCore() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  public static final class Message extends
      com.google.protobuf.GeneratedMessageLite {
    // Use Message.newBuilder() to construct.
    private Message() {
      initFields();
    }
    private Message(boolean noInit) {}
    
    private static final Message defaultInstance;
    public static Message getDefaultInstance() {
      return defaultInstance;
    }
    
    public Message getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    // required string command = 1;
    public static final int COMMAND_FIELD_NUMBER = 1;
    private boolean hasCommand;
    private java.lang.String command_ = "";
    public boolean hasCommand() { return hasCommand; }
    public java.lang.String getCommand() { return command_; }
    
    // optional int64 msgId = 2;
    public static final int MSGID_FIELD_NUMBER = 2;
    private boolean hasMsgId;
    private long msgId_ = 0L;
    public boolean hasMsgId() { return hasMsgId; }
    public long getMsgId() { return msgId_; }
    
    // optional int64 msgLength = 3;
    public static final int MSGLENGTH_FIELD_NUMBER = 3;
    private boolean hasMsgLength;
    private long msgLength_ = 0L;
    public boolean hasMsgLength() { return hasMsgLength; }
    public long getMsgLength() { return msgLength_; }
    
    // optional string msgString = 4;
    public static final int MSGSTRING_FIELD_NUMBER = 4;
    private boolean hasMsgString;
    private java.lang.String msgString_ = "";
    public boolean hasMsgString() { return hasMsgString; }
    public java.lang.String getMsgString() { return msgString_; }
    
    // optional bytes msgBytes = 5;
    public static final int MSGBYTES_FIELD_NUMBER = 5;
    private boolean hasMsgBytes;
    private com.google.protobuf.ByteString msgBytes_ = com.google.protobuf.ByteString.EMPTY;
    public boolean hasMsgBytes() { return hasMsgBytes; }
    public com.google.protobuf.ByteString getMsgBytes() { return msgBytes_; }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      if (!hasCommand) return false;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasCommand()) {
        output.writeString(1, getCommand());
      }
      if (hasMsgId()) {
        output.writeInt64(2, getMsgId());
      }
      if (hasMsgLength()) {
        output.writeInt64(3, getMsgLength());
      }
      if (hasMsgString()) {
        output.writeString(4, getMsgString());
      }
      if (hasMsgBytes()) {
        output.writeBytes(5, getMsgBytes());
      }
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasCommand()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(1, getCommand());
      }
      if (hasMsgId()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(2, getMsgId());
      }
      if (hasMsgLength()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(3, getMsgLength());
      }
      if (hasMsgString()) {
        size += com.google.protobuf.CodedOutputStream
          .computeStringSize(4, getMsgString());
      }
      if (hasMsgBytes()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(5, getMsgBytes());
      }
      memoizedSerializedSize = size;
      return size;
    }
    
    public static timur.p2pCore.P2pCore.Message parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static timur.p2pCore.P2pCore.Message parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static timur.p2pCore.P2pCore.Message parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static timur.p2pCore.P2pCore.Message parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static timur.p2pCore.P2pCore.Message parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static timur.p2pCore.P2pCore.Message parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static timur.p2pCore.P2pCore.Message parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static timur.p2pCore.P2pCore.Message parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static timur.p2pCore.P2pCore.Message parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static timur.p2pCore.P2pCore.Message parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(timur.p2pCore.P2pCore.Message prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
          timur.p2pCore.P2pCore.Message, Builder> {
      private timur.p2pCore.P2pCore.Message result;
      
      // Construct using timur.p2pCore.P2pCore.Message.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new timur.p2pCore.P2pCore.Message();
        return builder;
      }
      
      protected timur.p2pCore.P2pCore.Message internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new timur.p2pCore.P2pCore.Message();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public timur.p2pCore.P2pCore.Message getDefaultInstanceForType() {
        return timur.p2pCore.P2pCore.Message.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public timur.p2pCore.P2pCore.Message build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private timur.p2pCore.P2pCore.Message buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public timur.p2pCore.P2pCore.Message buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        timur.p2pCore.P2pCore.Message returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(timur.p2pCore.P2pCore.Message other) {
        if (other == timur.p2pCore.P2pCore.Message.getDefaultInstance()) return this;
        if (other.hasCommand()) {
          setCommand(other.getCommand());
        }
        if (other.hasMsgId()) {
          setMsgId(other.getMsgId());
        }
        if (other.hasMsgLength()) {
          setMsgLength(other.getMsgLength());
        }
        if (other.hasMsgString()) {
          setMsgString(other.getMsgString());
        }
        if (other.hasMsgBytes()) {
          setMsgBytes(other.getMsgBytes());
        }
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              return this;
            default: {
              if (!parseUnknownField(input, extensionRegistry, tag)) {
                return this;
              }
              break;
            }
            case 10: {
              setCommand(input.readString());
              break;
            }
            case 16: {
              setMsgId(input.readInt64());
              break;
            }
            case 24: {
              setMsgLength(input.readInt64());
              break;
            }
            case 34: {
              setMsgString(input.readString());
              break;
            }
            case 42: {
              setMsgBytes(input.readBytes());
              break;
            }
          }
        }
      }
      
      
      // required string command = 1;
      public boolean hasCommand() {
        return result.hasCommand();
      }
      public java.lang.String getCommand() {
        return result.getCommand();
      }
      public Builder setCommand(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasCommand = true;
        result.command_ = value;
        return this;
      }
      public Builder clearCommand() {
        result.hasCommand = false;
        result.command_ = getDefaultInstance().getCommand();
        return this;
      }
      
      // optional int64 msgId = 2;
      public boolean hasMsgId() {
        return result.hasMsgId();
      }
      public long getMsgId() {
        return result.getMsgId();
      }
      public Builder setMsgId(long value) {
        result.hasMsgId = true;
        result.msgId_ = value;
        return this;
      }
      public Builder clearMsgId() {
        result.hasMsgId = false;
        result.msgId_ = 0L;
        return this;
      }
      
      // optional int64 msgLength = 3;
      public boolean hasMsgLength() {
        return result.hasMsgLength();
      }
      public long getMsgLength() {
        return result.getMsgLength();
      }
      public Builder setMsgLength(long value) {
        result.hasMsgLength = true;
        result.msgLength_ = value;
        return this;
      }
      public Builder clearMsgLength() {
        result.hasMsgLength = false;
        result.msgLength_ = 0L;
        return this;
      }
      
      // optional string msgString = 4;
      public boolean hasMsgString() {
        return result.hasMsgString();
      }
      public java.lang.String getMsgString() {
        return result.getMsgString();
      }
      public Builder setMsgString(java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasMsgString = true;
        result.msgString_ = value;
        return this;
      }
      public Builder clearMsgString() {
        result.hasMsgString = false;
        result.msgString_ = getDefaultInstance().getMsgString();
        return this;
      }
      
      // optional bytes msgBytes = 5;
      public boolean hasMsgBytes() {
        return result.hasMsgBytes();
      }
      public com.google.protobuf.ByteString getMsgBytes() {
        return result.getMsgBytes();
      }
      public Builder setMsgBytes(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  result.hasMsgBytes = true;
        result.msgBytes_ = value;
        return this;
      }
      public Builder clearMsgBytes() {
        result.hasMsgBytes = false;
        result.msgBytes_ = getDefaultInstance().getMsgBytes();
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:p2pCore.Message)
    }
    
    static {
      defaultInstance = new Message(true);
      timur.p2pCore.P2pCore.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:p2pCore.Message)
  }
  
  
  static {
  }
  
  public static void internalForceInit() {}
  
  // @@protoc_insertion_point(outer_class_scope)
}
