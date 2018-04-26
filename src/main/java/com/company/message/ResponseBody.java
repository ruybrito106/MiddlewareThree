package com.company.message;

import java.io.Serializable;

public class ResponseBody implements Serializable {

    private Object operationResult;

    public ResponseBody(Object operationResult) {
        this.operationResult = operationResult;
    }

    public Object getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(Object operationResult) {
        this.operationResult = operationResult;
    }

}
