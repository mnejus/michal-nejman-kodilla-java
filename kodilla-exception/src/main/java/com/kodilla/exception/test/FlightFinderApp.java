package com.kodilla.exception.test;

import java.util.HashMap;

public class FlightFinderApp {
    public static void main(String[] args) {

        HashMap<String, Boolean> flightMap = new HashMap<>();
        flightMap.put("Warszawa Okęcie (WAW)", true);
        flightMap.put("Modlin (WMI)", true);
        flightMap.put("Wrocław (WRO)", true);
        flightMap.put("Poznań Ławica (POZ)", true);
        flightMap.put("Kraków Balice (KRK)", true);
        flightMap.put("Katowice Pyrzowice (KTW)", true);

        Flight flight = new Flight("Warszawa Okęcie (WAW)", "Rzym Fiumicino (FCO)");
        //Flight flight = new Flight("Warszawa Okęcie (WAW)", "Modlin (WMI)");
        FindFlight flightFinder = new FindFlight(flightMap);

        try {
            flightFinder.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println("One of the airports is unsupported. || " + e);
        } finally {
            System.out.println();
            System.out.println("Find another flight");
        }
    }
}
