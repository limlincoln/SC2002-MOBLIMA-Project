package entities;

/**
 * Showtime class that holds the showtime slots and seats for that slot for a particular day.
 */
public class ShowTime {
    /**
     * ID for this showtime
     */
    private int showTimeID;

    /**
     * array containing movie IDs
     * index indicated a showtime slot in the day
     */
    private int[] showtime;

    /**
     * an array of Seats for this Showtime
     */
    private Seats[] seats;

    /**
     * The Constructor of the ShowTime Class
     */
    public ShowTime(int showTimeID, int[] showTime, Seats[] seats){
        this.showTimeID = showTimeID;
        this.showtime = showTime;
        this.seats = seats;
    }

    /**
     * get a Seats class for particular showtime
     * @param index the index of the showtime slot wanted
     * @return Seats for the particular showtime
     */
    public Seats getSeatsByShowTime(int index){
        return this.seats[index];
    }
    
    /** 
     * Getters & Setters
     */
    public int getShowTimeID() {
        return showTimeID;
    }

    public void setShowTimeID(int showTimeID) {
        this.showTimeID = showTimeID;
    }

    public int[] getShowTime() {
        return this.showtime;
    }

    public void setShowTime(int[] showtime) {
        this.showtime = showtime;
    }

    public Seats[] getSeats() {
        return this.seats;
    }

    public void setSeats(Seats[] seats) {
        this.seats = seats;
    }

}
