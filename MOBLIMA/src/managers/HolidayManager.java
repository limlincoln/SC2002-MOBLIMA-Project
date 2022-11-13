package managers;
import java.time.LocalDate;
import java.util.ArrayList;

import entities.Holiday;

/**
 * Class that manages things related to Holidays and contains a list of holidays based on the Database
 */
public class HolidayManager {
    /**
     * a list of existing holidays from the database
     */
    private static ArrayList<Holiday> holidays = new ArrayList<Holiday>();

    /**
     * Add new Holiday
     * @param holiday the holiday to add
     */
    public static void addHoliday(Holiday holiday) {
        holidays.add(holiday);
    }

    /**
     * Remove existing holiday
     * @param holiday the holiday to remove
     * @return true if successful false otherwise
     */
    public static boolean removeHoliday(Holiday holiday) {
        return holidays.remove(holiday);
    }

    /**
     * Check if specific date is a holiday
     * @param date date to check
     * @return true if holiday else false
     */
    public static boolean isHoliday(LocalDate date) {
        for(int i = 0; i < holidays.size(); i++) {
            if(holidays.get(i).getDate().compareTo(date) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if a holiday with this name exists
     * @param nameOfHoliday name of the holiday to check for
     * @return true if exists false otherwise
     */
    public static boolean isHoliday(String nameOfHoliday) {
        for(int i = 0; i < holidays.size(); i++) {
            if(holidays.get(i).getName().toLowerCase().equals(nameOfHoliday.toLowerCase())) {
                return true;
            }
        }
        return false; 
    }

    /**
     * Get list of all existing Holidays
     */
    public static ArrayList<Holiday> getHolidays() {
        return holidays;
    }

    /**
     * Set all holidays
     * @param holidays
     */
    public static void setHolidays(ArrayList<Holiday> holidays) {
        HolidayManager.holidays = holidays;
    }
    
}
