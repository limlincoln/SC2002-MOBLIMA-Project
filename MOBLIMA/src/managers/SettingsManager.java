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
	// EDIT PRICES - DONE
	// EDIT MOVIES - DONE
	// EDIT HOLIDAYS - DONE

	

	// PRICE FUNCTIONS
	// 

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
