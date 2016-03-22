package com.goit.gojavaonline.module4;

public class TemperatureCalculator {
    public static double fahrenheitToCelsiusConverter(double fahrenheitDegrees){
        return (5.0/9) * (fahrenheitDegrees - 32);
    }

    public static double celsiusToFahrenheitConverter(double celsiusDegrees){
        return (9.0/5) * celsiusDegrees + 32;
    }
}
