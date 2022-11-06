package entities;

public class Seats extends ISeats{

    public Seats(ISeatLayout seatLayout ){
        this.setSeats(seatLayout.getLayout());
    };
    @Override
    public void showSeats() {
        int row = this.getSeats().length;
        int col = this.getSeats()[0].length;
        System.out.print("   "); 
        for(int i=0; i<col; i++){
            System.out.print(" " + (char)(i+65));
        }
        System.out.println("\n");
        for(int i=0; i<row; i++){
            System.out.print(i+"  |");
            for(int j=0; j<col; j++){
                System.out.print(this.getSeats()[i][j].getState() + "|");
            }
            System.out.println("");
        }
    }
    
}
