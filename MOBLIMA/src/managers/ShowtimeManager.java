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
    
    public void editShowTime(Cineplex cineplex, Cinema cinema, DayOfWeek day) {
    {//cineplex cinema[7 showtimes for each day], which day, showtimeslot(8),
    	
    	//ArrayList<ShowTime> showtimes = cinema.getShowtimes();
    	//cineplex.getCinemas().get(cinema.getCinemaID());
    	//cinema.getCinemaType()
    	
    	
    	int dayofweek = day.ordinal();
        // TODO: ITERATE THORUGH CINEMAS AND COMPARE
    	ShowTime target = cineplex.getCinemas().get(0).getShowtimes().get(0);
    	//ShowTime target = cinema.getShowtimes().get(dayofweek);
    	int listofshowtime[] = target.getShowTime();
    	
    	String[] timings = {"0000-0300","0300-0600","0600-0900"
    			,"0900-1200",
                "1200-1500",
                "1500-1800",
                "1800-2100",
                "2100-0000"};
    	for(int i=0; i < listofshowtime.length; i++)
    	{
    		System.out.println("TIMING : " + timings[i] + "  " + MovieManager.getInstance().getMovieByID(listofshowtime[i]));
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
        
        
        System.out.print("Replace with (Enter a new movie ID):");
        sc.next();
        while (!sc.hasNextInt()) {
        	System.out.println("Invalid input type. Please try again!");
    		sc.next(); 
        }
        int newmovieid = sc.nextInt();
        
        listofshowtime[subChoice] = newmovieid;
        // TODO: Write back
        
    }
    
    
}
}