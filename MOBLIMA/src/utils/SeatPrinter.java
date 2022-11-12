package utils;

import entities.ISeat;
import entities.ISeats;

// TODO: Auto-generated Javadoc
/**
 * The Class SeatPrinter.
 */
public class SeatPrinter implements IPrinter<ISeat[][]>{
    
    /** The single instance. */
    private static SeatPrinter single_instance = null;
    
    /**
	 * Instantiates a new seat printer.
	 */
    private SeatPrinter(){};

    /**
	 * Gets the single instance of SeatPrinter.
	 *
	 * @return single instance of SeatPrinter
	 */
    public static SeatPrinter getInstance(){
        if(single_instance == null){
            single_instance = new SeatPrinter();
        }
        return single_instance;
    }
    
    /**
	 * Seat layout printer.
	 *
	 * @param seatlayout the seatlayout
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
    
    /**
	 * Prints the.
	 *
	 * @param seats the seats
	 */
    // overload
    public void print(ISeats seats){
       this.print(seats.getSeats());
    }
}
