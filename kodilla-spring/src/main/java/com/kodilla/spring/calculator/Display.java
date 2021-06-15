package com.kodilla.spring.calculator;

import org.springframework.stereotype.Service;

@Service
public class Display {

    public String displayValue(double val) {
        return "Value: " + val;
    }
}
