package com.company.distribution;

import com.company.message.Message;

import java.io.*;

public class Marshaller {

    public byte [] marshall(Message toMarshall) throws IOException, InterruptedException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(toMarshall);

        byte[] objectBytes = baos.toByteArray();
        oos.close();
        baos.close();

        return objectBytes;

    }

    public Message unmarshall(byte [] toUnmarshall) throws IOException, InterruptedException, ClassNotFoundException {

        ByteArrayInputStream bais = new ByteArrayInputStream(toUnmarshall);
        ObjectInputStream ois = new ObjectInputStream(bais);

        Message msg = (Message) ois.readObject();
        ois.close();
        bais.close();

        return msg;

    }

}
