package managers;
import java.util.ArrayList;
import entities.Cineplex;

/**
 * Class that manages all Cineplex related things and contains a list of Cinplexes in the Database
 */
public class CineplexManager {
    /**
     * a single instance for this class
     */
    private static CineplexManager single_instance = null;

    /**
     * a list of cineplexes that are existent in the Database
     */
    private ArrayList<Cineplex> cineplex;

    /**
     * Constructor for the CineplexManager Class
     */
    private CineplexManager(){}

    /**
     * get a single instance of this class
     * @return a CinplexManager object
     */
    public static CineplexManager getInstance()
    {
        if (single_instance == null)
            single_instance = new CineplexManager();
        return single_instance;
    }

    // Setters
    public void setCineplex(ArrayList<Cineplex> cine){
        this.cineplex = cine;
    }

    // Getters
    public ArrayList<Cineplex> getCineplexs(){
        return this.cineplex;
    }

    public Cineplex getCineplexByID(int cineID){
        for (int x = 0; x <cineplex.size(); x++){
            if (cineplex.get(x).getCineplexID() == cineID){
                return cineplex.get(x);
            }
        }
        return null;
    }

    public Cineplex getCineplexByName(String cineName){
        for(int x = 0; x< cineplex.size(); x++){
            if(cineplex.get(x).getCineplexName() == cineName){
                return cineplex.get(x);
            }
        }
        return null;
    } 

    /**
     * Add new cineplex
     * @param cine the cineplex to add
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
     * Search Cineplex by ID and remove
     * @param cineID the ID of the cineplex to remove
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
     * Search Cineplex by name and remove
     * @param cineName the name of the cineplex to remove
     */
    public void removeCineplexByName(String cineName){
        for(int x = 0; x < cineplex.size(); x++){
            if(cineplex.get(x).getCineplexName() == cineName){
                cineplex.remove(x);
                System.out.println("Successfully removed: "+ cineName);
            }
        }
        System.out.println(cineName + " does not exist!");
    }

    /**
     * get a list of cinplexes where a movie is listed
     * @param movieID the ID of the movie 
     * @return a list of cinplexes where this movie is showing
     */
    public ArrayList<Cineplex> getCineplexByMovie(int movieID) {
        ArrayList<Cineplex> containsMovies = new ArrayList<Cineplex>();

        for(Cineplex cine: cineplex) {
            if(cine.containsMovie(movieID)) {
                containsMovies.add(cine);
            }
        }

        return containsMovies;
    }
}
