package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Moves {
    boolean end = false;
    Random r = new Random();

    public void moves() {
        Scanner keyScanner = new Scanner(System.in);
        int roundCounter = 0;
        int userScore = 0;
        int computerScore = 0;
        int numOfRounds = Menu.numOfGames;

        System.out.println("Your move! PRESS: 1 - Rock, 2 - Paper, 3 - Scissors");

        while(!end) {
            roundCounter++;
            System.out.println();
            System.out.print("ROUND #" + roundCounter + " Your move: ");

            int userMove = keyScanner.nextInt();
            int computerMove = r.nextInt(3) + 1;

            if(userMove == 1) {
                if(computerMove == 1) {
                    System.out.println(Menu.username + " -> ROCK : ROCK <- computer");
                    System.out.println("Draw: no one gets a point!");
                    System.out.println(Menu.username + " " + userScore + " : " + computerScore + " Computer");
                } else if(computerMove == 2) {
                    computerScore++;
                    System.out.println(Menu.username + " -> ROCK : PAPER <- computer");
                    System.out.println(Menu.username + " lost! Computer +1 point!");
                    System.out.println(Menu.username + " " + userScore + " : " + computerScore + " Computer");
                } else if(computerMove == 3) {
                    userScore++;
                    System.out.println(Menu.username + " -> ROCK : SCISSORS <- computer");
                    System.out.println(Menu.username + " WIN! +1 point!");
                    System.out.println(Menu.username + " " + userScore + " : " + computerScore + " Computer");
                }
            } else if(userMove == 2) {
                if(computerMove == 1) {
                    userScore++;
                    System.out.println(Menu.username + " -> PAPER : ROCK <- computer");
                    System.out.println(Menu.username + " WIN! +1 point!");
                    System.out.println(Menu.username + " " + userScore + " : " + computerScore + " Computer");
                } else if(computerMove == 2) {
                    System.out.println(Menu.username + " -> PAPER : PAPER <- computer");
                    System.out.println("Draw: no one gets a point!");
                    System.out.println(Menu.username + " " + userScore + " : " + computerScore + " Computer");
                } else if(computerMove == 3) {
                    computerScore++;
                    System.out.println(Menu.username + " -> PAPER : SCISSORS <- computer");
                    System.out.println(Menu.username + " lost! Computer +1 point!");
                    System.out.println(Menu.username + " " + userScore + " : " + computerScore + " Computer");
                }
            } else if(userMove == 3) {
                if (computerMove == 1) {
                    computerScore++;
                    System.out.println(Menu.username + " -> SCISSORS : ROCK <- computer");
                    System.out.println(Menu.username + " lost! Computer +1 point!");
                    System.out.println(Menu.username + " " + userScore + " : " + computerScore + " Computer");
                } else if (computerMove == 2) {
                    userScore++;
                    System.out.println(Menu.username + " -> SCISSORS : PAPER <- computer");
                    System.out.println(Menu.username + " WIN! +1 point!");
                    System.out.println(Menu.username + " " + userScore + " : " + computerScore + " Computer");
                } else if (computerMove == 3) {
                    computerScore++;
                    System.out.println(Menu.username + " -> SCISSORS : SCISSORS <- computer");
                    System.out.println("Draw: no one gets a point!");
                    System.out.println(Menu.username + " " + userScore + " : " + computerScore + " Computer");
                }
            }

            if(userScore == numOfRounds) {
                System.out.println(Menu.username + " WIN! Congratulations!");
                break;
            }

            if(computerScore == numOfRounds){
                System.out.println();
                System.out.println(Menu.username + " LOST THE GAME! Try again!");
                break;
            }
        }
    }
}
