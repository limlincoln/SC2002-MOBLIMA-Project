package managers;
import java.time.LocalDate;
import java.util.ArrayList;

import entities.Holiday;

// TODO: Auto-generated Javadoc
/**
 * The Class HolidayManager.
 */
public class HolidayManager {
    
    /** The holidays. */
    private static ArrayList<Holiday> holidays = new ArrayList<Holiday>();

    /**
	 * Add new Holiday.
	 *
	 * @param holiday the holiday
	 */
    public static void addHoliday(Holiday holiday) {
        holidays.add(holiday);
    }

    /**
	 * Remove existing holiday.
	 *
	 * @param holiday the holiday
	 * @return true, if successful
	 */
    public static boolean removeHoliday(Holiday holiday) {
        return holidays.remove(holiday);
    }

    /**
	 * Check if specific date is a holiday.
	 *
	 * @param date the date
	 * @return true, if is holiday
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
	 * Get list of all existing Holidays.
	 *
	 * @return the holidays
	 */
    public static ArrayList<Holiday> getHolidays() {
        return holidays;
    }

    /**
	 * Set all holidays.
	 *
	 * @param holidays the new holidays
	 */
    public static void setHolidays(ArrayList<Holiday> holidays) {
        HolidayManager.holidays = holidays;
    }
    
}
