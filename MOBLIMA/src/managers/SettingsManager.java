package managers;
import managers.HolidayManager;
import entities.Holiday;
import entities.Movie;
import managers.MovieManager;
import entities.Movie;
import enums.*;
import java.util.Scanner;
import java.util.ArrayList;

public class SettingsManager {
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

	
	// TODO: Implement
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
	 * @param dateString
	 * @return
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

}	

//TODO:
	// ATTRIBUTES:
	// WHICH TOP 5

	// FUNCTION:
	// EDIT PRICES
	// EDIT MOVIES
	// EDIT HOLIDAYS - DONE



	// PRICE FUNCTIONS
	// 


	
	/* 
	// MOVIE FUNCTIONS
	// display movie  - DONE
	// search movie - 
	// add movie - 
	// remove movie - DONE
	public void displayMovies(){
		private ArrayList<Movie> movies = new ArrayList<Movie>();
		movies = MovieManager.getMovies();
		for (int y = 0; y < holiday.size(); y++){
			System.out.println(y+1 + ". " + movies.get(y).getMovieName());
		}
	}

	public void searchMovies(){
		Scanner sc = new Scanner(System.in);
		private ArrayList<Movie> moviess = new ArrayList<Movie>();
		moviess = MovieManager.getMovies();
		String name;
		System.out.println("Enter Movie Name to search: ");
		name = sc.next();

		for (int z = 0; x < moviess.size(); z++){
			if (moviess.get(z).getMovieName() == name){
				//print all the values of the movies
			}
		}
	}

	public void addNewMovie(){
		Scanner sc = new Scanner(System.in);

	}

	public void removeExistingMovie(){
		Scanner sc = new Scanner(System.in);
		private ArrayList<Movie> moviesss = new ArrayList<Movie>();
		moviesss = MovieManager.getMovies();
		
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("=================== Remove Movie ===================");
			System.out.println("1. Remove by Name");
			System.out.println("2. Remove by ID");
			System.out.println("0. Exit");
			switch(choice){
				case 1:
					String name;
					System.out.println("Please enter the Name: ");
					name = sc.next();
					MovieManager.getInstance().removeMovieByName(name);
					break;
				case 2:
					int id;
					System.out.println("Please enter the ID: ");
					id = sc.nextInt();
					MovieManager.getInstance().removeMovieByID(id);
					break;
				case 0:
					System.out.println("Back to Settings Menu......");
					break;
				default:
					System.out.println("Invalid choice. Please choose between 0-8.");
					break;
			}
		} while (choice != 0);
	}*/




	// HOLIDAY FUNCTIONS - DONE
	// list holidays - DONE
	// add holidays - DONE
	// remove holiday - DONE
	public void listHolidays() {
		private ArrayList<Holiday> holiday = new ArrayList<Holiday>();
		holiday = HolidayManager.getHolidays();
		for (int x = 0; x < holiday.size(); x++){
			System.out.println(x+1 + ". " + holiday.get(x).getName());
		}
	}

	public void addNewHoliday(){
		Scanner sc  = new Scanner(System.in);
		String name;
		int date;
    	int dayOfWeeks;
		System.out.println("What is the holiday name: ");
		name = sc.next();
		System.out.println("What is the holiday date: ");
		date = sc.nextInt();
		System.out.println("What is the holiday day of week: ");
		dayOfWeeks = sc.nextInt();

		Holiday newhol = new Holiday(name,date,dayOfWeeks);
		
		HolidayManager.getInstance().addHoliday(newhol);
	}

	public void removeExistingHoliday(){
		Scanner sc  = new Scanner(System.in);
		String name;
		int date;
    	int dayOfWeeks;
		System.out.println("What is the holiday name: ");
		name = sc.next();
		//find date and dayofweek based on name

		Holiday newhol = new Holiday(name,date,dayOfWeeks);
		HolidayManager.getInstance().removeHoliday(newhol);
	}
