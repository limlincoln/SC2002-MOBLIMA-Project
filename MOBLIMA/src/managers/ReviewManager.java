package managers;

import entities.Movie;
import entities.Booking;
import java.util.ArrayList;

public class ReviewManager {
    public static void review(Movie movie, int newRating){
        if(newRating > 5 || newRating < 0){
            System.out.println("Invalid input");
            return;
        }
        ArrayList<Integer> ratings = movie.getRatings();
        ratings.add(newRating);
        movie.setRatings(ratings);
        movie.setAvgRating(getAvgRating(movie));
    }

    public static float getAvgRating(Movie movie){
        ArrayList<Integer> ratings = movie.getRatings();
        int totalRating = 0;
        for(int i=0; i<ratings.size(); i++){
            totalRating += ratings.get(i);
        }
        return totalRating/ratings.size();
    }

    public static void reviewBooking(Booking book, int rating) {
    	book.setRating(rating);
    	
    	Movie movie = MovieManager.getInstance().getMovieByID(book.getMovieID());
        review(movie, rating);
    }
}
