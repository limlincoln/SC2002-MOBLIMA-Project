package caculators;

import java.util.ArrayList;

import entities.IPrice;
import managers.PricingManager;
import enums.PriceType;

// TODO: Auto-generated Javadoc
/**
 * The Class PriceCalculator.
 */
public class PriceCalculator {
    
    /**
	 * Gets the total price.
	 *
	 * @param objs        - the objs
	 * @param noOfTickets - number of tickets
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
