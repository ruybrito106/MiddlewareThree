package com.company.distribution.naming;

import com.company.distribution.ClientProxy;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Naming implements NamingInterface {

    private NamingRepository repository;

    public Naming() {
        this.repository = new NamingRepository();
    }

    public void bind(String serviceName, ClientProxy client) throws UnknownHostException, IOException, Throwable {
        this.repository.addService(serviceName, client);
    }

    public ClientProxy lookup(String serviceName) throws UnknownHostException, IOException, Throwable {
        return this.repository.getService(serviceName);
    }

    public ArrayList<String> list() throws UnknownHostException, IOException, Throwable {
        return this.repository.getServices();
    }

}
