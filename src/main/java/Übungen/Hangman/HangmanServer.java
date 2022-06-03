package Übungen.Hangman;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HangmanServer {
    public static void main(String[] args) {

        try(ServerSocket server = new ServerSocket(2222)){
            while (true){
                Socket client = server.accept();

                Thread th = new Thread(new HangmanClient(client));
                th.run();
            }
        }catch (IOException x){
         x.printStackTrace();
        }
    }
}
