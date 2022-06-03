package Übungen.Hangman;

import Übungen.Uebungsabend1.DataFileException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class DictionaryLoader {
    private String path;

    public DictionaryLoader() {
        this.path = "C:\\Users\\Horoscloud\\Desktop\\FH CAMPUS02\\test\\log.txt";
    }

    public ArrayList<String> load() throws DataFileException {

        ArrayList<String> arrayList = new ArrayList<>();

        File file = new File(path);

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file)))) {

            String line;
            String[] lineParts;
            while ((line = br.readLine()) != null) {

                lineParts = line.split(";");

                if(arrayList == null){
                    arrayList.add(lineParts[0]);
                }
                for (String s:arrayList) {
                    for (int i = 0; i < lineParts.length; i++) {
                        if(!lineParts[i].equals(s) && lineParts[i] != null){
                            arrayList.add(lineParts[i]);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new DataFileException("Error", e);
        }

        Collections.sort(arrayList, new StringLengthComparator());
        return arrayList;
    }
}
