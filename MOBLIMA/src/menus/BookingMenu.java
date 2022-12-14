package menus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import caculators.PriceCalculator;
import entities.Cinema;
import entities.Customer;
import entities.IPrice;
import entities.Movie;
import managers.BookingManager;
import managers.PricingManager;
import managers.SeatSelector;
import managers.TicketManager;
import entities.Seats;
import entities.Ticket;
import enums.AgeGroup;
/**
 * Menu to display booking
 */
public class BookingMenu {
    /** 
     * Single instance of BookingMenu 
     */
    private static BookingMenu single_instance = null;
    
    private BookingMenu(){}

    /**
     * Get or creates the single instance of BookingMenu class
     * @return BookingMenu Class
     */
    public static BookingMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new BookingMenu();
        return single_instance;
    }

    /**
     * Display Booking menu
     * @param movie
     * @param cinema
     * @param seats
     * @param showTime
     */
    public void displayBookingMenu(Movie movie, Cinema cinema, Seats seats, LocalDateTime showTime) { 
        
        // CALL SEAT SELECTOR (MIGHT RETURN NULL)

        SeatSelector seatSelector = new SeatSelector();
        HashMap<String, AgeGroup> selectedSeats = seatSelector.StartSeatSelectionInstance(seats);
        if(selectedSeats == null || selectedSeats.size() ==0){
            return;
        }

        ArrayList<Ticket> tickets = TicketManager.generateTickets(showTime, selectedSeats);
        int noOfSeats = tickets.size();

        ArrayList<IPrice> prices = new ArrayList<IPrice>();
        prices.addAll(tickets);
        for(int i=0; i<noOfSeats; i++){
            prices.add(cinema);
        }

        double totalPrice = PriceCalculator.getTotalPrice(prices, noOfSeats);
        PricingManager.showPriceMatrix();
        System.out.println("Total Price: "+totalPrice);


        Customer newCustomer = CustomerFormMenu.startFullForm();
    
        BookingManager.createBooking(cinema.getCinemaID(), movie.getMovieID(), newCustomer, tickets, totalPrice, -1);

        System.out.println("Booking Complete!");
    }
}
