package telran.chat.client.task;

import telran.chat.model.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalTime;

public class Sender implements Runnable {
    Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (Socket socket = this.socket) {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your name: ");
            String name = br.readLine();
            System.out.println("Enter your message or type exit for quit");
            String messageText = br.readLine();
            while (true) {
                Message message = new Message(name, messageText);
                oos.writeObject(message);
                if ("exit".equalsIgnoreCase(messageText)) {
                    break;
                }
                messageText = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
