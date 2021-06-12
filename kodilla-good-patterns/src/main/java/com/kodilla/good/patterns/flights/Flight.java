package com.kodilla.good.patterns.flights;

import java.util.Objects;

public class Flight {

    public String departure;
    public String via;
    public String arrival;

    public Flight(String departure, String via, String arrival) {
        this.departure = departure;
        this.via = via;
        this.arrival = arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public String getVia() {
        return via;
    }

    public String getArrival() {
        return arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departure, flight.departure) && Objects.equals(via, flight.via) && Objects.equals(arrival, flight.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departure, via, arrival);
    }

}
