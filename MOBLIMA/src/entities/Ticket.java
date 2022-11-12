package entities;

import enums.DayOfWeek;
import enums.TimeOfDay;

import java.time.LocalDateTime;

import enums.AgeGroup;
import enums.TypeOfDay;

import managers.PricingManager;

// TODO: Auto-generated Javadoc
/**
 * The Class Ticket.
 */
public class Ticket implements IPrice {
    
    /** The ticket ID. */
    private int ticketID;
    
    /** The day of week. */
    private DayOfWeek dayOfWeek;
    
    /** The time of day. */
    private TimeOfDay timeOfDay; 
    
    /** The age group. */
    private AgeGroup ageGroup;
    
    /** The type of day. */
    private TypeOfDay typeOfDay;
    
    /** The exact date time. */
    private LocalDateTime exactDateTime;
    
    /** The seat. */
    private String seat;

    /**
	 * Instantiates a new ticket.
	 *
	 * @param ticketID      the ticket ID
	 * @param dayOfWeek     the day of week
	 * @param timeOfDay     the time of day
	 * @param typeOfDay     the type of day
	 * @param exactDateTime the exact date time
	 * @param ageGroup      the age group
	 * @param seat          the seat
	 */
    public Ticket(
        int ticketID,
        DayOfWeek dayOfWeek, 
        TimeOfDay timeOfDay, 
        TypeOfDay typeOfDay, 
        LocalDateTime exactDateTime, 
        AgeGroup ageGroup, 
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
	 * Gets the price.
	 *
	 * @return the price
	 */
    public double getPrice() {
        return 
        PricingManager.getPrice(dayOfWeek) + 
        PricingManager.getPrice(timeOfDay) +
        PricingManager.getPrice(ageGroup);
    }

    /**
	 * Gets the ticket ID.
	 *
	 * @return the ticket ID
	 */
    // GETTERS & SETTERS
    public int getTicketID() {
        return ticketID;
    }

    /**
	 * Sets the ticket ID.
	 */
    public void setTicketID() {
        this.ticketID = ticketID;
    }

    /**
	 * Gets the day of week.
	 *
	 * @return the day of week
	 */
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    /**
	 * Sets the day of week.
	 *
	 * @param dayOfWeek the new day of week
	 */
    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    /**
	 * Gets the time of day.
	 *
	 * @return the time of day
	 */
    public TimeOfDay getTimeOfDay() {
        return timeOfDay;
    }

    /**
	 * Sets the time of day.
	 *
	 * @param timeOfDay the new time of day
	 */
    public void setTimeOfDay(TimeOfDay timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    /**
	 * Gets the age group.
	 *
	 * @return the age group
	 */
    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    /**
	 * Sets the age group.
	 *
	 * @param ageGroup the new age group
	 */
    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    /**
	 * Gets the type of day.
	 *
	 * @return the type of day
	 */
    public TypeOfDay getTypeOfDay() {
        return typeOfDay;
    }

    /**
	 * Sets the type of day.
	 *
	 * @param typeOfDay the new type of day
	 */
    public void setTypeOfDay(TypeOfDay typeOfDay) {
        this.typeOfDay = typeOfDay;
    }

    /**
	 * Gets the exact date time.
	 *
	 * @return the exact date time
	 */
    public LocalDateTime getExactDateTime() {
        return exactDateTime;
    }

    /**
	 * Sets the exact date time.
	 *
	 * @param exactDateTime the new exact date time
	 */
    public void setExactDateTime(LocalDateTime exactDateTime) {
        this.exactDateTime = exactDateTime;
    }

    /**
	 * Gets the seat.
	 *
	 * @return the seat
	 */
    public String getSeat() {
        return seat;
    }

    /**
	 * Sets the seat.
	 *
	 * @param seat the new seat
	 */
    public void setSeat(String seat) {
        this.seat = seat;
    }
}
