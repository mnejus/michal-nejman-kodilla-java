package com.kodilla.testing.shape;

public class Circle implements Shape {
    private String shapeName;
    private double radius;
    private double field;

    public Circle(String shapeName, double radius) {
        this.shapeName = shapeName;
        this.radius = radius;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getRadius() {
        return radius;
    }

    public double getField() {
        field = Math.PI * radius * radius;
        return field;
    }
}
