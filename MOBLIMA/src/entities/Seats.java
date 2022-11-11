package entities;

public class Seats extends ISeats{
    /**
     * Constructor for the Seats Class
     * @param seatLayout layout of the seats with which to create the Seats
     */
    public Seats(ISeatLayout seatLayout){
        this.setSeats(seatLayout.getLayout());
    };
}
