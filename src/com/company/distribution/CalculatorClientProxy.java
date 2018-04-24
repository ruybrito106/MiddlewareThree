package com.company.distribution;

import java.net.UnknownHostException;
import java.util.ArrayList;

public class CalculatorClientProxy extends ClientProxy implements CalculatorInterface {

    public CalculatorClientProxy(String host, int port) {
        super(host, port);
    }

    public float Add(float a, float b) {
        return operate(a, b, "add");
    }

    public float Sub(float a, float b) {
        return operate(a, b, "sub");
    }

    public float Mul(float a, float b) {
        return operate(a, b, "mul");
    }

    public float Div(float a, float b) {
        return operate(a, b, "div");
    }

    private float operate(float a, float b, String methodName) {

        ArrayList<Object> parameters = new ArrayList<Object>();
        parameters.add(a);
        parameters.add(b);

        Invocation invocation = new Invocation();
        invocation.setobjectID(this.getobjectID());
        invocation.setHost(this.getHost());
        invocation.setPort(this.getPort());
        invocation.setMethodName(methodName);
        invocation.setParameters(parameters);

        Requestor requestor = new Requestor();

        Termination termination = new Termination();

        try {
            termination = requestor.invoke(invocation);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return (Float) termination.getResult();

    }

}
