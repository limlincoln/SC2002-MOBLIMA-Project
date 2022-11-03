package utils;

import entities.Movie;

public class SalesGenerator {
    public static void Generate(Movie[] movies){
        double total = 0;
        for(int i=0; i<movies.length; i++){
            total += movies[i].getTotalSales();
        }
        System.out.println(
            "Total Sales: " + total
        );
    }
}
