package entities;

import enums.DayOfWeek;
import enums.TimeOfDay;
import enums.AgeGroup;

public class Ticket {
    private DayOfWeek dayOfWeek;
    private TimeOfDay timeOfDay; 
    private AgeGroup ageGroup;

    public Ticket(DayOfWeek dayOfWeek, TimeOfDay timeOfDay, AgeGroup ageGroup) {
        this.dayOfWeek = dayOfWeek;
        this.timeOfDay = timeOfDay;
        this.ageGroup = ageGroup;
    }

    // GETTERS & SETTERS
    public DayOfWeek getdDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public TimeOfDay getTimeOfDay() {
        return timeOfDay;
    }
    
    public void setTimeOfDay(TimeOfDay timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

}
