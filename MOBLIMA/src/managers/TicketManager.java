package managers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import entities.Ticket;
import enums.AgeGroup;

public class TicketManager {
    // CHANGE TO HASHMAP
    public static ArrayList<Ticket> generateTickets(LocalDateTime exactDateTime, HashMap<String, AgeGroup> seats) {
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();

        DateManager dateManager = new DateManager(exactDateTime);

        for(Entry<String, AgeGroup> entry: seats.entrySet()) {
            Ticket newTicket = new Ticket(
                generateTicketID(),
                dateManager.getDayOfWeek(),
                dateManager.getTimeOfDay(),
                dateManager.getTypeOfDay(),
                exactDateTime,
                entry.getValue(),
                entry.getKey()
            );

            tickets.add(newTicket);
        }

        return tickets;
    }

    private static int generateTicketID() {
        return DateManager.getCurrentDateTimeFormatted("yyyyMMddhhmm");
    }
}
