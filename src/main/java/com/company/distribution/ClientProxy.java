package com.company.distribution;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ClientProxy implements Serializable {

    private String host;
    private int port;
    private int objectID;

    public ClientProxy(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public ClientProxy(String host, int port, int objectid) {
        this.host = host;
        this.port = port;
        this.objectID = objectid;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setobjectID(int objectID) {
        this.objectID = objectID;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public int getobjectID() {
        return objectID;
    }

    public String getMethodName(Object obj) {
        return obj.getClass().getEnclosingMethod().getName();
    }        

    
    public Object operate(ArrayList<Object> parameters, String methodName) throws UnknownHostException, IOException, ClassNotFoundException {

        Invocation invocation = new Invocation();
        invocation.setobjectID(this.getobjectID());
        invocation.setHost(this.getHost());
        invocation.setPort(this.getPort());
        invocation.setMethodName(methodName);
        invocation.setParameters(parameters);

        Requestor requestor = new Requestor();

        return requestor.invoke(invocation).getResult();

    }

    
}

    