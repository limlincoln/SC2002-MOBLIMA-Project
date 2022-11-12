package menus;

import java.util.Scanner;

import managers.SettingsManager;

public class Top5SelectorMenu {
    public static void displaySelector() {
        Scanner sc = new Scanner(System.in);

        int choice;
		do {
			System.out.println(	"========== Select Top 5 to Show to Movie-goer ============");
            System.out.println(" 1. Top 5 by Sales");
            System.out.println(" 2. Top 5 Rating");
            System.out.println(" 3. Show both options");
            System.out.println(" 0. Back to Settings Menu");
            System.out.println("===========================================================");	

			System.out.println("Enter choice:");
			while(!sc.hasNextInt()) {
				System.out.println("Please enter a number!");
				sc.next();
			}
			choice = sc.nextInt();
			// sc.nextLine();

			switch(choice) {
				case 1:
					SettingsManager.getInstance().setCustomerTop5MenuClass(Top5BySalesMenu.getInstance());
					break;
				case 2:
					SettingsManager.getInstance().setCustomerTop5MenuClass(Top5ByRatingMenu.getInstance());
					break;
                case 3:
                    SettingsManager.getInstance().setCustomerTop5MenuClass(Top5OptionsMenu.getInstance());
                    break;
                default:
					System.out.println("Invalid choice.");
					break;
			}

		} while(choice != 0);
    }
    
}
