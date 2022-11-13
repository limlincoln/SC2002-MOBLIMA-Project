package entities;

/**
 * Class that contains information about a set of Seats
 */
public class Seats extends ISeats{
    private int ID;

    /**
     * Constructor for the Seats Class
     * @param seatLayout layout of the seats with which to create the Seats
    */
    public Seats(Integer id, ISeatLayout seatLayout){
        this.ID = id;
        this.setSeats(seatLayout.getLayout());
    };

    /**
     * Constructor for the Seats Class
     * @param seatLayout layout of the seats with which to create the Seats
    */
    public Seats(Integer id, ISeat[][] seatLayout){
        this.ID = id;
        this.setSeats(seatLayout);
    }

    // GETTERS and SETTERS
    public int getSeatsID() {
        return ID;
    }

}
