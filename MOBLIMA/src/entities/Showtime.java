package entities;

//import entities.Cinema;
import java.time.LocalDateTime;


public class Showtime{
    private int showtimeID;
    private LocalDateTime dateTime;
    private String movieID;
    private Cinema cinema;
    private String cineplexName;

    public Showtime (int sTID, LocalDateTime dT, String mID, Cinema c, String cpN){
        this.showtimeID = sTID;
        this.dateTime = dT;
        this.movieID = mID;
        this.cinema = c;
        this.cineplexName =cpN;
    }

    //Getters
    public int getShowtimeID() {
        return showtimeID;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public String getMovieID() {
        return movieID;
    }
    public Cinema getCinema() {
        return cinema;
    }
    public String getCineplexName() {
        return cineplexName;
    }

    //Setters
    public void setShowtimeID(int showtimeID) {
        this.showtimeID = showtimeID;
    }
    public void setDateTime(LocalDateTime dateTime) { 
        this.dateTime = dateTime; 
    }
    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }

}
