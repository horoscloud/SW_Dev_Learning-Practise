package AbstractClasses;

public class Bird extends Animal implements FlyingAnimal{


    public Bird(String name, String color, int countEyes) {
        super(name, color, countEyes);
    }

    @Override
    public void walk() {
        System.out.println("Am a bird... no walking bruv");
    }


    @Override
    public void makeNoise() {
        System.out.println("Chirp! Chirp!");
    }

    @Override
    public void fly() {
        System.out.println("Can't talk currently FLYING");
    }
}
