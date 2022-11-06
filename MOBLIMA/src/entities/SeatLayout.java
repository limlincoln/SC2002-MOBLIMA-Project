package entities;

public class SeatLayout extends ISeatLayout{
    // creating a new layout
    public SeatLayout(){
        createLayout();
    }

    public SeatLayout(ISeat[][] layout){
        this.setLayout(layout);
    }


    @Override
    public void createLayout() {
        // TODO:
        
    }
    
}
