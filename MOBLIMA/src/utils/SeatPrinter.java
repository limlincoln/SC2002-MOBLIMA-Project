package utils;

import entities.ISeat;
import entities.ISeats;

public class SeatPrinter implements IPrinter<ISeat[][]>{
    private static SeatPrinter single_instance = null;
    private SeatPrinter(){};

    public static SeatPrinter getInstance(){
        if(single_instance == null){
            single_instance = new SeatPrinter();
        }
        return single_instance;
    }
    
    /**
     * Seat layout printer
     */
    public void print(ISeat[][] seatlayout){
        int row = seatlayout.length;
        int col = seatlayout[0].length;
        System.out.print("   "); 
        for(int i=0; i<col; i++){
            System.out.print(" " + (char)(i+65));
        }
        System.out.println("\n");
        for(int i=0; i<row; i++){
            System.out.print(i+"  |");
            for(int j=0; j<col; j++){
                System.out.print(seatlayout[i][j].getState() + "|");
            }
            System.out.println("");
        }
    }
    
    // overload
    public void print(ISeats seats){
       this.print(seats.getSeats());
    }
}
