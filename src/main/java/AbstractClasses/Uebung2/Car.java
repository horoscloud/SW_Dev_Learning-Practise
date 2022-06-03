package AbstractClasses.Uebung2;

public class Car implements Moveable{

    private String type;
    private String color;
    private int weight;

    public Car(String type, String color, int weight) {
        this.type = type;
        this.color = color;
        this.weight = weight;
    }

    @Override
    public void move(String destination) {
        System.out.println(color + " " + type + " will be moved to " + destination);
    }
}
