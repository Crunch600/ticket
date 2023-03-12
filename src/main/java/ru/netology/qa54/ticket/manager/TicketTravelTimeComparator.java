package ru.netology.qa54.ticket.manager;
import ru.netology.qa54.ticket.domain.Ticket;

import java.util.Comparator;

public class TicketTravelTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
            return o2.getTravelTime() - o1.getTravelTime();
        }
}
