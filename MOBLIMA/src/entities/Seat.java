package entities;

public class Seat implements ISeat {
    private boolean occupied;
    private boolean tempSelected;

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

    public boolean isOccupied() {
        return this.occupied;
    }

    public boolean getOccupied() {
        return this.occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isTempSelected() {
        return this.tempSelected;
    }

    public boolean getTempSelected() {
        return this.tempSelected;
    }

    public void setTempSelected(boolean tempSelected) {
        this.tempSelected = tempSelected;
    }
    
}
