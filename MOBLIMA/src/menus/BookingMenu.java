package menus;

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
                // " Available showtimes     					        \n" +
                " Seat Selector                              		\n" +
                " BOOKING!                                  		\n" +
                " THANK YOU                            				\n"+
			    "====================================================");
    	int choice;
        
        // CALL SEAT SELECTOR (MIGHT RETURN NULL)

        // SEATSELECTOR.STARTINSTANCE(SEATS): ARRAY OF SELECTED SEAT INFO
        // CALL TICKETMANAGER: ARRAY OF TICKETS + LOCALDATETIME
        // CREATE AN ARRAYLIST OF IPRICE INCLUDING TICKETS + CINEMA 
        // CALL PRICE.GETTOTALPRICE(): ARRALIST<IPRICE>, TICKETSARRAY.SIZE()
        // ASK CUSTOMER DETAILS (username, phone, email)
        // CREATE CUSTOMER CLASS
        // CALL BOOKING MANAGER: 
        // CREATEBOOKING: cinemaID, movieID, CUSTOMER CLASS, TICKETS ARRAYLIST, TOTALCOST

        // THANK YOU :)
    }
}
