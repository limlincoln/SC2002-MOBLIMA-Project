package initializer;

import managers.CineplexManager;
import managers.MovieManager;
import managers.PricingManager;

public class MainInitializer {
    public static void startInitializers() {
        CineplexManager.getInstance().setCineplex(CineplexIntializer.readCineplexListFromFile());
        MovieManager.initialize(Movie_Initializer.GetMovieListing());
        PricingManager.setPriceMatrix(Price_Initializer.read());

        // TODO: 
        // BOOKING INITIALIZER
    }
    
}
