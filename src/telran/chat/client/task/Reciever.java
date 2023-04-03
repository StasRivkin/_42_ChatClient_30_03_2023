package telran.chat.client.task;

import telran.chat.model.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Reciever implements Runnable {
    Socket socket;

    public Reciever(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (Socket socket = this.socket) {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            while (true) {
                Message message = (Message) ois.readObject();
                System.out.println(message);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
