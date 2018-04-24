package com.company.message;

import java.io.Serializable;
import java.util.ArrayList;

public class RequestBody implements Serializable {

    private ArrayList<Object> parameters;

    public RequestBody(ArrayList<Object> parameters) {
        this.parameters = parameters;
    }

    public ArrayList<Object> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Object> parameters) {
        this.parameters = parameters;
    }

}
