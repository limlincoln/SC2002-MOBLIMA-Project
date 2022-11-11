package entities;

/**
 * Showtime class that holds the showtime slots and seats for that slot for a particular day.
 */
public class ShowTime {
    private int[] showtime;
    private Seats[] seats;

    public ShowTime(){
        this.showtime = new int[8];
        this.seats = new Seats[8];
    }

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
