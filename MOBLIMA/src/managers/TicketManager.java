package managers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import entities.Ticket;
import enums.AgeGroup;
import utils.IDGenerator;

/**
 * The class to manage tickets
 */
public class TicketManager {
    /**
     * Generate list of tickets 
     * @param exactDateTime the exact date and time of the showtime of the movie
     * @param seats the seats (including seat no. and agegroup) for the movie booking
     * @return an array list of generated seats
     */
    public static ArrayList<Ticket> generateTickets(LocalDateTime exactDateTime, HashMap<String, AgeGroup> seats) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();

        DateManager dateManager = new DateManager(exactDateTime);

        for(Entry<String, AgeGroup> entry: seats.entrySet()) {
            Ticket newTicket = new Ticket(
                generateTicketID(),
                dateManager.getDayOfWeek(),
                dateManager.getTimeOfDay(),
                entry.getValue(),
                dateManager.getTypeOfDay(),
                exactDateTime,
                entry.getKey()
            );

            tickets.add(newTicket);
        }

        return tickets;
    }

    /**
     * generate a ticket ID for the ticket
     * @return ticket ID
     */
    private static int generateTicketID() {
        return IDGenerator.get();
    }
}
