package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        boolean shopping = factory.makeTask(TaskFactory.SHOPPING);
        //Then
        assertEquals(true, shopping);
    }

    @Test
    void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        boolean driving = factory.makeTask(TaskFactory.DRIVING);
        //Then
        assertEquals(true, driving);
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        boolean painting = factory.makeTask(TaskFactory.PAINTING);
        //Then
        assertEquals(true, painting);
    }
}
