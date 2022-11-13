package entities;

/**
 * interface for a seat that is selectable
 */
interface ISelectableSeat {
    /**
     * toggle if the seat has been temporarily selected
     */
    public void toggleTempSelected();

    /**
     * toggle if the seat has been occupied
     */
    public void toggleOccupied();
}
