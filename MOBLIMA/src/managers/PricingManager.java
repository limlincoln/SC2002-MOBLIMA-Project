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

    public static void addPrice(Object priceFor, Double price) {
        priceMatrix.put(priceFor, price);
    }

    public static void updatePrice(Object priceFor, Double newPrice) {
        priceMatrix.put(priceFor, newPrice);
    }

    public static HashMap<Object, Double> getPriceMatrix() {
        return priceMatrix;
    }

    public static void showPriceMatrix() {
        System.out.println("========== Pricing ==========");
        
        for(Object o: priceMatrix.keySet()) {
            System.out.println(o+":\t\t"+priceMatrix.get(o));
        }
    }

    public static void setPriceMatrix(HashMap<Object, Double> priceMatrix) {
        PricingManager.priceMatrix = priceMatrix;
    }
}
