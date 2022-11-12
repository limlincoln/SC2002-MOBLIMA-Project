package managers;
import java.util.ArrayList;
import entities.Cinema;

// TODO: Auto-generated Javadoc
/**
 * The Class CinemaManager.
 */
public class CinemaManager {
    
    /** The single instance. */
    private static CinemaManager single_instance = null;
    
    /** The ArrayList of cinemas. */
    private ArrayList<Cinema> cinemas;
    // 1 week worth of showtimes
    // array list of showimes

    /**
	 * Instantiates a new cinema manager.
	 */
    // Initialisers
    private CinemaManager(){}
    
    /**
	 * Gets the single instance of CinemaManager.
	 *
	 * @return single instance of CinemaManager
	 */
    public static CinemaManager getInstance()
    {
        if (single_instance == null)
            single_instance = new CinemaManager();
        return single_instance;
    }

    /**
	 * Gets the cinemas.
	 *
	 * @return the cinemas
	 */
    // Getters
    public ArrayList<Cinema> getCinemas() {
        return this.cinemas;
    }

    /**
	 * Gets the cinema by cinemaID.
	 *
	 * @param cineID - the ID of cinema
	 * @return the cinema if found
	 * else return null
	 */
    public Cinema getCinemaByID(int cineID){
        for(int x = 0; x < cinemas.size(); x++){
            if(cinemas.get(x).getCinemaID() == cineID){
                return cinemas.get(x);
            }
        }
        return null;
    }

    /**
	 * Sets the cinema.
	 *
	 * @param cine the new cinema
	 */
    // Setters
    public void setCinema(ArrayList<Cinema> cine) {
        this.cinemas = cine;
    }

    // Methods 
    /**
	 * Add new cinema to existing cinema.
	 *
	 * @param cine the cine
	 */
    public void addCinema(Cinema cine){
        for(int x = 0; x < cinemas.size(); x++){
            Cinema current = cinemas.get(x);
            if(current.getCinemaID() == cine.getCinemaID()){
                System.out.println("Cinema already exist!");
                return;
            }
        }
        cinemas.add(cine);
        System.out.println("Cinema successfully added!");
    }

    /**
	 * Search for cinema and remove from existing.
	 *
	 * @param cineID the cine ID
	 */
    public void removeCinemaByID(int cineID){
        for(int x = 0; x < cinemas.size(); x++){
            if(cinemas.get(x).getCinemaID() == cineID){
                cinemas.remove(x);
                System.out.println("Successfully removed movie with ID: "+ cineID);
                return;
            }
        }
        System.out.println("Movie with ID: "+ cineID + " does not exist!");
    } 
}
