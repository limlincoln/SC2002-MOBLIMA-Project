package menus;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Cinema;
/**
 * Menu to display cinema selector
 */
public class CinemaSelectorMenu implements ISelectorMenu<Cinema> {
    /** 
     * Single instance of CinemaSelectorMenu 
     */
    public static CinemaSelectorMenu single_instance = null;

    private CinemaSelectorMenu() {}
    /**
     * Get or creates the single instance of CinemaSelectorMenu class
     * @return CinemaSelectorMenu Class
     */
    public static CinemaSelectorMenu getInstance() {
        if(single_instance == null) {
            single_instance = new CinemaSelectorMenu();
        }
        return single_instance;
    }

    /**
     * Select cinema
     *  @param cinema
     *   @param heading 
     *   @return selected cinema
     */
    public Cinema startSelector(ArrayList<Cinema> cinema, String heading) {
        if(cinema.size() == 0){
            System.out.println("NO CINEPLEX");
            System.out.println("");
            return null;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println(	"================ " +heading+ " =================");
                    for(int i = 0;  i < cinema.size(); i++) {
                        System.out.println("("+(i+1)+")"+cinema.get(i).getCinemaType() + "|" + cinema.get(i).getCinemaClass());
        }

        int selectedInd;
        do {
            System.out.println("Choose a cinema or enter 0 to exit : ");
                
            while (!sc.hasNextInt()) {
                System.out.printf("Invalid input type.");
                sc.next(); 
            }
            selectedInd = sc.nextInt()-1;
            
            }while(selectedInd  < -1 || selectedInd >= cinema.size());

            if(selectedInd == -1) return null;
            
            Cinema selected = cinema.get(selectedInd); 

            return selected;
    } 
    
    
}

