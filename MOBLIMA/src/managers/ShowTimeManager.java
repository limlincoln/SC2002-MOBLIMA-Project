package managers;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Cinema;
import entities.Movie;
import entities.Seats;
import entities.ShowTime;
import enums.DayOfWeek;

/**
 * A class that helps manage showtimes
 */
public class ShowTimeManager {
    /**
     * a single instance of this class
     */
    private static ShowTimeManager single_instance = null;

    /**
     * scanner
     */
    private Scanner sc = new Scanner(System.in);

    /**
     * The Constructor for this class
     */
    private ShowTimeManager(){}

    /**
     * get a single instance for this class
     * @return a ShowTimeManager object
     */
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
     * @return the seats
     */
    public Seats getSeatsByLocalDateTime(Cinema cinema, LocalDateTime localDateTime){
        int dayOfWeekInInt = localDateTime.getDayOfWeek().getValue();
        int selectedTimeSlot = DateManager.getInstance().getTimeSlotIndex(localDateTime.toLocalTime());
        return cinema.getShowtimes().get(dayOfWeekInInt).getSeats()[selectedTimeSlot];

    }
}
