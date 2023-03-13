package ru.netology.qa54.ticket.domain;

public class Ticket implements Comparable<Ticket> {

    protected int id;
    protected int price;
    protected String fromAirport;
    protected String toAirport;
    protected int travelTime;


    public Ticket(int id, int price, String fromAirport, String toAirport, int travelTime) {
        this.id = id;
        this.price = price;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String departureAirport) {
        this.fromAirport = departureAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String arrivalAirport) {
        this.toAirport = arrivalAirport;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public int compareTo(Ticket o) {
        if (price < o.getPrice()) {
            return -1;
        } else if (price > o.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }
}
