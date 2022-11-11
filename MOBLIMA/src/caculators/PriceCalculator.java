package caculators;

import java.util.ArrayList;

import entities.IPrice;

public class PriceCalculator {
    public static double getTotalPrice(ArrayList<IPrice> objs) {
        double totalPrice = 0.0;

        for(IPrice o: objs) {
            totalPrice += o.getPrice();
        }
        return totalPrice;
    }
}
