package menus;

public class SettingsMenu {
    Scanner sc = new Scanner(System.in);

	// Settings Display Menuy
	public void displayMenu() {
		int choice;
		do {
            System.out.println("=================== Settings ===================");
            System.out.println("1. View Settings");
            System.out.println("2. Edit Settings");
            System.out.println("0. Back to Staff App");
            System.out.println("==========================================================");
            System.out.println("Select Option: ");
            while(!sc.hasNextInt()) {
                System.out.println("Please enter a number!");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();
            
			switch (choice) {
				case 1:
					viewSettings();
					break;
				case 2:
                    editSettings();
					break;
				case 0:
					System.out.println("Moving back to Staff App");
					break;
				default:
					System.out.println("Invalid option. Please choose an option between 0-4.");
					break;
			}
		} while (choice!=0);
	}

	// View Existing Settings
	private void viewSettings() {
		int choice;
		do {
	        System.out.println(	"=================== View Settings ===================");
            System.out.println(" 1. Default Prices");
            System.out.println(" 2. Daily Prices");
            System.out.println(" 3. Holiday Prices");
            System.out.println(" 4. Movie Format Prices");
            System.out.println(" 5. Ticket Type Prices");
            System.out.println(" 6. Cinema Type Prices");
            System.out.println(" 0. Back to Settings Menu");
            System.out.println("===========================================================");

			System.out.println("Enter choice:");
			while(!sc.hasNextInt()) {
				System.out.println("Please enter a number!");
				sc.next();
			}
			choice = sc.nextInt();
			sc.nextLine();
				
			switch (choice) {
				case 1: 
					
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				case 4:
					
					break;
				case 5:
					
					break;
				case 6:
					
					break;
				case 0:
					System.out.println("Back to SystemSettings Menu......");
					break;
				default:
					System.out.println("Invalid choice. Please choose between 0-8.");
					break;
			}
		} while (choice!=0);
	}

	// Edit Settings
	private void editSettings() {
		int choice;
		do {
	        System.out.println(	"=================== Edit Settings ==================");
            System.out.println(" 1. Default Prices");
            System.out.println(" 2. Daily Prices");
            System.out.println(" 3. Holiday Prices ");
            System.out.println(" 4. Movie Format Prices");
            System.out.println(" 5. Ticket Type Prices");
            System.out.println(" 6. Cinema Type Prices");
            System.out.println(" 0. Back to Settings Menu");
            System.out.println("===========================================================");
			System.out.println("Enter choice: ");
			while(!sc.hasNextInt()) {
				System.out.println("Please enter a number!");
				sc.next();
			}
			choice = sc.nextInt();
			sc.nextLine();
				
			switch (choice) {
				case 1:
                    
                    break;
				case 2:
					
					break;
				case 3: 
					
					break;
				case 4:
					
					break;
				case 5:
					
					break;			
				case 6:
                    
					break;		
				case 7:
					
					break;			
				case 0: 
					break;
				default:
					System.out.println("Invalid choice. Please choose between 0-7.");
					break;
			}
		} while (choice!=0);
		
		System.out.println("Back to Settings Menu......");
	}
}
