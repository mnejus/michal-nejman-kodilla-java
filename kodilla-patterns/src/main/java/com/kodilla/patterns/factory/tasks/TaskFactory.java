package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                return new ShoppingTask("Grocery shopping", "carrot", 12.50);
            case PAINTING:
                return new PaintingTask("Painting inside", "red", "paint the walls");
            case DRIVING:
                return new DrivingTask("Driving", "in the forest", "quad");
            default:
                return null;
        }
    }
}
