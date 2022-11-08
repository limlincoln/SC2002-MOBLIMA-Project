package entities;

import java.util.ArrayList;

public class Cinema{
    private int CinemaID;
    private int CinemaType;
    private ArrayList<ShowTime> showtimes;
    
    public Cinema(int cID, int cType, ArrayList<ShowTime> sTime){
        this.CinemaID = cID;
        this.CinemaType = cType;
        this.showtimes = sTime;
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

    public int getCinemaType() {
        return this.CinemaType;
    }

    public void setCinemaType(int CinemaType) {
        this.CinemaType = CinemaType;
    }

    public ArrayList<ShowTime> getShowtimes() {
        return this.showtimes;
    }

    public void setShowtimes(ArrayList<ShowTime> showtimes) {
        this.showtimes = showtimes;
    }
   
}