package com.company.distribution;

import java.io.Serializable;

public class ClientProxy implements Serializable {

    private String host;
    private int port;
    private int objectID;

    public ClientProxy(String host, int port) {
        this.host = host;
        this.port = port;
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

}
