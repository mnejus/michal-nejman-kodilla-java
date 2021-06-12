package com.kodilla.good.patterns.flights;

import static com.kodilla.good.patterns.flights.Airports.*;

public class App {

    public static void main(String[] args) {

        Flights flights = new Flights();
        Flight flight = new Flight(BZG, WAW, GDN);

        SearchFlight searchFlight = new SearchFlight();
        searchFlight.flightFrom(flight, flights);
        searchFlight.flightTo(flight, flights);
        searchFlight.flightVia(flight, flights);
    }
}
