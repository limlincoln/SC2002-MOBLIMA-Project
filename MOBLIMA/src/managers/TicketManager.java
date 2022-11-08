package managers;

import java.util.ArrayList;

import entities.Ticket;

public class TicketManager {
    private static ArrayList<Ticket> tickets;
    
    public static void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public static void resetTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    public static ArrayList<Ticket> getAllTickets() {
        return tickets;
    }

    //TODO: CREATE TICKETS AND RETURN ARRAYLIST OF THEM 
    // WILL GET A ARRAYLIST: {SEAT STRING, AGEGROUP}
    // GET DATE TIME INFO FROM DATA MANAGER
    // RETURN ARRAY OF TICKETS
}
