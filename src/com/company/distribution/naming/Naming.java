package com.company.distribution.naming;

import com.company.distribution.ClientProxy;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Naming implements NamingInterface {

    private NamingRespository respository;

    public Naming() {
        this.respository = new NamingRespository();
    }

    public void bind(String serviceName, ClientProxy client) throws UnknownHostException, IOException, Throwable {
        this.respository.addService(serviceName, client);
    }

    public ClientProxy lookup(String serviceName) throws UnknownHostException, IOException, Throwable {
        return this.respository.getService(serviceName);
    }

    public ArrayList<String> list() throws UnknownHostException, IOException, Throwable {
        return this.respository.getServices();
    }

}
