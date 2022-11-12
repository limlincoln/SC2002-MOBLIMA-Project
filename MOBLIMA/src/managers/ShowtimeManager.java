package managers;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import entities.Cinema;
import entities.Cineplex;
import entities.Movie;
import entities.Seats;
//import entities.Movie;
//import managers.MovieManager;
import entities.ShowTime;
import enums.DayOfWeek;
import menus.CustomerApp;
import menus.LoginMenu;
import menus.StaffApp;

//need to filter by movie or cinplex??


public class ShowTimeManager {
    private static ShowTimeManager single_instance = null;

    private Scanner sc = new Scanner(System.in);
    // FUNCTIONALITY
    // SHOW ShowTime FOR A PARTICULAR MOVIE & DAY & CINEPLEX & CINEMA
    // RETURN ARRAY OF ShowTime

    // FINDSEATS:
    // FIND THE SEATS FROM CINEMA CLASS USING ShowTime SLOT INDEX

    // Initialisers
    private ShowTimeManager(){}
    public static ShowTimeManager getInstance()
    {
        if (single_instance == null)
            single_instance = new ShowTimeManager();
        return single_instance;
    }

    /**
     * Get all date and time where a particular movie in a cinema is showing
     * @param cinema
     * @param movie
     * @return An arraylist of localdate time where the movie is showing
     */

    public ArrayList<LocalDateTime> getShowTimeByMovie(Cinema cinema, Movie movie){
        ArrayList<LocalDateTime> showDateTimes = new ArrayList<LocalDateTime>();
        int movieID = movie.getMovieID();
        ArrayList<ShowTime> showtimes = cinema.getShowtimes();
        int numOfTimeSlots = showtimes.get(0).getShowTime().length;

        for(int i=0; i<showtimes.size(); i++){
            int[] curShowTimeSlots = showtimes.get(i).getShowTime();
            for(int j=0; j<numOfTimeSlots; j++){
                if(curShowTimeSlots[j] == movieID){
                    showDateTimes.add(DateManager.getInstance().getExactShowTime(DayOfWeek.values()[i],j));
                }
            }
        }
        return showDateTimes;
    }
    
    /**
     * Get the seats based on the selected date and time
     * @param cinema
     * @param localDateTime
     * @return
     */
    public Seats getSeatsByLocalDateTime(Cinema cinema, LocalDateTime localDateTime){
        int dayOfWeekInInt = localDateTime.getDayOfWeek().getValue();
        int selectedTimeSlot = DateManager.getInstance().getTimeSlotIndex(localDateTime.toLocalTime().of(23, 0));
        return cinema.getShowtimes().get(dayOfWeekInInt).getSeats()[selectedTimeSlot];

    }
    
    public void editShowTime(Cineplex cineplex, Cinema cinema, DayOfWeek day) 
    {
    	
    	
    	int dayofweek = day.ordinal();
    	
        // TODO: ITERATE THORUGH CINEMAS AND COMPARE
    	
    	boolean check=false;
		for(Cinema cine: cineplex.getCinemas()) {
    		if(cine == cinema) {
    			check = true;
    		}
    	}
		
		if(check)
		{
			String[] timings = {"0000-0300","0300-0600","0600-0900","0900-1200","1200-1500","1500-1800","1800-2100","2100-0000"};
			int[] listofshowtime  = cinema.getShowtimes().get(dayofweek).getShowTime();
	    	for(int i=0; i < listofshowtime.length; i++)
	    	{
	    		System.out.println(i+1+".TIMING: " + timings[i] + "  " + MovieManager.getInstance().getMovieByID(listofshowtime[i]));
	    	}
	    	int choice; 
			do {
		        System.out.println("Enter the index to change or zero to exit: ");
		    	for(int i=0; i < listofshowtime.length; i++)
		    	{
		    		System.out.println(i+1+".TIMING: " + timings[i] + "  " + MovieManager.getInstance().getMovieByID(listofshowtime[i]));
		    	}
		    	
	      
		        while (!sc.hasNextInt()) {
	            	System.out.println("Invalid input type. Please enter an integer value.");
	        		sc.next(); 
	            }

				choice = sc.nextInt()-1;
		        sc.nextLine();
				
			} while (choice  < -1 || choice >= listofshowtime.length);
			
			System.out.println("Is this the one you want to change? (Y to confirm):" +timings[choice] + "  " + MovieManager.getInstance().getMovieByID(listofshowtime[choice]));
			String confirmation = sc.nextLine();
			
			if(confirmation.equals("Y"))
			{
				cinema.getShowtimes().get(dayofweek).setShowTime(listofshowtime);
				System.out.println("SUCCESSFULLY CHANGED");
			}
			else
			{
				System.out.println("UNSUCCESSFULLY CHANGED");
			}
		}
		else
		{
			System.out.print("Cineplex does not have selected cinema!!!!");
		}
		

        // TODO: Write back
    
    }
    
    
}