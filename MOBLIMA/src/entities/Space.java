package entities;

public class Space implements ISeat{
    /**
     * The Constructor for the Space Class
     */
    public Space(){}; 

    /**
     * get the state of this space
     * @return always a " "
     */
    @Override
    public String getState(){
        return " ";
    }
}
