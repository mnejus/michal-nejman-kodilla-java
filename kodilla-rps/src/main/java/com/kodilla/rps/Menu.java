package com.kodilla.rps;

import java.util.Scanner;

public class Menu {
    public static String username;
    public static int numOfGames;
    public static Scanner keyScanner = new Scanner(System.in);

    public void start() {
        System.out.print("Enter your name: ");
        username = keyScanner.nextLine();
    }

    public void numOfGames() {
        System.out.println("Hi " + username);
        System.out.println();
        System.out.print("How many won games you want to play? -> ");
        numOfGames = keyScanner.nextInt();
    }

    public void infoGame() {
        System.out.println("The rules of the game");
        System.out.println("# Paper covers Rock");
        System.out.println("# Rock crushes Scissors");
        System.out.println("# Scissors cuts Paper");
        System.out.println("Press: key 1 = Rock, key 2 = Paper, key 3 = Scissors");
        System.out.println();
        System.out.println("Press: (X) end the game || (N) restart the game");

        Game game = new Game();
        game.game();
    }

}
