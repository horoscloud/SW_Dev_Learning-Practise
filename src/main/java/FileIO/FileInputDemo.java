package FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputDemo {
    public static void main(String[] args) throws IOException {
        //FileIO -> Die Hände schmutzig machen;)

        File file = new File("C:\\Users\\Horoscloud\\Desktop\\FH CAMPUS02\\test\\demo-text.txt");

        if (!file.exists())
            return;
        // some code
        FileInputStream fis = new FileInputStream(file);

        int count = 0;

        int byteRead = fis.read();
        while (byteRead != -1) {
            char[] chArr = Character.toChars(byteRead);
            //System.out.print((char) byteRead);
            System.out.print(chArr[0]);
            byteRead = fis.read();
            count++;
        }
        fis.close();

        System.out.println(count);

    }
}
