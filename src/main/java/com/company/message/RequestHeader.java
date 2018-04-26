package com.company.message;

import java.io.Serializable;

public class RequestHeader implements Serializable {

    private boolean responseExpected;
    private int requestID;
    private String operation;

    public RequestHeader(boolean responseExpected, int requestID, String operation) {
        this.responseExpected = responseExpected;
        this.requestID = requestID;
        this.operation = operation;
    }

    public boolean isResponseExpected() {
        return responseExpected;
    }

    public void setResponseExpected(boolean responseExpected) {
        this.responseExpected = responseExpected;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

}
