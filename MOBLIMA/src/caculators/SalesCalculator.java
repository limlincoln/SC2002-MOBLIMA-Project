package caculators;

import java.util.ArrayList;

import entities.Movie;

public class SalesCalculator {
    private static SalesCalculator single_instance = null;

    private SalesCalculator(){}

    public static SalesCalculator getInstance(){
        if(single_instance == null){
            single_instance = new SalesCalculator();
        }
        return single_instance;
    }
    
    public double calc(ArrayList<Movie> movies){
        double total = 0;
        for(int i=0; i<movies.size(); i++){
            total += movies.get(i).getTotalSales();
        }
        return total;
    }
}
