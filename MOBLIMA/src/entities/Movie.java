package entities;

import java.text.DecimalFormat;
import java.util.ArrayList;

import enums.CinemaType;
import enums.MovieGenre;
import enums.Status;

public class Movie {
    /**
     * The ID of this Movie
     */
    private int movieID;

    /**
     * The name of this Movie
     */
    private String movieName;

    /**
     * The genre for this Movie
     */
    private MovieGenre genre;

    /**
     * The status of this Movie:
     * NOW SHOWING, COMING SOON, END OF SHOWING
     */
    private Status status;

    /**
     * The casts of this Movie
     */
    private ArrayList<String> casts;

    /**
     * The director of this Movie
     */
    private String director;

    /**
     * The synopsis of this Movie
     */
    private String sypnopsis;

    /**
     * The list of ratings given to this Movie
     */
    private ArrayList<Integer> ratings;

    /**
     * The total sales made by this Movie so far
     */
    private double totalSales;

    /**
     * The average rating given to this Movie
     */
    private Float avgRating;

    /**
     * The List of cinema types which shows this movie
     */
    private ArrayList<CinemaType> cinemaTypes;

    /**
     * The Constructor for the Movie Class
     * @param movieID The ID of this Movie
     * @param movieName The name of this Movie
     * @param genre The genre for this Movie
     * @param status The status of this Movie
     * @param casts The casts of this Movie
     * @param director The director of this Movie
     * @param sypnopsis The synopsis of this Movie
     * @param ratings The list of ratings given to this Movie 
     * @param totalSales The total sales made by this Movie so far
     * @param avgRating The average rating given to this Movie
     * @param cinemaTypes The List of cinema types which shows this movie 
     */
    public Movie(int movieID, String movieName, MovieGenre genre, Status status, ArrayList<String> casts, String director, String sypnopsis, ArrayList<Integer> ratings, double totalSales, Float avgRating, ArrayList<CinemaType> cinemaTypes) {
        this.movieID = movieID;
        this.movieName = movieName;
        this.director = director;
        this.sypnopsis = sypnopsis;
        this.casts = casts;
        this.status = status;
        this.totalSales = totalSales;
        this.ratings = ratings;
        this.avgRating = avgRating;
        this.genre = genre;
        this.cinemaTypes = cinemaTypes;
    }

    /**
     * Prints the details of this Movie on to the screen
     */
    public void showDetails(){
        DecimalFormat df = new DecimalFormat(".##");
        System.out.println(
            "MovieName: " + getMovieName() + "\n" +
            "Genre: " + getMovieType() + "\n" +
            "status: " + getStatus() + "\n" +
            "casts: " + getCasts() + "\n" +
            "director: " + getDirector() + "\n" +
            "sypnopsis: " + getSypnopsis() + "\n" +
            "Average Rating: " + df.format(getAvgRating()) + "\n" +
            "Cinema Types: " + getCinemaTypes() + "\n"
        ); 
    }

    // GETTERS AND SETTERS
    public int getMovieID() {
        return this.movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public MovieGenre getMovieType() {
        return this.genre;
    }

    public void setMovieType(MovieGenre genre) {
        this.genre = genre;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ArrayList<String> getCasts() {
        return this.casts;
    }

    public void setCasts(ArrayList<String> casts) {
        this.casts = casts;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSypnopsis() {
        return this.sypnopsis;
    }

    public void setSypnopsis(String sypnopsis) {
        this.sypnopsis = sypnopsis;
    }

    public ArrayList<Integer> getRatings() {
        return this.ratings;
    }

    public void setRatings(ArrayList<Integer> ratings) {
        this.ratings = ratings;
    }

    public double getTotalSales() {
        return this.totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public double getAvgRating() {
        return this.avgRating;
    }

    public void setAvgRating(Float avgRating) {
        this.avgRating = avgRating;
    }
    
    public ArrayList<CinemaType> getCinemaTypes(){
        return this.cinemaTypes;
    }

    public void setCinemaTypes(ArrayList<CinemaType> cinemaTypes){
        this.cinemaTypes = cinemaTypes;
    }
}
