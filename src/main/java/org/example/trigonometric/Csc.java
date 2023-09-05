package org.example.trigonometric;

import org.example.FuncHelper;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;
import static java.math.MathContext.DECIMAL128;
import static java.math.RoundingMode.HALF_EVEN;

public class Csc implements FuncHelper {
    private final Sin sin;

    public Csc(final Sin sin) {
        super();
//        this.sin = sin;
//        this.cos = cos;
        this.sin = sin;
    }

    public Csc() {
        super();
//        this.sin = new Sin();
//        this.cos = new Cos();
        this.sin = new Sin();
    }

    @Override
    public BigDecimal calculate(final BigDecimal x, final BigDecimal precision)
            throws ArithmeticException {
//        checkValidity(x, precision);
//
//        final BigDecimal sinValue = sin.calculate(x, precision);
//        final BigDecimal cosValue = cos.calculate(x, precision);
        final BigDecimal sinValue = sin.calculate(x, precision);

//        if (cosValue.compareTo(ZERO) == 0) {
//            throw new ArithmeticException(format("Function value for argument %s doesn't exist", x));
//        }

//        final BigDecimal result = sinValue.divide(cosValue, DECIMAL128.getPrecision(), HALF_EVEN);
        final BigDecimal result = ONE.divide(sinValue, DECIMAL128.getPrecision(), HALF_EVEN);
        return result.setScale(precision.scale(), HALF_EVEN);
    }
}
