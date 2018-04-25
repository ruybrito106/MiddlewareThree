package com.company.distribution.naming;

public class NamingServer {

    public static void main(String[] args) {

        NamingInvoker invoker = new NamingInvoker();
        NamingProxy client = new NamingProxy("localhost", 1313);

        try {
            invoker.invoke(client);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }

}
