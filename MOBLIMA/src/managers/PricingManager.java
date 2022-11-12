package managers;
import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class PricingManager.
 */
public class PricingManager {
    
    /** The price matrix. */
    /*
     * Price Matrix (HashMap of adders and subtractors)
     * eg:
     * TypeOfDay.WEEKEND = -2.30
     * AgeGroup.STUDENT = -1.20 
    */
    private static HashMap<Object, Double> priceMatrix = new HashMap<Object, Double>();

    /**
	 * Gets the price.
	 *
	 * @param o the o
	 * @return the price
	 */
    public static double getPrice(Object o) {
        return priceMatrix.get(o);
    }

    /**
	 * Add new price into the price matrix.
	 *
	 * @param priceFor the price for
	 * @param price    the price
	 */
    public static void addPrice(Object priceFor, Double price) {
        priceMatrix.put(priceFor, price);
    }

    /**
	 * Update Price for each individual pricings.
	 *
	 * @param priceFor the price for
	 * @param newPrice the new price
	 */
    public static void updatePrice(Object priceFor, Double newPrice) {
        priceMatrix.put(priceFor, newPrice);
    }

    /**
	 * Get the entire price matrix.
	 *
	 * @return the price matrix
	 */
    public static HashMap<Object, Double> getPriceMatrix() {
        return priceMatrix;
    }

    /**
	 * Display the price matrix.
	 */
    public static void showPriceMatrix() {
        System.out.println("========== Pricing ==========");
        
        for(Object o: priceMatrix.keySet()) {
            System.out.println(o+":\t\t"+priceMatrix.get(o));
        }
    }

    /**
	 * Set price matrix.
	 *
	 * @param priceMatrix the price matrix
	 */
    public static void setPriceMatrix(HashMap<Object, Double> priceMatrix) {
        PricingManager.priceMatrix = priceMatrix;
    }
}
