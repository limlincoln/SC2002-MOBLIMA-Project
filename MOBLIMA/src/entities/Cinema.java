package entities;

import java.util.ArrayList;

import enums.CinemaType;
import managers.PricingManager;

public class Cinema implements IPrice {
    private String CinemaName;
    private int CinemaID;
    private CinemaType CinemaType;
    private ArrayList<ShowTime> showtimes;
    
    public Cinema(int cID, CinemaType cType, ArrayList<ShowTime> sTime){
        this.CinemaID = cID;
        this.CinemaType = cType;
        this.showtimes = sTime;
    }

    public double getPrice() {
        return PricingManager.getPrice(CinemaType);
    }

    // TODO: IMPLEMENT
    public ArrayList<Movie> getMovies(){
        return new ArrayList<Movie>();
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
   
}