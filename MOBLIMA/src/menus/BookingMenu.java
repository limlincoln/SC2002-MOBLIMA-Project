package menu;
import entities.Movie;
import entities.Booking;
import entities.Cinema;
import entities.Customer;
import java.util.Scanner;

public class BookingMenu {
    private static BookingMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private BookingMenu(){}


    public static BookingMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new BookingMenu();
        return single_instance;
    }
    // BOOKINGMENU
        // SHOW AVALIABLE SHOW TIMES FOR THE WHOLE WEEK
        // SELECT DAY -> CALL SHOWTIME MANAGER 
        // SELECT SHOWTIME SLOT
        // SHOWTIMEMANAGER.FINDSEATS
        // CALL SEAT SELECTOR

        // SEATSELECTOR.STARTINSTANCE(SEATS): ARRAY OF SELECTED SEAT INFO
        // CALL TICKETMANAGER: ARRAY OF TICKETS
        // CALL PRICE.GETTOTALPRICE()
        // 
        // CALL BOOKING MANAGER: BOOKING

  
    public void displayBookingMenu() { //TODO: CHANGE TO BOOKING HISTORY MENU
    	int choice;	
		do {
            System.out.println(	"=========== MOBLIMA CUSTOMER BOOKING MENU =========\n" +
			                    " 1. Show booking history     					   \n" +
			                    " 0. Back to MOBLIMA APP                           \n"+
							    "====================================================");
	    	
            System.out.println("Enter choice: ");
            
            while (!sc.hasNextInt()) {
            	System.out.println("Invalid input type. Please enter an integer value.");
        		sc.next(); 
            }
            
            choice = sc.nextInt();
            
            switch(choice){
                case 1:
                	//showbookinghistory();
                    break;
                case 0:
                	System.out.println("Back to MOBLIMA APP......");
                	break;
                default: 
                	System.out.printf("Invalid input type.");
                	break;
	            }
	        } while (choice != 0);
    }
}
