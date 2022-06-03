package AbstractClasses.Uebung2;

public class Shirt implements Moveable{

    private String brand;
    private char size;
    private String color;

    public Shirt(String brand, char size, String color) {
        this.brand = brand;
        this.size = size;
        this.color = color;
    }

    @Override
    public void move(String destination) {
        System.out.println(color + " " + brand + " with the size " + size + ", will be moved to " + destination);
    }
}
