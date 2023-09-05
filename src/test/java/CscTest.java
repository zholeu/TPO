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

public class CscTest {
    private static final BigDecimal DEFAULT_PRECISION = new BigDecimal("0.0001");

    @Mock
    private Sin mockSin;
    @Mock private Cos mockCos;
    @Spy
    private Sin spySin;

    @Test
    void shouldCallSinFunction() {
//        final Cos cos = new Cos(spySin);
//        final Sin spy = spy(spySin);
        final Csc tan = new Csc(spySin);
        tan.calculate(ONE, DEFAULT_PRECISION);
        verify(spySin, atLeastOnce()).calculate(any(BigDecimal.class), any(BigDecimal.class));
//        verify(cos, atLeastOnce()).calculate(any(BigDecimal.class), any(BigDecimal.class));
    }

    @Test
    void shouldCalculateWithMockSinAndMockCos() {
        final BigDecimal arg = new BigDecimal(5);
        when(mockSin.calculate(eq(arg), any(BigDecimal.class)))
                .thenReturn(new BigDecimal("-0.95892427"));
        final Csc tan = new Csc(mockSin);
        final BigDecimal expectedResult = new BigDecimal("-1.0428");
        assertEquals(expectedResult, tan.calculate(arg, DEFAULT_PRECISION));
    }

    @Test
    void shouldCalculateForZero() {


        final Csc cot = new Csc();
        final MathContext mc = new MathContext(DECIMAL128.getPrecision());
//        final BigDecimal arg = new BigDecimal(0);
        assertThrows(ArithmeticException.class, () -> cot.calculate(ZERO, DEFAULT_PRECISION));
    }

    @Test
    void shouldCalculateForOne() {
        final Csc tan = new Csc();
        final BigDecimal expected = new BigDecimal("1.1884");
        assertEquals(expected, tan.calculate(ONE, DEFAULT_PRECISION));
    }

}
