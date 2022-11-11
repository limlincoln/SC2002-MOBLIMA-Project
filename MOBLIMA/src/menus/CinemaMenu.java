package menus;
import java.time.format.DateTimeFormatter; 
import java.util.Scanner;

import consolidators.MovieConsolidator;

import java.util.ArrayList;
import java.util.List;
import entities.Movie;
import entities.Cinema;
import entities.Cineplex;
import entities.ShowTime;

public class CinemaMenu {
    private static CinemaMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private CinemaMenu(){}


    public static CinemaMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new CinemaMenu();
        return single_instance;
    }


	public void displayCinemaMenu(Movie movie, Cineplex cineplex) { 
		// CALL CINEMA MENU(CINEPLEX, CINEMA);
			
		System.out.println(	"================ SELECT A CINEMA =================");
	
		// Check which cinema has that movie,cineplex and display.
		
		int choice;
		Cineplex test = new Cineplex(0, null, null);
		ArrayList<ShowTime> showtimes = new ArrayList<ShowTime>();
            
        do {
        	
		    System.out.println("Enter Cinema: ");
                
            while (!sc.hasNextInt()) {
        		System.out.printf("Invalid input type.");
        		sc.next(); 
        	}
            choice = sc.nextInt();
            
            }while(choice  < 0 || choice >= 3);


        	
        	System.out.println("Selected Cineplex : " + choice);
        	Cinema cinema = new Cinema(1,choice,showtimes);
			

			// TODO: Go to SHOWTIME

			BookingMenu.getInstance().displayBookingMenu(movie,cineplex,cinema); // (CINEPLEX, CINEMA, MOVIE)

		}
	public void movielisting() {
		//edit cinema
		int choice;
		do {
	        System.out.println(	"======= MOBLIMA STAFF EDIT MOVIE LISTING ==========\n" +
	                " 1. Edit Showtime                                    \n" +
	                " 2. Edit Cineplex                                    \n" + // REMOVE (EXTRA FEATURES)
	                " 3. Edit Cinema                                     \n" +  // REMOVE (EXTRA FEATURES)
	                " 0. Back to MOBLIMA APP                              \n"+
				    "====================================================");
    		System.out.println("Enter choice: ");
            
            while (!sc.hasNextInt()) {
            	System.out.println("Please enter an integer value or correct value.");
        		sc.next(); 
            }
            
            choice = sc.nextInt();
            
            switch(choice){
                case 1:
                	// edit showtime
					// SHOWTIME EDITOR MENU
						// CINEPLEX -> CINEMA -> MOVIE
							// CALL SHOWTIME MANAGER TO:
								// ADD
								// REMOVE
                    break;
                case 2:
                	
                    break;
                case 3:
                	
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
