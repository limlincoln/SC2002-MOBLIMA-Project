package menus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import caculators.PriceCalculator;
import entities.Cinema;
import entities.Customer;
import entities.IPrice;
import entities.Movie;
import managers.BookingManager;
import managers.DateManager;
import managers.PricingManager;
import managers.SeatSelector;
import managers.TicketManager;
import entities.Seats;
import entities.Ticket;
import enums.AgeGroup;

public class BookingMenu {
    private static BookingMenu single_instance = null;
    
    private Scanner sc = new Scanner(System.in);

    private BookingMenu(){}


    public static BookingMenu getInstance()
    {
        if (single_instance == null)
            single_instance = new BookingMenu();
        return single_instance;
    }

    public Customer showCustomerDetailsForm() {
        String userName;
        String phoneNumber;
        String email;

        System.out.println("Enter Username: ");
        userName = sc.nextLine();

        System.out.println("Enter Phone Number: ");
        phoneNumber = sc.nextLine();

        System.out.println("Email Address: ");
        email = sc.nextLine();

        Random rand = new Random();
        Customer newCustomer = new Customer(DateManager.getCurrentDateTimeFormatted("hhmmss")+rand.nextInt(1000), userName, email, phoneNumber);

        return newCustomer;
    }

  
    public void displayBookingMenu(Movie movie, Cinema cinema, Seats seats, LocalDateTime showTime) { 
        
        // CALL SEAT SELECTOR (MIGHT RETURN NULL)

        SeatSelector seatSelector = new SeatSelector();
        HashMap<String, AgeGroup> selectedSeats = seatSelector.StartSeatSelectionInstance(seats);

        ArrayList<Ticket> tickets = TicketManager.generateTickets(showTime, selectedSeats);
        int noOfSeats = tickets.size();

        ArrayList<IPrice> prices = new ArrayList<IPrice>();
        prices.addAll(tickets);
        prices.add(cinema);

        double totalPrice = PriceCalculator.getTotalPrice(prices, noOfSeats);
        PricingManager.showPriceMatrix();
        System.out.println("Total Price: "+totalPrice);


        Customer newCustomer = showCustomerDetailsForm();
    
        BookingManager.createBooking(cinema.getCinemaID(), movie.getMovieID(), newCustomer, tickets, totalPrice);

        System.out.println("BOOKEDJFHJDKJJHKJKSAKJAS!!!");

        // SEATSELECTOR.STARTINSTANCE(SEATS): ARRAY OF SELECTED SEAT INFO
        // CALL TICKETMANAGER: ARRAY OF TICKETS + LOCALDATETIME
        // CREATE AN ARRAYLIST OF IPRICE INCLUDING TICKETS + CINEMA 
        // CALL PRICE.GETTOTALPRICE(): ARRALIST<IPRICE>, TICKETSARRAY.SIZE()
        // ASK CUSTOMER DETAILS (username, phone, email)
        // CREATE CUSTOMER CLASS
        // CALL BOOKING MANAGER: 
        // CREATEBOOKING: cinemaID, movieID, CUSTOMER CLASS, TICKETS ARRAYLIST, TOTALCOST

        // THANK YOU :)
    }
}
