package menu;
import entities.Movie;
import entities.Booking;
import entities.Cinema;
import entities.Customer;
import java.util.Scanner;

public class BookingHistoryMenu {
    private static BookingHistoryMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private BookingHistoryMenu(){}


    public static BookingHistoryMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new BookingHistoryMenu();
        return single_instance;
    }


    public void displayBookingHistoryMenu() { 
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
