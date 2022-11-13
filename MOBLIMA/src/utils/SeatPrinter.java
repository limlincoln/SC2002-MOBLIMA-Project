package utils;

import entities.ISeat;
import entities.ISeats;
/**
 * Display seats for movie
 */
public class SeatPrinter implements IPrinter<ISeat[][]>{
    /**
     * Single instance of SeatPrinter
     */
    private static SeatPrinter single_instance = null;
    private SeatPrinter(){};
    /**
    * Creates or gets a single instance of SeatPrinter class
    * @return SeatPrinter Class
    */
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
            System.out.print(i);
            if(!(0<col && seatlayout[i][0].getState().equals(" "))){
                System.out.print("  |");
            }
            for(int j=0; j<col; j++){
                if(j==0 && j+1<col && seatlayout[i][j+1].getState().equals(" ")){
                    continue;
                }
                if(j==col-1 && j>0 && seatlayout[i][j-1].getState().equals(" ")){
                    continue;
                }
                if(j>0 && j+1<col && seatlayout[i][j-1].getState().equals(" ") && seatlayout[i][j+1].getState().equals(" ")){
                    continue;
                }
                System.out.print(seatlayout[i][j].getState() + "|");
            }
            System.out.println("");
        }
    }
    
    // overload
    
    /**
     * Seat printer
     */
    public void print(ISeats seats){
       this.print(seats.getSeats());
    }
}
