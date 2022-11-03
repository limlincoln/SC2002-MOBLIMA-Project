package menus;

import FileManager.LoginAuthenticator;
import java.util.Scanner;

/**
 * StaffApp for Staff
 */
public class StaffApp {


    private static StaffApp single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private StaffApp(){}


    public static StaffApp getInstance()
    {
        if (single_instance == null)
            single_instance = new StaffApp();
        return single_instance;
    }

    
    // Public exposed methods to app


    public void displayLoginMenu() {
    	boolean loggedIn = false;
    	boolean quit = false;
		int choice;
		
		do {
	        System.out.println(	"==================== MOBLIMA STAFF APP ====================\n"+
				                " 1. Login                                                \n"+
				                " 0. Back to MOBLIMA APP                                  \n"+
				                "===========================================================");
	        System.out.println("Enter choice: ");
      
	        while (!sc.hasNextInt()) {
            	System.out.println("Invalid input type. Please enter an integer value.");
        		sc.next(); // Remove newline character
            }

			choice = sc.nextInt();
	        sc.nextLine();
			
			switch (choice) {
			case 1: 
                System.out.println("Username: ");
                while (!sc.hasNext()) {
                	System.out.println("Invalid input type. Please try again!");
            		sc.next(); // Remove newline character
                }
                String username = sc.nextLine();
                System.out.println("Password: ");
                while (!sc.hasNext()) {
                	System.out.println("Invalid input type. Please try again!");
            		sc.next(); // Remove newline character
                }
                String password = sc.nextLine();
                
                boolean authenticate = LoginAuthenticator.getInstance().login(username, password);
                
                
                if (authenticate) {
                	loggedIn = true;
                	this.displayLoggedInMenu();
                	quit = true;
                } else {
                	System.out.println("Invalid Username or Password, please try again.");
                }
				break;
			case 0:
				System.out.println("Back to MOBLIMA APP......");
				quit = true;
				break;
			}
		} while (loggedIn == false && quit == false);
    }
    
    
    // Private methods


    private void displayLoggedInMenu() {
		int choice;
		
		do {
            System.out.println(	"==================== MOBLIMA STAFF APP ====================\n" +
			                    " 1. View Top 5 Movies                                     \n" +
			                    " 2. Configure System Settings                             \n" +
			                    " 3. Movie Database                                        \n" +
			                    " 0. Logout from StaffApp                                  \n"+
								"===========================================================");
            System.out.println("Enter choice: ");

            while (!sc.hasNextInt()) {
            	System.out.println("Invalid input type. Please enter an integer value.");
        		sc.next(); // Remove newline character
            }

			choice = sc.nextInt();
			
			switch (choice) {
			case 1: 
                //MovieManager.getInstance().viewTop5("Staff");
				break;
			case 2:
				//SystemSettingsManager.getInstance().displayMenu();
				break;
			case 3:
				//MovieManager.getInstance().movieMenuStaff();
				break;
			case 0:
				System.out.println("Logging out from StaffApp......");
				break;
			default:
				System.out.println("Invalid choice. Please choose between 0-3.");
				break;
			}
		} while (choice != 0);
    }
}