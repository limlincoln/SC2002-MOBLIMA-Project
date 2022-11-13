package entities;

import enums.DayOfWeek;
import enums.TimeOfDay;

import java.time.LocalDateTime;

import enums.AgeGroup;
import enums.TypeOfDay;

import managers.PricingManager;

/**
 * Class that contains inforamtion about a Ticket
 */
public class Ticket implements IPrice {
    /**
     * The ticket id of this ticket
     */
    private int ticketID;

    /**
     * the day of week of the showtime this ticket was generated for 
     */
    private DayOfWeek dayOfWeek;

    /**
     * the time of day of the showtime this ticket was generated for  
     */
    private TimeOfDay timeOfDay; 

    /**
     * the age group of the showtime this ticket was generated for 
     */
    private AgeGroup ageGroup;

    /**
     * the type of day of the showtime this ticket was generated for 
     */
    private TypeOfDay typeOfDay;

    /**
     * the exact date and time of the showtime this ticket was generated for 
     */
    private LocalDateTime exactDateTime;

    /**
     * the seat this ticket is assigned to
     */
    private String seat;

    /**
     * Constructor for the Ticket Class
     * @param ticketID The ticket id of this ticket
     * @param dayOfWeek the day of week of the showtime this ticket was generated for 
     * @param timeOfDay the time of day of the showtime this ticket was generated for  
     * @param ageGroup the age group of the showtime this ticket was generated for 
     * @param typeOfDay the type of day of the showtime this ticket was generated for 
     * @param exactDateTime the exact date and time of the showtime this ticket was generated for 
     * @param seat the seat this ticket is assigned to
     */
    public Ticket(
        int ticketID,
        DayOfWeek dayOfWeek, 
        TimeOfDay timeOfDay, 
        AgeGroup ageGroup, 
        TypeOfDay typeOfDay, 
        LocalDateTime exactDateTime, 
        String seat
    ) {
        this.ticketID = ticketID;
        this.dayOfWeek = dayOfWeek;
        this.timeOfDay = timeOfDay;
        this.ageGroup = ageGroup;
        this.typeOfDay = typeOfDay;
        this.exactDateTime = exactDateTime;
        this.seat = seat;
    }

    /**
     * get the price associated with this ticket
     * @return the price
     */
    public double getPrice() {
        return 
        PricingManager.getPrice(typeOfDay) + 
        PricingManager.getPrice(timeOfDay) +
        PricingManager.getPrice(ageGroup);
    }

    // GETTERS & SETTERS
    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

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
