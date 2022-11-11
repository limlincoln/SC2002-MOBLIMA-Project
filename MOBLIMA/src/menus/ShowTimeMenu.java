package menus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Cinema;
import entities.Cineplex;
import entities.Movie;
import entities.Seats;
import entities.ShowTime;
import managers.ShowTimeManager;

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
		// CALL DATEMANAGER TO GET MEXT 7 DATES STARTING TODAY
		// CALL DATEMANAGER TO GET TIMES OF THE TIMESLOTS
		// PRINT SHOWTIMES 
		// USER FIRST SEELCTS DAY (STORE INDEX GIVEN by CINEMA CLASS)
		// USER SELECTS SPECIFIC SHOWTIME (STORE INDEX GIVEN BY SHOWTIME CLASS)
		// CALL DATEMANAGER with 2 INDEX to get EXACTDATTIME (LOCALDATETIME)
		// GET SEATS FROM SHOWTIME MANAGER
		// PASS LOCALDATETIME + SEATS to BOOKING MENU
		System.out.println("MOVIE: "+movie.getMovieName());
		System.out.println(	"================ SELECT A ShowTime =================");
		ArrayList<LocalDateTime> showtimes = ShowTimeManager.getInstance().getShowTimeByMovie(cinema, movie);

		for(int i = 0; i < showtimes.size(); i++) {
			LocalDateTime currentShowTime = showtimes.get(i);
			System.out.println(
				"("+(i+1)+")"+
				currentShowTime.getDayOfWeek()+"\n"+
				currentShowTime.getDayOfMonth()+", "+
				currentShowTime.getMonth()+"\n"+
				currentShowTime.getHour()+":"+currentShowTime.getMinute()
			);
			System.out.println("----------------------------------");
		}

		int selectedShowTime;
		do {	
			selectedShowTime = sc.nextInt();
		} while(selectedShowTime < 1 || selectedShowTime > showtimes.size());

		Seats selectedSeats = ShowTimeManager.getInstance().getSeatsByLocalDateTime(cinema, showtimes.get(selectedShowTime));

		BookingMenu.getInstance().displayBookingMenu(movie, cinema, selectedSeats, showtimes.get(selectedShowTime));

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
