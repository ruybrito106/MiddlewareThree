package com.company.distribution.naming;

import com.company.distribution.ClientProxy;
import com.company.distribution.Invocation;
import com.company.distribution.Requestor;
import com.company.distribution.Termination;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class NamingProxy extends ClientProxy implements NamingInterface {

    private String host;
    private int port;

    public NamingProxy(String host, int port) {
        super(host, port);
        this.host = host;
        this.port = port;
    }

    @Override
    public void bind(String serviceName, ClientProxy clientProxy) throws UnknownHostException, IOException, Throwable {
        Invocation invoker = new Invocation();

        ArrayList<Object> params = new ArrayList<Object>();
        params.add(serviceName);
        params.add(clientProxy);

        invoker.setMethodName("bind");
        invoker.setHost(this.host);
        invoker.setPort(this.port);
        invoker.setParameters(params);

        Requestor.invoke(invoker);
    }

    @Override
    public ClientProxy lookup(String serviceName) throws UnknownHostException, IOException, Throwable {
        Invocation invoker = new Invocation();
        Termination terminator;

        ArrayList<Object> params = new ArrayList<Object>();
        params.add(serviceName);

        invoker.setMethodName("lookup");
        invoker.setHost(this.host);
        invoker.setPort(this.port);
        invoker.setParameters(params);

        terminator = Requestor.invoke(invoker);

        return (ClientProxy) terminator.getResult();
    }

    @Override
    public ArrayList<String> list() throws UnknownHostException, IOException, Throwable {
        Invocation invoker = new Invocation();
        Termination terminator;

        ArrayList<Object> params = new ArrayList<Object>();

        invoker.setMethodName("list");
        invoker.setHost(this.host);
        invoker.setPort(this.port);
        invoker.setParameters(params);

        terminator = Requestor.invoke(invoker);

        @SuppressWarnings("unchecked")
        ArrayList<String> result = (ArrayList<String>) terminator.getResult();

        return result;
    }

}
