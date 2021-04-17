package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Add and remove figures tests")
    class AddAndRemoveTests {

        @Test
        public void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle("Circle", 8);

            //When
            shapeCollector.addFigure(circle);

            //Then
            assertEquals(1, shapeCollector.shapes.size());
        }

        @Test
        public void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle("Circle", 8);
            shapeCollector.addFigure(circle);

            //When
            boolean result = shapeCollector.removeFigure(circle);

            //Then
            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("Get figures tests")
    class GetTests {

        @Test
        public void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle("Circle", 8);
            shapeCollector.addFigure(circle);

            //When
            Shape result = shapeCollector.getFigure(0);

            //Then
            assertEquals(shapeCollector.shapes.get(0), result);
        }

    }
}
