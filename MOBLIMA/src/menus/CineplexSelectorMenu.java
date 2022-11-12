package menus;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Cineplex;

public class CineplexSelectorMenu implements ISelectorMenu<Cineplex> {

    public static CineplexSelectorMenu single_instance = null;

    private CineplexSelectorMenu() {}

    public static CineplexSelectorMenu getInstance() {
        if(single_instance == null) {
            single_instance = new CineplexSelectorMenu();
        }
        return single_instance;
    }

    /**
     * Select cineplex
     */
    public Cineplex startSelector(ArrayList<Cineplex> cineplex, String heading) {
        if(cineplex.size() == 0){
            System.out.println("NO CINEPLEX");
            System.out.println("");
            return null;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println(	"================ " +heading+ " =================");
                    for(int i = 0;  i < cineplex.size(); i++) {
                        System.out.println("("+(i+1)+")"+cineplex.get(i).getCineplexName());
        }
        int selectedInd;
        do {
            System.out.println("Choose a cineplex or enter 0 to exit : ");
                
            while (!sc.hasNextInt()) {
                System.out.printf("Invalid input type.");
                sc.next(); 
            }
            selectedInd = sc.nextInt()-1;
            
            }while(selectedInd  < -1 || selectedInd >= cineplex.size());

            if(selectedInd == -1) return null;
            
            Cineplex selected = cineplex.get(selectedInd); 

            return selected;
    } 
    
    
}
