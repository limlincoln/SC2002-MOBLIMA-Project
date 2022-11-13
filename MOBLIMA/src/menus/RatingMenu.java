package menus;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Booking;
import managers.BookingManager;
import managers.MovieManager;

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
                	BookingHistoryMenu.getInstance().displayBookingHistoryMenu();
                    break;
                case 2:
                	displayPastRatings();
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

    public void displayPastRatings() {
        String username = CustomerFormMenu.startUserNameForm();
        ArrayList<Booking> bookings = BookingManager.getRatedBookingsByUsername(username);
        if(bookings.size() == 0) {
            System.out.println("No Past Ratings!");
            return;
        }
        System.out.println("======== PAST RATINGS =========");
        for(Booking booking: bookings) {
            System.out.println(MovieManager.getInstance().getMovieByID(booking.getMovieID()).getMovieName() + ": Rating Given - " + booking.getRating() + "/5");
        }
    }
}
