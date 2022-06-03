package Übungen.ecom;

import Übungen.Hangman.DataFileException;

public class BasketDemo {
    public static void main(String[] args) throws DataFileException {

        BasketDataLoad basketDataLoad = new BasketDataLoad();
        System.out.println(basketDataLoad.load("src/main/java/Übungen/ecom/buyings.json", new BasketComparator()));



    }
}
