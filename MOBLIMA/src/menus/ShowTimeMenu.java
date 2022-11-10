package menu;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Cinema;
import entities.Cineplex;
import entities.Movie;
import entities.ShowTime;

public class ShowTimeMenu {
	
    private static ShowTimeMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private ShowTimeMenu(){}


    public static ShowTimeMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new ShowTimeMenu();
        return single_instance;
    }


	public void ShowTimeMenu(Movie movie, Cineplex cineplex,Cinema cinema) { 
			
		System.out.println(	"================ SELECT A ShowTime =================");

		//DISPLAY showtime and select -> bookingmenu??????????????
			


			//BookingMenu.getInstance().displayBookingMenu(movie,cineplex,cinema); 

		}
	public void editShowTime() {
    	// edit showtime
		// SHOWTIME EDITOR MENU
			// CINEPLEX -> CINEMA -> MOVIE
				// CALL SHOWTIME MANAGER TO:
					// ADD
					// REMOVE

        		
		}
}
