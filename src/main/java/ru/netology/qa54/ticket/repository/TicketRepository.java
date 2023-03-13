package ru.netology.qa54.ticket.repository;

import ru.netology.qa54.ticket.domain.Ticket;
import ru.netology.qa54.ticket.exception.AlreadyExistException;
import ru.netology.qa54.ticket.exception.NotFoundException;

public class TicketRepository {

    public Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        if (findById(ticket.getId()) != null) {
            throw new AlreadyExistException(
                    "Ticket with id: " + ticket.getId() + "already exist");
        }

        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void removeToID(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Ticket with id: " + id + " not found"
            );
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
            tickets = tmp;
        }
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public Ticket[] getTickets() {
        return tickets;
    }

}
