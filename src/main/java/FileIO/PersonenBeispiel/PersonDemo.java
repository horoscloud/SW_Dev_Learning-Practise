package FileIO.PersonenBeispiel;

public class PersonDemo {
    public static void main(String[] args) {

        PersonManager pm = new PersonManager();

        pm.load("C:\\Users\\Horoscloud\\Desktop\\FH CAMPUS02\\test\\testdata-einwohner.csv");


        for (Person p: pm.getPersons()) {

            if(p.getBirthday() == 1998){
                System.out.println(p);
            }
        }


    }
}
