package entities;

public class Seats implements ISeats{
    private ISeat[][] seats;

    public Seats(ISeatLayout seatLayout ){
        this.seats = seatLayout.getLayout();
    };
    @Override
    public void showSeats() {
        int row = seats.length;
        int col = seats[0].length;
        System.out.print("|");
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                System.out.print(seats[i][j].getState() + "|");
            }
            System.out.println("");
        }
        
    }
    
}
