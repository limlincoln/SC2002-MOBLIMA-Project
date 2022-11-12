package initializer;

import managers.BookingManager;
import managers.CineplexManager;
import managers.HolidayManager;
import managers.MovieManager;
import managers.PricingManager;

public class MainInitializer {
    public static void startInitializers() {
        CineplexManager.getInstance().setCineplex(CineplexIntializer.readCineplexListFromFile());
        MovieManager.initialize(Movie_Initializer.GetMovieListing());
        PricingManager.setPriceMatrix(Price_Initializer.read());
        Settings_Initializer.read();
        BookingManager.initialize(Booking_Initializer.read());
        HolidayManager.setHolidays(Holiday_Initializer.GetHolidayListing());
    }
    
}
