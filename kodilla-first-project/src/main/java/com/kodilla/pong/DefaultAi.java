package com.kodilla.pong;

import static com.kodilla.pong.Parameters.*;

public class DefaultAi extends PaddleAi{

    private static final double timeBetweenUpdates = 0.2;

    public DefaultAi(Paddle paddle, Game game) {
        super(paddle, game);
    }

    private double timeSinceLastUpdate = 0;

    @Override
    public void update(double deltaTime)
    {
        timeSinceLastUpdate += deltaTime;

        if (timeSinceLastUpdate < timeBetweenUpdates) {
            return;
        }

        timeSinceLastUpdate -= timeBetweenUpdates;

        double distanceFromPaddle = getPaddle().getX() - getGame().getPuck().getX();

        if (Math.signum(distanceFromPaddle) != Math.signum(getGame().getPuck().getSpeed())) {
            getPaddle().setMovement(Paddle.Movement.NONE);
            return;
        }

        double targetY = getGame().getPuck().getY() + distanceFromPaddle * Math.tan(getGame().getPuck().getAngle());
        boolean paddleOnTarget = targetY >= getPaddle().getY() && targetY + PUCK_SIZE <= getPaddle().getY() + PADDLE_HEIGHT;

        if (paddleOnTarget) {
            getPaddle().setMovement(Paddle.Movement.NONE);
        } else if (targetY < getPaddle().getY()) {
            getPaddle().setMovement(Paddle.Movement.UP);
        } else if (targetY > getPaddle().getY()) {
            getPaddle().setMovement(Paddle.Movement.DOWN);
        }
    }
}
