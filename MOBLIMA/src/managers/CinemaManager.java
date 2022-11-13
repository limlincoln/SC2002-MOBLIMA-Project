package managers;
import java.util.ArrayList;
import entities.Cinema;

/**
 * Manages Cinemas and contains a list of all Cinemas
 */
public class CinemaManager {

    /**
     * a single instance for this class
     */
    private static CinemaManager single_instance = null;

    /**
     * The list of cinemas existent in the datebase
     */
    private ArrayList<Cinema> cinemas;

    /**
     * Constructor for the CinemaManager Class
     */
    private CinemaManager(){}

    /**
     * Get a single instance of this manager
     * @return a CinemaManager object
     */
    public static CinemaManager getInstance()
    {
        if (single_instance == null)
            single_instance = new CinemaManager();
        return single_instance;
    }

    // Getters
    public ArrayList<Cinema> getCinemas() {
        return this.cinemas;
    }

    public Cinema getCinemaByID(int cineID){
        for(int x = 0; x < cinemas.size(); x++){
            if(cinemas.get(x).getCinemaID() == cineID){
                return cinemas.get(x);
            }
        }
        return null;
    }

    // Setters
    public void setCinema(ArrayList<Cinema> cine) {
        this.cinemas = cine;
    }
 
    /**
     * Add new cinema to existing cinema list
     * @param cine the cinema to add to the list
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
     * Search for cinema and remove from existing list of cinemas
     * @param cineID the ID of the cinema to remove
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
