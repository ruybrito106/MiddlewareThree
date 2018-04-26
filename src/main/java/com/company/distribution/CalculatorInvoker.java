package com.company.distribution;

import com.company.infrastructure.ServerRequestHandler;
import com.company.message.Message;

import java.io.IOException;
import java.util.ArrayList;

public class CalculatorInvoker {

    public void invoke(CalculatorClientProxy client) throws IOException, Throwable {

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

            Calculator calculator = new Calculator(
                    (Float) parameters.get(0),
                    (Float) parameters.get(1)
            );

            switch (operation) {
                case "add":
                    result = (Object) calculator.Add();
                    break;
                case "sub":
                    result = (Object) calculator.Sub();
                    break;
                case "mul":
                    result = (Object) calculator.Mul();
                    break;
                case "div":
                    result = (Object) calculator.Div();
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
