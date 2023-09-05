package org.example.trigonometric;

import org.example.FuncHelper;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static java.math.MathContext.DECIMAL128;
import static java.math.RoundingMode.HALF_EVEN;
import ch.obermuhlner.math.big.BigDecimalMath;



public class Cos implements FuncHelper {
    private final Sin sin;

    public Cos() {
//        super();
        this.sin = new Sin();
    }

    public Cos(final Sin sin) {
//        super();
        this.sin = sin;
    }
    protected void checkValidity(final BigDecimal x, final BigDecimal precision) {
        Objects.requireNonNull(x, "Function argument can not be null");
        Objects.requireNonNull(precision, "Precision can not be null");
        if (precision.compareTo(ZERO) <= 0 || precision.compareTo(ONE) >= 0) {
            throw new ArithmeticException("Precision must be less than one and more than zero");
        }
    }
    @Override
    public BigDecimal calculate(final BigDecimal x, final BigDecimal precision)
            throws ArithmeticException {
        checkValidity(x, precision);

        final MathContext mc = new MathContext(DECIMAL128.getPrecision(), HALF_EVEN);
        final BigDecimal correctedX = x.remainder(BigDecimalMath.pi(mc).multiply(new BigDecimal(2)));

        if (correctedX.compareTo(ZERO) == 0) {
            return ONE;
        }

        final BigDecimal result =
                sin.calculate(
                        BigDecimalMath.pi(mc)
                                .divide(new BigDecimal(2), DECIMAL128.getPrecision(), HALF_EVEN)
                                .subtract(correctedX),
                        precision);
        return result.setScale(precision.scale(), HALF_EVEN);
    }
}
