package caculators;

import java.util.ArrayList;

import entities.IPrice;

public class PriceCalculator {
    // GET BASE PRICE FROM PRICING MANAGER
    public static double getTotalPrice(ArrayList<IPrice> objs, int noOfTickets) {
        double totalPrice = 0.0;

        for(IPrice o: objs) {
            totalPrice += o.getPrice();
        }
        return totalPrice;
    }
}
