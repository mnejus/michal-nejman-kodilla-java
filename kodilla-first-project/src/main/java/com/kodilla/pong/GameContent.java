package com.kodilla.pong;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import com.kodilla.pong.Paddle.*;

import static com.kodilla.pong.Parameters.*;

public class GameContent extends Pane {
    private final Game game;
    private final Text playerScore = new Text("0");

    public GameContent(Game game) {
        this.game = game;

        Rectangle puck = new Rectangle(PUCK_SIZE, PUCK_SIZE);
        puck.translateXProperty().bind(game.getPuck().xProperty());
        puck.translateYProperty().bind(game.getPuck().yProperty());
        puck.getStyleClass().add("ball");

        Rectangle player = new Rectangle(PADDLE_WIDTH, PADDLE_HEIGHT);
        player.translateXProperty().bind(game.getPlayer().xProperty());
        player.translateYProperty().bind(game.getPlayer().yProperty());
        player.getStyleClass().add("paddle");

        Rectangle opponent = new Rectangle(PADDLE_WIDTH, PADDLE_HEIGHT);
        opponent.translateXProperty().bind(game.getOpponent().xProperty());
        opponent.translateYProperty().bind(game.getOpponent().yProperty());
        opponent.getStyleClass().add("paddle");

        playerScore.textProperty().bind(game.getPlayer().scoreProperty().asString());
        playerScore.boundsInLocalProperty().addListener(observable -> playerScore.setTranslateX(WIDTH / 2 - SCORE_SPACING / 2 - playerScore.getBoundsInLocal().getWidth()));

        playerScore.setTranslateY(TEXT_MARGIN_TOP_BOTTOM);
        playerScore.getStyleClass().add("score");

        Text opponentScore = new Text("0");
        opponentScore.textProperty().bind(game.getOpponent().scoreProperty().asString());
        opponentScore.setTranslateX(WIDTH / 2 + SCORE_SPACING / 2);
        opponentScore.setTranslateY(TEXT_MARGIN_TOP_BOTTOM);
        opponentScore.getStyleClass().add("score");

//        Text counter = new Text("00");
//        counter.textProperty().bind(game.getTimer().timeProperty().asString());
//        counter.setTranslateX(WIDTH / 2 - 22);
//        counter.setTranslateY(TEXT_MARGIN_TOP_BOTTOM);
//        counter.getStyleClass().add("counter");

        setPrefSize(WIDTH, HEIGHT);
        getChildren().addAll(puck, player, opponent, playerScore, opponentScore);
        getStyleClass().add("screen");

        setOnKeyPressed(this::keyPressed);
        setOnKeyReleased(this::keyReleased);
    }

    private void keyPressed(KeyEvent event)
    {
        if (event.getCode() == KeyCode.P) {
            game.pause();
        } else if (event.getCode() == KeyCode.ESCAPE) {
            game.forfeit();
        } else if (game.getPlayer().getMovement() == Paddle.Movement.NONE && event.getCode() == KeyCode.UP) {
            game.getPlayer().setMovement(Movement.UP);
        } else if (game.getPlayer().getMovement() == Movement.NONE && event.getCode() == KeyCode.DOWN) {
            game.getPlayer().setMovement(Movement.DOWN);
        }
    }

    private void keyReleased(KeyEvent event)
    {
        if (game.getPlayer().getMovement() == Movement.UP && event.getCode() == KeyCode.UP) {
            game.getPlayer().setMovement(Movement.NONE);
        } else if (game.getPlayer().getMovement() == Movement.DOWN && event.getCode() == KeyCode.DOWN) {
            game.getPlayer().setMovement(Movement.NONE);
        }
    }
}
