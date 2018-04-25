package com.company.distribution.naming;

import com.company.distribution.ClientProxy;
import com.company.distribution.Marshaller;
import com.company.infrastructure.ServerRequestHandler;
import com.company.message.Message;

import java.util.ArrayList;

public class NamingInvoker {

    private NamingRespository repository = new NamingRespository();
    private Naming naming = new Naming(repository);

    public void invoke(NamingProxy client) throws Throwable {

        ServerRequestHandler server = new ServerRequestHandler(
                client.getHost(),
                client.getPort()
        );

        Marshaller marshaller = new Marshaller();

        byte [] requestMessage;
        byte [] responseMessage;

        while (true) {

            requestMessage = server.receive();
            Message request = marshaller.unmarshall(requestMessage);

            Object result = null;
            int status = 200;

            String operation = request.getBody().getRequestHeader().getOperation();
            ArrayList<Object> parameters = request.getBody().getRequestBody().getParameters();

            switch (operation) {
                case "bind":
                    String serviceName = parameters.get(0).toString();
                    ClientProxy clientProxy = (ClientProxy) parameters.get(1);

                    this.naming.bind(serviceName, clientProxy);
                    result = (Object) serviceName;
                    break;

                case "lookup":
                    serviceName = parameters.get(0).toString();

                    clientProxy = this.naming.lookup(serviceName);
                    result = (Object) clientProxy;
                    break;

                case "list":
                    ArrayList<String> list = this.naming.list();
                    result = (Object) list;
                    break;
            }

            if (result == null) {
                status = 500;
            }

            Message response = new Message().NewResponseMessage(
                    request.getBody().getRequestHeader().getRequestID(),
                    status,
                    result
            );

            responseMessage = marshaller.marshall(response);
            server.send(responseMessage);

        }

    }

}
