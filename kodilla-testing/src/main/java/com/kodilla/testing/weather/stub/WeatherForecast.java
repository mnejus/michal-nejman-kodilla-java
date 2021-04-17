package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();
        for(Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double averageTemperature() {
        double sum = 0;
        for(Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()) {
            sum += temperature.getValue();
        }
        double average = sum / temperatures.getTemperatures().size();
        return average;
    }

    public double medianTemperature() {
        double median = 0;
        List<Double> temperatureList = new ArrayList<>();

        for(Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()) {
            temperatureList.add(temperature.getValue());
        }

        Collections.sort(temperatureList);

        for(int n = 0; n < temperatureList.size(); n++){
            if(temperatureList.size() % 2 == 0) {
                median = ((temperatureList.get(temperatureList.size() / 2) + (temperatureList.get(temperatureList.size() / 2 - 1)))) / 2;
            } else {
                median = temperatureList.get((temperatureList.size() - 1) / 2);
            }
        }

        return median;
    }
}
