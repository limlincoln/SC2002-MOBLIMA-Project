package entities;

/**
 * Class that contains information about a Seat
 */
public class Seat implements ISeat, ISelectableSeat {
    /**
     * Whether the seat has been occupied or not
     */
    private boolean occupied = false;

    /**
     * Whether the seat has been selected temporarily 
     * during the seat selection process
     */
    private boolean tempSelected = false;

    /**
     * Constructor for the Seat Class
     */
    public Seat(){};

    /**
     * Get the current status of the seat
     * @return whether it is:
     * occupied 'X', 
     * is temporarily selected 'O',
     * is available to be selected '_'
     */
    @Override
    public String getState() {
        if(this.isOccupied()){
            return "X";
        }else{
            if(this.isTempSelected()){
                return "O";
            }else{
                return "_";
            }
        }
    }

    /**
     * Get the current status of the seat
     * @return whethere it is:
     * occupied 0
     * is temporarily selected -1
     * is available to be selected 1
     */
    public int getStateInt() {
        if(this.isOccupied()){
            return 0;
        }else{
            if(this.isTempSelected()){
                return -1;
            }else{
                return 1;
            }
        } 
    }

    /**
     * Change the status of the seat to occupied
     * if unoccupied else set to it occupied
     */
    @Override
    public void toggleOccupied(){
        this.setOccupied(!this.getOccupied());
    }

    /**
     * Toggle the value of tempSelected 
     * atrribute
     */
    @Override
    public void toggleTempSelected(){
        this.setTempSelected(!this.getTempSelected());
    }

    /**
     * Checks if seat is occupied
     * @return true if occupied false if not
     */
    public boolean isOccupied() {
        return this.occupied;
    }

    /**
     * Check if seat is selected temporarily
     * @return true if selected temporarily false if not
     */
    public boolean isTempSelected() {
        return this.tempSelected;
    }

    // GETTERS AND SETTERS
    public boolean getOccupied() {
        return this.occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
    
    public boolean getTempSelected() {
        return this.tempSelected;
    }

    public void setTempSelected(boolean tempSelected) {
        this.tempSelected = tempSelected;
    }
    
}
