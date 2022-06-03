package Networking.RateDieNummerBeispiel;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class GuessNumberServer {
    public static void main(String[] args) throws IOException {

        System.out.println("Starte EinwohnerServer");
        try (ServerSocket server = new ServerSocket(2222)) {


            while (true) {
                System.out.println("Warte auf Clients...");


                Socket client = server.accept();
                System.out.println("Verbindung zu Client wurde hergestellt");


                try (BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()))) {

                    bw.write("Hallo, wie lautet ihr Name? Antwort mit 'name:<your name>'");
                    bw.flush();

                    System.out.println("lese vom client -->");
                    String line;
                    while ((line = br.readLine()) != null) {

                       if(line.equals("Test")){
                           System.out.println("Empfangen: "+line);
                           bw.write("Selber Test, hmpf");
                           bw.newLine();
                           bw.flush();
                       }
                    }
                }
            }
        }
    }
}