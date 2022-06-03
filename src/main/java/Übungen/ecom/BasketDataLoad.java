package Übungen.ecom;

import com.google.gson.Gson;
import Übungen.Hangman.DataFileException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BasketDataLoad{


    public BasketDataLoad() {
    }

    public ArrayList<BasketData> load(String path, BasketComparator comparator) throws DataFileException {

        ArrayList<BasketData> arrayList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new InputStreamReader( new FileInputStream(path)))){

            String line;
            while ((line = br.readLine()) != null){
                BasketData bd = new Gson().fromJson(line, BasketData.class);

                arrayList.add(bd);
            }

            Collections.sort(arrayList, comparator);

        }catch (Exception e){
            throw new DataFileException("Error", e);
        }

        return arrayList;
    }

}
