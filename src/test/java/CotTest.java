import ch.obermuhlner.math.big.BigDecimalMath;
import org.example.trigonometric.*;
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

public class CotTest {
    private static final BigDecimal DEFAULT_PRECISION = new BigDecimal("0.0001");

    @Mock
    private Sin mockSin;
    @Mock private Cos mockCos;
    @Mock private Tan mockTan;
    @Spy
    private Sin spySin;

    @Test
    void shouldCallSinFunction() {
        final Cos cos = new Cos(spySin);
        final Cos spyCos = spy(cos);
        final Tan tan = new Tan(spySin, spyCos);
        final Tan spyTan = spy(tan);

        final Cot cot = new Cot(spyTan);
        cot.calculate(ONE, DEFAULT_PRECISION);
        verify(spyTan, atLeastOnce()).calculate(any(BigDecimal.class), any(BigDecimal.class));
    }

    @Test
    void shouldCalculateWithMockSinAndMockCos() {
        final BigDecimal arg = new BigDecimal(5);
        when(mockTan.calculate(eq(arg), any(BigDecimal.class)))
                .thenReturn(new BigDecimal("-3.38051501"));
        final Cot tan = new Cot(mockTan);
        final BigDecimal expectedResult = new BigDecimal("-0.2958");
        assertEquals(expectedResult, tan.calculate(arg, DEFAULT_PRECISION));
    }

    @Test
    void shouldCalculateForZero() {
//        final Sec tan = new Sec();
//        assertEquals(
//                ONE.setScale(DEFAULT_PRECISION.scale(), HALF_EVEN),
//                tan.calculate(ZERO, DEFAULT_PRECISION));

        final Cot cot = new Cot();
        final MathContext mc = new MathContext(DECIMAL128.getPrecision());
//        final BigDecimal arg = new BigDecimal(0);
        assertThrows(ArithmeticException.class, () -> cot.calculate(ZERO, DEFAULT_PRECISION));
    }

    @Test
    void shouldCalculateForOne() {
        final Cot tan = new Cot();
        final BigDecimal expected = new BigDecimal("0.6421");
        assertEquals(expected, tan.calculate(ONE, DEFAULT_PRECISION));
    }
}
