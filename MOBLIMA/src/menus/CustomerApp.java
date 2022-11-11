package menus;
import java.util.Scanner;


public class CustomerApp {
	
    private static CustomerApp single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private CustomerApp(){}


    public static CustomerApp getInstance()
    {
        if (single_instance == null)
            single_instance = new CustomerApp();
        return single_instance;
    }


	public void displayCustomerMenu() {
		int choice;		
		
		do {
            System.out.println(	"============== MOBLIMA CUSTOMER APP ================\n" +
			                    " 1. View Movie menu     					        \n" +
			                    " 2. View Booking menu                              \n" +
			                    " 3. View Ratings                                  \n" +
			                    " 0. Back to MOBLIMA APP                           \n"+
							    "====================================================");
	    	
            System.out.println("Enter choice: ");
            
            while (!sc.hasNextInt()) {
            	System.out.println("Please enter an integer value or correct value.");
        		sc.next(); 
            }
            
            choice = sc.nextInt();
            
            switch(choice){
                case 1:
                	MovieMenu.getInstance().displayCustomerMovieMenu();
                    break;
                case 2:
                	BookingHistoryMenu.getInstance().displayBookingHistoryMenu(); // TODO: BOOKING HISTORY
                    break;
                case 3:
                	RatingMenu.getInstance().displayRatingMenu();
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