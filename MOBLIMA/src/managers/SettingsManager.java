package managers;
import entities.Holiday;
import enums.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import enums.*;
import java.util.Scanner;

import consolidators.MovieConsolidator;

import java.util.ArrayList;
import entities.Movie;
import menus.ITop5Menu;
import utils.IDGenerator;

public class SettingsManager {
	Scanner sc = new Scanner(System.in);
	private static SettingsManager single_instance = null;
	private ITop5Menu customerTop5MenuClass;
	private SettingsManager(ITop5Menu customerTop5MenuClass){
		this.customerTop5MenuClass = customerTop5MenuClass;
	}
	public static SettingsManager getInstance(){
		return single_instance;
	}

	/**
	 * Initialises a single instance of settings manager
	 * @param customerTop5Value
	 */
	public static void initialize(ITop5Menu customerTop5Value){
		single_instance = new SettingsManager(customerTop5Value);
	}

	public boolean editPrices(PriceType base, double newPrice){
		String ba = base.name();
		if (ba == "BASE_PRICE"){
			PricingManager.updatePrice(PriceType.BASE_PRICE,newPrice);
			System.out.println("Base Price updated to " + PricingManager.getPrice(PriceType.BASE_PRICE));
			return true;
		}
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

	public ITop5Menu getCustomerTop5MenuClass() {
		return this.customerTop5MenuClass;
	}

	public void setCustomerTop5MenuClass(ITop5Menu customerTop5MenuClass) {
		this.customerTop5MenuClass = customerTop5MenuClass;
	}

	// HOLIDAY FUNCTIONS

	/**
	 * List all available holidays
	 */
	public void listHolidays() {
		ArrayList<Holiday> holiday = new ArrayList<Holiday>();
		holiday = HolidayManager.getHolidays();
		for (int x = 0; x < holiday.size(); x++){
			System.out.println(x+1 + ". " + holiday.get(x).getName() + " " + holiday.get(x).getDate());
		}
	}

	/**
	 * Add new holidays
	 */
	public void addNewHoliday(){
		String name;
		LocalDate date = null;
		boolean reAsk;

		System.out.println("What is the holiday name: ");
		do {
			reAsk = false;
			name = sc.next();
			reAsk = HolidayManager.isHoliday(name);

			if(reAsk) {
				System.out.println("This holiday already exists!");
			}
		} while(reAsk);
		do {
			reAsk = false;
			System.out.println("What is the holiday date? (yyyy-MM-dd): ");
			try{
				date = LocalDate.parse(sc.next());
				if(HolidayManager.isHoliday(date)) {
					System.out.println("This Holiday already exists!");
					reAsk = true;
				}
			} catch (DateTimeParseException e) {
				System.out.println("Please make sure date is correct!");
				reAsk = true;
			}
		} while(reAsk);

		DateManager dateManager = new DateManager(LocalDateTime.of(date, LocalTime.now()));
		
		DayOfWeek day = dateManager.getDayOfWeek();

		Holiday newhol = new Holiday(IDGenerator.get(), name, date, day);
		
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
        String heading;
        Movie selectedMovie;
		System.out.println(	"================ SELECT A MOVIE =================");
		int editchoice = -1;
		ArrayList<Movie> movies = MovieConsolidator.getInstance().getAll();

		for(int i = 0;  i < movies.size(); i++) {
			System.out.println("("+(i+1)+") "+movies.get(i).getMovieName());
		}
		
		do {
			
			System.out.println("Choose a movie or enter 0 to exit : ");
				
			while (!sc.hasNextInt()) {
				System.out.printf("Invalid input type.");
				sc.next(); 
			}
			editchoice = sc.nextInt();
			
		} while(editchoice  < 0 || editchoice > movies.size());
		sc.nextLine();
		
		if(editchoice == 0) return;
			
		Movie movieToEdit = movies.get(editchoice-1);

		int subchoice;
		System.out.println("=================== Choose what to edit ==================\n" +
							" 1. Edit Movie Title      	                                \n" +
							" 2. Edit Movie Genres                      	        			\n" +
							" 3. Edit Movie Status	                                    \n" +
							" 4. Edit Movie Cast                                        \n" +
							" 5. Edit Movie Director                                    \n" +
							" 6. Edit Movie Synopsis                                    \n" +
							" 7. Edit Movie CinemaType                                  \n" +
							" 0. Finish Editing Movie                                		\n"+
							"=========================================================");
		do {
			System.out.println("Enter choice: ");
			
			while (!sc.hasNextInt()) {
				System.out.println("Invalid input type. Please enter an integer value between 0-10.");
				sc.next(); // Remove newline character
			}
			
			subchoice = sc.nextInt();
			sc.nextLine();
			switch (subchoice) {
				case 1:
					System.out.println("The current title is: "+movieToEdit.getMovieName());
					System.out.println("Enter the new Movie title: ");
					while (!sc.hasNext()) {
						System.out.println("Invalid input type. Please try again!");
						sc.next(); 
					}
					String title = sc.nextLine();
					
					movieToEdit.setMovieName(title);
					System.out.println("Movie title edited to "+ movieToEdit.getMovieName()); 
					break;
				case 2:
					System.out.println("The current genre is: "+movieToEdit.getMovieType());
					System.out.println("Enter the Movie Genre (ACTION/COMEDY): ");
					while (!sc.hasNext()) {
						System.out.println("Invalid input type. Please try again!");
						sc.next(); 
					}
					
					String askgenre = sc.nextLine();
					MovieGenre genre = null;
					try 
					{
						genre = MovieGenre.valueOf(askgenre);
					}
					catch(IllegalArgumentException e)
					{
						System.out.println("Invalid input type!!. Please follow the status format");
						break;
					}
					

					movieToEdit.setMovieType(genre);
					System.out.println("Movie genre edited to "+ genre); 
					break;
				case 3:
					System.out.println("The current Status is: "+movieToEdit.getStatus());
					System.out.println("Enter the new Status (ComingSoon/Showing/EndOfShowing): ");
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
						break;
					}
					
					movieToEdit.setStatus(status);
					System.out.println("The new Movie status is"+ movieToEdit.getStatus()); 
					break;
				case 4:
					System.out.println("The current casts are: "+movieToEdit.getCasts());
					ArrayList<String> casts = new ArrayList<String>();  
					System.out.println("Enter 2 cast: ");  
					for(int i=0; i<2; i++)  
					{  
						System.out.println("Please enter cast " +(i+1)+ ":");
						casts.add(sc.next());  
					}  
					movieToEdit.setCasts(casts);
					break;
				case 5:
					System.out.println("The current Movie Director is: "+movieToEdit.getDirector());
					System.out.println("Enter new Movie Director: ");
					while (!sc.hasNext()) {
						System.out.println("Invalid input type. Please try again!");
						sc.next(); 
					}
					String director = sc.nextLine();
					
					movieToEdit.setDirector(director);
					System.out.println("The new Movie director is "+ movieToEdit.getDirector());
					
					break;
				case 6:
					System.out.println("The current Movie Sypnopsis is: "+movieToEdit.getSypnopsis());
					System.out.println("Enter new Movie Sypnopsis: ");
					while (!sc.hasNext()) {
						System.out.println("Invalid input type. Please try again!");
						sc.next(); 
					}
					String sypnopsis = sc.nextLine();
					
					movieToEdit.setSypnopsis(sypnopsis);
					System.out.println("The new Movie sypnopsis is "+ movieToEdit.getSypnopsis()); 
					
					break;
				case 7:
					ArrayList<CinemaType> cineTypes = movieToEdit.getCinemaTypes();
					System.out.println("The current Movie CinemaType is: "+cineTypes);
					System.out.println("Enter CinemaType to add or remove: ");
					while (!sc.hasNext()) {
						System.out.println("Invalid input type. Please try again!");
						sc.next(); 
					}
					String cinemaTypeString = sc.nextLine();
					CinemaType cineType = CinemaType.valueOf(cinemaTypeString);
					
					if(cineTypes.contains(cineType)){
						cineTypes.remove(cineType);
					}
					
					System.out.println("The new Movie CinemaType is "+ cineTypes); 
					
					break;
				case 0:
					System.out.println("============= Exiting Edit =============");
					break;
				default:
					System.out.println("Please enter a number from 0-10: ");
			}
		} while (subchoice != 0);
	}

	public void addMovieSettings(){
		System.out.println("Movie title: ");
		while (!sc.hasNext()) {
			System.out.println("Invalid input type. Please try again!");
			sc.next(); 
		}
		String title = sc.nextLine();
		
		System.out.println("Movie Genre (HORROR/ACTION): ");
		while (!sc.hasNext()) {
			System.out.println("Invalid input type. Please try again!");
			sc.next(); 
		}
		
		String askgenre = sc.nextLine();
		MovieGenre genre = null;
		try 
		{
			genre = MovieGenre.valueOf(askgenre);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Invalid input type!!. Please follow the status format");
		}
		
		System.out.println("Status (ComingSoon/Showing/EndOfShowing): ");
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
		
		ArrayList<CinemaType> cineTypes = new ArrayList<CinemaType>(); 

		System.out.println("Number of cinemas supported (IMAX/_3D/NORMAL)");
		while (!sc.hasNextInt()) {
			System.out.println("Invalid input type. Please try again!");
			sc.next(); 
		}
		int num = sc.nextInt();
		for(int i=0;i<num;i++){
			System.out.println("Cinema Types (IMAX/_3D/NORMAL): ");
			while (!sc.hasNext()) {
				System.out.println("Invalid input type. Please try again!");
				sc.next(); 
			}
			
			String askCinetype = sc.nextLine();
			CinemaType cinetype = null;
			try 
			{
				cinetype = CinemaType.valueOf(askCinetype);
				cineTypes.add(cinetype);
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Invalid input type!!. Please follow the status format");
			}
		}



		ArrayList<Integer> ratings = new ArrayList<>();
		float avg = 0.000f;
		Movie newmovie = new Movie(IDGenerator.get(),title,genre,status,cast,director,sypnopsis,ratings,0.0,avg,cineTypes); //movieID should be size()+1?
		
		MovieManager.getInstance().addMovie(newmovie);                    
	}

	public void deleteMovieSetting(){
		System.out.println(	"================ SELECT A MOVIE =================");
		//ArrayList<Movie> delete = new ArrayList<Movie>();
		ArrayList<Movie> movies = MovieConsolidator.getInstance().getAll();

		for(int i = 0;  i < movies.size(); i++) {
			System.out.println("("+(i+1)+") "+movies.get(i).getMovieName());
		}
		int deletechoice = -1;

		do {
			System.out.println("Choose a movie or enter 0 to exit : ");
				
			while (!sc.hasNextInt()) {
				System.out.printf("Invalid input type.");
				sc.next(); 
			}
			deletechoice = sc.nextInt();
			
			}while(deletechoice  < 0 || deletechoice >= movies.size());
		sc.nextLine(); 

		if(deletechoice == 0) return;

		System.out.println("Enter Y to confirm delete : ");
		String confirmation = sc.nextLine();
		
		if(confirmation.toUpperCase().equals("Y"))
		{
			MovieManager.getInstance().removeMovieByID(movies.get(deletechoice-1).getMovieID());
			System.out.println("SUCCESSFULLY DELETED");
		}
		else
		{
			System.out.println("NOT DELETED");
		}
	}
}