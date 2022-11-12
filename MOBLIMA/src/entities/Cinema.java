package entities;

import java.util.ArrayList;

import enums.CinemaClass;
import enums.CinemaType;
import managers.MovieManager;
import managers.PricingManager;
import managers.ShowTimeManager;

public class Cinema implements IPrice {
    /**
     * The ID of the Cinema
     */
    private int CinemaID;

    /**
     * The type of this Cinema
     */
    private CinemaType CinemaType;

    /**
     * The list of ShowTimes for this Cinema
     */
    private ArrayList<ShowTime> showtimes;
    
    /**
     * The Class of the cinema
     */
    private CinemaClass CinemaClass;
    
    /**
     * Constructor for the Cinema Class
     * @param cID The ID of this Cinema
     * @param cType The type of this Cinema
     * @param sTime The list of ShowTimes for this Cinema
     */
    public Cinema(int cID, CinemaType cType, ArrayList<ShowTime> sTime, CinemaClass CinemaClass){
        this.CinemaID = cID;
        this.CinemaType = cType;
        this.showtimes = sTime;
        this.CinemaClass = CinemaClass;
    }

    public double getPrice() {
        return PricingManager.getPrice(CinemaType) + PricingManager.getPrice(CinemaClass);
    }

    public boolean containsMovie(int movieID) {
        return ShowTimeManager.getInstance().getShowTimeByMovie(this, MovieManager.getInstance().getMovieByID(movieID)).size() != 0;
    }

    public int getCinemaID() {
        return this.CinemaID;
    }

    public void setCinemaID(int CinemaID) {
        this.CinemaID = CinemaID;
    }

    public CinemaType getCinemaType() {
        return this.CinemaType;
    }

    public void setCinemaType(CinemaType CinemaType) {
        this.CinemaType = CinemaType;
    }

    public ArrayList<ShowTime> getShowtimes() {
        return this.showtimes;
    }

    public void setShowtimes(ArrayList<ShowTime> showtimes) {
        this.showtimes = showtimes;
    }
    
    public CinemaClass getCinemaClass(){
        return this.CinemaClass;
    }

    public void setCinemaClass(CinemaClass cinemaClass){
        this.CinemaClass = cinemaClass;
    }
   
}