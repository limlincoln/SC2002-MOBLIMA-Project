package managers;

import entities.ISeats;

// TODO: Auto-generated Javadoc
/**
 * The Interface ISeatSelector.
 */
interface ISeatSelector{
    
    /**
	 * Start seat selection instance.
	 *
	 * @param <T>   the generic type
	 * @param seats the seats
	 * @return the t
	 */
    public <T> T StartSeatSelectionInstance(ISeats seats);
}
