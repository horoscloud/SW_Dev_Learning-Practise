package Übungen.Uebungsabend1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EinwohnerServer {

    public static void main(String[] args) {

        try(ServerSocket server = new ServerSocket(2222)){

            System.out.println("EinwohnerServer gestartet");
            while (true){

                Socket client = server.accept();
                System.out.println("Client connected");

                EinwohnerHandler eh = new EinwohnerHandler(client);

                Thread th = new Thread(eh);
                th.start();
            }


        }catch (IOException x){
            x.printStackTrace();
        }

    }
}
