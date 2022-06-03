package Networking.TimeServerBeispiel;

import java.io.*;
import java.net.Socket;

public class TimeClient {
    public static void main(String[] args) {

        try(Socket serverConnection = new Socket("localhost", 1111);
        BufferedReader br = new BufferedReader(new InputStreamReader(serverConnection.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(serverConnection.getOutputStream()))){

            String line;
            while((line = br.readLine()) != null){
                System.out.println("Antort vom EinwohnerServer: " + line);
            }


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
