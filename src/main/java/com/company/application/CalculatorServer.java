package com.company.application;

import com.company.distribution.Calculator;
import com.company.distribution.Invoker;
import com.company.distribution.CalculatorClientProxy;
import com.company.distribution.naming.NamingProxy;

public class CalculatorServer {

    public static void main(String[] args) {

        Calculator calc = new Calculator();
        Invoker invoker = new Invoker(calc);
        int id = 2;
        CalculatorClientProxy client = new CalculatorClientProxy("localhost", 3000, id);
        
        NamingProxy namingService = new NamingProxy("localhost", 1313);
        
        try {
            
            namingService.bind("Calculator", client);
            invoker.invoke(client);

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

}
