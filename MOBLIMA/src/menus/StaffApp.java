package menus;

import java.util.Scanner;
import managers.LoginAuthenticator;


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

//    public void displayLoginMenu() {
//    	boolean loggedIn = false;
//    	boolean quit = false;
//		int choice;
//		
//		do {
//	        System.out.println(	"==================== MOBLIMA STAFF APP ====================\n"+
//				                " 1. Login                                                \n"+
//				                " 0. Back to MOBLIMA APP                                  \n"+
//				                "===========================================================");
//	        System.out.println("Enter choice: ");
//      
//	        while (!sc.hasNextInt()) {
//            	System.out.println("Invalid input type. Please enter an integer value.");
//        		sc.next(); 
//            }
//
//			choice = sc.nextInt();
//	        sc.nextLine();
//			
//			switch (choice) {
//			case 1: 
//                System.out.println("Username: ");
//                while (!sc.hasNext()) {
//                	System.out.println("Invalid input type. Please try again!");
//            		sc.next(); 
//                }
//                String username = sc.nextLine();
//                System.out.println("Password: ");
//                while (!sc.hasNext()) {
//                	System.out.println("Invalid input type. Please try again!");
//            		sc.next(); 
//                }
//                String password = sc.nextLine();
//                
//                boolean authenticate = LoginAuthenticator.getInstance().login(username, password);
//                
//                
//                if (authenticate) {
//                	loggedIn = true;
//                	this.displayLoggedInMenu();
//                	quit = true;
//                } else {
//                	System.out.println("Invalid Username or Password, please try again.");
//                }
//				break;
//			case 0:
//				System.out.println("Back to MOBLIMA APP......");
//				quit = true;
//				break;
//			}
//		} while (loggedIn == false && quit == false);
//    }
    
    /**
	 * Logged in meny for staff app
	 */
    public void displayLoggedInMenu() { //TDOO: CREATE NEW MENU FOR THIS
		int choice;
		
		do {
            System.out.println(	"============== MOBLIMA STAFF APP ================\n" +
			                    " 1. Edit Movie Listing(Showtime,Cineplex,Cinema)   \n" +
			                    " 2. Edit Movie                                    \n" +
			                    " 3. System Settings                               \n" +
			                    " 0. Back to MOBLIMA APP                           \n"+
							    "====================================================");
            System.out.println("Enter choice: ");

            while (!sc.hasNextInt()) {
            	System.out.println("Invalid input type. Please enter an integer value.");
        		sc.next(); 
            }

			choice = sc.nextInt();
			
			switch (choice) {
			case 1: 
                CinemaMenu.getInstance().movielisting();
				break;
			case 2:
				MovieMenu.getInstance().displayStaffMovieMenu();
				break;
			case 3:
				//System settings?
					// CALL SYSTEM MENU -> CALL SETTINGS MANAGER
					SystemSettingsMenu.getInstance().displaySystemSettingsMenu();
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