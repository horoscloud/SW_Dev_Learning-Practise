package AbstractClasses;

public class Dog extends Animal{

    public Dog(String name, String color, int countEyes) {
        super(name, color, countEyes);
    }

    @Override
    public void walk() {
        System.out.println("Ich kann laufen digga!");
    }

    @Override
    public void makeNoise() {
        System.out.println("Woof! Woof! Gib essen bruder");
    }
}
