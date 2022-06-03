package Networking.GamePractise;

import java.io.*;
import java.net.Socket;

public class GameClient {
    public static void main(String[] args) {


        try(Socket client = new Socket("localhost", 1112);
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            BufferedReader cli = new BufferedReader(new InputStreamReader(System.in));){

            System.out.printf("send: ");

            String command;
            while ((command = cli.readLine()) != null){
                System.out.printf(":");
                String response = br.readLine();
                System.out.println(response);

                System.out.printf("send: ");
                bw.write(command);
                bw.newLine();
                bw.flush();
            }


        }catch (IOException x){
            x.printStackTrace();
        }
    }
}
