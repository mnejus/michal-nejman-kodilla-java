package com.kodilla.good.patterns.srp;

import java.time.LocalDateTime;

public class RentRequestRetriever {

    public RentRequest retrieve() {
        User user = new User("Jan", "Nowak");
        LocalDateTime rentFrom = LocalDateTime.of(2020, 10, 1, 12, 0);
        LocalDateTime rentTo = LocalDateTime.of(2020, 10, 2, 12, 0);

        return new RentRequest(user, rentFrom, rentTo);
    }
}
