package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private String shapeName;
    private double a;
    private double h;
    private double field;

    public Triangle(String shapeName, double a, double h) {
        this.shapeName = shapeName;
        this.a = a;
        this.h = h;
    }

    public String getShapeName() {
        return shapeName;
    }

    public double getA() {
        return a;
    }

    public double getH() {
        return h;
    }

    public double getField() {
        field = (a * h) / 2;
        return field;
    }
}
