package com.company.application;

import com.company.distribution.CalculatorClientProxy;
import com.company.distribution.ClientProxy;
import com.company.distribution.naming.NamingProxy;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class CalculatorClient {

    public static void main(String[] args) throws UnknownHostException, IOException, Throwable {

        NamingProxy namingService = new NamingProxy("localhost", 1313);
        ClientProxy client = (ClientProxy) namingService.lookup("Calculator");

        CalculatorClientProxy calculator = (CalculatorClientProxy) client;

        float a = calculator.Add(3, 5);
        float s = calculator.Sub(3, 5);
        float m = calculator.Mul(3, 5);
        float d = calculator.Div(3, 5);

        System.out.println(a + ", " + s + ", " + m + ", " + d);

    }

}
