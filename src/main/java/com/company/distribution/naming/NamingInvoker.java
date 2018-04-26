package com.company.distribution.naming;

import com.company.distribution.ClientProxy;
import com.company.distribution.Marshaller;
import com.company.infrastructure.ServerRequestHandler;
import com.company.message.Message;

import java.util.ArrayList;

public class NamingInvoker {

    private Naming naming = new Naming();

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

            ClientProxy result = null;
            String name;
            ArrayList<String> dict;

            int status = 500;

            String operation = request.getBody().getRequestHeader().getOperation();
            ArrayList<Object> parameters = request.getBody().getRequestBody().getParameters();

            Message response = new Message();

            switch (operation) {
                case "bind":
                    String serviceName = parameters.get(0).toString();
                    ClientProxy clientProxy = (ClientProxy) parameters.get(1);

                    this.naming.bind(serviceName, clientProxy);
                    name = serviceName;

                    if (name != "") {
                        status = 200;
                        response = response.NewResponseMessage(
                                request.getBody().getRequestHeader().getRequestID(),
                                status,
                                (Object) name
                        );
                    }

                    break;

                case "lookup":
                    serviceName = parameters.get(0).toString();
                    result = (ClientProxy) this.naming.lookup(serviceName);

                    if (result != null) {
                        status = 200;
                        response = response.NewResponseMessage(
                                request.getBody().getRequestHeader().getRequestID(),
                                status,
                                (Object) result
                        );
                    }

                    break;

                case "list":
                    dict = this.naming.list();

                    if (dict != null) {
                        status = 200;
                        response = response.NewResponseMessage(
                                request.getBody().getRequestHeader().getRequestID(),
                                status,
                                (Object) dict
                        );
                    }

                    break;
            }

            if (status == 500) {
                response = response.NewResponseMessage(
                        request.getBody().getRequestHeader().getRequestID(),
                        status,
                        null
                );
            }

            responseMessage = marshaller.marshall(response);
            server.send(responseMessage);

        }

    }

}
