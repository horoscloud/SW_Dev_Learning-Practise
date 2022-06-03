package AbstractClasses;

import AbstractClasses.Uebung.Document;
import AbstractClasses.Uebung.TextDocument;

public class Main {

    public static void main(String[] args) {

        Animal dog = new Dog("Hund", "Blau", 38);

        dog.makeNoise();

        dog.walk();


        Document doc = new TextDocument();

        doc.printDocument();

    }
}
