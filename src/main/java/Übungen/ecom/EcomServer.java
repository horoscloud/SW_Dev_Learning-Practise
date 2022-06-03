package Übungen.ecom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EcomServer {

    public static void main(String[] args) {

        try(ServerSocket server = new ServerSocket(2222)){
            while (true){

                Socket client = server.accept();

                EcommerceLogic logic = new EcommerceLogic(client);
                logic.run();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
