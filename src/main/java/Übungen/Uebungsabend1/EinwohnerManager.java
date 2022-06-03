package Übungen.Uebungsabend1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class EinwohnerManager {

    public ArrayList<Einwohner> load() throws DataFileException {
        ArrayList<Einwohner> einwohner = new ArrayList<>();

        File file = new File("C:\\Users\\Horoscloud\\Desktop\\FH CAMPUS02\\test\\testdata-einwohner.csv");

        try(BufferedReader br = new BufferedReader(new FileReader(file))){

            String line;
            while ((line = br.readLine()) != null) {
                String[] lineParts = line.split(";");

                int id = Integer.parseInt(lineParts[0]);
                String name = lineParts[1];
                String bundesland = lineParts[2];
                int yearOfBirth = Integer.parseInt(lineParts[3]);

                Einwohner ewn = new Einwohner(id, name, bundesland, yearOfBirth);
                einwohner.add(ewn);
            }

            Collections.sort(einwohner, new EinwohnerComparator());

        }catch (Exception e){
            throw new DataFileException("Error", e);
        }

        return einwohner;
    }


}
