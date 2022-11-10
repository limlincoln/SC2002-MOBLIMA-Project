package entities;

import java.util.ArrayList;
import enums.CinemaType;
import enums.Status;



// should we inherit from a abstract class Show? To fulfill DIP, 
// also so we can say out system allow future extension of different kinds of shows (live performance etc)

public class Movie {
    private int movieID;
    private String movieName;
    private CinemaType genre;
    private Status status;
    private ArrayList<String> casts;
    private String director;
    private String sypnopsis;
    private ArrayList<Integer> ratings;
    private double totalSales;
    private Float avgRating;


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

    public CinemaType getMovieType() {
        return this.genre;
    }

    public void setMovieType(CinemaType genre) {
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
    
}
