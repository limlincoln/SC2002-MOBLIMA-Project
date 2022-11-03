package managers;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.util.Calendar;

enum DayOfWeek {
    SUN,
    MON,
    TUE,
    WED,
    THU,
    FRI,
    SAT,
}

enum TimeOfDay {
    MORNING,
    EVENING
}

public class DateManager {
    public static int getCurrentDateTime(String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();

        return Integer.parseInt(dtf.format(now));
    }

    public static DayOfWeek getDayOfWeek() {
        return DayOfWeek.values()[
            Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1
        ];
    }

    public static boolean isWeekend(DayOfWeek day) {
        if(day == DayOfWeek.SAT || day == DayOfWeek.SUN)
            return true;
        return false;
    }

    public static TimeOfDay getTimeOfDay() {
        int time = getCurrentDateTime("HHmm");

        if(time < 1800) {
            return TimeOfDay.MORNING;
        }

        return TimeOfDay.EVENING;
    }
}
