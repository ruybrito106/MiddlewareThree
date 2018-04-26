package com.company.message;

import java.io.Serializable;

public class MessageBody implements Serializable {

    private RequestHeader requestHeader;
    private RequestBody requestBody;
    private ResponseHeader responseHeader;
    private ResponseBody responseBody;

    public MessageBody(RequestHeader requestHeader, RequestBody requestBody, ResponseHeader responseHeader, ResponseBody responseBody) {
        this.requestHeader = requestHeader;
        this.requestBody = requestBody;
        this.responseHeader = responseHeader;
        this.responseBody = responseBody;
    }

    public RequestHeader getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(RequestHeader requestHeader) {
        this.requestHeader = requestHeader;
    }

    public RequestBody getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public ResponseBody getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(ResponseBody responseBody) {
        this.responseBody = responseBody;
    }

}
