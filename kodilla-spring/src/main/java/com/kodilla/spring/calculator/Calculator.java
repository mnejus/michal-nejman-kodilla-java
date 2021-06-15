package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculator {

    @Autowired
    private Display display;

    public Calculator() {
    }

    public String add(double a, double b) {
        return display.displayValue(a + b);
    }

    public String sub(double a, double b) {
        return display.displayValue(a - b);
    }

    public String mul(double a, double b) {
        return display.displayValue(a * b);
    }

    public String div(double a, double b) {
        if (b != 0) {
            return display.displayValue(a / b);
        } else {
            return "You cannot divide by zero!";
        }
    }
}
