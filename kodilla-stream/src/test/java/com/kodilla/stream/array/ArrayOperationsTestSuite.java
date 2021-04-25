package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        //When
        double result = ArrayOperations.getAverage(array);

        //Then
        assertEquals(4.5, result);
    }
}
