package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            secondChallenge.probablyIWillThrowException(2, 1);
        } catch (Exception e) {
            System.out.println("When x >= 2 or x < 1 or y == 1.5 i will throw exception: " + e);
        } finally {
            System.out.println("Done!");
        }
    }
}
