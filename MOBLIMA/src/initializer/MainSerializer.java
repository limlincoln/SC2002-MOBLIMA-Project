package initializer;
import consolidators.MovieConsolidator;
import managers.BookingManager;
import managers.CineplexManager;
import managers.HolidayManager;
import managers.PricingManager;
import managers.SettingsManager;

public class MainSerializer {

    /** 
	 * Responsible for saving data into their respective users are done with the program
     * 
     * Runs when MOBLIMA closes to save data to their respective text files
	 */
    public static void startSerializer() {
        try{

            CineplexIntializer.writeCineplexListToFile(CineplexManager.getInstance().getCineplexs());
            Movie_Initializer.WriteMovieListingFile(MovieConsolidator.getInstance().getAll());
            Price_Initializer.write(PricingManager.getPriceMatrix());
            Settings_Initializer.write(SettingsManager.getInstance());
            Booking_Initializer.write(BookingManager.getAllBookingHistory());
            Holiday_Initializer.NewHolidayListing(HolidayManager.getHolidays());
        }
        catch(Exception e) {
            System.out.println("Error in main serializer: "+e.getMessage());
        }
    }
    
}
