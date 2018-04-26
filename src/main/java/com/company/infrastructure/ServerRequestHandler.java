package com.company.infrastructure;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRequestHandler {

    private int portNumber;
    private ServerSocket welcomeSocket  = null;
    private Socket connectionSocket = null;

    private int sentMessageSize;
    private int receivedMessageSize;
    private DataOutputStream outToClient = null;
    private DataInputStream inFromClient = null;

    public ServerRequestHandler() {
        this.portNumber = 0; //random
    }

    public ServerRequestHandler(int port) {
        this.portNumber = port;
    }

    public void send(byte [] msg) throws IOException, InterruptedException {
        sentMessageSize = msg.length;
        outToClient.writeInt(sentMessageSize);
        outToClient.write(msg, 0, sentMessageSize);

        connectionSocket.close();
        welcomeSocket.close();
        outToClient.close();
        inFromClient.close();
    }

    public byte [] receive() throws IOException, InterruptedException {
        this.welcomeSocket = new ServerSocket(this.portNumber);
        connectionSocket = welcomeSocket.accept();
        inFromClient = new DataInputStream(connectionSocket.getInputStream());
        outToClient = new DataOutputStream(connectionSocket.getOutputStream());

        receivedMessageSize = inFromClient.readInt();
        byte[] receivedMessage = new byte[receivedMessageSize];
        inFromClient.read(receivedMessage, 0, receivedMessageSize);
        return receivedMessage;
    }

}
