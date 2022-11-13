package managers;

import entities.Movie;
import entities.Booking;
import java.util.ArrayList;

/**
 * A Class which manages all the reviews
 */
public class ReviewManager {
    /**
     * User give review to movie
     * @param movie the movie to review
     * @param newRating the rating to give
     */
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

    /**
     * Return average rating of the selected movie
     * @param movie 
     * @return
     */
    public static float getAvgRating(Movie movie){
        ArrayList<Integer> ratings = movie.getRatings();
        int totalRating = 0;
        for(int i=0; i<ratings.size(); i++){
            totalRating += ratings.get(i);
        }
        return totalRating/ratings.size();
    }

    /**
     * Make a review on the booking
     * @param book the booking to review
     * @param rating the rating to give
     */
    public static void reviewBooking(Booking book, int rating) {
    	book.setRating(rating);
    	
    	Movie movie = MovieManager.getInstance().getMovieByID(book.getMovieID());
        review(movie, rating);
    }
}
