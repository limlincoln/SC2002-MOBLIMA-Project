package entities;

import enums.DayOfWeek;
import enums.TimeOfDay;

import java.time.LocalDateTime;

import enums.AgeGroup;
import enums.TypeOfDay;

import managers.PricingManager;

public class Ticket implements IPrice {
    private DayOfWeek dayOfWeek;
    private TimeOfDay timeOfDay; 
    private AgeGroup ageGroup;
    private TypeOfDay typeOfDay;
    private LocalDateTime exactDateTime;
    private String seat;

    public Ticket(
        DayOfWeek dayOfWeek, 
        TimeOfDay timeOfDay, 
        TypeOfDay typeOfDay, 
        LocalDateTime exactDateTime, 
        AgeGroup ageGroup, 
        String seat
    ) {
        this.dayOfWeek = dayOfWeek;
        this.timeOfDay = timeOfDay;
        this.ageGroup = ageGroup;
        this.typeOfDay = typeOfDay;
        this.exactDateTime = exactDateTime;
        this.seat = seat;
    }

    public double getPrice() {
        return 
        PricingManager.getPrice(dayOfWeek) + 
        PricingManager.getPrice(timeOfDay) +
        PricingManager.getPrice(ageGroup);
    }

    // GETTERS & SETTERS
    public DayOfWeek getDayOfWeek() {
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

    public TypeOfDay getTypeOfDay() {
        return typeOfDay;
    }

    public void setTypeOfDay(TypeOfDay typeOfDay) {
        this.typeOfDay = typeOfDay;
    }

    public LocalDateTime getExactDateTime() {
        return exactDateTime;
    }

    public void setExactDateTime(LocalDateTime exactDateTime) {
        this.exactDateTime = exactDateTime;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}
