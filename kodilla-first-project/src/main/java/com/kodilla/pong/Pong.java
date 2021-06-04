package com.kodilla.pong;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

import static com.kodilla.pong.Parameters.*;

public class Pong extends Application {

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game(FINAL_SCORE);
        Group content = new Group();
        Scene scene = new Scene(new Group(content), WIDTH, HEIGHT, Color.BLACK);
        scene.getStylesheets().add("/style.css");

        Font.loadFont(getClass().getResource("/game-play.ttf").toExternalForm(), 0);

        Scale scale = Transform.scale(1, 1, 0, 0);
        content.getTransforms().add(scale);

        GameContent gameContent = new GameContent(game);
        StartGame startGame = new StartGame();
        EndGame endGame = new EndGame();

        content.getChildren().add(startGame);

        startGame.setOnStart(() -> {
            content.getChildren().clear();
            content.getChildren().add(gameContent);
            gameContent.requestFocus();
            game.start();
        });

        game.setOnGameEnd(() -> {
            content.getChildren().clear();
            content.getChildren().add(endGame);
            endGame.requestFocus();
            endGame.setScore(game.getPlayer().getScore());
        });

        endGame.setOnRestart(() -> {
           content.getChildren().clear();
           content.getChildren().add(gameContent);
           gameContent.requestFocus();
           game.start();
        });

        InvalidationListener updateScale = value -> {
            double scaleX = scene.getWidth() / WIDTH;
            double scaleY = scene.getHeight() / HEIGHT;

            if(scaleX < scaleY) {
                scale.setX(scaleX);
                scale.setY(scaleX);

                double remainingHeight = scene.getHeight() - HEIGHT * scaleX;

                content.setTranslateX(0);
                content.setTranslateY(remainingHeight / 2);
            } else if(scaleY < scaleX) {
                scale.setX(scaleY);
                scale.setY(scaleY);

                double remainingWidth = scene.getWidth() - WIDTH * scaleY;

                content.setTranslateX(remainingWidth /2);
                content.setTranslateY(0);
            } else {
                scale.setX(scaleX);
                scale.setY(scaleY);
                content.setTranslateX(0);
                content.setTranslateY(0);
            }
        };

        scene.widthProperty().addListener(updateScale);
        scene.heightProperty().addListener(updateScale);

        primaryStage.setScene(scene);
        primaryStage.setTitle("M-Pong");
        primaryStage.show();

        startGame.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
