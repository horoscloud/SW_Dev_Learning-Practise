package Networking.GamePractise;

import java.io.*;
import java.net.Socket;
import java.security.Timestamp;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatterBuilder;

public class ClientHandler implements Runnable{

    private Socket client;
    private String name;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    public void start(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));){

            bw.write("Hello stranger, whats your name? 'name:<your name>'");
            bw.newLine();
            bw.flush();

            System.out.printf("read from client --> ");
            String line;
            while ((line = br.readLine()) != null){
                if(line.startsWith("name:")){
                    String[] names = line.split(":");
                    name = names[1];
                    bw.write("Hello, " + name);
                    bw.newLine();
                    bw.flush();
                }else {
                    switch (line) {
                        case "time":
                            bw.write(LocalTime.now().toString());
                            break;

                        case "date":
                            bw.write(LocalDate.now().toString());
                            break;

                        default:
                            System.out.println("schicke error");
                            bw.write("error");
                    }
                }
                bw.newLine();
                bw.flush();
            }
        }catch (IOException x){
            x.printStackTrace();
        }
    }

    @Override
    public void run() {
        start();
    }
}
