package managers;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 
import java.time.LocalTime;
import java.time.LocalDate;

import enums.DayOfWeek;
import enums.TimeOfDay;
import enums.TypeOfDay;

/**
 * Class that manages all date and time related things
 */
public class DateManager {
    /**
     * single instance of the this class
     */
    private static DateManager single_instance = null;

    /**
     * a predifined array descrbing how a day is divided into 
     * different timeslots for the movies to be allocated
     */
    private static LocalTime showTimeSlots[] = new LocalTime[8];

    /**
     * the exact date and time for which to use this manager
     */
    private LocalDateTime exactDateTime = LocalDateTime.now();

    /**
     * The Constructor for the DateManager Class
     */
    public DateManager() {
        initializeShowTimeSlots();
    }

    /**
     * The Constructor for the DateManager Class
     * @param exactDateTime the exact date and time for which to use this manager
     */
    public DateManager(LocalDateTime exactDateTime) {
        this.exactDateTime = exactDateTime;
        initializeShowTimeSlots();
    }
    
    /**
     * get an instance of this class
     * @return DateManager object
     */
    public static DateManager getInstance()
    {
        if (single_instance == null)
        single_instance = new DateManager();
        return single_instance;
    }

    /**
     * Initialises the showtime slot array
     */
    private static void initializeShowTimeSlots() {
        for(int i = 0; i < showTimeSlots.length; i++) {
            showTimeSlots[i] = LocalTime.of(i*3, 0);
        } 
    }
    
    /**
     * get the current date and time
     * @param format the format in which to return the date time
     * @return the current date and time
     */
    public static String getCurrentDateTimeFormatted(String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();

        return dtf.format(now);
    }

    /**
     * Get current day of the week
     * @return day of week
     */
    public DayOfWeek getDayOfWeek() {
        return DayOfWeek.values()[exactDateTime.getDayOfWeek().ordinal()];
    }

    /**
     * Check if input day is a weekend
     * @param day the day to check 
     * @return true if weekend else false
     */
    public boolean isWeekend(DayOfWeek day) {
        if(day == DayOfWeek.SAT || day == DayOfWeek.SUN)
            return true;
        return false;
    }

    /**
     * Get current time of the day
     * @return time of day
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
     * @return type of day
     */
    public TypeOfDay getTypeOfDay() {
        if(HolidayManager.isHoliday(exactDateTime.toLocalDate())) 
        return TypeOfDay.PUBLIC_HOLIDAY;
        
        if(isWeekend(getDayOfWeek()))
        return TypeOfDay.WEEKEND;
        
        return TypeOfDay.WEEKDAY;
    }

    /**
     * generates the exact date and time for a showtime
     * @param day the day in which the movie is showing
     * @param timeSlotIndex the index of the time slot
     * @return the exact date and time for a particular movie showtime
     */
    public LocalDateTime getExactShowTime(DayOfWeek day, int timeSlotIndex) {
        exactDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(timeSlotIndex*3, 0));
        
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
     * @param time the time to use for the slot index
     * @return the time slot index 
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
