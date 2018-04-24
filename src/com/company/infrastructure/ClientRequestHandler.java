package com.company.infrastructure;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientRequestHandler {

    private String host;
    private int port;
    private int sentMessageSize;
    private int receivedMessageSize;

    private Socket clientSocket = null;
    private DataOutputStream outToServer = null;
    private DataInputStream inFromServer = null;

    public ClientRequestHandler(String host, int port) {

        this.host = host;
        this.port = port;

        // Init socket
    }

    public void send(byte [] msg) throws IOException, InterruptedException {
        return;
    }

    public byte [] receive() throws IOException, InterruptedException {
        byte [] ret = new byte [100];
        return ret;
    }

}
