package ru.netology.qa54.ticket.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.qa54.ticket.domain.Ticket;
import ru.netology.qa54.ticket.repository.TicketRepository;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 25_000, "DMD", "TH", 9);
    Ticket ticket2 = new Ticket(2, 5000, "SVO", "KZN", 3);
    Ticket ticket3 = new Ticket(3, 6000, "LED", "SVO", 2);
    Ticket ticket4 = new Ticket(4, 18_000, "DMD", "TH", 12);
    Ticket ticket5 = new Ticket(5, 4500, "VKO", "SIP", 4);
    Ticket ticket6 = new Ticket(45, 6500, "DMD", "SIP", 3);

    @BeforeEach
    void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }

    @Test

    public void shouldFindSomeTicket() {

        Ticket[] expected = {ticket4, ticket1};
        Ticket[] actual = manager.findAll("DMD", "TH");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void shouldNotFindTicket() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("DMD", "VKO");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldFindOneTicket() {

        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.findAll("DMD", "SIP");

        Assertions.assertArrayEquals(expected, actual);
    }

}
