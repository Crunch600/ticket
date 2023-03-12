package ru.netology.qa54.ticket.manager;

import ru.netology.qa54.ticket.domain.Ticket;
import ru.netology.qa54.ticket.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {

    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {

        repo.save(ticket);
    }

    public Ticket[] findAll(String fromAirport, String toAirport) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getTickets()) {
            if (matches(ticket, fromAirport, toAirport)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;

    }

    public boolean matches(Ticket ticket, String fromAirport, String toAirport) {
            if (ticket.getFromAirport().equals(fromAirport)) {
                if (ticket.getToAirport().equals(toAirport)) {
                    return true;
                }
            }
        return false;
    }


}




