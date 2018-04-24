package com.company.distribution;

import java.util.ArrayList;

public class Invocation {

    private int objectID;
    private String host;
    private int port;
    private String methodName;
    private ArrayList<Object> parameters;

    public Invocation(){}

    public int getObjectId() {
        return objectID;
    }

    public void setobjectID(int objectID) {
        this.objectID = objectID;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public ArrayList<Object> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Object> parameters) {
        this.parameters = parameters;
    }

}
