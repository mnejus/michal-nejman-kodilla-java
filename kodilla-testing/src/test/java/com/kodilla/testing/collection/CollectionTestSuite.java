package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test case: end");
        System.out.println();
    }

    @DisplayName("when the list is empty, then should not return error")
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        //When
        OddNumbersExterminator.exterminate(numbers);
        int result = numbers.size();
        //Then
        Assertions.assertEquals(result, 0);
    }

    @DisplayName("when the numbers in list are odd and even, then should return only even numbers")
    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++){
            numbers.add(i);
        }
        //When
        OddNumbersExterminator.exterminate(numbers);
        ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++){
            if(i % 2 == 0) {
                evenNumbers.add(i);
            }
        }
        //Then
        for (int n = 0; n < numbers.size(); n++) {
            Assertions.assertEquals(evenNumbers.get(n), numbers.get(n));
        }
    }
}
