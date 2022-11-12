package menus;

import java.util.Scanner;

import initializer.MainInitializer;
import initializer.MainSerializer;


/**
 * Main app to run to choose Customer or Staff app
 */
public class MOBLIMA_APP {
	public static void main(String[] args) {
		MainInitializer.startInitializers();
		int choice;
		Scanner sc = new Scanner(System.in); 
		
		do {
	        System.out.println("======================= MOBLIMA APP =======================\n"+
	                " 1. Customer App                                          \n"+
	                " 2. Staff App                                             \n"+
	                " 0. Quit App                                              \n"+
							   "===========================================================");
		
	        System.out.println("Enter choice: ");
	        
	        while (!sc.hasNextInt()) {
            	System.out.println("Invalid input type. Please enter an integer value.");
        		sc.next(); 
            }
	        
	        choice = sc.nextInt();
	        
	        switch (choice) {
		        case 1:
		        	 CustomerApp.getInstance().displayCustomerMenu();
		        	break;
		        case 2:
		        	LoginMenu.getInstance().displayLoginMenu();
		        	break;
		        case 0:
		        	System.out.println("Thank you for using our MOBLIMA APP");
		        	break;
	        	default:
	        		System.out.println("Please enter an option between 0-2");
	        		break;
	        }
		} while (choice != 0);
		
		MainSerializer.startSerializer();
		sc.close();
	}
}
