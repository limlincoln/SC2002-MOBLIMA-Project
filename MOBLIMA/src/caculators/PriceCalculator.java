package caculators;

import java.util.ArrayList;

import entities.IPrice;
import managers.PricingManager;
import enums.PriceType;

/**
 * Helps calculate prices
 */
public class PriceCalculator {

    /**
     * Get the total price
     * @param objs the objects with which to base the price calculation on
     * @param noOfTickets the no of tickets to use for the price calculation
     * @return the total price
     */
    public static double getTotalPrice(ArrayList<IPrice> objs, int noOfTickets) {
        double totalPrice = 0.0;
        double basePrice = PricingManager.getPrice(PriceType.BASE_PRICE);

        totalPrice += basePrice * noOfTickets;

        for(IPrice o: objs) {
            totalPrice += o.getPrice();
        }
        return totalPrice;
    }
}
