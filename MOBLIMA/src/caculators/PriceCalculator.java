package caculators;

import java.util.ArrayList;

import entities.IPrice;

public class PriceCalculator {
    public static double getGeneralPrice(ArrayList<IPrice> objs) {
        double totalPrice = 0.0;

        for(IPrice o: objs) {
            totalPrice += o.getPrice();
        }
        return totalPrice;
    }

    // public static double getTotalPrice(ArrayList<IPrice> individual, ArrayList<IPrice> general) {
    //     double totalPrice = 0.0;
    //     double generalPrice = getGeneralPrice(general);

    //     for(IPrice o: individual) {
    //         totalPrice += o.getPrice();
    //         totalPrice += generalPrice;
    //     }

    //     return totalPrice;
    // }
}
