package AbstractClasses.Uebung2;

import java.util.ArrayList;
import java.util.List;

public class LogisticManager{

    private ArrayList<Moveable> moveables;


    public LogisticManager() {
        this.moveables = new ArrayList<>();
    }

    public void add(Moveable m){
        moveables.add(m);
    }


    public void moveAll(String finalDestination){

        for (Moveable m: moveables) {
            m.move(finalDestination);
        }
    }
}
