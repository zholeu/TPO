import org.example.Function;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionTest {

    private static final BigDecimal DEFAULT_PRECISION = new BigDecimal("0.00000001");
    private static final int DEFAULT_SCALE = 8;

    @Test
    void shouldNotAcceptNullArgument() {
        final Function system = new Function();
        assertThrows(NullPointerException.class, () -> system.calculate(null, DEFAULT_PRECISION));
    }

    @Test
    void shouldNotAcceptNullPrecision() {
        final Function system = new Function();
        assertThrows(NullPointerException.class, () -> system.calculate(new BigDecimal(-2), null));
    }

    @ParameterizedTest
    @MethodSource("illegalPrecisions")
    void shouldNotAcceptIncorrectPrecisions(final BigDecimal precision) {
        final Function system = new Function();
        assertThrows(ArithmeticException.class, () -> system.calculate(new BigDecimal(-2), precision));
    }

//    @Test
//    void shouldNotAcceptZeroArgument() {
//        final Function system = new Function();
//        assertEquals(ZERO.setScale(DEFAULT_SCALE, RoundingMode.HALF_UP), system.calculate(ZERO, DEFAULT_PRECISION));
//    }

    @Test
    void shouldNotAcceptOneArgument() {
        final Function system = new Function();
        assertNull((system.calculate(ONE, DEFAULT_PRECISION)));
    }

  //  @Test
//    void shouldCalculateForPositiveValue() {
//        final Function system = new Function();
//        final BigDecimal expected = new BigDecimal("0.15223487");
//        assertEquals(expected, system.calculate(new BigDecimal(5), DEFAULT_PRECISION));
//    }
//
//    @Test
//    void shouldCalculateForNegativeValue() {
//        final Function system = new Function();
//        final BigDecimal expected = new BigDecimal("1349425269770380495617447998046070618658242090070447101476.03288643");
//        assertEquals(expected, system.calculate(new BigDecimal(-5), DEFAULT_PRECISION));
//    }

    private static Stream<Arguments> illegalPrecisions() {
        return Stream.of(
                Arguments.of(BigDecimal.valueOf(1)),
                Arguments.of(BigDecimal.valueOf(0)),
                Arguments.of(BigDecimal.valueOf(1.01)),
                Arguments.of(BigDecimal.valueOf(-0.01)));
    }
}
