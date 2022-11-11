package menu;

import java.util.Scanner;
import entities.Cinema;
import entities.Cineplex;
import entities.Movie;

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

  
    public void displayBookingMenu(Movie movie, Cineplex cineplex, Cinema cinema) { 
    
        System.out.println(	"================ BOOKING MENU =================\n" +
                " Available showtimes     					        \n" +
                " Seat Selector                              		\n" +
                " BOOKING!                                  		\n" +
                " THANK YOU                            				\n"+
			    "====================================================");
    	int choice;	
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

    }
}
