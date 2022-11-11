package menus;
import java.util.ArrayList;
import java.util.Scanner;

import entities.IPrice;
import managers.PricingManager;

public class PriceSelectorMenu implements ISelectorMenu<IPrice>{
    public static PriceSelectorMenu single_instance = null;

    private PriceSelectorMenu(){}

    public static PriceSelectorMenu getInstance(){
        if (single_instance == null){
            single_instance = new PriceSelectorMenu();
        }
        return single_instance;
    }

    public IPrice startSelector(ArrayList<IPrice> price, String heading){
        Scanner sc = new Scanner(System.in);
        System.out.println(	"================ " + heading + " =================");
        for (int x = 0; x < price.size(); x++){
            // System.out.println("("+x+1+")"+
            // PricingManager.

        }

        int selectedInd;
        do {
            System.out.println("Choose a pricing or enter 0 to exit : ");
                
            while (!sc.hasNextInt()) {
                System.out.printf("Invalid input type.");
                sc.next(); 
            }
            selectedInd = sc.nextInt()-1;
            
            }while(selectedInd  < 0 || selectedInd >= price.size());

            if(selectedInd == 0) return null;
            
            IPrice selected = price.get(selectedInd); 
            // MovieManager.getInstance().getMovieByID(selected.getMovieID()).showDetails();

            System.out.println("Do you want to edit? (y/n)");
            boolean want = sc.nextLine().toLowerCase().charAt(0) == 'y';

            if(want) {
                return selected;
            }  
            return null;
    }
    
}
