package managers;
import settings.SystemSettings;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.io.IOException;


public class SettingsManager {
    private SystemSettings systemSettings;
    private Scanner sc = new Scanner(System.in);
    //intialiser
    private SettingsManager() {
		SystemSettings serializedObject = this.load();
		if (serializedObject != null) {
			this.systemSettings = serializedObject;
		} else {
			this.systemSettings = new SystemSettings();
			System.out.println("System Settings File created!");
		}
	}

    //loading
    private SystemSettings load() {
        //get current directory?
		String filePath = ProjectRootPathFinder.findProjectRootPath() + "/data/system_settings/system_settings.dat";
        //change filename to propeor file name
		return (SystemSettings) SerializerHelper.deSerializeObject(filePath);
	}
    //date converter
	private LocalDate dateConverter(String dateString) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(dateString, formatter);
			return date;
		}
		catch (DateTimeParseException dtpe) {
			System.out.println("Wrong date format");
			return null;
		}
	}

    //main menu display
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
					viewSystemSetting();
					break;
				case 2:
                    changeSystemSetting();
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

    //view settings
    private void viewSystemSetting() {
		int choice;
		do {
	        System.out.println(	"=================== View SystemSettings ===================");
            System.out.println(" 1. All Price References");
            System.out.println(" 2. Holiday References");
            System.out.println(" 3. Default Prices");
            System.out.println(" 4. Day-of-the-Week Prices");
            System.out.println(" 5. Holiday Prices");
            System.out.println(" 6. Movie Format Prices");
            System.out.println(" 7. Ticket Type Prices");
            System.out.println(" 8. Cinema Type Prices");
            System.out.println(" 0. Back to SystemSettings Menu");
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
					this.systemSettings.viewSetting("priceReference");
					break;
				case 2:
					this.systemSettings.viewSetting("holidayReference");
					break;
				case 3: 
					this.systemSettings.viewSetting("default$");
					break;
				case 4:
					this.systemSettings.viewSetting("dayOfWeek$");
					break;
				case 5:
					this.systemSettings.viewSetting("holiday$");
					break;
				case 6:
					this.systemSettings.viewSetting("movieFormat$");
					break;
				case 7:
					this.systemSettings.viewSetting("ticketType$");
					break;
				case 8:
					this.systemSettings.viewSetting("cinemaType$");
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
	
	//edit setting
	private void changeSystemSetting() {
		int choice;
		do {
	        System.out.println(	"=================== Change SystemSettings ==================");
            System.out.println(" 1. Holiday References");
            System.out.println(" 2. Movie Format Prices");
            System.out.println(" 3. Ticket Type Prices");
            System.out.println(" 4. Cinema Type Prices");
            System.out.println(" 5. Daily Prices");
            System.out.println(" 6. Holiday Prices");
            System.out.println(" 7. Default Prices");
            System.out.println(" 0. Back to SystemSettings Menu");
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
                    holidayReference();
                    break;
				case 2:
					movieFormat();
					break;
				case 3: 
					ticketType();
					break;
				case 4:
					cinemaType();
					break;
				case 5:
					dailyPrices();
					break;			
				case 6:
                    holidayPrices();
					break;		
				case 7:
					defaultPrices();
					break;			
				case 0: 
					break;
				default:
					System.out.println("Invalid choice. Please choose between 0-7.");
					break;
			}
		} while (choice!=0);
		
		System.out.println("Back to SystemSettings Menu......");
	}
	
    private void holidayReference(){
        this.systemSettings.viewSetting("holidayReference");
		LocalDate holidayDate;
		String holidayName;
					
		System.out.println("Enter date of holiday you want to change in format YYYY-MM-DD: ");
		holidayDate = this.dateConverter(sc.next());
		while (holidayDate == null) {
			System.out.println("Enter date of holiday in format YYYY-MM-DD: ");
			holidayDate = this.dateConverter(sc.nextLine());
		}
		System.out.println("Enter new name of holiday: ");
		holidayName = sc.next().toUpperCase();
					
		this.systemSettings.updateSetting("holidayReference", holidayDate, holidayName);
		this.systemSettings.viewSetting("holidayReference");
    }

    private void movieFormat(){
        this.systemSettings.viewSetting("movieFormat$");
		String movieFormatName;
		double movieFormatModifier;
					
		System.out.println("Enter name of movie format you want to change: ");
		movieFormatName = sc.next().toUpperCase();
					
		System.out.println("Enter new price modifier: ");
		while(!sc.hasNextDouble()) {
			System.out.println("Please enter a number!");
			sc.next();
		}
		movieFormatModifier = sc.nextDouble();
					
		this.systemSettings.updateSetting("movieFormat$", movieFormatName, movieFormatModifier);
		this.systemSettings.viewSetting("movieFormat$");
    }

    private void ticketType(){
        this.systemSettings.viewSetting("ticketType$");
		String ticketTypeName;
		double ticketTypeModifier;
					
		System.out.println("Enter name of ticket type you want to change: ");
		ticketTypeName = sc.next().toUpperCase();
					
		System.out.println("Enter new price modifier: ");
		while(!sc.hasNextDouble()) {
			System.out.println("Please enter a number!");
			sc.next();
		}
		ticketTypeModifier = sc.nextDouble();
					
		this.systemSettings.updateSetting("ticketType$", ticketTypeName, ticketTypeModifier);
		this.systemSettings.viewSetting("ticketType$");
    }

    private void cinemaType(){
        this.systemSettings.viewSetting("cinemaType$");
		String cinemaTypeName;
		double cinemaTypeModifier;
					
		System.out.println("Enter name of cinema type you want to change: ");
		cinemaTypeName = sc.next().toUpperCase();
					
		System.out.println("Enter new price modifier: ");
		while(!sc.hasNextDouble()) {
			System.out.println("Please enter a number!");
			sc.next();
		}
		cinemaTypeModifier = sc.nextDouble();
					
		this.systemSettings.updateSetting("cinemaType$", cinemaTypeName, cinemaTypeModifier);	
		this.systemSettings.viewSetting("cinemaType$");
    }

    private void dailyPrices(){
        this.systemSettings.viewSetting("dayOfWeek$");
		String newDay;
		double dayModifier;
					
		System.out.println("Enter name of day of the week you want to change: ");
		newDay = sc.next().toUpperCase();
					
		System.out.println("Enter new price modifier: ");
		while(!sc.hasNextDouble()) {
			System.out.println("Please enter a number!");
			sc.next();
		}
		dayModifier = sc.nextDouble();
					
		this.systemSettings.updateSetting("dayOfWeek$", newDay, dayModifier);	
		this.systemSettings.viewSetting("dayOfWeek$");
    }

    private void holidayPrices(){
        this.systemSettings.viewSetting("holiday$");
		double holidayModifier;
					
		System.out.println("Enter new price modifier for holidays: ");
		while(!sc.hasNextDouble()) {
			System.out.println("Please enter a number!");
			sc.next();
		}
		holidayModifier = sc.nextDouble();
					
		this.systemSettings.updateSetting("holiday$", "HOLIDAY", holidayModifier);	
		this.systemSettings.viewSetting("holiday$");
    }

    private void defaultPrices(){
        this.systemSettings.viewSetting("default$");
		String newDefaultName;
		double newDefaultModifier;
					
		System.out.println("Enter the default setting you want to change: ");
		newDefaultName = sc.next().toUpperCase();
					
		System.out.println("Enter new default price: ");
		while(!sc.hasNextDouble()) {
			System.out.println("Please enter a number!");
			sc.next();
		}
		newDefaultModifier = sc.nextDouble();
					
		this.systemSettings.updateSetting("default$", newDefaultName, newDefaultModifier);	
		this.systemSettings.viewSetting("default$");
    }
}
