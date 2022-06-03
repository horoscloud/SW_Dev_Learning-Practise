package ExceptionHandling.Raumschiff;

public class DemoEpisode42 {
    public static void main(String[] args) {

        Starship enterprise = new Starship("Enterprise", new Transporter());

        enterprise.beamUp("Loki", "Earth");


    }
}
