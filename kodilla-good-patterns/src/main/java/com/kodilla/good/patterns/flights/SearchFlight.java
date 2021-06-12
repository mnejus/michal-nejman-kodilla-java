package com.kodilla.good.patterns.flights;

public class SearchFlight {

    public void flightFrom(Flight flight, Flights flights) {
        flights.getFlights().entrySet().stream()
                .map(f -> f.getValue())
                .filter(f -> f.getDeparture().equals(flight.getDeparture()))
                .map(f -> "From " + f.getDeparture() + " to " + f.getArrival())
                .forEach(System.out::println);
        System.out.println();
    }

    public void flightTo(Flight flight, Flights flights) {
        flights.getFlights().entrySet().stream()
                .map(f -> f.getValue())
                .filter(f -> f.getArrival().equals(flight.getArrival()))
                .map(f -> "To " + f.getArrival() + " from " + f.getDeparture())
                .forEach(System.out::println);
        System.out.println();
    }

    public void flightVia(Flight flight, Flights flights) {
        flights.getFlights().entrySet().stream()
                .map(f -> f.getValue())
                .filter(f -> f.getDeparture().equals(flight.getDeparture()) || f.getArrival().equals(flight.getArrival()))
                .filter(f -> f.getDeparture().equals(flight.getVia()) || f.getArrival().equals(flight.getArrival()))
                .map(f -> "From " + f.getDeparture() + " via " + f.getVia() + " to " + f.getArrival())
                .forEach(System.out::println);
        System.out.println();
    }
}
