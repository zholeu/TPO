import ch.obermuhlner.math.big.BigDecimalMath;
import org.example.trigonometric.Cos;
import org.example.trigonometric.Sec;
import org.example.trigonometric.Sin;
import org.example.trigonometric.Tan;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static java.math.MathContext.DECIMAL128;
import static java.math.RoundingMode.HALF_EVEN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)

public class SecTest {
    private static final BigDecimal DEFAULT_PRECISION = new BigDecimal("0.0001");

    @Mock
    private Sin mockSin;
    @Mock private Cos mockCos;
    @Spy
    private Sin spySin;

    @Test
    void shouldCallSinFunction() {
        final Cos cos = new Cos(spySin);
        final Cos spyCos = spy(cos);

        final Sec tan = new Sec(spyCos);
        tan.calculate(ZERO, DEFAULT_PRECISION);
        verify(spyCos, atLeastOnce()).calculate(any(BigDecimal.class), any(BigDecimal.class));
//        verify(cos, atLeastOnce()).calculate(any(BigDecimal.class), any(BigDecimal.class));
    }

    @Test
    void shouldCalculateWithMockSinAndMockCos() {
        final BigDecimal arg = new BigDecimal(5);
        when(mockCos.calculate(eq(arg), any(BigDecimal.class)))
                .thenReturn(new BigDecimal("0.28366218"));
        final Sec tan = new Sec(mockCos);
        final BigDecimal expectedResult = new BigDecimal("3.5253");
        assertEquals(expectedResult, tan.calculate(arg, DEFAULT_PRECISION));
    }

    @Test
    void shouldCalculateForZero() {
        final Sec tan = new Sec();
        assertEquals(
                ONE.setScale(DEFAULT_PRECISION.scale(), HALF_EVEN),
                tan.calculate(ZERO, DEFAULT_PRECISION));
    }

    @Test
    void shouldCalculateForOne() {
        final Sec tan = new Sec();
        final BigDecimal expected = new BigDecimal("1.8508");
        assertEquals(expected, tan.calculate(ONE, DEFAULT_PRECISION));
    }


}
