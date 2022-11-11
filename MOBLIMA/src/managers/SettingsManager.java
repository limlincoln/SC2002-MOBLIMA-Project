package managers;

import enums.*;
import menus.ITop5Menu;

public class SettingsManager {
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
	public static void initialiser(ITop5Menu customerTop5Value){
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
	// EDIT HOLIDAYS
