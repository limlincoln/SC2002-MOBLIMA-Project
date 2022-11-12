package entities;

import java.util.ArrayList;

import enums.CinemaType;
import enums.Status;

// TODO: Auto-generated Javadoc
/**
 * The Class Movie.
 */
public class Movie {
    
    /** The ID of this Movie. */
    private int movieID;

    /** The name of this Movie. */
    private String movieName;

    /** The genre for this Movie. */
    private CinemaType genre;

    /** The status of this Movie: NOW SHOWING, COMING SOON, END OF SHOWING. */
    private Status status;

    /** The casts of this Movie. */
    private ArrayList<String> casts;

    /** The director of this Movie. */
    private String director;

    /** The synopsis of this Movie. */
    private String sypnopsis;

    /** The list of ratings given to this Movie. */
    private ArrayList<Integer> ratings;

    /** The total sales made by this Movie so far. */
    private double totalSales;

    /** The average rating given to this Movie. */
    private Float avgRating;

    /**
	 * The Constructor for the Movie Class.
	 *
	 * @param movieID    The ID of this Movie
	 * @param movieName  The name of this Movie
	 * @param genre      The genre for this Movie
	 * @param status     The status of this Movie
	 * @param casts      The casts of this Movie
	 * @param director   The director of this Movie
	 * @param sypnopsis  The synopsis of this Movie
	 * @param ratings    The list of ratings given to this Movie
	 * @param totalSales The total sales made by this Movie so far
	 * @param avgRating  The average rating given to this Movie
	 */
    public Movie(int movieID, String movieName, CinemaType genre, Status status, ArrayList<String> casts, String director, String sypnopsis, ArrayList<Integer> ratings, double totalSales, Float avgRating) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.genre = genre;
        this.status = status;
        this.casts = casts;
        this.director = director;
        this.sypnopsis = sypnopsis;
        this.ratings = ratings;
        this.totalSales = totalSales;
        this.avgRating = avgRating;
    }

    /**
	 * Prints the details of this Movie on to the screen.
	 */
    public void showDetails(){
        System.out.println(
            "MovieName: " + getMovieName() + "\n" +
            "MovieType: " + getMovieType() + "\n" +
            "status: " + getStatus() + "\n" +
            "casts: " + getCasts() + "\n" +
            "director: " + getDirector() + "\n" +
            "sypnopsis: " + getSypnopsis() + "\n" +
            "Average Rating: " + getAvgRating() + "\n"
        ); 
    }

    /**
	 * Gets the movie ID.
	 *
	 * @return the movie ID
	 */
    // GETTERS AND SETTERS
    public int getMovieID() {
        return this.movieID;
    }

    /**
	 * Sets the movie ID.
	 *
	 * @param movieID the new movie ID
	 */
    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    /**
	 * Gets the movie name.
	 *
	 * @return the movie name
	 */
    public String getMovieName() {
        return this.movieName;
    }

    /**
	 * Sets the movie name.
	 *
	 * @param movieName the new movie name
	 */
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    /**
	 * Gets the movie type.
	 *
	 * @return the movie type
	 */
    public CinemaType getMovieType() {
        return this.genre;
    }

    /**
	 * Sets the movie type.
	 *
	 * @param genre the new movie type
	 */
    public void setMovieType(CinemaType genre) {
        this.genre = genre;
    }

    /**
	 * Gets the status.
	 *
	 * @return the status
	 */
    public Status getStatus() {
        return this.status;
    }

    /**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
	 * Gets the casts.
	 *
	 * @return the casts
	 */
    public ArrayList<String> getCasts() {
        return this.casts;
    }

    /**
	 * Sets the casts.
	 *
	 * @param casts the new casts
	 */
    public void setCasts(ArrayList<String> casts) {
        this.casts = casts;
    }

    /**
	 * Gets the director.
	 *
	 * @return the director
	 */
    public String getDirector() {
        return this.director;
    }

    /**
	 * Sets the director.
	 *
	 * @param director the new director
	 */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
	 * Gets the sypnopsis.
	 *
	 * @return the sypnopsis
	 */
    public String getSypnopsis() {
        return this.sypnopsis;
    }

    /**
	 * Sets the sypnopsis.
	 *
	 * @param sypnopsis the new sypnopsis
	 */
    public void setSypnopsis(String sypnopsis) {
        this.sypnopsis = sypnopsis;
    }

    /**
	 * Gets the ratings.
	 *
	 * @return the ratings
	 */
    public ArrayList<Integer> getRatings() {
        return this.ratings;
    }

    /**
	 * Sets the ratings.
	 *
	 * @param ratings the new ratings
	 */
    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    /**
	 * Gets the total sales.
	 *
	 * @return the total sales
	 */
    public double getTotalSales() {
        return this.totalSales;
    }

    /**
	 * Sets the total sales.
	 *
	 * @param totalSales the new total sales
	 */
    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    /**
	 * Gets the avg rating.
	 *
	 * @return the avg rating
	 */
    public double getAvgRating() {
        return this.avgRating;
    }

    /**
	 * Sets the avg rating.
	 *
	 * @param avgRating the new avg rating
	 */
    public void setAvgRating(Float avgRating) {
        this.avgRating = avgRating;
    }
    
}
