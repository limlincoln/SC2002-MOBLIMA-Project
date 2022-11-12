package menus;

import java.util.Scanner;

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

    /**
	 * Logged in meny for staff app
	 */
    public void displayLoggedInMenu() { //TDOO: CREATE NEW MENU FOR THIS
		int choice;
		
		do {
            System.out.println(	"============== MOBLIMA STAFF APP ================\n" +
			                    " 1. Edit ShowTime                                 \n" +
			                    " 2. System Settings (Edit Movies, Holidays, etc.) \n" +
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
				ShowTimeEditorMenu.startShowTimeEditor();
				break;
			case 2:
				SettingsMenu.getInstance().displayMenu();
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