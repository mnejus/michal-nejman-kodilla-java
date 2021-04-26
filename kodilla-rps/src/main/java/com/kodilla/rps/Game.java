package com.kodilla.rps;

import java.util.Scanner;

public class Game {

    Menu menu = new Menu();
    Moves moves = new Moves();

    public void game() {

        Scanner keyScanner = new Scanner(System.in);
        moves.moves();
        char choice;
        char choice2;

        System.out.println("Press: (X) end the game || (N) restart the game");
        choice = keyScanner.next().charAt(0);

        if(choice == 'n' || choice == 'N') {
            menu.numOfGames();
            menu.infoGame();
        } else if(choice == 'x' || choice == 'X') {
            System.out.println("Are you sure you want to quit the game? PRESS: (Y) Yes / (N) No");
            choice2 = keyScanner.next().charAt(0);
            if(choice2 == 'y' || choice2 == 'Y') {
                System.out.println("See you soon!");
            } else if(choice2 == 'n' || choice2 == 'N') {
                menu.numOfGames();
                menu.infoGame();
            }
        }

    }
}
