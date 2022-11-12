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

// TODO: Auto-generated Javadoc
//need to filter by movie or cinplex??


/**
 * The Class ShowTimeManager.
 */
public class ShowTimeManager{
    
    /** The single instance. */
    private static ShowTimeManager single_instance = null;

    /** The scanner - for user input. */
    private Scanner sc = new Scanner(System.in);
    // FUNCTIONALITY
    // SHOW ShowTime FOR A PARTICULAR MOVIE & DAY & CINEPLEX & CINEMA
    // RETURN ARRAY OF ShowTime

    // FINDSEATS:
    // FIND THE SEATS FROM CINEMA CLASS USING ShowTime SLOT INDEX

    /**
	 * Instantiates a new show time manager.
	 */
    // Initialisers
    private ShowTimeManager(){}
    
    /**
	 * Gets the single instance of ShowTimeManager.
	 *
	 * @return single instance of ShowTimeManager
	 */
    public static ShowTimeManager getInstance()
    {
        if (single_instance == null)
            single_instance = new ShowTimeManager();
        return single_instance;
    }

    /**
	 * Get all date and time where a particular movie in a cinema is showing.
	 *
	 * @param cinema the cinema
	 * @param movie  the movie
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
	 * Get the seats based on the selected date and time.
	 *
	 * @param cinema        the cinema
	 * @param localDateTime the local date time
	 * @return the seats by local date time
	 */
    public Seats getSeatsByLocalDateTime(Cinema cinema, LocalDateTime localDateTime){
        int dayOfWeekInInt = localDateTime.getDayOfWeek().getValue();
        int selectedTimeSlot = DateManager.getInstance().getTimeSlotIndex(localDateTime.toLocalTime().of(23, 0));
        return cinema.getShowtimes().get(dayOfWeekInInt).getSeats()[selectedTimeSlot];

    }
    
    /**
	 * Edits the show time.
	 *
	 * @param cineplex the cineplex
	 * @param cinema   the cinema
	 * @param day      the day
	 */
    public void editShowTime(Cineplex cineplex, Cinema cinema,DayOfWeek day)
    {//cineplex cinema[7 showtimes for each day], which day, showtimeslot(8),
    	
    	//ArrayList<ShowTime> showtimes = cinema.getShowtimes();
    	//cineplex.getCinemas().get(cinema.getCinemaID());
    	//cinema.getCinemaType()
    	
    	
    	int dayofweek = day.ordinal();
    	ShowTime target = cineplex.getCinemas().get(cinema.getCinemaID()).getShowtimes().get(dayofweek);
    	//ShowTime target = cinema.getShowtimes().get(dayofweek);
    	int listofshowtime[] = target.getShowtime();
    	
    	String[] timings = {"0000-0300","0300-0600","0600-0900"
    			,"0900-1200",
                "1200-1500",
                "1500-1800",
                "1800-2100",
                "2100-0000"};
    	for(int i=0; i <= listofshowtime.length; i++)
    	{
    		System.out.println("TIMING : " + timings[i]);
    		MovieManager.getInstance().getMovieByID(listofshowtime[i]);
    	}
//        System.out.println("=================== Choose what showtime to edit ==================\n" +
//                " 1. 0000-0300      	                                \n" +
//                " 2. 0300-0600                      	        	\n" +
//                " 3. 0600-0900	                                    \n" +
//                " 4. 0900-1200                                        \n" +
//                " 5. 1200-1500                                     \n" +
//                " 6. 1500-1800                                     \n" +
//                " 7. 1800-2100                               \n"+
//                " 8. 2100-0000                                \n"+
//                "=========================================================");
    	int subChoice;
        do {
        	
        	System.out.println("Choose a movie at the allocated timing or enter 0 to exit : ");
                
            while (!sc.hasNextInt()) {
        		System.out.printf("Invalid input type.");
        		sc.next(); 
        	}
            subChoice = sc.nextInt()-1;
            
            }while(subChoice  < 0 || subChoice >= listofshowtime.length);
        
        
        sc.next();
        System.out.print("Replace with (Enter a new movie ID):");
        while (!sc.hasNextInt()) {
        	System.out.println("Invalid input type. Please try again!");
    		sc.next(); 
        }
        int newmovieid = sc.nextInt();
        
        listofshowtime[subChoice] = newmovieid;
    }
    
    
}