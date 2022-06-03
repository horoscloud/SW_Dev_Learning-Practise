package Networking.GamePractise;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static void main(String[] args) {

        System.out.println("start server....");
        try(ServerSocket server = new ServerSocket(1112)) {
            System.out.println("server startet");


            System.out.println("listen for clients...");
            while(true){
                Socket client = server.accept();
                System.out.println("client: " + client.getInetAddress() + " connected");

                ClientHandler clientHandler = new ClientHandler(client);

                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
