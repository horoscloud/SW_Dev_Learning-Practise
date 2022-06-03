package FileIO;

import java.io.*;
import java.util.Scanner;

public class TextIOBeispiel {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        String input = "";
        boolean loop = true;

        File file = new File("C:\\Users\\Horoscloud\\Desktop\\FH CAMPUS02\\test\\demo-text.txt");

        if (!file.exists())
            return;

        try {
            FileWriter fw = new FileWriter(file);

            while (loop == true) {
                System.out.printf("FACH:NOTE: ");
                input = in.next();

                if (input.equals("STOP")) {
                    loop = false;
                }
                input = input + "\n";
                fw.write(input);
                fw.flush();
            }
            fw.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }

        FileReader fl = new FileReader(file);
        BufferedReader br = new BufferedReader(fl);

        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
    }
}
