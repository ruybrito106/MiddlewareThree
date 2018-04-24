package com.company.distribution;

import com.company.message.Message;

import java.io.*;

public class Marshaller {

    public byte [] marshall(Message toMarshall) throws IOException, InterruptedException {

        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
        objectStream.writeObject(toMarshall);

        return byteStream.toByteArray();

    }

    public Message unmarshall(byte [] toUnmarshall) throws IOException, InterruptedException, ClassNotFoundException {

        ByteArrayInputStream byteStream = new ByteArrayInputStream(toUnmarshall);
        ObjectInputStream objectStream = new ObjectInputStream(byteStream);

        return (Message) objectStream.readObject();

    }

}
