package com.company.distribution;

import com.company.infrastructure.ServerRequestHandler;
import com.company.message.Message;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Invoker {
    private Object core;

    public Invoker (Object obj) {
        core = obj;
    }


    public void invoke(ClientProxy client) throws IOException, Throwable {

        ServerRequestHandler server = new ServerRequestHandler(client.getPort());

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

            Object[] params = parameters.toArray();
            
            try {
                Class<?> types[] = new Class[params.length];
                for (int i = 0; i < params.length; i++) {
                    if (params[i] instanceof Integer) {
                        types[i] = Integer.TYPE;
                    } else if (params[i] instanceof String) {
                        types[i] = String.class;
                    } else if (params[i] instanceof Float) {
                        types[i] = float.class;
                    }
                }
                Method method = core.getClass().getDeclaredMethod(operation, types);
                
                result = method.invoke(core, params);
            } catch (Exception e) { e.printStackTrace(); }
            
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
