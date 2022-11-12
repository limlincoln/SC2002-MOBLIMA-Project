package entities;

// TODO: Auto-generated Javadoc
/**
 * Showtime class that holds the showtime slots and seats for that slot for a particular day.
 */
public class ShowTime {
    
    /** ID for this showtime. */
    private int showTimeID;

    /** array containing movie IDs index indicated a showtime slot in the day. */
    private int[] showtime;

    /** an array of Seats for this Showtime. */
    private Seats[] seats;

    /**
	 * The Constructor of the ShowTime Class.
	 */
    public ShowTime(){
        this.showtime = new int[8];
        this.seats = new Seats[8];
    }

    /**
	 * get a Seats class for particular showtime.
	 *
	 * @param index the index of the showtime slot wanted
	 * @return Seats for the particular showtime
	 */
    public Seats getSeatsByShowTime(int index){
        return this.seats[index];
    }
    
    /**
	 * 
	 * Getters & Setters.
	 *
	 * @return the show time ID
	 */
    public int getShowTimeID() {
        return showTimeID;
    }

    /**
	 * Sets the show time ID.
	 *
	 * @param showTimeID the new show time ID
	 */
    public void setShowTimeID(int showTimeID) {
        this.showTimeID = showTimeID;
    }

    /**
	 * Gets the show time.
	 *
	 * @return the show time
	 */
    public int[] getShowTime() {
        return this.showtime;
    }

    /**
	 * Sets the show time.
	 *
	 * @param showtime the new show time
	 */
    public void setShowTime(int[] showtime) {
        this.showtime = showtime;
    }

    /**
	 * Gets the seats.
	 *
	 * @return the seats
	 */
    public Seats[] getSeats() {
        return this.seats;
    }

    /**
	 * Sets the seats.
	 *
	 * @param seats the new seats
	 */
    public void setSeats(Seats[] seats) {
        this.seats = seats;
    }

}
