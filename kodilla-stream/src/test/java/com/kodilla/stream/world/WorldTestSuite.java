package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Country poland = new Country(new BigDecimal("37970000"));
        Country ukraine = new Country(new BigDecimal("44390000"));
        Country italy = new Country(new BigDecimal("60360000"));

        Country russia = new Country(new BigDecimal("144400000"));
        Country china = new Country(new BigDecimal("1398000000"));
        Country india = new Country((new BigDecimal("1366000000")));

        Country columbia = new Country(new BigDecimal("50340000"));
        Country peru = new Country((new BigDecimal("32510000")));
        Country argentina = new Country(new BigDecimal("44940000"));

        Continent europe = new Continent();
        europe.addCountry(poland);
        europe.addCountry(ukraine);
        europe.addCountry(italy);

        Continent asia = new Continent();
        asia.addCountry(russia);
        asia.addCountry(china);
        asia.addCountry(india);

        Continent southAmerica = new Continent();
        southAmerica.addCountry(columbia);
        southAmerica.addCountry(peru);
        southAmerica.addCountry(argentina);

        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(southAmerica);

        //When
        BigDecimal result = world.getPeopleQuantity();

        //Then
        BigDecimal expectedResult = new BigDecimal("3178910000");
        assertEquals(expectedResult, result);
    }
}
