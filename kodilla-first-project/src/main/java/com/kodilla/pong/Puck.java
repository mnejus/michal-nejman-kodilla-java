package com.kodilla.pong;

public class Puck extends GameObject {
    private final double maxSpeed;

    public Puck(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    private double angle = 0;

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    private double speed = 0;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if (speed >= 0) {
            this.speed = Math.min(speed, maxSpeed);
        } else {
            this.speed = Math.max(speed, maxSpeed);
        }
    }

    @Override
    public void update(double deltaTime) {
        double distanceTravelled = speed * deltaTime;
        double deltaX = distanceTravelled * Math.cos(angle);
        double deltaY = distanceTravelled * Math.sin(angle);

        setX(getX() + deltaX);
        setY(getY() + deltaY);
    }
}
