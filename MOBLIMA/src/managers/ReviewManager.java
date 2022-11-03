package managers;

import entities.Movie;
import java.util.ArrayList;

public class ReviewManager {
    // Add a rating
    public static void Review(Movie movie, int newRating){
        if(newRating > 5 || newRating < 0){
            System.out.println("Invalid input");
            return;
        }
        ArrayList<Integer> ratings = movie.getRatings();
        ratings.add(newRating);
        movie.setRatings(ratings);
    }
    // Get average rating
    public static int getAvgRating(Movie movie){
        ArrayList<Integer> ratings = movie.getRatings();
        int totalRating = 0;
        for(int i=0; i<ratings.size(); i++){
            totalRating += ratings.get(i);
        }
        return totalRating/ratings.size();
    }
}
