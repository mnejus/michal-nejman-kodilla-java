package com.kodilla.pong;

import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;

import static com.kodilla.pong.Parameters.*;

public class EndGame extends Pane {
    private Runnable onRestart = () -> {};

    public void setOnRestart(Runnable onRestart) {
        this.onRestart = onRestart;
    }

    private final Text header = new Text();

    public void setScore(int playerScore) {
        header.setText(playerScore == FINAL_SCORE ? "you win" : "you lose");
    }

    public EndGame() {
        header.boundsInLocalProperty().addListener(observable -> {
            header.setTranslateX((WIDTH - header.getBoundsInLocal().getWidth()) / 2);
            header.setTranslateY(TEXT_MARGIN_TOP_BOTTOM);
        });
        header.getStyleClass().add("header");

        Text info = new Text("press enter to restart\npress escape to quit");
        info.boundsInLocalProperty().addListener(observable -> {
            info.setTranslateX((WIDTH - info.getBoundsInLocal().getWidth()) / 2);
            info.setTranslateY(HEIGHT - TEXT_MARGIN_TOP_BOTTOM - info.getBoundsInLocal().getHeight());
        });
        info.getStyleClass().add("info");

        setPrefSize(WIDTH, HEIGHT);
        getChildren().addAll(header, info);
        getStyleClass().add("screen");

        setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER) {
                onRestart.run();
            } else if (event.getCode() == KeyCode.ESCAPE) {
                Platform.exit();
            }
        });
    }
}
