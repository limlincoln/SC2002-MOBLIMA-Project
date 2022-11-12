package initializer;
import consolidators.MovieConsolidator;
import managers.BookingManager;
import managers.CineplexManager;
import managers.HolidayManager;
import managers.PricingManager;
import managers.SettingsManager;

public class MainSerializer {

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

        }
    }
    
}
