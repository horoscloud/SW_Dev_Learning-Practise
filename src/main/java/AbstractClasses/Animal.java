package AbstractClasses;

public abstract class Animal {

    private String name;
    private String color;
    private int countEyes;

    public Animal(String name, String color, int countEyes) {
        this.name = name;
        this.color = color;
        this.countEyes = countEyes;
    }

    public abstract void walk();

    public abstract void makeNoise();

}
