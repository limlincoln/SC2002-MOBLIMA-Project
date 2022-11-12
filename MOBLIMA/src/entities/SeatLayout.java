package entities;

import java.util.Optional;
import java.util.Scanner;

import utils.IDGenerator;
import utils.SeatPrinter;

// TODO: Auto-generated Javadoc
/**
 * The Class SeatLayout.
 */
public class SeatLayout extends ISeatLayout{
    
    /** The id. */
    private Integer ID;

    /**
	 * Constructor for the SeatLayout Class.
	 */
    public SeatLayout(){
        Optional<ISeat[][]> l = createLayout();
        if(l.isPresent()){
            this.setLayout(l.get());   
            this.ID = IDGenerator.get();
        }else{
            System.out.println("SeatLayout creation interrupted");
        }
    }

    /**
	 * Constructor for the SeatLayout Class.
	 *
	 * @param id     the id
	 * @param layout layout of the seat
	 */
    public SeatLayout(Integer id, ISeat[][] layout){
        this.setLayout(layout);
        this.ID = id;
    }

    /**
	 * creates the Seat layout.
	 *
	 * @return the optional
	 */
    @Override
    public Optional<ISeat[][]> createLayout() {
        Scanner sc = new Scanner(System.in);
        SeatPrinter sp = SeatPrinter.getInstance();
        int choice = 0;
        ISeat[][] layout =new ISeat[1][1];
        System.out.println("Creating New Cinema Layout...\n");
        do{
            System.out.println("Enter total number of rows in cinema");
            int rows = sc.nextInt();
            System.out.println("Enter total number of columns in cinema");
            int cols = sc.nextInt();
    
            System.out.println("Creating Layout");
            if(rows>0 && cols>0){
                layout = new ISeat[rows][cols];
                for(int i=0; i<rows; i++){
                    for(int j=0; j<cols; j++){
                        layout[i][j] = new Seat();
                    }
                }
                System.out.println("Successfully Created Basic Layout");
                System.out.println("\n1. Proceed to add Space      \n"+
                                        "2. Re-enter basic layout  \n"+
                                        "0. Quit\n");
                choice = sc.nextInt();
                if(choice ==0){
                    return Optional.empty();
                }
            }else{
                choice = 2;
            }            
        }while(choice==2);
        
        do{
            sp.print(layout);
            System.out.println("1. Remove Seat                \n"+
                                "2. Confrim Seat Layout       \n"+
                                "0. Quit                      \n");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                System.out.println("Enter Seat to be removed eg. A0");
                    sc.nextLine();
                    String input = sc.nextLine().toUpperCase();
                    Integer colSelected = ((int)input.charAt(0)) - 65;
                    Integer rowSelected = Integer.parseInt(input.substring(1));
                    if(rowSelected >= layout.length || colSelected >= layout.length){
                        System.out.println("Invalid Seat Selected");
                        continue;
                    }else{
                        if(layout[rowSelected][colSelected] instanceof Space){
                            layout[rowSelected][colSelected] = new Seat();
                        }else{
                            layout[rowSelected][colSelected] = new Space();
                        }
                    }
                    break;
                case 2:
                    return Optional.of(layout);
                case 0:
                default:
                    return Optional.empty();
            }
    }while(choice == 1);
    return Optional.empty();
    }
    
    /**
	 * Gets the id.
	 *
	 * @return the id
	 */
    public Integer getID() {
        return this.ID;
    }

    /**
	 * Sets the id.
	 *
	 * @param ID the new id
	 */
    public void setID(Integer ID) {
        this.ID = ID;
    }
    
}
