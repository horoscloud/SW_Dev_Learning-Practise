package FileIO;

import java.io.*;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Horoscloud\\Desktop\\FH CAMPUS02\\test\\demo-text.txt");

        if (!file.exists())
            return;

        FileReader fl = new FileReader(file);
        BufferedReader br = new BufferedReader(fl);

        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();


    }
}
