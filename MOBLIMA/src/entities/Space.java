package entities;

/**
 * Class that contains information about a Space
 */
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

    /**
     * get the state of this space
     * @return always a 2
     */
    public int getStateInt() {
        return 2;
    }
}
