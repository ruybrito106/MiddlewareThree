package com.company.message;

public class MessageHeader {

    private int version;
    private boolean byteOrder;
    private int messageType;
    private long messageSize;

    public MessageHeader(int version, boolean byteOrder, int messageType, long messageSize) {
        this.version = version;
        this.byteOrder = byteOrder;
        this.messageType = messageType;
        this.messageSize = messageSize;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean isByteOrder() {
        return byteOrder;
    }

    public void setByteOrder(boolean byteOrder) {
        this.byteOrder = byteOrder;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public long getMessageSize() {
        return messageSize;
    }

    public void setMessageSize(long messageSize) {
        this.messageSize = messageSize;
    }

}
