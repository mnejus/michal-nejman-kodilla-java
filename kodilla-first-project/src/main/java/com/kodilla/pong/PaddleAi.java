package com.kodilla.pong;

public abstract class PaddleAi {

    private final Paddle paddle;
    private final Game game;

    protected PaddleAi(Paddle paddle, Game game) {
        this.paddle = paddle;
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public abstract void update(double deltaTime);
}
