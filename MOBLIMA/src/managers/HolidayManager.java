package managers;
import java.time.LocalDate;
import java.util.ArrayList;

import entities.Holiday;

public class HolidayManager {
    private static ArrayList<Holiday> holidays = new ArrayList<Holiday>();

    /**
     * Add new Holiday
     * @param holiday
     */
    public static void addHoliday(Holiday holiday) {
        holidays.add(holiday);
    }

    /**
     * Remove existing holiday
     * @param holiday
     * @return
     */
    public static boolean removeHoliday(Holiday holiday) {
        return holidays.remove(holiday);
    }

    /**
     * Check if specific date is a holiday
     * @param date
     * @return
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
