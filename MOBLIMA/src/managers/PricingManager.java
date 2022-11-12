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
        int[] moreTab = {1,3,4,8,9};
        int i=0;
        int j=0;
        for(Object o: priceMatrix.keySet()) {
            String tabs = "\t\t";
            if(j<5 && i==moreTab[j]){
                tabs+="\t";
                j++;
            }
            i++;
            System.out.println(o+":"+tabs+priceMatrix.get(o));
        }
        System.out.println("");
    }

    /**
     * Set price matrix
     * @param priceMatrix
     */
    public static void setPriceMatrix(HashMap<Object, Double> priceMatrix) {
        PricingManager.priceMatrix = priceMatrix;
    }
}
