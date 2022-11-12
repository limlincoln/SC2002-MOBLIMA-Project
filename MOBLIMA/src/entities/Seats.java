package entities;

// TODO: Auto-generated Javadoc
/**
 * The Class Seats.
 */
public class Seats extends ISeats{
    
    /** The id. */
    private int ID;

    /**
	 * Constructor for the Seats Class.
	 *
	 * @param id         the id
	 * @param seatLayout layout of the seats with which to create the Seats
	 */
    public Seats(Integer id, ISeatLayout seatLayout){
        this.ID = id;
        this.setSeats(seatLayout.getLayout());
    };

    /**
	 * Gets the seats ID.
	 *
	 * @return the seats ID
	 */
    public int getSeatsID() {
        return ID;
    }

}
