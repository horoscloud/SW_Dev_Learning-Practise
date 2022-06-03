package AbstractClasses;

public class FlyingDog extends Dog implements FlyingAnimal{

    public FlyingDog(String name, String color, int countEyes) {
        super(name, color, countEyes);
    }

    @Override
    public void walk() {
        super.walk();
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
    }

    @Override
    public void fly() {

    }
}
