package com.kodilla.testing.shape;

public class Square implements Shape {
    private String shapeName;
    private double a;
    private double field;

    public Square(String shapeName, double a) {
        this.a = a;
        this.shapeName = shapeName;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getA() {
        return a;
    }

    public double getField() {
        field = a * a;
        return field;
    }
}
