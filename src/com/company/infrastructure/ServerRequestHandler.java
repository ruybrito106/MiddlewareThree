package com.company.infrastructure;

import org.omg.CORBA.ServerRequest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerRequestHandler {

    private int portNumber;
    private ServerRequest welcomeSocket  = null;
    private Socket connectionSocket = null;

    private int sentMessageSize;
    private int receivedMessageSize;
    private DataOutputStream outToClient = null;
    private DataInputStream inFromClient = null;

    public ServerRequestHandler(String host, int port) {

        this.portNumber = port;

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
