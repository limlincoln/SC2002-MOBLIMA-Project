package managers;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 
import java.time.LocalTime;
import java.time.LocalDate;

import enums.DayOfWeek;
import enums.TimeOfDay;
import enums.TypeOfDay;

public class DateManager {
    // ADD A GET INSTANCE
    private LocalDateTime exactDateTime = LocalDateTime.now();
    private static DateManager single_instance = null;

    public DateManager() {}

    public DateManager(LocalDateTime exactDateTime) {
        this.exactDateTime = exactDateTime;
    }

    public static DateManager getInstance()
    {
        if (single_instance == null)
            single_instance = new DateManager();
        return single_instance;
    }

    public static int getCurrentDateTimeFormatted(String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();

        return Integer.parseInt(dtf.format(now));
    }

    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.values()[exactDateTime.getDayOfWeek().ordinal()];
    }

    public boolean isWeekend(DayOfWeek day) {
        if(day == DayOfWeek.SAT || day == DayOfWeek.SUN)
            return true;
        return false;
    }

    public TimeOfDay getTimeOfDay() {

        LocalTime sixPM = LocalTime.of(18, 0);

        if(exactDateTime.toLocalTime().isAfter(sixPM)) {
            return TimeOfDay.BEFORE_6;
        }

        return TimeOfDay.AFTER_6;
    }

    public TypeOfDay getTypeOfDay() {
        if(HolidayManager.isHoliday(exactDateTime.toLocalDate())) 
            return TypeOfDay.PUBLIC_HOLIDAY;

        if(isWeekend(getDayOfWeek()))
            return TypeOfDay.WEEKEND;
        
        return TypeOfDay.WEEKDAY;
    }
}
