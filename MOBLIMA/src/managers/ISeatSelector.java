package managers;

import entities.ISeats;

interface ISeatSelector{
    public <T> T StartSeatSelectionInstance(ISeats seats);
}
