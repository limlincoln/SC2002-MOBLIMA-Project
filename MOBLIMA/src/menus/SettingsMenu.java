package menus;
import managers.PricingManager;
import managers.SettingsManager;

import java.util.ArrayList;
import java.util.Scanner;

import enums.*;

public class SettingsMenu {
    private static SettingsMenu single_instance = null;
	Scanner sc = new Scanner(System.in);

	private SettingsMenu(){};
    
    public static SettingsMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new SettingsMenu();
        return single_instance;
    }

    /**
     * Displays the main settings menu
    */
	public void displayMenu() {
        int choice;
		do {
            System.out.println("=================== Settings ===================");
            System.out.println("1. Price Settings");
            System.out.println("2. Movie Settings");
            System.out.println("3. Holiday Settings");
			System.out.println("4. Top 5 Movies Settings");
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
					priceSettings();
					break;
				case 2:
                    movieSettings();
					break;
                case 3:
                    holidaySettings();
					break;
				case 4:
					top5MoviesSettings();
				case 0:
					System.out.println("Moving back to Staff App");
					break;
				default:
					System.out.println("Invalid option.");
					break;
			}
		} while (choice!=0);
	}

	public void top5MoviesSettings() {
		int choice;
		do {
			System.out.println(	"=================== Top 5 Movies Settings ===================");
            System.out.println(" 1. View Top 5 by Sales");
            System.out.println(" 2. View Top 5 Rating");
			System.out.println(" 3. Set Top 5 View for Movie-goer");
            System.out.println(" 0. Back to Settings Menu");
            System.out.println("===========================================================");	

			System.out.println("Enter choice:");
			while(!sc.hasNextInt()) {
				System.out.println("Please enter a number!");
				sc.next();
			}
			choice = sc.nextInt();
			sc.nextLine();

			switch(choice) {
				case 1:
					Top5BySalesMenu.getInstance().displayMenu();
					break;
				case 2:
					Top5ByRatingMenu.getInstance().displayMenu();
					break;
				case 3:
					Top5SelectorMenu.displaySelector();
				default:
					System.out.println("Invalid choice.");
					break;
			}

		} while(choice != 0);
	}

    /**
     * Price Settings Menu
     */
    private void priceSettings(){
        int choice;
		do {
	        System.out.println(	"=================== Price Settings ===================");
            System.out.println(" 1. View Price Settings");
            System.out.println(" 2. Edit Price Settings");
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
					viewPriceSettings();
					break;
				case 2:
					editPriceSettings();
					break;
				case 0:
					System.out.println("Back to SystemSettings Menu......");
					break;
				default:
					System.out.println("Invalid choice.");
					break;
			}
		} while (choice!=0);
    }

    /**
     * Edit the respective Price Settings
     */
	private void editPriceSettings() {
		int choice;
		boolean reAsk = false;
		ArrayList<Class<? extends IPriceable>> priceAbleObjs = PricingManager.getPriceAbleObjects();

		do {
			reAsk = false;
	        System.out.println("=================== Edit Price Settings ===================");
			for(int i = 0; i < priceAbleObjs.size(); i++) {
				System.out.println((i+1)+". "+priceAbleObjs.get(i).getSimpleName() + " Prices");
			}
            System.out.println(" 0. Back to Settings Menu");
            System.out.println("===========================================================");

			System.out.println("Enter choice:");
			while(!sc.hasNextInt()) {
				System.out.println("Please enter a number!");
				sc.next();
			}
			choice = sc.nextInt();
			sc.nextLine();

			if(choice < 0 || choice > priceAbleObjs.size()) {
				System.out.println("Please enter a valid number!");
				reAsk = true;
			}

		} while(reAsk);

		if(choice == 0) return;
		Class <? extends IPriceable> selectedType  = priceAbleObjs.get(choice-1);

		double newPrice = 0;
		int thischoice;

		do {
			reAsk = false;
			for(int i = 0; i < selectedType.getEnumConstants().length; i++) {
				System.out.println((i+1)+". "+selectedType.getEnumConstants()[i]);
			}
			System.out.println(" 0. Back to Settings Menu");
			System.out.println("Enter choice: ");
			thischoice = sc.nextInt();

			if(thischoice < 0 || thischoice > selectedType.getEnumConstants().length) {
				System.out.println("Please enter a valid option!");
				reAsk = true;
			}
			else if(thischoice!=0)
			{
				System.out.println("Enter new Price: ");
				newPrice = sc.nextDouble();

				PricingManager.updatePrice(selectedType.getEnumConstants()[thischoice-1], newPrice);	
			}
		
		} while (reAsk);					
	}

    /**
     * View the respective price settings
     */
	private void viewPriceSettings() {
		int choice;
		boolean reAsk = false;
		ArrayList<Class<? extends IPriceable>> priceAbleObjs = PricingManager.getPriceAbleObjects();

		do {
			reAsk = false;
	        System.out.println("=================== View Price Settings ===================");
			for(int i = 0; i < priceAbleObjs.size(); i++) {
				System.out.println((i+1)+". "+priceAbleObjs.get(i).getSimpleName() + " Prices");
			}
            System.out.println(" 0. Back to Settings Menu");
            System.out.println("===========================================================");

			System.out.println("Enter choice:");
			while(!sc.hasNextInt()) {
				System.out.println("Please enter a number!");
				sc.next();
			}
			choice = sc.nextInt();
			sc.nextLine();

			if(choice < 0 || choice > priceAbleObjs.size()) {
				System.out.println("Please enter a valid number!");
				reAsk = true;
			}

		} while(reAsk);

		if(choice == 0) return;
		Class <? extends IPriceable> selectedType  = priceAbleObjs.get(choice-1);

		int thischoice;

		do {
			reAsk = false;
			for(int i = 0; i < selectedType.getEnumConstants().length; i++) {
				System.out.println((i+1)+". "+selectedType.getEnumConstants()[i]);
			}
			System.out.println(" 0. Back to Settings Menu");
			System.out.println("Enter choice: ");
			thischoice = sc.nextInt();

			if(thischoice < 0 || thischoice > selectedType.getEnumConstants().length) {
				System.out.println("Please enter a valid option!");
				reAsk = true;
			}

			System.out.println("Price is: $"+PricingManager.getPrice(selectedType.getEnumConstants()[thischoice-1]));	
		
		} while (reAsk);				
	}

    /**
     * View all movie settings
     */
    public void movieSettings() {
		int choice;
		do {
            System.out.println(	"============== Movie Settings ================\n" +
			                    " 1. Edit Movie          					        \n" +
			                    " 2. Add Movie                                     \n" +
			                    " 3. Delete Movie                                  \n" +
			                    " 0. Back to Settings Menu                           \n"+
							    "====================================================");
	    	
            System.out.println("Enter choice: ");
            
            while (!sc.hasNextInt()) {
            	System.out.println("Invalid input type. Please enter an integer value.");
        		sc.next(); 
            }
            choice = sc.nextInt();
            sc.nextLine();
            
            switch(choice){
                case 1:

                	SettingsManager.getInstance().editMovieSettings();
                    break;
                case 2:
                	// ADD MOVIE
					// ASK FOR ALL NECESSARY ATTRIBUTE
					// MOVIEMANAGER.ADDMOVIE(...) - RMB TO VALIDATE
                    SettingsManager.getInstance().addMovieSettings();
                    break;
                case 3:
                	// DELETE MOVIE
					// ASK WHAT MOVIE (LIST ALL MOVIES)
					// CONFIMATION PAGE
                	SettingsManager.getInstance().deleteMovieSetting();
                    break;
                case 0:
                	System.out.println("Back to MOBLIMA APP......");
                	break;
                default: 
                	System.out.println("Invalid choice.");
                	break;
	            }
	        } while (choice != 0);
		}


    /**
     * View all Holiday Settings
     */
    private void holidaySettings(){
        int choice;
		do {
	        System.out.println(	"=================== Holiday Settings ===================");
            System.out.println(" 1. View all Holidays");
            System.out.println(" 2. Add New Holiday");
            System.out.println(" 3. Remove Exisiting Holiday");
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
					SettingsManager.getInstance().listHolidays();
					break;
				case 2:
					SettingsManager.getInstance().addNewHoliday();
					break;
                case 3:
					SettingsManager.getInstance().removeExistingHoliday();
					break;
				case 0:
					System.out.println("Back to Settings Menu......");
					break;
				default:
					System.out.println("Invalid choice.");
					break;
			}
		} while (choice!=0);
    }
}