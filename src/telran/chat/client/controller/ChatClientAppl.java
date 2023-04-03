package telran.chat.client.controller;

import telran.chat.client.task.Reciever;
import telran.chat.client.task.Sender;

import java.io.IOException;
import java.net.Socket;

public class ChatClientAppl {
    public static void main(String[] args) {
        String serverHost = "127.0.0.1";
        int port = 9000;
        try {Socket socket = new Socket(serverHost, port);
            Sender sender = new Sender(socket);
            Reciever receiver = new Reciever(socket);
            Thread senderThread = new Thread(sender);
            Thread receiverThread = new Thread(receiver);
            receiverThread.setDaemon(true);
            receiverThread.start();
            senderThread.start();
            //senderThread.join();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
