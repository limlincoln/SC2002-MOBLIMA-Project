package managers;
import java.util.ArrayList;
import entities.Movie;


public class PricingManager {
    private static double basePrice = 5.30;

    // SHOULD I CHANGE THIS TO A HASH MAP/TABLE?
    /*
     * Price Matrix (matrix of adders and subtractors)
     * [
     *  [adult, senior citizen, student]
     *  [IMAX, 3D, NORMAL],
     *  [weekend, weekday, public holiday],
     *  [before 6, after 6]
     * ]
    */
    private static ArrayList<ArrayList<Double>> priceMatrix = new ArrayList<ArrayList<Double>>();

    // CustomerType is an enum of senior, adult, student, etc.
    // can probably be created in the Customer class
    public static double calculatePrice(Movie movie,  int[] customerTypes) {
        double totalPrice = 0.0;
        double perPersonPrice = basePrice;
        
        switch(movie.getMovieType()) {
            case IMAX:
                perPersonPrice += priceMatrix.get(1).get(0);
                break;
            case _3D:
                perPersonPrice += priceMatrix.get(1).get(1);
                break;
            case NORMAL:
                perPersonPrice += priceMatrix.get(2).get(2);
        }
        
        if(HolidayManager.isHoliday(DateManager.getCurrentDateTime("yyyyMMdd"))) {
            perPersonPrice += priceMatrix.get(2).get(2);
        }
        else if(DateManager.isWeekend(DateManager.getDayOfWeek())) {
            perPersonPrice += priceMatrix.get(2).get(1);
        } 
        else {
            perPersonPrice += priceMatrix.get(2).get(0);
        }

        switch(DateManager.getTimeOfDay()) {
            case MORNING:
                perPersonPrice += priceMatrix.get(3).get(0);
                break;
            case EVENING:
                perPersonPrice += priceMatrix.get(3).get(1);
        }
        
        for(int i = 0; i < customerTypes.length; i++) {
            totalPrice += perPersonPrice;
            totalPrice += priceMatrix.get(0).get(customerTypes[i]);
        }

        return totalPrice;
    } 

    public static void showPriceBreakdown(Movie movie, int[] customerTypes) {
        double totalPrice = 0.0;
        double perPersonPrice = basePrice;

        System.out.println("Base Price:\t\t $"+basePrice);
        switch(movie.getMovieType()) {  
            case IMAX:
                perPersonPrice += priceMatrix.get(1).get(0);
                System.out.println("IMAX Movie:\t\t $"+priceMatrix.get(1).get(0));
                break;
            case _3D:
                perPersonPrice += priceMatrix.get(1).get(1);
                System.out.println("3D Movie:\t\t $"+priceMatrix.get(1).get(1));
                break;
            case NORMAL:
                // this should have no change on the price
                perPersonPrice += priceMatrix.get(2).get(2);
        }
        
        if(HolidayManager.isHoliday(DateManager.getCurrentDateTime("yyyyMMdd"))) {
            perPersonPrice += priceMatrix.get(2).get(2);
            System.out.println("Public Holiday:\t\t $"+priceMatrix.get(2).get(2));
        }
        else if(DateManager.isWeekend(DateManager.getDayOfWeek())) {
            perPersonPrice += priceMatrix.get(2).get(1);
            System.out.println("Weekend:\t\t $"+priceMatrix.get(2).get(1));
        } 
        else {
            perPersonPrice += priceMatrix.get(2).get(0);
            System.out.println("Weekday:\t\t $"+priceMatrix.get(2).get(0));
        }

        switch(DateManager.getTimeOfDay()) {
            case MORNING:
                perPersonPrice += priceMatrix.get(3).get(0);
                System.out.println("Morning:\t\t $"+priceMatrix.get(3).get(0));
                break;
            case EVENING:
                perPersonPrice += priceMatrix.get(3).get(1);
                System.out.println("Evening:\t\t $"+priceMatrix.get(3).get(1));
        }
        
        System.out.println("No. of Seats:\t\t x"+customerTypes.length);
        for(int i = 0; i < customerTypes.length; i++) {
            totalPrice += perPersonPrice;
            totalPrice += priceMatrix.get(0).get(customerTypes[i]);
        }

        System.out.println("=======================================");
        System.out.println("Total:\t\t $"+totalPrice);
    }
}
