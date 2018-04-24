package com.company.message;

import java.io.Serializable;

public class ResponseHeader implements Serializable {

    private int requestID;
    private int responseStatus;

    public ResponseHeader(int requestID, int responseStatus) {
        this.requestID = requestID;
        this.responseStatus = responseStatus;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }

}
