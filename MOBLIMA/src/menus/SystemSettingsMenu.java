package menus;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Movie;

public class SystemSettingsMenu {
    private static SystemSettingsMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private SystemSettingsMenu(){}


    public static SystemSettingsMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new SystemSettingsMenu();
        return single_instance;
    }
    
	public void displaySystemSettingsMenu() {
		int choice;
		
		do {
            System.out.println(	"================== SYSTEM SETTINGS ==================\n" +
			                    " 1. Settings 		     					        \n" +
			                    " 2. Global Settings                               \n" +
			                    " 0. Back to MOBLIMA APP                           \n"+
							    "====================================================");
	    	
            System.out.println("Enter choice: ");
            
            while (!sc.hasNextInt()) {
            	System.out.println("Invalid input type. Please enter an integer value.");
        		sc.next(); 
            }
            
            choice = sc.nextInt();
            
            switch(choice){
                case 1:
                	// EDIT PRICES
                	// EDIT HOLIDAYS
                    break;
                case 2:
                	// WHICH TOP 5
                    break;
                case 0:
                	System.out.println("Back to MOBLIMA APP");
                	break;
                default: 
                	System.out.println("Please enter an integer value or correct value.");
                	break;
	            }
	        } while (choice != 0);
		}
}
