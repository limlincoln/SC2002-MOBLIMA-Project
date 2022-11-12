package caculators;

import java.util.ArrayList;

import entities.Movie;

// TODO: Auto-generated Javadoc
/**
 * The Class SalesCalculator.
 */
public class SalesCalculator {
    
    /** The single instance. */
    private static SalesCalculator single_instance = null;

    /**
	 * Instantiates a new sales calculator.
	 */
    private SalesCalculator(){}

    /**
	 * Gets the single instance of SalesCalculator.
	 *
	 * @return single instance of SalesCalculator
	 */
    public static SalesCalculator getInstance(){
        if(single_instance == null){
            single_instance = new SalesCalculator();
        }
        return single_instance;
    }
    
    /**
	 * Calc.
	 *
	 * @param movies the movies
	 * @return the double
	 */
    public double calc(ArrayList<Movie> movies){
        double total = 0;
        for(int i=0; i<movies.size(); i++){
            total += movies.get(i).getTotalSales();
        }
        return total;
    }
}
