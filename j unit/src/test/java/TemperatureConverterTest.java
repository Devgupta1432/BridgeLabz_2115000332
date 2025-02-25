package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TemperatureConverterTest {
    TemperatureConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new TemperatureConverter();
    }

    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(32.0, converter.celsiusToFahrenheit(0.0), 0.001);
    }

    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(0.0, converter.fahrenheitToCelsius(32.0), 0.001);
    }
}
