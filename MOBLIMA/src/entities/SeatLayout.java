package entities;

public class SeatLayout extends ISeatLayout{
    // creating a new layout
    private SeatLayout(){
        createLayout();
    }

    private SeatLayout(ISeat[][] layout){
        this.setLayout(layout);
    }


    @Override
    public void createLayout() {
        // TODO:
        
    }
    
}
