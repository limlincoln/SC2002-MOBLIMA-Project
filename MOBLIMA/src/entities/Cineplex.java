package entities;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Cineplex.
 */
public class Cineplex {
    
    /** The ID of this Cineplex. */
    private int CineplexID;

    /** The name given to this Cineplex. */
    private String CineplexName;

    /** The list of Cinemas that are in this Cineplex. */
    private ArrayList<Cinema> cinemas;

    /**
	 * Constructor for the Cineplex Class.
	 *
	 * @param cID   The ID of this Cinplex
	 * @param cName The name given to this Cineplex
	 * @param cType The list of Cinemas that are in this Cineplex
	 */
    public Cineplex(int cID, String cName, Cinema[] cType){
        this.CineplexID = cID;
        this.CineplexName = cName;
    }

    /**
	 * Check whether this Cineplex is showing a Movie.
	 *
	 * @param movieID the ID of the Movie to check
	 * @return true if showing false otherwise
	 */
    public boolean containsMovie(int movieID) {
        boolean contains = false;

        for(Cinema cinema: cinemas) {
            contains = contains || cinema.containsMovie(movieID);
            if(contains) return true;
        }

        return false;
    }

    /**
	 * Gets the cineplex ID.
	 *
	 * @return the cineplex ID
	 */
    //get
    public int getCineplexID(){
        return this.CineplexID;
    }
    
    /**
	 * Gets the cineplex name.
	 *
	 * @return the cineplex name
	 */
    public String getCineplexName(){
        return this.CineplexName;
    }
    
    /**
	 * Gets the cinemas.
	 *
	 * @return the cinemas
	 */
    public ArrayList<Cinema> getCinemas() {
        return this.cinemas;
    }

    /**
	 * Sets the cineplex ID.
	 *
	 * @param cID the new cineplex ID
	 */
    //set
    public void setCineplexID(int cID){
        this.CineplexID = cID;
    }
    
    /**
	 * Sets the cineplex name.
	 *
	 * @param cName the new cineplex name
	 */
    public void setCineplexName(String cName){
        this.CineplexName = cName;
    }
}

