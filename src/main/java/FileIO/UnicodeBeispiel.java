package FileIO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UnicodeBeispiel {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\Horoscloud\\Desktop\\FH CAMPUS02\\test\\demo-text.txt");

        if (!file.exists())
            return;


        try(
                BufferedReader br = new BufferedReader
                        (new InputStreamReader
                                (new FileInputStream(file), StandardCharsets.UTF_8))){

            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }


    }
}
