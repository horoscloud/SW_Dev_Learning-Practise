package Übungen.ecom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BasketAnalyzer {

    private ArrayList<BasketData> baskets;

    public BasketAnalyzer(ArrayList<BasketData> baskets) {
        this.baskets = baskets;
    }

    public List<BasketData> getEveryNthBasket(int n){

        List<BasketData> list = new ArrayList<>();

        for(int i = 0;i < baskets.size(); i+=n) {
            list.add(baskets.get(i));
        }

        return list;
    }

    public List<BasketData> filterBaskets(String paymentType, Double from, Double to){

        List<BasketData> list = new ArrayList<>();

        for (BasketData bd:baskets) {
            if(bd.getPaymentType().equals(paymentType)){
                if(bd.getOrderTotal() >= from && bd.getOrderTotal() <= to){
                    list.add(bd);
                }
            }
        }

        return list;
    }

    public HashMap<String, ArrayList<Double>> groupByProductCategory(){

        HashMap<String, ArrayList<Double>> hashMap = new HashMap<>();

        for (BasketData bd:baskets) {
         if(!hashMap.containsKey(bd.getProductCategory())){
             hashMap.put(bd.getProductCategory(), new ArrayList<Double>());

             ArrayList<Double> list = hashMap.get(bd.getProductCategory());
             list.add(bd.getOrderTotal());
         }
        }

        return hashMap;
    }

}
