package managers;
import java.util.HashMap;

public class PricingManager {
    /*
     * Price Matrix (HashMap of adders and subtractors)
     * eg:
     * TypeOfDay.WEEKEND = -2.30
     * AgeGroup.STUDENT = -1.20 
    */
    private static HashMap<Object, Double> priceMatrix = new HashMap<Object, Double>();

    public static double getPrice(Object o) {
        return priceMatrix.get(o);
    }

    /**
     * Add new price into the price matrix
     * @param priceFor
     * @param price
     */
    public static void addPrice(Object priceFor, Double price) {
        priceMatrix.put(priceFor, price);
    }

    /**
     * Update Price for each individual pricings
     * @param priceFor
     * @param newPrice
     */
    public static void updatePrice(Object priceFor, Double newPrice) {
        priceMatrix.put(priceFor, newPrice);
    }

    /**
     * Get the entire price matrix
     * @return
     */
    public static HashMap<Object, Double> getPriceMatrix() {
        return priceMatrix;
    }

    /**
     * Display the price matrix
     */
    public static void showPriceMatrix() {
        System.out.println("========== Pricing ==========");
        
        for(Object o: priceMatrix.keySet()) {
            System.out.println(o+":\t\t"+priceMatrix.get(o));
        }
    }

    /**
     * Set price matrix
     * @param priceMatrix
     */
    public static void setPriceMatrix(HashMap<Object, Double> priceMatrix) {
        PricingManager.priceMatrix = priceMatrix;
    }
}
