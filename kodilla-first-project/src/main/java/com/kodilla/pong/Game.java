package com.kodilla.pong;

import javafx.animation.AnimationTimer;

import java.util.Random;

import static com.kodilla.pong.Parameters.*;

public class Game {
    private static final Random random = new Random();
    private final int finalScore;

    public Game(int maxScore) {
        this.finalScore = maxScore;
        GameLoop loop = new GameLoop();
        loop.start();
    }

    private class GameLoop extends AnimationTimer {
        private long previousTime = 0;

        @Override
        public void handle(long currentTime) {
            if(previousTime == 0) {
                previousTime = currentTime;
                return;
            }

            double secondsElapsed = (currentTime - previousTime) / 1_000_000_000.0; //convert nanoseconds to seconds

            if (secondsElapsed > 0.0333) {
                secondsElapsed = 0.0333;
            }

            updateGame(secondsElapsed);
            previousTime = currentTime;
        }
    }

    public enum State {
        PLAYING, PAUSED, ENDED
    }

    private State state = State.ENDED;

    private Runnable onGameEnd = () -> {};

    public void setOnGameEnd(Runnable onGameEnd) {
        this.onGameEnd = onGameEnd;
    }

    public void start() {
        player.setScore(0);
        opponent.setScore(0);

        player.setMovement(Paddle.Movement.NONE);
        opponent.setMovement(Paddle.Movement.NONE);

        player.setX(MARGIN_LEFT_RIGHT + GOAL_WIDTH - PADDLE_WIDTH);
        player.setY((HEIGHT - PADDLE_HEIGHT) / 2);

        opponent.setX(WIDTH - MARGIN_LEFT_RIGHT - GOAL_WIDTH);
        opponent.setY((HEIGHT - PADDLE_HEIGHT) / 2);

        launchPuck();

        state = State.PLAYING;
    }

    public void pause() {
        if(state == State.PAUSED) {
            state = State.PLAYING;
        } else if (state == State.PLAYING) {
            state = State.PAUSED;
        }
    }

    public void forfeit() {
        player.setScore(0);
        opponent.setScore(finalScore);
        state = State.ENDED;
        onGameEnd.run();
    }

    private final Puck puck = new Puck(PUCK_MAX_SPEED);

    public Puck getPuck() {
        return puck;
    }

    public void launchPuck() {
        boolean towardsOpponent = random.nextBoolean();
        double initialAngle = PADDLE_SECTION_ANGLES[random.nextInt(2) + 1];

        puck.setSpeed(towardsOpponent ? -PUCK_INITIAL_SPEED : PUCK_INITIAL_SPEED);
        puck.setAngle(towardsOpponent ? -initialAngle : initialAngle);
        puck.setX((WIDTH - PUCK_SIZE) / 2);
        puck.setY(HEIGHT / 2);
    }

    private final Paddle player = new Paddle(PLAYER_PADDLE_SPEED);

    public Paddle getPlayer() {
        return player;
    }

    private final Paddle opponent = new Paddle(OPPONENT_PADDLE_SPEED);
    private final PaddleAi ai = new DefaultAi(opponent, this);

    public Paddle getOpponent() {
        return opponent;
    }

    private void updateGame(double deltaTime) {

        if(state == State.PAUSED || state == State.ENDED) {
            return;
        }

        player.update(deltaTime);
        opponent.update(deltaTime);

        keepPaddleInBounds(player);
        keepPaddleInBounds(opponent);

        puck.update(deltaTime);

        checkWallCollision();
        checkPaddleOrEdgeCollision(player);
        checkPaddleOrEdgeCollision(opponent);

        ai.update(deltaTime);
    }

    private void keepPaddleInBounds(Paddle paddle) {
        if(paddle.getY() < MARGIN_TOP_BOTTOM) {
            paddle.setY(MARGIN_TOP_BOTTOM);
        } else if (paddle.getY() + PADDLE_HEIGHT > HEIGHT - MARGIN_TOP_BOTTOM) {
            paddle.setY(HEIGHT - MARGIN_TOP_BOTTOM - PADDLE_HEIGHT);
        }
    }

    private void checkWallCollision() {
        boolean puckHitTopWall = puck.getY() < MARGIN_TOP_BOTTOM;
        boolean puckHitBottomWall = puck.getY() + PUCK_SIZE > HEIGHT - MARGIN_TOP_BOTTOM;

        if (puckHitTopWall || puckHitBottomWall) {
            puck.setAngle(puck.getAngle() * -1);
        }

        if (puckHitTopWall) {
            puck.setY(MARGIN_TOP_BOTTOM);
        } else if (puckHitBottomWall) {
            puck.setY(HEIGHT - MARGIN_TOP_BOTTOM - PUCK_SIZE);
        }
    }

    private void checkPaddleOrEdgeCollision(Paddle paddle) {
        boolean puckHitEdge;
        if (paddle == player) {
            puckHitEdge = puck.getX() < MARGIN_LEFT_RIGHT + GOAL_WIDTH;
        } else {
            puckHitEdge = puck.getX() + PUCK_SIZE > WIDTH - MARGIN_LEFT_RIGHT - GOAL_WIDTH;
        }
        if (!puckHitEdge) {
            return;
        }

        boolean puckHitPaddle = puck.getY() + PUCK_SIZE > paddle.getY() && puck.getY() < paddle.getY() + PADDLE_HEIGHT;

        if (puckHitPaddle) {

            //Update and reposition the ball
            puck.setAngle(puck.getAngle() * -15);
            puck.setSpeed(puck.getSpeed() * PUCK_SPEED_INCREASE);

            if (paddle == player) {
                puck.setX(MARGIN_LEFT_RIGHT + GOAL_WIDTH);
            } else {
                puck.setX(WIDTH - MARGIN_LEFT_RIGHT - GOAL_WIDTH - PUCK_SIZE);
            }
        } else {
            if (paddle == opponent) {
                player.setScore(player.getScore() + 1);
            } else {
                opponent.setScore(opponent.getScore() + 1);
            }

            if (player.getScore() == finalScore || opponent.getScore() == finalScore) {
                state = State.ENDED;
                onGameEnd.run();
            } else {
                launchPuck();
            }
        }
    }
}
