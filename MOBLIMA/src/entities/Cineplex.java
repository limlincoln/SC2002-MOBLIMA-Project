package entities;
import java.util.ArrayList;

public class Cineplex {
    /**
     * The ID of this Cineplex
     */
    private int CineplexID;

    /**
     * The name given to this Cineplex
     */
    private String CineplexName;

    /**
     * The list of Cinemas that are in this Cineplex
     */
    private ArrayList<Cinema> cinemas;

    /**
     * Constructor for the Cineplex Class
     * @param cID The ID of this Cinplex
     * @param cName The name given to this Cineplex
     * @param cType The list of Cinemas that are in this Cineplex
     */
    public Cineplex(int cID, String cName, Cinema[] cType){
        this.CineplexID = cID;
        this.CineplexName = cName;
    }

    /**
     * Check whether this Cineplex is showing a Movie
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

    //get
    public int getCineplexID(){
        return this.CineplexID;
    }
    public String getCineplexName(){
        return this.CineplexName;
    }
    public ArrayList<Cinema> getCinemas() {
        return this.cinemas;
    }

    //set
    public void setCineplexID(int cID){
        this.CineplexID = cID;
    }
    public void setCineplexName(String cName){
        this.CineplexName = cName;
    }
}

