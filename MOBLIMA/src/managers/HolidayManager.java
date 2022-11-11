package managers;
import java.time.LocalDate;
import java.util.ArrayList;

import entities.Holiday;

public class HolidayManager {
    private static ArrayList<Holiday> holidays = new ArrayList<Holiday>();

    public static void addHoliday(Holiday holiday) {
        holidays.add(holiday);
    }

    public static boolean removeHoliday(Holiday holiday) {
        return holidays.remove(holiday);
    }

    public static boolean isHoliday(LocalDate date) {
        for(int i = 0; i < holidays.size(); i++) {
            if(holidays.get(i).getDate().compareTo(date) == 0) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Holiday> getHolidays() {
        return holidays;
    }

    public static void setHolidays(ArrayList<Holiday> holidays) {
        HolidayManager.holidays = holidays;
    }
    
}
