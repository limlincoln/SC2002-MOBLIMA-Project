package menus;

import java.util.Scanner;

public class RatingMenu {
    private static RatingMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private RatingMenu(){}


    public static RatingMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new RatingMenu();
        return single_instance;
    }

    /**
     * Customer app rating function
     */
	public void displayRatingMenu() {
		int choice;		
		
		do {
            System.out.println(	"============== MOBLIMA CUSTOMER APP ================\n" +
			                    " 1. Rate a movie     					        	\n" +
			                    " 2. View past rating                               \n" + //NOT IMPORTANT
			                    " 0. Back to MOBLIMA APP                            \n"+
							    "====================================================");
	    	
            System.out.println("Enter choice: ");
            
            while (!sc.hasNextInt()) {
            	System.out.println("Please enter an integer value or correct value.");
        		sc.next(); 
            }
            
            choice = sc.nextInt();
            
            switch(choice){
                case 1:
                	//Rate movie based on booking history?
                    // TODO: CALL BOOKINGMANAGER.GETUNRATEDBOOKINGS;
                    // TODO: CALL REVIEWMANGER WITH SELECTED BOOKING
                    break;
                case 2:
                	//View past rating history?
                    break;
                case 0:
                	System.out.println("Back to MOBLIMA APP......");
                	break;
                default: 
                	System.out.println("Please enter an integer value or correct value.");
                	break;
	            }
	        } while (choice != 0);
		}
}
