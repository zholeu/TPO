import org.example.logariphmic.Ln;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LnTest {

    private static final BigDecimal DEFAULT_PRECISION = new BigDecimal("0.00001");

    @Test
    void shouldNotCalculateForZero() {
        final Ln ln = new Ln();
        assertThrows(ArithmeticException.class, () -> ln.calculate(ZERO, DEFAULT_PRECISION));
    }

    @Test
    void shouldCalculateForOne() {
        final Ln ln = new Ln();
        assertEquals(ZERO, ln.calculate(ONE, DEFAULT_PRECISION));
    }

    @Test
    void shouldCalculateForPositive() {
        final Ln ln = new Ln();
        final BigDecimal expected = new BigDecimal("1.38629");
        assertEquals(expected, ln.calculate(new BigDecimal(4), DEFAULT_PRECISION));
    }
}
