package com.sagar.example1;

// Behavioral design patterns are concerned with algorithms
// and the assignment of responsibilities between objects

public class WeatherStation {
    public static void main(String[] args) {

        WeatherData weatherData=new WeatherData();
        CurrentConditionDisplay currentConditionDisplay=new CurrentConditionDisplay(weatherData);


        weatherData.setMeasurement(80,65,30.4f);
        weatherData.setMeasurement(82,70,29.2f);
        weatherData.setMeasurement(78,90,29.2f);
    }
}
