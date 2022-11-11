package entities;

/**
 * Showtime class that holds the showtime slots and seats for that slot for a particular day.
 */
public class ShowTime {
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
    public ShowTime(){
        this.showtime = new int[8];
        this.seats = new Seats[8];
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
