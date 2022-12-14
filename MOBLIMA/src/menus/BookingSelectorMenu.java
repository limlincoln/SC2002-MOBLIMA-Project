package menus;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Booking;
import managers.MovieManager;
/**
 * Menu to display Booking selector
 */
public class BookingSelectorMenu implements ISelectorMenu<Booking> {
    /** 
     * Single instance of BookingSelectorMenu 
     */
    public static BookingSelectorMenu single_instance = null;

    private BookingSelectorMenu() {}
    /**
     * Get or creates the single instance of BookingSelectorMenu class
     * @return BookingSelectorMenu Class
     */
    public static BookingSelectorMenu getInstance() {
        if(single_instance == null) {
            single_instance = new BookingSelectorMenu();
        }
        return single_instance;
    }

    /**
     * Select Booking to rate
     *  @param bookings
     *   @param heading
     *   @return Selected booking
     */
    public Booking startSelector(ArrayList<Booking> bookings, String heading) {
        if(bookings.size() ==0){
            System.out.println("NO "+heading);
            return null;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println(	"================ " +heading+ " =================");
        for(int i = 0;  i < bookings.size(); i++) {
            System.out.println("("+(i+1)+")"+
            MovieManager.getInstance().getMovieByID(bookings.get(i).getMovieID()).getMovieName()
            );
        }

        int selectedInd;
        do {
            System.out.println("Choose a booking or enter 0 to exit : ");
                
            while (!sc.hasNextInt()) {
                System.out.printf("Invalid input type.");
                sc.next(); 
            }
            selectedInd = sc.nextInt()-1;
            
            }while(selectedInd  < -1 || selectedInd >= bookings.size());

            if(selectedInd == -1) return null;
            
            Booking selected = bookings.get(selectedInd); 
            MovieManager.getInstance().getMovieByID(selected.getMovieID()).showDetails();

            System.out.println("Do you want to rate? (y/n)");
            sc.nextLine();
            boolean want = sc.nextLine().toLowerCase().charAt(0) == 'y';
        
            if(want) {
                return selected;
            }  
            return null;
    } 
}
