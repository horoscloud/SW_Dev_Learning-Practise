package Networking.RateDieNummerBeispiel;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class GuessNumberClient {
    public static void main(String[] args) {

        try(Socket client = new Socket("localhost", 2222);
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                BufferedReader cli = new BufferedReader(new InputStreamReader(System.in))){


            System.out.println("Mit EinwohnerServer verbunden!");


            String command;
            while ((command = cli.readLine()) != null) {
                if (command.equalsIgnoreCase("quit")) {
                    System.out.println("Client will beenden");
                    break;
                }

                System.out.println("Schicke command an EinwohnerServer");
                bw.write(command);
                bw.newLine(); // !!!!!!!!
                bw.flush();

                System.out.println("Erhalte die Antwort vom EinwohnerServer");
                String response = br.readLine();
                System.out.println(response);
            }


        }catch (IOException x){
            x.printStackTrace();
        }
    }
}
