package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final boolean makeTask(final String taskClass) {
        switch (taskClass) {
            case SHOPPING:
                ShoppingTask shoppingTask = new ShoppingTask("Grocery shopping", "carrot", 12.50);
                if (shoppingTask.getTaskName() != null) {
                    shoppingTask.executeTask();
                    return true;
                }
                return false;
            case PAINTING:
                PaintingTask paintingTask = new PaintingTask("Painting inside", "red", "paint the walls");
                if (paintingTask.getTaskName() != null) {
                    paintingTask.executeTask();
                    return true;
                }
                return false;
            case DRIVING:
                DrivingTask drivingTask = new DrivingTask("Driving", "in the forest", "quad");
                if (drivingTask.getTaskName() != null) {
                    drivingTask.executeTask();
                    return true;
                }
                return false;
            default:
                return false;
        }
    }
}
