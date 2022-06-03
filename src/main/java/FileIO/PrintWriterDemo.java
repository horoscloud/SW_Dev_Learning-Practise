package FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Horoscloud\\Desktop\\FH CAMPUS02\\test\\demo-text.txt");

        if (!file.exists())
            return;

        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        pw.println("First Line");
        pw.println("Second Line");

        pw.flush();
        pw.close();
    }
}
