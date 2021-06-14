package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    private static int testCounter = 0;
    Map<String, Double> temperaturesMap;

    @BeforeEach
    public void before() {
        testCounter ++;
        System.out.println("Preparing to execute test # " + testCounter);

        temperaturesMap = new HashMap<>();

        temperaturesMap.put("Rzeszów", 25.5);
        temperaturesMap.put("Kraków", 26.2);
        temperaturesMap.put("Wrocław", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdańsk", 26.1);
    }

    @Mock
    private Temperatures temperaturesMock;

    @Test
    void testCalculateForecastWithMock() {
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        assertEquals(5, quantityOfSensors);
    }

//    @Test
//    void testCalculateAverageTemperature() {
//        //Given
//        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
//        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
//
//        //When
//        double result = weatherForecast.averageTemperature();
//
//        //Then
//        assertEquals(25.56, result);
//    }

    @Test
    void testCalculateMedianTemperature() {
        //Given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double result = weatherForecast.medianTemperature();

        //Then
        assertEquals(25.5, result);
    }
}
