package initializer;
import managers.BookingManager;
import managers.CineplexManager;
import managers.PricingManager;
import managers.SettingsManager;

public class MainSerializer {

    public static void startSerializer() {
        try{

            CineplexIntializer.writeCineplexListToFile(CineplexManager.getInstance().getCineplexs());
            Price_Initializer.write(PricingManager.getPriceMatrix());
            Settings_Initializer.write(SettingsManager.getInstance());
            Booking_Initializer.write(BookingManager.getAllBookingHistory());
        }
        catch(Exception e) {

        }
    }
    
}
