package com.company.distribution;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class CalculatorClientProxy extends ClientProxy implements CalculatorInterface {

    private int objectid;

    public CalculatorClientProxy(String host, int port, int objectid) {
        super(host, port);
        this.objectid = objectid;
    }

    public int getObjectId() {
        return this.objectid;
    }

    public float add(float a, float b) throws IOException, ClassNotFoundException {
        return operate(a, b, getMethodName(new Object(){}));
    }

    public float sub(float a, float b) throws IOException, ClassNotFoundException {
        return operate(a, b, getMethodName(new Object(){}));
    }

    public float mul(float a, float b) throws IOException, ClassNotFoundException {
        return operate(a, b, getMethodName(new Object(){}));
    }

    public float div(float a, float b) throws IOException, ClassNotFoundException {
        return operate(a, b, getMethodName(new Object(){}));
    }

    private float operate(float a, float b, String methodName) throws IOException, ClassNotFoundException {

        ArrayList<Object> params = new ArrayList<Object>();
        params.add(a);
        params.add(b);

        return (Float) super.operate(params, methodName);

    }

}
