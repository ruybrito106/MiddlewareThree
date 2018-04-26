package com.company.message;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {

    private MessageHeader header;
    private MessageBody body;

    public Message() {}

    public Message(MessageHeader header, MessageBody body) {
        this.header = header;
        this.body = body;
    }

    public Message NewRequestMessage(boolean responseExpected, int requestID, String methodName, ArrayList<Object> parameters) {
        RequestHeader requestHeader = new RequestHeader(responseExpected, requestID, methodName);
        RequestBody requestBody = new RequestBody(parameters);

        MessageHeader messageHeader = new MessageHeader(1, true, 0, 0);
        MessageBody messageBody = new MessageBody(requestHeader, requestBody, null, null);

        return new Message(messageHeader, messageBody);
    }

    public Message NewResponseMessage(int requestID, int status, Object result) {
        ResponseHeader responseHeader = new ResponseHeader(requestID, status);
        ResponseBody responseBody = new ResponseBody(result);

        MessageHeader messageHeader = new MessageHeader(1, true, 0, 0);
        MessageBody messageBody = new MessageBody(null, null, responseHeader, responseBody);

        return new Message(messageHeader, messageBody);
    }

    public MessageHeader getHeader() {
        return header;
    }

    public void setHeader(MessageHeader header) {
        this.header = header;
    }

    public MessageBody getBody() {
        return body;
    }

    public void setBody(MessageBody body) {
        this.body = body;
    }

}
