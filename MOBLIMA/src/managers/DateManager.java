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

    /**
     * Initialises each show time slot
     */
    private static void initializeShowTimeSlots() {
        for(int i = 0; i < showTimeSlots.length; i++) {
            showTimeSlots[i] = LocalTime.of(i*3, 0);
        } 
    }
    
    /**
     * Format date and time
     * @param format
     * @return
     */
    public static int getCurrentDateTimeFormatted(String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();

        return Integer.parseInt(dtf.format(now));
    }

    /**
     * Get current day of the week
     * @return
     */
    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.values()[exactDateTime.getDayOfWeek().ordinal()];
    }

    /**
     * Check if input day is a weekend
     * @param day
     * @return
     */
    public boolean isWeekend(DayOfWeek day) {
        if(day == DayOfWeek.SAT || day == DayOfWeek.SUN)
            return true;
        return false;
    }

    /**
     * Get current time of the day
     * @return
     */
    public TimeOfDay getTimeOfDay() {

        LocalTime sixPM = LocalTime.of(18, 0);

        if(exactDateTime.toLocalTime().isAfter(sixPM)) {
            return TimeOfDay.BEFORE_6;
        }

        return TimeOfDay.AFTER_6;
    }

    /**
     * Get current type of day
     * @return
     */
    public TypeOfDay getTypeOfDay() {
        if(HolidayManager.isHoliday(exactDateTime.toLocalDate())) 
        return TypeOfDay.PUBLIC_HOLIDAY;
        
        if(isWeekend(getDayOfWeek()))
        return TypeOfDay.WEEKEND;
        
        return TypeOfDay.WEEKDAY;
    }

    /**
     * Get exact showtime slot of the day and timeslot
     * @param day
     * @param timeSlotIndex
     * @return
     */
    public LocalDateTime getExactShowTime(DayOfWeek day, int timeSlotIndex) {
        exactDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(timeSlotIndex, 0));
        
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

    /**
     * Get show time slot index based on the time
     * @param time
     * @return
     */
    public int getTimeSlotIndex(LocalTime time) {
        for(int i = 0; i < showTimeSlots.length; i++) {
            if(time.compareTo(showTimeSlots[i]) == 0) {
                return i;
            }
        }
        return -1;
    }
}
