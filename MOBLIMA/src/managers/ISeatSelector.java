package managers;

import entities.ISeats;

/**
 * interface for seat selector
 */
interface ISeatSelector{
    public <T> T StartSeatSelectionInstance(ISeats seats);
}
