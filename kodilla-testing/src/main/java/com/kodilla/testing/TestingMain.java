package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

import java.util.Objects;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        //test calculator
        Calculator calculator = new Calculator(3, 4);

        int addResult = calculator.add();
        int subtractResult = calculator.subtract();

        if (addResult == 7) {
            System.out.println("Calc add: Test OK");
        } else {
            System.out.println("Calc add: Error!");
        }

        if (subtractResult == 1) {
            System.out.println("Calc subtract: Test OK");
        } else {
            System.out.println("Calc subtract: Error!");
        }

    }
}
