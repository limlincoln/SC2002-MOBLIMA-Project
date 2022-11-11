package managers;
import entities.Holiday;
import enums.DayOfWeek;
import java.time.LocalDate;
import enums.*;
import java.util.Scanner;
import java.util.ArrayList;
import entities.Movie;

public class SettingsManager {
	Scanner sc = new Scanner(System.in);
	private static SettingsManager single_instance = null;
	private int customerTop5;
	private SettingsManager(int customerTop5){
		this.customerTop5 = customerTop5;
	}
	public static SettingsManager getInstance(){
		return single_instance;
	}

	/**
	 * Initialises a single instance of settings manager
	 * @param customerTop5Value
	 */
	public static void initialiser(int customerTop5Value){
		single_instance = new SettingsManager(customerTop5Value);
	}

	
	// TODO Implement
	/**
	 * Function to edit price matrix
	 * @param ageGroup
	 * @param newPrice
	 * @return
	 */
	public boolean editPrices(AgeGroup ageGroup, int newPrice){
		return false;		
	}
	/**
	 * Overload editPrice for typeOfDay enum
	 * @param typeOfDay
	 * @param newPrice
	 * @return
	 */
	public boolean editPrices(TypeOfDay typeOfDay, int newPrice){
		return false;
	}
	/**
	 * Overload editprice for timeOfDay Enum
	 * @param timeOfDay
	 * @param newPrice
	 * @return
	 */
	public boolean editPrices(TimeOfDay timeOfDay, int newPrice){
		return false;
	}

	/**
	 * Overload editPrice for cinemaType
	 * @param cinemaType
	 * @param newPrice
	 * @return
	 */
	public boolean editPrices(CinemaType cinemaType, int newPrice){
		return false;
	}
	/**
	 * Removes or edits dates of holidays stored in Holiday Manager 
	 * @param nameOfHoliday
	 * @param StartDateString
	 * @param EndDateString
	 * @return success or not
	 */
	public boolean editHoliday(String nameOfHoliday, String StartDateString, String EndDateString){
		return false;
	}


	/**
	 * Getter and Setters
	 */
	public int getCustomerTop5() {
		return this.customerTop5;
	}

	public void setCustomerTop5(int customerTop5) {
		this.customerTop5 = customerTop5;
	}

	

	// To do
	// ATTRIBUTES:
	// WHICH TOP 5


	// PRICE FUNCTIONS
	/**
	 * Edits the base price of movies
	 */
	public void editBasePrice(){
		double newbase;
        System.out.println("Current Base Price: " + PricingManager.getPrice(PriceType.BASE_PRICE));
        System.out.println("Enter New Base Price: ");
        newbase = sc.nextDouble();
		PricingManager.updatePrice(PriceType.BASE_PRICE,newbase);
	}

	/**
	 * Edits the Price of different age groups
	 */
	public void editAgeGroupPrice(){
		int ageGroupChoice;
        double newageprice;
        do {
            System.out.println(" 1. Adult Prices");
            System.out.println(" 2. Senior Prices");
            System.out.println(" 3. Student Prices");
            System.out.println(" 0. Back to Pricing");
            System.out.println("Enter choice:");
            ageGroupChoice = sc.nextInt();
            System.out.println("Enter new Price: ");
            newageprice = sc.nextDouble();
            switch(ageGroupChoice){
                case 1:
                    PricingManager.updatePrice(AgeGroup.ADULT, newageprice);
                    System.out.println("Price of ADULT updated to " + PricingManager.getPrice(AgeGroup.ADULT));
                    break;
                case 2:
                    PricingManager.updatePrice(AgeGroup.SENIOR, newageprice);
                    System.out.println("Price of SENIOR updated to " + PricingManager.getPrice(AgeGroup.SENIOR));
                    break;
                case 3:
                    PricingManager.updatePrice(AgeGroup.STUDENT, newageprice);
                    System.out.println("Price of STUDENT updated to " + PricingManager.getPrice(AgeGroup.STUDENT));
                    break;
                case 0:
                    System.out.println("Back to Price Settings......");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose between 0-3.");
                    break;
            }
        } while (ageGroupChoice != 0);
	}

	/**
	 * Edits the Price of different cinema types
	 */
	public void editCinemaTypePrice(){
		int cinemaTypeChoice;
        double newcinematypeprice;
        do {
        	System.out.println(" 1. IMAX Prices");
            System.out.println(" 2. 3D Prices");
            System.out.println(" 3. NORMAL Prices");
            System.out.println(" 0. Back to Pricing");
        	System.out.println("Enter choice:");
            cinemaTypeChoice = sc.nextInt();
            System.out.println("Enter new Price: ");
            newcinematypeprice = sc.nextDouble();
            switch(cinemaTypeChoice){
                case 1:
                    PricingManager.updatePrice(CinemaType.IMAX, newcinematypeprice);
                    System.out.println("Price of IMAX updated to " + PricingManager.getPrice(CinemaType.IMAX));
                    break;
                case 2:
                    PricingManager.updatePrice(CinemaType._3D, newcinematypeprice);
                    System.out.println("Price of SENIOR updated to " + PricingManager.getPrice(CinemaType._3D));
                    break;
                case 3:
                    PricingManager.updatePrice(CinemaType.NORMAL, newcinematypeprice);
                    System.out.println("Price of STUDENT updated to " + PricingManager.getPrice(CinemaType.NORMAL));
                    break;
                case 0:
                    System.out.println("Back to Price Settings......");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose between 0-3.");
                    break;
            }
        } while (cinemaTypeChoice != 0);
	}

	/**
	 * Edits the Price of different day of weeks
	 */
	public void editDayOfWeekPrice(){
		int dowChoice;
        double newdowprice;
        do {
            System.out.println(" 1. MONDAY Prices");
            System.out.println(" 2. TUESDAY Prices");
            System.out.println(" 3. WEDNESDAY Prices");
            System.out.println(" 4. THURSDAY Prices");
            System.out.println(" 5. FRIDAY Prices");
            System.out.println(" 6. SATURDAY Prices");
            System.out.println(" 7. SUNDAY Prices");
            System.out.println(" 0. Back to Pricing");
            System.out.println("Enter choice:");
            dowChoice = sc.nextInt();
            System.out.println("Enter new Price: ");
            newdowprice = sc.nextDouble();
            switch(dowChoice){
                case 1:
                    PricingManager.updatePrice(DayOfWeek.MON, newdowprice);
                    System.out.println("Price of MON updated to " + PricingManager.getPrice(DayOfWeek.MON));
                    break;
                case 2:
                    PricingManager.updatePrice(DayOfWeek.TUE, newdowprice);
                    System.out.println("Price of TUE updated to " + PricingManager.getPrice(DayOfWeek.TUE));
                    break;
                case 3:
                    PricingManager.updatePrice(DayOfWeek.WED, newdowprice);
                    System.out.println("Price of WED updated to " + PricingManager.getPrice(DayOfWeek.WED));
                    break;
                case 4:
                    PricingManager.updatePrice(DayOfWeek.THU, newdowprice);
                    System.out.println("Price of THU updated to " + PricingManager.getPrice(DayOfWeek.THU));
                    break;
                case 5:
                    PricingManager.updatePrice(DayOfWeek.FRI, newdowprice);
                    System.out.println("Price of FRI updated to " + PricingManager.getPrice(DayOfWeek.FRI));
                    break;
                case 6:
                    PricingManager.updatePrice(DayOfWeek.SAT, newdowprice);
                    System.out.println("Price of SAT updated to " + PricingManager.getPrice(DayOfWeek.SAT));
                    break;
                case 7:
                    PricingManager.updatePrice(DayOfWeek.SUN, newdowprice);
                    System.out.println("Price of SUN updated to " + PricingManager.getPrice(DayOfWeek.SUN));
                    break;
                case 0:
                    System.out.println("Back to Price Settings......");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose between 0-7.");
                    break;
            }
        } while (dowChoice != 0);
	}

	/**
	 * Edits the Price of different times of day
	 */
	public void editTimeOfDayPrice(){
		int statusChoice;
        double newstatusprice;
    	do {
            System.out.println(" 1. Before 6PM Prices");
            System.out.println(" 2. After 6PM Prices");
            System.out.println(" 0. Back to Pricing");
            System.out.println("Enter choice:");
            statusChoice = sc.nextInt();
            System.out.println("Enter new Price: ");
            newstatusprice = sc.nextDouble();
            switch(statusChoice){
                case 1:
                	PricingManager.updatePrice(TimeOfDay.BEFORE_6, newstatusprice);
                    System.out.println("Price Before 6PM updated to " + PricingManager.getPrice(TimeOfDay.BEFORE_6));
                    break;
                case 2:
                    PricingManager.updatePrice(TimeOfDay.AFTER_6, newstatusprice);
                    System.out.println("Price After 6PM updated to " + PricingManager.getPrice(TimeOfDay.AFTER_6));
                    break;
                case 0:
                    System.out.println("Back to Price Settings......");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose between 0-2.");
                    break;
            }
        } while (statusChoice != 0);
	}

	/**
	 * Edits the Price of different type of day
	 */
	public void editTypeOfDayPrice(){
		int todChoice;
        double newtodprice;
        do {
            System.out.println(" 1. WEEKEND Prices");
            System.out.println(" 2. WEEKDAY Prices");
            System.out.println(" 3. PUBLIC HOLIDAY Prices");
            System.out.println(" 0. Back to Pricing");
            System.out.println("Enter choice:");
            todChoice = sc.nextInt();
            System.out.println("Enter new Price: ");
            newtodprice = sc.nextDouble();
            switch(todChoice){
                case 1:
                    PricingManager.updatePrice(TypeOfDay.WEEKEND, newtodprice);
                    System.out.println("Price of WEEKEND updated to " + PricingManager.getPrice(TypeOfDay.WEEKEND));
                    break;
                case 2:
                    PricingManager.updatePrice(TypeOfDay.WEEKDAY, newtodprice);
                    System.out.println("Price of WEEKDAY updated to " + PricingManager.getPrice(TypeOfDay.WEEKDAY));
                    break;
                case 3:
                    PricingManager.updatePrice(TypeOfDay.PUBLIC_HOLIDAY, newtodprice);
                    System.out.println("Price of PUBLIC HOLIDAY updated to " + PricingManager.getPrice(TypeOfDay.PUBLIC_HOLIDAY));
                    break;
                case 0:
                	System.out.println("Back to Price Settings......");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose between 0-3.");
                    break;
            }
        } while (todChoice != 0);
	}

	// HOLIDAY FUNCTIONS

	/**
	 * List all available holidays
	 */
	public void listHolidays() {
		ArrayList<Holiday> holiday = new ArrayList<Holiday>();
		holiday = HolidayManager.getHolidays();
		for (int x = 0; x < holiday.size(); x++){
			System.out.println(x+1 + ". " + holiday.get(x).getName());
		}
	}

	/**
	 * Add new holidays
	 */
	public void addNewHoliday(){
		String name;
		LocalDate date;
    	int dayOfWeeks;
		System.out.println("What is the holiday name: ");
		name = sc.next();
		System.out.println("What is the holiday date: ");
		date = LocalDate.parse("test");
		System.out.println("What is the holiday day of week: ");
		dayOfWeeks = sc.nextInt();
		DayOfWeek day = DayOfWeek.values()[dayOfWeeks-1];

		Holiday newhol = new Holiday(name, date, day);
		
		HolidayManager.addHoliday(newhol);
	}

	/**
	 * Remove existing holiday
	 */
	public void removeExistingHoliday(){
		int choice;
		ArrayList<Holiday> holi = HolidayManager.getHolidays();
		System.out.println("Enter number of holiday to remove");
		//print list of holidays
		for (int a = 0; a < holi.size(); a++){
			System.out.println(a+1 + ".  " + holi.get(a).getName());
		}
		choice = sc.nextInt();

		//remove based on index
		holi.remove(choice - 1);
	}

	// MOVIE FUNCTIONS

	public void editMovieSettings(){
	// EDIT MOVIE
		// MOVIE EDITOR MENU
		// ASK WHAT MOVIE (LIST ALL MOVIES)
		// ASK WHICH ATTRIBUTE TO CHANGE
		// ASK FOR VALUE
		// CALL MOVIEMANAGER(MOVIE, ATTRIBUTE, VALUE), VALIDATE IN MOVIEMANAGER
		// CHECK RESPONSE FROM MOVIEMANGER, REPEAT IF NEEDED
                	
		System.out.println(	"================ SELECT A MOVIE =================");
		//ArrayList<Movie> editmovie = new ArrayList<Movie>();
		int editchoice = -1;
		
		//editmovie = MovieConsolidator.getInstance().getAll();
		do {
			
			System.out.println("Choose a movie or enter 0 to exit : ");
				
			while (!sc.hasNextInt()) {
				System.out.printf("Invalid input type.");
				sc.next(); 
			}
			editchoice = sc.nextInt();
			
			}while(editchoice  < 0 || editchoice >= 10);//movies.size()
			sc.nextLine();
		
			
		// Movie targetedit = editmovie.get(editchoice);
		int subchoice;
		do {
			System.out.println("=================== Choose what to edit ==================\n" +
								" 1. Edit Movie Title      	                                \n" +
								" 2. Edit Movie Genres                      	        	\n" +
								" 3. Edit Movie Status	                                    \n" +
								" 4. Edit Movie Cast                                        \n" +
								" 5. Edit Movie Director                                     \n" +
								" 6. Edit Movie Synopsis                                     \n" +
								" 0. Finish Editing Movie                                \n"+
								"=========================================================");
			System.out.println("Enter choice: ");
			
			while (!sc.hasNextInt()) {
				System.out.println("Invalid input type. Please enter an integer value between 0-10.");
				sc.next(); // Remove newline character
			}
			
			subchoice = sc.nextInt();
			sc.nextLine();
			switch (subchoice) {
				case 1:
					System.out.println("Movie title: ");
					while (!sc.hasNext()) {
						System.out.println("Invalid input type. Please try again!");
						sc.next(); 
					}
					String title = sc.nextLine();
					
					System.out.println("Movie title "+ title); 
					//targetedit.setMovieName(title);

					break;
				case 2:
					System.out.println("Movie Genre (IMAX/_3D/NORMAL): ");
					while (!sc.hasNext()) {
						System.out.println("Invalid input type. Please try again!");
						sc.next(); 
					}
					
					String askgenre = sc.nextLine();
					CinemaType genre = null;
					try 
					{
						genre = CinemaType.valueOf(askgenre);
					}
					catch(IllegalArgumentException e)
					{
						System.out.println("Invalid input type!!. Please follow the status format");
					}
					
					System.out.println("Movie genre "+ genre); 
					//targetedit.setMovieType(genre);

					break;
				case 3:
					System.out.println("Status (ComingSoon/Showing): ");
					while (!sc.hasNext()) {
						System.out.println("Invalid input type. Please try again!");
						sc.next(); 
					}
					
					String askstatus = sc.nextLine();
					Status status = null;
					try 
					{
						status = Status.valueOf(askstatus);
					}
					catch(IllegalArgumentException e)
					{
						System.out.println("Invalid input type!!. Please follow the status format");
					}
					
					System.out.println("Movie status "+ status); 
					//targetedit.setStatus(status);
					break;
				case 4:
					ArrayList<String> cast = new ArrayList<String>();  
					System.out.println("Enter 2 cast: ");  
					for(int i=0; i<2; i++)  
					{  
						System.out.println("Please enter cast " +(i+1)+ ":");
						cast.add(sc.next());  
					}  
					//targetedit.setCasts(cast);
					break;
				case 5:
					
					System.out.println("Movie Director: ");
					while (!sc.hasNext()) {
						System.out.println("Invalid input type. Please try again!");
						sc.next(); 
					}
					String director = sc.nextLine();
					
					System.out.println("Movie director "+ director); 
					//targetedit.setDirector(director);
					
					break;
				case 6:
					System.out.println("Movie Sypnopsis: ");
					while (!sc.hasNext()) {
						System.out.println("Invalid input type. Please try again!");
						sc.next(); 
					}
					String sypnopsis = sc.nextLine();
					
					System.out.println("Movie sypnopsis "+ sypnopsis); 
					// targetedit.setSypnopsis(sypnopsis);
					
					break;
				case 0:
					System.out.println("=============Exiting Edit=============");
					break;
				default:
					System.out.println("Please enter a number from 0-10: ");
			}
		} while (subchoice != 0);
	}

	public void addMovieSettings(){
		// ADD MOVIE
		// ASK FOR ALL NECESSARY ATTRIBUTE
		// MOVIEMANAGER.ADDMOVIE(...) - RMB TO VALIDATE
                    
		System.out.println("Movie title: ");
		while (!sc.hasNext()) {
			System.out.println("Invalid input type. Please try again!");
			sc.next(); 
		}
		String title = sc.nextLine();
		
		System.out.println("Movie Genre (IMAX/_3D/NORMAL): ");
		while (!sc.hasNext()) {
			System.out.println("Invalid input type. Please try again!");
			sc.next(); 
		}
		
		String askgenre = sc.nextLine();
		CinemaType genre = null;
		try 
		{
			genre = CinemaType.valueOf(askgenre);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Invalid input type!!. Please follow the status format");
		}
		
		System.out.println("Status (ComingSoon/Showing): ");
		while (!sc.hasNext()) {
			System.out.println("Invalid input type. Please try again!");
			sc.next(); 
		}
		
		String askstatus = sc.nextLine();
		Status status = null;
		try 
		{
			status = Status.valueOf(askstatus);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Invalid input type!!. Please follow the status format");
		}
		
	
		ArrayList<String> cast = new ArrayList<String>();  
		System.out.println("Enter 2 cast: ");  
		for(int i=0; i<2; i++)  
		{  
			System.out.println("Please enter cast " +(i+1)+ ":");
			cast.add(sc.next());  
		}    

		
		System.out.println("Movie Director: ");
		while (!sc.hasNext()) {
			System.out.println("Invalid input type. Please try again!");
			sc.next(); 
		}
		String director = sc.nextLine();
		
		System.out.println("Movie Sypnopsis: ");
		while (!sc.hasNext()) {
			System.out.println("Invalid input type. Please try again!");
			sc.next(); 
		}
		String sypnopsis = sc.nextLine();
		
		ArrayList<Integer> ratings = new ArrayList<>();
		float avg = 0.000f;
		Movie newmovie = new Movie(0,title,genre,status,cast,director,sypnopsis,ratings,0.0,avg); //movieID should be size()+1?
		
		MovieManager.getInstance().addMovie(newmovie);                    

	}

	public void deleteMovieSetting(){
		System.out.println(	"================ SELECT A MOVIE =================");
		//ArrayList<Movie> delete = new ArrayList<Movie>();
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
		}
	}
}


