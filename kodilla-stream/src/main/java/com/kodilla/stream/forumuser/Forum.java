package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private final List<ForumUser> usersList = new ArrayList<>();

    public Forum() {
        char sex;
        int year = LocalDate.now().getYear();
        int month = LocalDate.now().getMonthValue();
        int day = LocalDate.now().getDayOfMonth();
        LocalDate date = LocalDate.of(year, month, day);

        for(int n = 0; n < 30; n++) {
            date = LocalDate.of(year - n, month, day);
            if(n % 2 == 0) {
                sex = 'F';
            } else {
                sex = 'M';
            }
            usersList.add(new ForumUser(n, "user"+n, sex, date, n * 10));
        }
    }

    public List<ForumUser> getUserList() { return new ArrayList<>(usersList); }
}
