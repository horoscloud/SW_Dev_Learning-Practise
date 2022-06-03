package Networking;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class URLUebung {

    public static void main(String[] args) {


        try {
             URL url = new URL("https://orf.at/");
             BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            BufferedWriter bw = new BufferedWriter(
                    new PrintWriter(
                            new FileWriter("C:\\Users\\Horoscloud\\Desktop\\FH CAMPUS02\\test\\orf.html"), true));

             String line;
             while((line = br.readLine()) != null){
                 System.out.println(line);
                 bw.write(line);
                 bw.newLine();
             }

        }catch (MalformedURLException u){
            u.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
