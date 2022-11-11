package entities;
import java.util.ArrayList;

public class Cineplex {
    private int CineplexID;
    private String CineplexName;
    private ArrayList<Cinema> cinemas;

    public Cineplex(int cID, String cName, Cinema[] cType){
        this.CineplexID = cID;
        this.CineplexName = cName;
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

