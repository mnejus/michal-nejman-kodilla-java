package com.kodilla.pong;

import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import static com.kodilla.pong.Parameters.*;

public class StartGame extends Pane {

    private Runnable onStart = () -> {};

    public void setOnStart(Runnable onStart) {
        this.onStart = onStart;
    }

    public StartGame() {
        Text header = new Text("M-pong");
        header.boundsInLocalProperty().addListener(observable -> {
            header.setTranslateX((WIDTH - header.getBoundsInLocal().getWidth()) / 2);
            header.setTranslateY(TEXT_MARGIN_TOP_BOTTOM);
        });

        header.getStyleClass().add("header");

        Text info = new Text("Use the arrow keys to move\nPress ENTER to start \nPress P to pause\nPress ESC to quit");

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
                onStart.run();
            } else if(event.getCode() == KeyCode.ESCAPE) {
                Platform.exit();
            }
        });
    }
}
