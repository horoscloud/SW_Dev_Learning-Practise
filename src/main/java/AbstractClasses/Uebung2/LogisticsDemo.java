package AbstractClasses.Uebung2;

public class LogisticsDemo {
    public static void main(String[] args) {

        LogisticManager manager = new LogisticManager();

        Moveable car = new Car("Limo", "Blau", 30);
        Moveable car2 = new Car("Limo2", "Grün", 40);
        Moveable car3 = new Car("Limo3", "Grau", 50);

        manager.add(car);
        manager.add(car2);
        manager.add(car3);

        manager.moveAll("Graz");


    }
}
