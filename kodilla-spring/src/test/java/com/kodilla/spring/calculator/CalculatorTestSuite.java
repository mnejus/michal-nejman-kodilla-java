package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    Calculator calculator;

    @Test
    void testCalculations() {
        //Given
        //When
        //Then
        assertEquals("Value: 12.0", calculator.add(10, 2));
        assertEquals("Value: 8.0", calculator.sub(10, 2));
        assertEquals("Value: 20.0", calculator.mul(10, 2));
        assertEquals("Value: 5.0", calculator.div(10, 2));
        assertEquals("You cannot divide by zero!", calculator.div(10,0));
    }
}
