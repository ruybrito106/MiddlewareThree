package com.company.application;

import com.company.distribution.CalculatorClientProxy;
import com.company.distribution.CalculatorInvoker;
import com.company.distribution.naming.NamingProxy;

public class CalculatorServer {

    public static void main(String[] args) {

        CalculatorInvoker invoker = new CalculatorInvoker();
        CalculatorClientProxy client = new CalculatorClientProxy("localhost", 8088);

        NamingProxy namingService = new NamingProxy("localhost", 8089);

        try {

            namingService.bind("Calculator", client);
            invoker.invoke(client);

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

}