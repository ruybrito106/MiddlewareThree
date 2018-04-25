package com.company.distribution;

import com.company.infrastructure.ClientRequestHandler;
import com.company.message.Message;
import com.company.message.RequestBody;
import com.company.message.RequestHeader;
import com.company.message.ResponseHeader;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Random;

public class Requestor {

    public static Termination invoke(Invocation invocation) throws IOException, ClassNotFoundException {

        ClientRequestHandler handler = new ClientRequestHandler(
                invocation.getHost(),
                invocation.getPort()
        );

        Marshaller marshaller = new Marshaller();
        Termination termination = new Termination();

        Random rand = new Random();
        Message requestMessage = new Message().NewRequestMessage(
                true,
                rand.nextInt(10000),
                invocation.getMethodName(),
                invocation.getParameters()
        );

        Message responseMessage = new Message();

        byte [] marshalledRequest = null;
        byte [] marshalledResponse = null;

        try {

            marshalledRequest = marshaller.marshall(requestMessage);
            handler.send(marshalledRequest);

            marshalledResponse = handler.receive();
            responseMessage = marshaller.unmarshall(marshalledResponse);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        termination.setResult(responseMessage.getBody().getResponseBody().getOperationResult());
        return termination;

    }

}
