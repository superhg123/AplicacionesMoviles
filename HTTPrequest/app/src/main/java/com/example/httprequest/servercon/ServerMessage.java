package com.example.httprequest.servercon;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerMessage implements Runnable{
    private Socket socket;
    private MessageListener messageListener;

    public ServerMessage(MessageListener messageListener) {
        this.messageListener = messageListener;
    }

    @Override
    public void run() {
        try {
            socket = new Socket("192.168.1.70", 8082);
            while (true) {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String message = in.readUTF();
                messageListener.onMessage(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
