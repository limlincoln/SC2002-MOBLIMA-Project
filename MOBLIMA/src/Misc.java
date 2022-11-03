import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class BookingManager {

    private Scanner sc = new Scanner(System.in);
    private static Booking[] bookingHistory;

    private int[][] seatsArray;
    // private ArrayList<String> selectedSeats;

    private boolean inSelectedSeats(String seat) {
        for(int i = 0; i < selectedSeats.size(); i++) {
            if(seat == selectedSeats.get(i)) return true;
        }

        return false;
    }

    private boolean isSeat(String testString) {
        // this function needs to be done by the SeatManager

        if(testString.length() != 2) 
            {return false;}
        
        if(
            !Character.isAlphabetic(testString.charAt(0))
            && !Character.isDigit(testString.charAt(1))
        ) {return false;}

        // check if this seat selection is valid
        return true;
    }

    private void addSeat() {
        System.out.print("Enter the seat to select (e.g. A2) ");
        String selectedSeat = sc.next();

        if(isSeat(selectedSeat) && !inSelectedSeats(selectedSeat)) {
            seatsArray[selectedSeat.charAt(0)-65][selectedSeat.charAt(1)] = 1;
            System.out.println("\nSeat selected!");
        } else {
            System.out.println("\nThat is an invalid seat selection!");
        }
    }

    private void removeSeat() {
        System.out.print("Enter the seat to deselect (e.g. A2) ");
        String selectedSeat = sc.next();

        if(isSeat(selectedSeat) && inSelectedSeats(selectedSeat)) {
            seatsArray[selectedSeat.charAt(0)-65][selectedSeat.charAt(1)] = 0;
            System.out.println("\nSeat selection removed!");
        } else {
            System.out.println("\nThat is an invalid seat selection!");
        }
    }

    private void confirmSeats() {
        //
    }

    private int selectSeats() {
        // call seat manager to show seats and get available seats
        // assumption: getAvailableSeats() returns an array of seats
        seatsArray = SeatManager.getAvailableSeats();
        DisplayManager.displaySeats(seatsArray);

        int input;  
        int noOfSeats;      
        seatselector:
        do {
            System.out.println("====Seat Selector====");
            System.out.println("(1) Select seats");
            System.out.println("(2) Deselect seats");
            System.out.println("(3) Confirm seats");
            System.out.println("=====================");
            input = sc.nextInt();

            switch(input) {
                case 1:
                    addSeat();
                    noOfSeats++;
                    break;
                case 2:
                    removeSeat();
                    noOfSeats--;
                    break;
                case 3:
                    if (noOfSeats <= 0) {
                        System.out.println("Please select a seat to confirm!");
                    } else { 
                        confirmSeats();
                        return noOfSeats;
                    }
                    break;
                default:   
                    System.out.println("Invalid input. Retry!");
            } 
        } while(true);

        return noOfSeats;
    }

    public boolean bookTicket(Cineplex cineplex, Customer customer, Movie movie) {
        // ask user to select cinema type
        System.out.println("Select the type of cinema: ");
        int cinemaType[] = cineplex.getCinemaType();
        for(int i = 0; i < cinemaType.length; i++) {
            System.out.println("("+(i+1)+") "+cinemaType[i]);
        }
        int cinemaSelected = sc.nextInt();

        int showtimes[] = ShowtimeManager.getShowtimes(cinemaType[cinemaSelected].getShowTime());

        // starts seat selector (maybe the seat manager can do this)
        SeatManager.selectSeats(showtimeSelected);

        // returns the price of the ticket
        PricingManager.getPrice();

        System.out.println("Confirm Booking? (y/n)");
        char selection = sc.next().charAt(0);

        if(selection == 'y') {
            Booking booking = new Booking();
            updateBookingHistory(Booking booking);
            return true;
        }
        // go back to main
        return false;
    }
}

