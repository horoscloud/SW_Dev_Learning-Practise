package Übungen.Hangman;

import Übungen.Uebungsabend1.DataFileException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Game {

    private char[] currentWord;
    private char[] foundWord;
    private int counter;

    public Game() {
    }

    public void loadWord(){
        try{
            ArrayList<String> arrayList = new DictionaryLoader().load();

            String word = arrayList.get(counter);

            currentWord = word.toCharArray();

            counter++;

            char[] arr = new char[currentWord.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = '_';
            }
            foundWord = arr;

        } catch (DataFileException | IndexOutOfBoundsException e) {
            System.out.println("FUCK");
            e.printStackTrace();
        }

    }

    public String tryCharacter(char c){
        for (int i = 0; i < currentWord.length; i++) {
            if(currentWord[i] == c) {
                foundWord[i] = c;
            }
        }

        return new String(foundWord);
    }

    public boolean isFinished(){

        for (int i = 0; i < foundWord.length; i++) {
            if(foundWord[i] == '_')
                return false;
            else
                return true;
        }

        return false;
    }
}
