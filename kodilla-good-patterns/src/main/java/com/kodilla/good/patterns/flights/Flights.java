package com.kodilla.good.patterns.flights;

import java.util.HashMap;
import java.util.Map;

import static com.kodilla.good.patterns.flights.Airports.*;

public class Flights {

    private final Map<Integer, Flight> flights;

    public Flights() {

        flights = new HashMap<>();

        flights.put(1, new Flight(BZG, WAW, GDN));
        flights.put(2, new Flight(GDN, KTW, KRK));
        flights.put(3, new Flight(KRK, LUZ, GDN));
        flights.put(4, new Flight(LCJ, SZY, SZZ));
        flights.put(5, new Flight(POZ, RZE, WAW));
        flights.put(6, new Flight(SZZ, WAW, KRK));
        flights.put(7, new Flight(WRO, IEG, LCJ));

    }

    public Map<Integer, Flight> getFlights() { return new HashMap<>(flights); }

}
