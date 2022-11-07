package managers;
import java.util.ArrayList;

import entities.Holiday;

public class HolidayManager {
    private static ArrayList<Holiday> holidays = new ArrayList<Holiday>();

    public void addHoliday(Holiday holiday) {
        holidays.add(holiday);
    }

    public boolean removeHoliday(Holiday holiday) {
        return holidays.remove(holiday);
    }

    public static boolean isHoliday(int date) {
        for(int i = 0; i < holidays.size(); i++) {
            if(holidays.get(i).getDate() == date) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(ArrayList<Holiday> holidays) {
        HolidayManager.holidays = holidays;
    }
    
}
