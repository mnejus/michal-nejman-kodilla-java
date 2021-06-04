package com.kodilla.pong;

import static com.kodilla.pong.Utilities.*;

public class Parameters {

    private Parameters() {}
    public static final int FINAL_SCORE = 10;
//    public static final int TIME_TO_END = 59;
//    public static final int TIME_UPDATE = -1;
    public static final double WIDTH = 568;
    public static final double HEIGHT = 320;
    public static final double MARGIN_TOP_BOTTOM = 10;
    public static final double MARGIN_LEFT_RIGHT = 10;
    public static final double GOAL_WIDTH = 20;
    public static final double TEXT_MARGIN_TOP_BOTTOM = 30;
    public static final double SCORE_SPACING = 300;
    public static final double PUCK_SIZE = 6;
    public static final double PUCK_INITIAL_SPEED = -200;
    public static final double PUCK_SPEED_INCREASE = -1.25;
    public static final double PUCK_MAX_SPEED = 600;
    public static final double PLAYER_PADDLE_SPEED = 500;
    public static final double OPPONENT_PADDLE_SPEED = 450;
    public static final double PADDLE_WIDTH = 5;
    public static final double PADDLE_SECTIONS = 8;
    public static final double PADDLE_SECTION_HEIGHT = PUCK_SIZE;
    public static final double PADDLE_HEIGHT = PADDLE_SECTIONS * PADDLE_SECTION_HEIGHT;
    public static final double[] PADDLE_SECTION_ANGLES = new double[] {degreesToRadians(-60),
            degreesToRadians(-40),
            degreesToRadians(-20),
            degreesToRadians(0),
            degreesToRadians(0),
            degreesToRadians(20),
            degreesToRadians(40),
            degreesToRadians(60)};
}
