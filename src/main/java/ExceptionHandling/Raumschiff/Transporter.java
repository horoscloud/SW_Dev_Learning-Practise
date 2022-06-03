package ExceptionHandling.Raumschiff;

public class Transporter {

    public void beam(String person, String from, String to, boolean urgent) throws TransporterMalfunctionException{


        if(urgent && Math.random() < 0.5){
            throw new TransporterMalfunctionException();
        }
        System.out.println(person + " wurde von " + from + " nach " + to + " gebeamt!");

    }

    public void shutdown(){
        System.out.printf("shutdown transporter");
    }

}
