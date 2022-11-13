package managers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import entities.IPrice;
import enums.IPriceable;

public class PricingManager {
    /*
     * Price Matrix (HashMap of adders and subtractors)
     * eg:
     * TypeOfDay.WEEKEND = -2.30
     * AgeGroup.STUDENT = -1.20 
    */
    private static HashMap<IPriceable, Double> priceMatrix = new HashMap<IPriceable, Double>();

    public static double getPrice(Object o) {
        return priceMatrix.get(o);
    }

    /**
     * Add new price into the price matrix
     * @param priceFor
     * @param price
     */
    public static void addPrice(IPriceable priceFor, Double price) {
        priceMatrix.put(priceFor, price);
    }

    /**
     * Update Price for each individual pricings
     * @param priceFor
     * @param newPrice
     */
    public static void updatePrice(IPriceable priceFor, Double newPrice) {
        priceMatrix.put(priceFor, newPrice);
    }

    /**
     * Get the entire price matrix
     * @return
     */
    public static HashMap<IPriceable, Double> getPriceMatrix() {
        return priceMatrix;
    }

    /**
     * Display the price matrix
     */
    public static void showPriceMatrix() {
        System.out.println("========== Pricing ==========");
        int[] moreTab = {1,2,4,6,10,11,12,14};
        int i=0;
        int j=0;
        for(IPriceable o: priceMatrix.keySet()) {
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
     * Get the objects which can have a price
     * @return a string set with the name of the IPricable classes
     */
    public static ArrayList<Class<? extends IPriceable>> getPriceAbleObjects() {
        ArrayList<Class<? extends IPriceable>> priceableObjsStr = new ArrayList<Class<? extends IPriceable>>();
        
        for(IPriceable priceableObj: priceMatrix.keySet()) {
            priceableObjsStr.add(priceableObj.getClass());
        }
        
        Set<Class<? extends IPriceable>> temp = new HashSet<>(priceableObjsStr);
        priceableObjsStr.clear();
        priceableObjsStr.addAll(temp);

        return priceableObjsStr;
    }

    /**
     * Set price matrix
     * @param priceMatrix
     */
    public static void setPriceMatrix(HashMap<IPriceable, Double> priceMatrix) {
        PricingManager.priceMatrix = priceMatrix;
    }
}
