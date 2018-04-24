package com.company.distribution.naming;

import com.company.distribution.ClientProxy;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public interface NamingInterface {
    void bind(String serviceName, ClientProxy proxy) throws UnknownHostException, IOException, Throwable;
    ClientProxy lookup(String serviceName) throws UnknownHostException, IOException, Throwable;
    ArrayList<String> list() throws UnknownHostException, IOException, Throwable;
}
