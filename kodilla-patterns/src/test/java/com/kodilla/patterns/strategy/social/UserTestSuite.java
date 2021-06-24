package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User adam = new Millenials("Adam Adam");
        User arek = new YGeneration("Arek Arek");
        User adrian = new ZGeneration("Adrian Adrian");

        //When
        String adamShare = adam.sharePost();
        System.out.println("Adam shared post on " + adamShare);
        String arekShare = arek.sharePost();
        System.out.println("Arek shared post on " + arekShare);
        String adrianShare = adrian.sharePost();
        System.out.println("Adrian shared post on " + adrianShare);

        //Then
        assertEquals("Twitter", adamShare);
        assertEquals("Facebook", arekShare);
        assertEquals("Snapchat", adrianShare);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User adam = new Millenials("Adam Adam");

        //When
        String adamShare = adam.sharePost();
        System.out.println("Adam shared post on " + adamShare);
        adam.setSharingStrategy(new FacebookPublisher());
        adamShare = adam.sharePost();
        System.out.println("Adam will share post on " + adamShare);

        //Then
        assertEquals("Facebook", adamShare);
    }
}
