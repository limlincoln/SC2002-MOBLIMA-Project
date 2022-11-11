package managers;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 
import java.time.LocalTime;
import java.time.LocalDate;

import enums.DayOfWeek;
import enums.TimeOfDay;
import enums.TypeOfDay;

public class DateManager {
    private static DateManager single_instance = null;
    private static LocalTime showTimeSlots[] = new LocalTime[8];
    private LocalDateTime exactDateTime = LocalDateTime.now();

    public DateManager() {
        initializeShowTimeSlots();
    }

    public DateManager(LocalDateTime exactDateTime) {
        this.exactDateTime = exactDateTime;
        initializeShowTimeSlots();
    }
    
    public static DateManager getInstance()
    {
        if (single_instance == null)
        single_instance = new DateManager();
        return single_instance;
    }

    private static void initializeShowTimeSlots() {
        for(int i = 0; i < showTimeSlots.length; i++) {
            showTimeSlots[i] = LocalTime.of(i*3, 0);
        } 
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

    public LocalDateTime getExactShowTime(DayOfWeek day, int timeSlotIndex) {
        exactDateTime = LocalDateTime.now().with(showTimeSlots[timeSlotIndex]);

        DayOfWeek today = getDayOfWeek();

        int difference = day.compareTo(today);

        if(difference > 0) {
            return exactDateTime.plusDays(difference);
        } 
        else if (difference < 0) {
            return exactDateTime.plusDays(7 + difference);
        } 
        else {
            return exactDateTime;
        }
    }

    public int getTimeSlotIndex(LocalTime time) {
        for(int i = 0; i < showTimeSlots.length; i++) {
            if(time.compareTo(showTimeSlots[i]) == 0) {
                return i;
            }
        }
        return -1;
    }
}
