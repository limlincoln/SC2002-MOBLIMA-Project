package entities;

public class Seat implements ISeat, ISelectableSeat {
    private boolean occupied;
    private boolean tempSelected;

    public Seat(){};
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

    @Override
    public void toggleOccupied(){
        this.setOccupied(!this.getOccupied());
    }

    @Override
    public void toggleTempSelected(){
        this.setTempSelected(!this.getTempSelected());
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
