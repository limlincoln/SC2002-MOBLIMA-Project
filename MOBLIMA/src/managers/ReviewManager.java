package managers;

import entities.Movie;
import entities.Booking;
import java.util.ArrayList;

import consolidators.MovieConsolidator;

public class ReviewManager {
    // Add a rating to movie class
    public void Review(Movie movie, int newRating){
        if(newRating > 5 || newRating < 0){
            System.out.println("Invalid input");
            return;
        }
        ArrayList<Integer> ratings = movie.getRatings();
        ratings.add(newRating);
        movie.setRatings(ratings);
    }
    // Get average rating
    public int getAvgRating(Movie movie){
        ArrayList<Integer> ratings = movie.getRatings();
        int totalRating = 0;
        for(int i=0; i<ratings.size(); i++){
            totalRating += ratings.get(i);
        }
        return totalRating/ratings.size();
    }

    // TODO: REVMIEW A PARTICULAR BOOKING
    // change the rating in the booking class
    // add this rating to movie class
    // update average rating.
    public void Reviewbooking(Booking book, int rating) {
    	//Set new rating to bookinghistory
    	book.setRating(rating);
    	
    	// update average rating
    	ArrayList<Movie> movies = new ArrayList<Movie>();
    	movies = MovieConsolidator.getInstance().getAll();
    	ArrayList<Integer> allpreviousrating = movies.get(book.getMovieID()).getRatings();
    	allpreviousrating.add(rating);
    	movies.get(book.getMovieID()).setRatings(allpreviousrating);
    	
    }
}
