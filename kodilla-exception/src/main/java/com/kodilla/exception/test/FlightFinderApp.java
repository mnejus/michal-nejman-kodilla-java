package com.kodilla.exception.test;

import java.util.HashMap;

public class FlightFinderApp {

    public static void main(String[] args) {

        HashMap<String, Boolean> airport = new HashMap<>();
        airport.put("Warszawa Okęcie (WAW)", true);
        airport.put("Modlin (WMI)", false);
        airport.put("Wrocław (WRO)", true);
        airport.put("Poznań Ławica (POZ)", true);
        airport.put("Kraków Balice (KRK)", false);
        airport.put("Katowice Pyrzowice (KTW)", false);

        Flight flight = new Flight("Warszawa Okęcie (WAW)", "Modlin (WMI)");
        FindFlight flightFinder = new FindFlight(airport);

        try {
            flightFinder.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println("One of the airports is closed. || " + e);
        } finally {
            System.out.println();
            System.out.println("Find another flight");
        }
    }
}
