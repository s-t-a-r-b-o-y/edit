public class TemperatureConverter {

    /**
     * Converts Celsius to Fahrenheit.
     * Formula: F = (C × 9/5) + 32
     */
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32.0;
    }

    /**
     * Converts Fahrenheit to Celsius.
     * Formula: C = (F − 32) × 5/9
     */
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    /**
     * Converts Celsius to Kelvin.
     * Formula: K = C + 273.15
     */
    public double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
}
