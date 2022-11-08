package managers;

import java.util.ArrayList;

import entities.Ticket;
import enums.AgeGroup;

public class TicketManager {
    public ArrayList<Ticket> generateTickets(int exactDateTime, ArrayList<String> seats, ArrayList<AgeGroup> ageGroups) {
        if(seats.size() != ageGroups.size()) return null;

        ArrayList<Ticket> tickets = new ArrayList<Ticket>();

        DateManager dateManager = new DateManager(exactDateTime);

        for(int i = 0; i < seats.size(); i++) {
            Ticket newTicket = new Ticket(
                dateManager.getDayOfWeek(),
                dateManager.getTimeOfDay(),
                dateManager.getTypeOfDay(),
                exactDateTime,
                ageGroups.get(i),
                seats.get(i)
            );

            tickets.add(newTicket);
        }

        return tickets;
    }
}
