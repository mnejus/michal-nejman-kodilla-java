package com.kodilla.pong;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public abstract class GameObject {
    private final DoubleProperty x = new SimpleDoubleProperty(0);

    public double getX() {
        return x.get();
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public void setX(double x) {
        this.x.set(x);
    }

    private final DoubleProperty y = new SimpleDoubleProperty(0);

    public double getY() {
        return y.get();
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public abstract void update(double deltaTime);
}
