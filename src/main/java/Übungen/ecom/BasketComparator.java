package Übungen.ecom;

import java.util.Comparator;

public class BasketComparator implements Comparator<BasketData> {

    @Override
    public int compare(BasketData o1, BasketData o2) {
        if(o1.getBuyingLocation().equals(o2.getBuyingLocation()))
            return Double.compare(o1.getOrderTotal(), o2.getOrderTotal());
        else
            return o1.getBuyingLocation().compareTo(o2.getBuyingLocation());
    }
}
