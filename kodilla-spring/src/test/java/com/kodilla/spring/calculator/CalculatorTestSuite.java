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
        assertEquals(12, calculator.add(10, 2));
        assertEquals(8, calculator.sub(10, 2));
        assertEquals(20, calculator.mul(10, 2));
        assertEquals(5, calculator.div(10, 2));
        assertEquals(Double.NaN, calculator.div(10,0));
    }
}
