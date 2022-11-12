package menus;
import managers.PricingManager;
import managers.SettingsManager;
import managers.MovieManager;
import java.util.Scanner;

import entities.Movie;
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
				case 0:
					System.out.println("Moving back to Staff App");
					break;
				default:
					System.out.println("Invalid option. Please choose an option between 0-4.");
					break;
			}
		} while (choice!=0);
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
					System.out.println("Invalid choice. Please choose between 0-8.");
					break;
			}
		} while (choice!=0);
    }

    /**
     * Edit the respective Price Settings
     */
	private void editPriceSettings() {
		int choice;
		do {
	        System.out.println("=================== Edit Price Settings ===================");
            System.out.println(" 1. Base Prices");
            System.out.println(" 2. Age Group Prices");
            System.out.println(" 3. Cinema Type Prices");
            System.out.println(" 4. Day of Week Prices");
            System.out.println(" 5. Time of Day Prices");
            System.out.println(" 6. Type of Day Prices");
            System.out.println(" 0. Back to Settings Menu");
            System.out.println("===========================================================");

			System.out.println("Enter choice:");
			while(!sc.hasNextInt()) {
				System.out.println("Please enter a number!");
				sc.next();
			}
			choice = sc.nextInt();
			sc.nextLine();
				
			double newPrice;
			int thischoice;
			switch (choice) {
				case 1: 
					do {
						System.out.println("Enter the new base price:");
						System.out.println(" 0. Back to Settings Menu");
						newPrice = sc.nextDouble();
						SettingsManager.getInstance().editPrices(PriceType.BASE_PRICE,newPrice);
					} while (newPrice != 0);
					break;
				case 2:
					do {
						System.out.println(" 1. Adult Prices");
						System.out.println(" 2. Student Prices");
						System.out.println(" 3. Senior Prices");
						System.out.println("Enter choice: ");
						thischoice = sc.nextInt();
						System.out.println("Enter new Price: ");
						newPrice = sc.nextDouble();
						if (thischoice == 1){SettingsManager.getInstance().editPrices(AgeGroup.ADULT,newPrice);}
						else if (thischoice == 2){SettingsManager.getInstance().editPrices(AgeGroup.STUDENT,newPrice);}						
						else if (thischoice == 3){SettingsManager.getInstance().editPrices(AgeGroup.SENIOR,newPrice);}						
					} while (thischoice != 0);					
					break;
				case 3:
					do {
						System.out.println(" 1. IMAX Prices");
						System.out.println(" 2. 3D Prices");
						System.out.println(" 3. Normal Prices");
						System.out.println("Enter choice: ");
						thischoice = sc.nextInt();
						System.out.println("Enter new Price: ");
						newPrice = sc.nextDouble();
						if (thischoice == 1){SettingsManager.getInstance().editPrices(CinemaType.IMAX,newPrice);}
						else if (thischoice == 2){SettingsManager.getInstance().editPrices(CinemaType._3D,newPrice);}						
						else if (thischoice == 3){SettingsManager.getInstance().editPrices(CinemaType.NORMAL,newPrice);}						
					} while (thischoice != 0);					
					break;
				case 4:
					do {
						System.out.println(" 1. Monday Prices");
						System.out.println(" 2. Tuesday Prices");
						System.out.println(" 3. Wednesday Prices");
						System.out.println(" 4. Thursday Prices");
						System.out.println(" 5. Friday Prices");
						System.out.println(" 6. Saturday Prices");
						System.out.println(" 7. Sunday Prices");
						System.out.println("Enter choice: ");
						thischoice = sc.nextInt();
						System.out.println("Enter new Price: ");
						newPrice = sc.nextDouble();
						if (thischoice == 1){SettingsManager.getInstance().editPrices(DayOfWeek.MON,newPrice);}
						else if (thischoice == 2){SettingsManager.getInstance().editPrices(DayOfWeek.TUE,newPrice);}						
						else if (thischoice == 3){SettingsManager.getInstance().editPrices(DayOfWeek.WED,newPrice);}
						else if (thischoice == 4){SettingsManager.getInstance().editPrices(DayOfWeek.THU,newPrice);}						
						else if (thischoice == 5){SettingsManager.getInstance().editPrices(DayOfWeek.FRI,newPrice);}						
						else if (thischoice == 6){SettingsManager.getInstance().editPrices(DayOfWeek.SAT,newPrice);}						
						else if (thischoice == 7){SettingsManager.getInstance().editPrices(DayOfWeek.SUN,newPrice);}												
					} while (thischoice != 0);					
					break;
				case 5:
					do {
						System.out.println(" 1. Before 6 Prices");
						System.out.println(" 2. After 6 Prices");
						System.out.println("Enter choice: ");
						thischoice = sc.nextInt();
						System.out.println("Enter new Price: ");
						newPrice = sc.nextDouble();
						if (thischoice == 1){SettingsManager.getInstance().editPrices(TimeOfDay.BEFORE_6,newPrice);}
						else if (thischoice == 2){SettingsManager.getInstance().editPrices(TimeOfDay.AFTER_6,newPrice);}						
					} while (thischoice != 0);					
					break;
				case 6:
					do {
						System.out.println(" 1. Weekday Prices");
						System.out.println(" 2. Weekend Prices");
						System.out.println(" 3. Public Holiday Prices");
						System.out.println("Enter choice: ");
						thischoice = sc.nextInt();
						System.out.println("Enter new Price: ");
						newPrice = sc.nextDouble();
						if (thischoice == 1){SettingsManager.getInstance().editPrices(TypeOfDay.WEEKDAY,newPrice);}
						else if (thischoice == 2){SettingsManager.getInstance().editPrices(TypeOfDay.WEEKEND,newPrice);}						
						else if (thischoice == 3){SettingsManager.getInstance().editPrices(TypeOfDay.PUBLIC_HOLIDAY,newPrice);}						
					} while (thischoice != 0);					
					break;
				case 0:
					System.out.println("Back to Settings Menu......");
					break;
				default:
					System.out.println("Invalid choice. Please choose between 0-8.");
					break;
			}
		} while (choice!=0);
	}

    /**
     * View the respective price settings
     */
	private void viewPriceSettings() {
		int choice;
		do {
	        System.out.println(	"=================== View Price Settings ==================");
            System.out.println(" 1. Base Prices");
            System.out.println(" 2. Age Group Prices");
            System.out.println(" 3. Cinema Type Prices");
            System.out.println(" 4. Day of Week Prices");
            System.out.println(" 5. Time of Day Prices");
            System.out.println(" 6. Type of Day Prices");
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
					System.out.println("Adult Price: $" + PricingManager.getPrice(AgeGroup.ADULT));
                    System.out.println("Senior Price: $" + PricingManager.getPrice(AgeGroup.SENIOR));
                    System.out.println("Student Price: $" + PricingManager.getPrice(AgeGroup.STUDENT));
					break;
				case 3: 
                    System.out.println("IMAX Price: $" + PricingManager.getPrice(CinemaType.IMAX));
                    System.out.println("3D Price: $" + PricingManager.getPrice(CinemaType._3D));
                    System.out.println("Normal Price: $" + PricingManager.getPrice(CinemaType.NORMAL));
					break;
				case 4:
                    System.out.println("Monday Price: $" + PricingManager.getPrice(DayOfWeek.MON));
                    System.out.println("Tuesday Price: $" + PricingManager.getPrice(DayOfWeek.TUE));
                    System.out.println("Wednesday Price: $" + PricingManager.getPrice(DayOfWeek.WED));
                    System.out.println("Thursday Price: $" + PricingManager.getPrice(DayOfWeek.THU));
                    System.out.println("Friday Price: $" + PricingManager.getPrice(DayOfWeek.FRI));
                    System.out.println("Saturday Price: $" + PricingManager.getPrice(DayOfWeek.SAT));
                    System.out.println("Sunday Price: $" + PricingManager.getPrice(DayOfWeek.SUN));
					break;
				case 5:
                    System.out.println("Before 6PM Price: $" + PricingManager.getPrice(TimeOfDay.BEFORE_6));
                    System.out.println("After 6PM Price: $" + PricingManager.getPrice(TimeOfDay.AFTER_6));
					break;			
				case 6:
                    System.out.println("Weekend Price: $" + PricingManager.getPrice(TypeOfDay.WEEKEND));
                    System.out.println("Weekday Price: $" + PricingManager.getPrice(TypeOfDay.WEEKDAY));
                    System.out.println("Public Holiday Price: $" + PricingManager.getPrice(TypeOfDay.PUBLIC_HOLIDAY));
					break;
				case 0: 
					break;
				default:
					System.out.println("Invalid choice. Please choose between 0-7.");
					break;
			}
		} while (choice!=0);
		
		System.out.println("Back to Price Settings......");
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
                	// EDIT MOVIE
					// MOVIE EDITOR MENU
					// ASK WHAT MOVIE (LIST ALL MOVIES)
                    // ASK WHICH ATTRIBUTE TO CHANGE
                    // ASK FOR VALUE
                    // CALL MOVIEMANAGER(MOVIE, ATTRIBUTE, VALUE), VALIDATE IN MOVIEMANAGER
                    // CHECK RESPONSE FROM MOVIEMANGER, REPEAT IF NEEDED
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
                    // display list of all movies with directors
                    // search fucntion for movie??
					SettingsManager.getInstance().listHolidays();
					break;
				case 2:
                    // Add new movie
					SettingsManager.getInstance().addNewHoliday();
					break;
                case 3:
                    // Remove Holiday
					SettingsManager.getInstance().removeExistingHoliday();
					break;
				case 0:
					System.out.println("Back to Settings Menu......");
					break;
				default:
					System.out.println("Invalid choice. Please choose between 0-8.");
					break;
			}
		} while (choice!=0);
    }
}
