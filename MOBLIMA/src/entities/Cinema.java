package entities;

import java.util.ArrayList;

public class Cinema{
    private String CinemaName;
    private int CinemaID;
    private int CinemaType;
    private int[] showTime;
    //arraylist of showtimes
    
    public Cinema(int cID, int cType, int[] sTime){
        this.CinemaID = cID;
        this.CinemaType = cType;
        this.showTime = sTime;
    }

    // TODO: IMPLEMENT
    public ArrayList<Movie> getMovies(){
        return new ArrayList<Movie>();
    }

    //get methods
    public String getCinemaName(){
        return this.CinemaName;
    }
    public int getCinemaType(){
        return this.CinemaType;
    }
    public int getCinemaID(){
        return this.CinemaID;
    }
    public int[] getShowTime(){
        return this.showTime;
    }
    
    //set methods
    public void setCinemaName(String cName){
        this.CinemaName = cName;
    }
    public void setCinemaType(int cType){
        this.CinemaType = cType;
    }
    public void setCinemaID(int cID){
        this.CinemaID = cID;
    }
    public void setShowTime(int[] sTime){
        this.showTime = sTime;
    }
}