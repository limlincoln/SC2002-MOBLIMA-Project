public class Cinema{
    private int CinemaID;
    private int CinemaType;
    private int[] showTime;
    
    public Cinema(int cID, int cType, int[] sTime){
        this.CinemaID = cID;
        this.CinemaType = cType;
        this.showTime = sTime;
    }

    //get methods
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