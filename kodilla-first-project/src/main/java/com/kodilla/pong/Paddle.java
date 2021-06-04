package com.kodilla.pong;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Paddle extends GameObject {
    private final double speed;

    @Override
    public void update(double deltaTime) {
        if (movement == Movement.DOWN) {
            setY(getY() + speed * deltaTime);
        } else if (movement == Movement.UP) {
            setY(getY() - speed * deltaTime);
        }
    }

    public Paddle(double speed) {
        this.speed = speed;
    }

    public enum Movement {
        UP, DOWN, NONE
    }

    private Movement movement = Movement.NONE;

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    private final IntegerProperty score = new SimpleIntegerProperty(0);

    public int getScore() {
        return score.get();
    }

    public IntegerProperty scoreProperty() {
        return score;
    }

    public void setScore(int score) {
        this.score.set(score);
    }

}
