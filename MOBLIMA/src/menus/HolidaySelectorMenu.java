package menus;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Holiday;
import managers.HolidayManager;

public class HolidaySelectorMenu {

    // TODO: Holiday ID
    public static HolidaySelectorMenu single_instance = null;

    private HolidaySelectorMenu(){}

    public static HolidaySelectorMenu getInstance(){
        if (single_instance == null){
            single_instance = new HolidaySelectorMenu();
        }
        return single_instance;
    }

    public Holiday startSelector(ArrayList<Holiday> Holiday, String heading){
        Scanner sc = new Scanner(System.in);
        System.out.println(	"================ " + heading + " =================");
        for (int x = 0; x < Holiday.size(); x++){
            System.out.println("("+x+1+")"+
            HolidayManager.getHolidays().get(x).getName());
        }

        int selectedInd;
        do {
            System.out.println("Choose a pricing or enter 0 to exit : ");
                
            while (!sc.hasNextInt()) {
                System.out.printf("Invalid input type.");
                sc.next(); 
            }
            selectedInd = sc.nextInt()-1;
            
            }while(selectedInd  < 0 || selectedInd >= Holiday.size());

            if(selectedInd == 0) return null;
            
            Holiday selected = Holiday.get(selectedInd);
            HolidayManager.getHolidays().get(selectedInd).getName(); 
            // MovieManager.getInstance().getMovieByID(selected.getMovieID()).showDetails();

            System.out.println("Do you want to edit? (y/n)");
            boolean want = sc.nextLine().toLowerCase().charAt(0) == 'y';

            if(want) {
                return selected;
            }  
            return null;
    }
}
