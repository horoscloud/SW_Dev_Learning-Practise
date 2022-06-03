package Networking.TimeServerBeispiel;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static void main(String[] args) throws IOException {

        System.out.println("Erzeuge EinwohnerServer");
        try (ServerSocket serverSocket = new ServerSocket(1111)){

            int clients = 0;

            while (clients < 5) {
                System.out.println("Warte auf Clients...");
                try (Socket client = serverSocket.accept();
                        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {

                    System.out.println("Client Nr: " + clients + " hat sich verbunden");


                    bw.write("Hallo Client!");
                    bw.flush();

                    clients++;
                }

            }

        }catch (IOException x){
            x.printStackTrace();
        }
    }

}
