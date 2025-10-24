import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    private static final double EPS = 1e-9;

    @Test
    @DisplayName("Celsius to Fahrenheit: basic values")
    void testCelsiusToFahrenheitBasic() {
        TemperatureConverter tc = new TemperatureConverter();
        assertEquals(32.0, tc.celsiusToFahrenheit(0.0), EPS);
        assertEquals(212.0, tc.celsiusToFahrenheit(100.0), EPS);
        assertEquals(-40.0, tc.celsiusToFahrenheit(-40.0), EPS); // intersection point
    }

    @Test
    @DisplayName("Fahrenheit to Celsius: basic values")
    void testFahrenheitToCelsiusBasic() {
        TemperatureConverter tc = new TemperatureConverter();
        assertEquals(0.0, tc.fahrenheitToCelsius(32.0), EPS);
        assertEquals(100.0, tc.fahrenheitToCelsius(212.0), EPS);
        assertEquals(-40.0, tc.fahrenheitToCelsius(-40.0), EPS); // intersection point
    }

    @Test
    @DisplayName("Celsius to Kelvin: absolute zero and room temp")
    void testCelsiusToKelvin() {
        TemperatureConverter tc = new TemperatureConverter();
        assertEquals(273.15, tc.celsiusToKelvin(0.0), EPS);
        assertEquals(298.15, tc.celsiusToKelvin(25.0), EPS);
        // Below absolute zero is physically invalid, but the converter should still
        // apply the formula correctly per the assignment.
        assertEquals(0.0, tc.celsiusToKelvin(-273.15), EPS);
    }

    @Test
    @DisplayName("Round-trip consistency C→F→C and F→C→F")
    void testRoundTrip() {
        TemperatureConverter tc = new TemperatureConverter();
        double c = 37.0;
        double f = tc.celsiusToFahrenheit(c);
        double cBack = tc.fahrenheitToCelsius(f);
        assertEquals(c, cBack, EPS);

        double f2 = 77.0;
        double c2 = tc.fahrenheitToCelsius(f2);
        double fBack = tc.celsiusToFahrenheit(c2);
        assertEquals(f2, fBack, EPS);
    }
}
