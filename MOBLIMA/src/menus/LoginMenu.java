package menus;

import java.util.Scanner;

import managers.LoginAuthenticator;
/**
 *  Login Menu  for staff
 */
public class LoginMenu {
    /** 
     * Single instance of LoginMenu 
     */
    private static LoginMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private LoginMenu(){}

    /**
     * Get or creates the single instance of LoginMenu class
     * @return LoginMenu Class
     */
    public static LoginMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new LoginMenu();
        return single_instance;
    }
    
	/**
	 * Main Staff App interface
	 */
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
        		sc.next(); 
            }

			choice = sc.nextInt();
	        sc.nextLine();
			
			switch (choice) {
			case 1: 
                System.out.println("Username: ");
                while (!sc.hasNext()) {
                	System.out.println("Invalid input type. Please try again!");
            		sc.next(); 
                }
                String username = sc.nextLine();
                
                System.out.println("Password: ");
                while (!sc.hasNext()) {
                	System.out.println("Invalid input type. Please try again!");
            		sc.next(); 
                }
                String password = sc.nextLine();
                
                boolean authenticate = LoginAuthenticator.getInstance().login(username, password);
                
                
                if (authenticate) {
                	loggedIn = true;
                	//this.displayLoginMenu();
                	quit = true;
                	StaffApp.getInstance().displayLoggedInMenu();
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


}
