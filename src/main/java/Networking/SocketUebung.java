package Networking;

import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.*;

public class SocketUebung {
    public static void main(String[] args) throws IOException {

        try (Socket socket = SSLSocketFactory.getDefault()
                .createSocket("news.orf.at", 443);
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader br = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()))){


            bw.write("GET / HTTP/1.1\r\nHost: news.orf.at\r\n\r\n"); // Send GET request to Host
            bw.flush();


            BufferedWriter bwFile = new BufferedWriter(
                    new PrintWriter(
                            new FileWriter(
                                    new File("C:\\Users\\Horoscloud\\Desktop\\FH CAMPUS02\\test\\socket-uebung.html")), true));

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bwFile.write(line);
                bwFile.newLine();
            }
        }catch (IOException x){
            x.printStackTrace();
        }
    }
}
