package FileIO.PersonenBeispiel;

import java.io.*;
import java.util.ArrayList;

public class PersonManager {

    private ArrayList<Person> persons;

    public PersonManager() {
        this.persons = new ArrayList<>();
    }

    public void load(String path){
        File file = new File(path);


        try(
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))
                ){

            String line;
            String[] lineParts;
            while((line = br.readLine()) != null){

                try {
                    lineParts = line.split(";");

                    if(!lineParts[0].equals("Id")){
                        int id = Integer.parseInt(lineParts[0]);
                        String name = lineParts[1];
                        String bundesland = lineParts[2];
                        int birthday = Integer.parseInt(lineParts[3]);

                        Person person = new Person(id,name,bundesland,birthday);
                        persons.add(person);
                    }

                }catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }
}
