package org.example.trigonometric;

import org.example.FuncHelper;

import java.math.BigDecimal;
import java.util.Objects;

import static java.lang.String.format;
import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.ONE;

import static java.math.MathContext.DECIMAL128;
import static java.math.RoundingMode.HALF_EVEN;

public class Cot implements FuncHelper {
//    private final Sin sin;
//    private final Cos cos;
    private final Tan tan;

    public Cot(final Tan tan) {
        super();
//        this.sin = sin;
//        this.cos = cos;
        this.tan = tan;
    }

    public Cot() {
        super();
//        this.sin = new Sin();
//        this.cos = new Cos();
        this.tan = new Tan();
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
//
//        final BigDecimal sinValue = sin.calculate(x, precision);
//        final BigDecimal cosValue = cos.calculate(x, precision);
        final BigDecimal tanValue = tan.calculate(x, precision);
        if (tanValue.compareTo(ZERO) == 0) {
            throw new ArithmeticException(format("Function value for argument %s doesn't exist", x));
        }

//        if (cosValue.compareTo(ZERO) == 0) {
//            throw new ArithmeticException(format("Function value for argument %s doesn't exist", x));
//        }

//        final BigDecimal result = sinValue.divide(cosValue, DECIMAL128.getPrecision(), HALF_EVEN);
        final BigDecimal result = ONE.divide(tanValue, DECIMAL128.getPrecision(), HALF_EVEN);
        return result.setScale(precision.scale(), HALF_EVEN);
    }
}
