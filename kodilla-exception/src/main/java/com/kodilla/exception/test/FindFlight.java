package com.kodilla.exception.test;

import java.util.Map;

public class FindFlight {

    private Map<String, Boolean> flightMap;

    public FindFlight(Map<String, Boolean> flightMap) {
        this.flightMap = flightMap;
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {

        if(!flightMap.containsKey(flight.getDepartureAirport()) || !flightMap.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException("Flight not found");
        } else {
            System.out.println("Flight found");
        }

        return flightMap.entrySet().iterator().next().getValue();
    }
}
