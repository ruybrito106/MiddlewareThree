package com.company.application;

import com.company.distribution.CalculatorClientProxy;
import com.company.distribution.naming.NamingProxy;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class CalculatorClient {

    public static void main(String[] args) throws UnknownHostException, IOException, Throwable {

        NamingProxy namingService = new NamingProxy("localhost", 1313);
        CalculatorClientProxy client = (CalculatorClientProxy) namingService.lookup("Calculator");

        ArrayList<String> ret = namingService.list();

        float a = client.Add(3, 5);
        float s = client.Sub(3, 5);
        float m = client.Mul(3, 5);
        float d = client.Div(3, 5);

        System.out.println(a + ", " + s + ", " + m + ", " + d);

    }

}
