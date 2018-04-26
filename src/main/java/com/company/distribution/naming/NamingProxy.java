package com.company.distribution.naming;

import com.company.distribution.ClientProxy;
import com.company.distribution.Invocation;
import com.company.distribution.Requestor;
import com.company.distribution.Termination;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class NamingProxy extends ClientProxy implements NamingInterface {

    public NamingProxy(String host, int port) {
        super(host, port);
    }

    @Override
    public void bind(String serviceName, ClientProxy clientProxy) throws UnknownHostException, IOException, Throwable {
        ArrayList<Object> params = new ArrayList<Object>();
        params.add(serviceName);
        params.add(clientProxy);

        operate(params, getMethodName(new Object(){}));
    }

    @Override
    public ClientProxy lookup(String serviceName) throws UnknownHostException, IOException, Throwable {
        
        ArrayList<Object> params = new ArrayList<Object>();
        params.add(serviceName);

        return (ClientProxy) operate(params, getMethodName(new Object(){}));
    }

    @Override
    public ArrayList<String> list() throws UnknownHostException, IOException, Throwable {
        
        @SuppressWarnings("unchecked")
        ArrayList<String> operate = (ArrayList<String>) operate(null, getMethodName(new Object(){}));
		return operate;
    }

}
