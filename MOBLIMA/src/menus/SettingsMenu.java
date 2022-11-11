package menus;
import managers.PricingManager;
import managers.SettingsManager;
import managers.MovieManager;
import entities.Movie;

public class SettingsMenu {
    Scanner sc = new Scanner(System.in);

	// Settings Display Menuy
	public void displayMenu() {
		int choice;
		do {
            System.out.println("=================== Settings ===================");
            System.out.println("1. Price Settings");
            System.out.println("2. Movie Settings");
            System.out.println("3. Holiday Settings");
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

	// View Price Settings
	private void viewPriceSettings() {
		int choice;
		do {
	        System.out.println(	"=================== View Price Settings ===================");
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

	// Edit Price Settings
	private void editPriceSettings() {
		int choice;
		do {
	        System.out.println(	"=================== Edit Price Settings ==================");
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
				case 0: 
					break;
				default:
					System.out.println("Invalid choice. Please choose between 0-7.");
					break;
			}
		} while (choice!=0);
		
		System.out.println("Back to Settings Menu......");
	}

    

    // Movie Settings
    private void movieSettings(){
        int choice;
		do {
	        System.out.println(	"=================== Movie Settings ===================");
            System.out.println(" 1. View Movie Settings");
            System.out.println(" 2. Add New Movie");
            System.out.println(" 3. Remove Movie");
            System.out.println(" 4. Edit Movie Settings");
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
					viewMovieSettings();
					break;
                case 2:
                    addNewMovie();
                    break;
                case 3:
                    removeExistingMovie();
                    break;
				case 4:
                    // edit movie name, directors and cast
					editMovieSettings();
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

	// View Movie Settings
	private void viewMovieSettings() {
		int choice;
		do {
	        System.out.println(	"=================== View Movie Settings ===================");
            System.out.println(" 1. List All Movies");
            System.out.println(" 2. Search for Movie");
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
					SettingsManager.displayMovies();
					break;
				case 2:
					SettingsManager.searchMovies();
					break;
				case 3:
					
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

	// Edit Movie Settings
	private void editMovieSettings() {
		int choice;
        String moviename;
        Movie movie;
        // enter movie name / id first
        System.out.println("Enter the movie to edit: ")
        moviename = sc.next();
        movie = getMovieByName(moviename);
		do {
	        System.out.println(	"=================== Edit " + moviename + " Settings ==================");
            System.out.println(" 1. Edit Name");
            System.out.println(" 2. Edit Cast");
            System.out.println(" 3. Edit Director");
            System.out.println(" 4. Edit Duration");
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
                    String newname; 
                    System.out.println("Enter new Name: ");
                    newname = sc.next();
                    movie.setMovieName(newname);
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
					break;
				default:
					System.out.println("Invalid choice. Please choose between 0-7.");
					break;
			}
		} while (choice!=0);
		
		System.out.println("Back to Settings Menu......");
	}



    // Holiday Settings
    private void holidaySettings(){
        int choice;
		do {
	        System.out.println(	"=================== Holiday Settings ===================");
            System.out.println(" 1. View Holidays");
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

	// View Holiday Settings - dont need this
	private void viewHolidaySettings() {
		int choice;
		do {
	        System.out.println(	"=================== View Holiday Settings ===================");
            System.out.println(" 1. List All Holiday");
            System.out.println(" 2. Search for Holiday");
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
					SettingsManager.listHolidays();
					break;
				case 2:
					SettingsManager.searchHolidays():
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
