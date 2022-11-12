package entities;

import java.util.ArrayList;

import enums.CinemaType;
import managers.MovieManager;
import managers.PricingManager;
import managers.ShowTimeManager;

// TODO: Auto-generated Javadoc
/**
 * The Class Cinema.
 */
public class Cinema implements IPrice {
    
    /** The ID of the Cinema. */
    private int CinemaID;

    /** The type of this Cinema. */
    private CinemaType CinemaType;

    /** The list of ShowTimes for this Cinema. */
    private ArrayList<ShowTime> showtimes;
    
    /**
	 * Constructor for the Cinema Class.
	 *
	 * @param cID   The ID of this Cinema
	 * @param cType The type of this Cinema
	 * @param sTime The list of ShowTimes for this Cinema
	 */
    public Cinema(int cID, CinemaType cType, ArrayList<ShowTime> sTime){
        this.CinemaID = cID;
        this.CinemaType = cType;
        this.showtimes = sTime;
    }

    /**
	 * Gets the price.
	 *
	 * @return the price
	 */
    public double getPrice() {
        return PricingManager.getPrice(CinemaType);
    }

    /**
	 * Contains movie.
	 *
	 * @param movieID the movie ID
	 * @return true, if successful
	 */
    public boolean containsMovie(int movieID) {
        return ShowTimeManager.getInstance().getShowTimeByMovie(this, MovieManager.getInstance().getMovieByID(movieID)).size() == 0;
    }

    /**
	 * Gets the cinema ID.
	 *
	 * @return the cinema ID
	 */
    public int getCinemaID() {
        return this.CinemaID;
    }

    /**
	 * Sets the cinema ID.
	 *
	 * @param CinemaID the new cinema ID
	 */
    public void setCinemaID(int CinemaID) {
        this.CinemaID = CinemaID;
    }

    /**
	 * Gets the cinema type.
	 *
	 * @return the cinema type
	 */
    public CinemaType getCinemaType() {
        return this.CinemaType;
    }

    /**
	 * Sets the cinema type.
	 *
	 * @param CinemaType the new cinema type
	 */
    public void setCinemaType(CinemaType CinemaType) {
        this.CinemaType = CinemaType;
    }

    /**
	 * Gets the showtimes.
	 *
	 * @return the showtimes
	 */
    public ArrayList<ShowTime> getShowtimes() {
        return this.showtimes;
    }

    /**
	 * Sets the showtimes.
	 *
	 * @param showtimes the new showtimes
	 */
    public void setShowtimes(ArrayList<ShowTime> showtimes) {
        this.showtimes = showtimes;
    }
   
}