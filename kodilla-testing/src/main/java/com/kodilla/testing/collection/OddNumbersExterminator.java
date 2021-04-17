package com.kodilla.testing.collection;

import java.util.ArrayList;

public class OddNumbersExterminator {

    public static ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        for (int n = 0; n < numbers.size(); n++) {
            if ((numbers.get(n)  % 2) != 0) {
                numbers.remove(n);
            }
        }
        return numbers;
    }

}
