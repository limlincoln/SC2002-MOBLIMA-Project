package menus;
import managers.PricingManager;
import managers.SettingsManager;
import managers.MovieManager;
import entities.Movie;
import enums.*;

public class SettingsMenu {
    Scanner sc = new Scanner(System.in);
    
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
				
			switch (choice) {
				case 1: 
                    SettingsManager.editBasePrice();
					break;
				case 2:
                    SettingsManager.editAgeGroupPrice();
					break;
				case 3:
                    SettingsManager.editCinemaTypePrice();
                    break;
				case 4:
                    SettingsManager.editDayOfWeekPrice();
					break;
				case 5:
                    SettingsManager.editTimeOfDayPrice();
                    break;
				case 6:
                    SettingsManager.editTypeOfDayPrice():
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
                	SettingsManager.editMovieSettings():
                    break;
                case 2:
                	// ADD MOVIE
					// ASK FOR ALL NECESSARY ATTRIBUTE
					// MOVIEMANAGER.ADDMOVIE(...) - RMB TO VALIDATE
                    SettingsManager.addMovieSettings();
                    break;
                case 3:
                	// DELETE MOVIE
					// ASK WHAT MOVIE (LIST ALL MOVIES)
					// CONFIMATION PAGE
                	System.out.println(	"================ SELECT A MOVIE =================");
                	ArrayList<Movie> delete = new ArrayList<Movie>();
                    int deletechoice = -1;

                    //delete = MovieConsolidator.getInstance().getAll();
                    do {
                    	System.out.println("Choose a movie or enter 0 to exit : ");
                            
                        while (!sc.hasNextInt()) {
                    		System.out.printf("Invalid input type.");
                    		sc.next(); 
                    	}
                        deletechoice = sc.nextInt();
                        
                        }while(deletechoice  < 0 || deletechoice >= 10);//movies.size()
                    sc.nextLine(); 
                    System.out.println("Enter Y to confirm delete : ");
                    String confirmation = sc.nextLine();
                    
                    if(confirmation.equals("Y"))
                    {
                    	System.out.println("SUCCESSFULLY DELETED");
                    	//MovieManager.removeMovieByID(deletechoice);
                    }
                    else
                    {
                    	System.out.println("DELETE UNSUCCESSFULLY");
                    	break;
                    }
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
            System.out.println(" 3. Remove Exisiting Holiday")
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
					SettingsManager.listHolidays();
					break;
				case 2:
                    // Add new movie
					SettingsManager.addNewHoliday();
					break;
                case 3:
                    // Remove Holiday
					SettingsManager.removeExistingHoliday();
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
