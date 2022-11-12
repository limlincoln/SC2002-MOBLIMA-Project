package managers;
import java.util.ArrayList;
import entities.Cineplex;

// TODO: Auto-generated Javadoc
/**
 * The Class CineplexManager.
 */
public class CineplexManager {
    
    /** The single instance. */
    private static CineplexManager single_instance = null;
    
    /** The cineplex. */
    private ArrayList<Cineplex> cineplex;

    /**
	 * Instantiates a new cineplex manager.
	 */
    // Initialiser
    private CineplexManager(){}

    /**
	 * Gets the single instance of CineplexManager.
	 *
	 * @return single instance of CineplexManager
	 */
    public static CineplexManager getInstance()
    {
        if (single_instance == null)
            single_instance = new CineplexManager();
        return single_instance;
    }

    /**
	 * Sets the cineplex.
	 *
	 * @param cine the new cineplex
	 */
    // Setters
    public void setCineplex(ArrayList<Cineplex> cine){
        this.cineplex = cine;
    }

    /**
	 * Gets the cineplexs.
	 *
	 * @return the cineplexs
	 */
    // Getters
    public ArrayList<Cineplex> getCineplexs(){
        return this.cineplex;
    }

    /**
	 * Gets the cineplex by ID.
	 *
	 * @param cineID the cine ID
	 * @return the cineplex by ID
	 */
    public Cineplex getCineplexByID(int cineID){
        for (int x = 0; x <cineplex.size(); x++){
            if (cineplex.get(x).getCineplexID() == cineID){
                return cineplex.get(x);
            }
        }
        return null;
    }

    /**
	 * Gets the cineplex by name.
	 *
	 * @param cineName the cine name
	 * @return the cineplex by name
	 */
    public Cineplex getCineplexByName(String cineName){
        for(int x = 0; x< cineplex.size(); x++){
            if(cineplex.get(x).getCineplexName() == cineName){
                return cineplex.get(x);
            }
        }
        return null;
    } 

    // Methods
    /**
	 * Add new cineplex.
	 *
	 * @param cine the cine
	 */
    public void addCineplex(Cineplex cine){
        for(int x = 0; x < cineplex.size(); x++){
            Cineplex current = cineplex.get(x);
            if(current.getCineplexName() == cine.getCineplexName() 
               || current.getCineplexID() == cine.getCineplexID()){
                System.out.println("Cineplex already exist!");
                return;
            }
        }
        cineplex.add(cine);
        System.out.println("Cineplex successfully added!");
    }

    /**
	 * Search Cineplex by ID and remove.
	 *
	 * @param cineID the cine ID
	 */
    public void removeCineplexByID(int cineID){
        for(int x = 0; x < cineplex.size(); x++){
            if(cineplex.get(x).getCineplexID() == cineID){
                cineplex.remove(x);
                System.out.println("Successfully removed Cineplex with ID: "+ cineID);
                return;
            }
        }
        System.out.println("Cineplex with ID: "+ cineID + " does not exist!");
    }
    
    /**
	 * Removes the cineplex by name.
	 *
	 * @param cineName the cine name
	 */
    // remove Cineplex by name
    public void removeCineplexByName(String cineName){
        for(int x = 0; x < cineplex.size(); x++){
            if(cineplex.get(x).getCineplexName() == cineName){
                cineplex.remove(x);
                System.out.println("Successfully removed: "+ cineName);
            }
        }
        System.out.println(cineName + " does not exist!");
    }

    // consolidate which cineplex have particular, take in movie ID and see which cineplex have that ID
    /**
	 * Gets the cineplex by movie.
	 *
	 * @param movieID the movie ID
	 * @return the cineplex by movie
	 */
    // search cineplexs for movieID
    public ArrayList<Cineplex> getCineplexByMovie(int movieID) {
        ArrayList<Cineplex> containsMovies = new ArrayList<Cineplex>();

        for(Cineplex cine: cineplex) {
            if(cine.containsMovie(movieID)) {
                containsMovies.add(cine);
            }
        }

        return containsMovies;
    }

    // consolidate which cinema in that cineplex have movieID
}
