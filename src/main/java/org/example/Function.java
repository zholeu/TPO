package org.example;

import ch.obermuhlner.math.big.BigDecimalMath;
import org.example.logariphmic.Ln;
import org.example.logariphmic.Log;
import org.example.trigonometric.*;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.ONE;
import static java.math.MathContext.DECIMAL128;
import static java.math.RoundingMode.HALF_EVEN;
import static java.math.RoundingMode.HALF_UP;

public class Function implements FuncHelper {
    private final Sin sin;
    private final Cos cos;
    private final Csc csc;
    private final Cot cot;
    private final Sec sec;
//    private final Tan tan;
    private final Ln ln;
    private final Log log3;
    private final Log log2;
    private final Log log10;

    public Function() {
        this.sin = new Sin();
        this.cos = new Cos();
        this.csc = new Csc();
        this.cot = new Cot();
        this.sec = new Sec();
        this.ln = new Ln();
        this.log3 = new Log(3);
        this.log2 = new Log(2);
        this.log10 = new Log(10);
    }

    private BigDecimal second(final BigDecimal x, final BigDecimal precision) {
        return cos.calculate(x, precision).subtract(cot.calculate(x,precision));
    }
    private BigDecimal th(final BigDecimal x, final BigDecimal precision) {
        return log2.calculate(x, precision).multiply(log10.calculate(x,precision));
    }
    private BigDecimal fth(final BigDecimal x, final BigDecimal precision) {
        return log10.calculate(x, precision).divide(th(x,precision), HALF_UP);
    }

    private BigDecimal foth(final BigDecimal x, final BigDecimal precision) {
        return ln.calculate(x, precision).add(log2.calculate(x,precision));
    }

    public BigDecimal calculate(final BigDecimal x, final BigDecimal precision) {
        final MathContext mc = new MathContext(DECIMAL128.getPrecision(), HALF_EVEN);
        final BigDecimal correctedX = x.remainder(BigDecimalMath.pi(mc).multiply(new BigDecimal(2)));
        System.out.println("Corr " + correctedX);
        if (x.compareTo(ZERO) <= 0) {
            return sec.calculate(correctedX, precision).multiply(cot.calculate(correctedX, precision))
                    .subtract(second(correctedX,precision))
                    .multiply(csc.calculate(correctedX,precision))
                    .add(cot.calculate(correctedX, precision))
                    .subtract(sin.calculate(correctedX, precision))
                    .setScale(precision.scale(), HALF_EVEN);
        }
        else {
            if (ln.calculate(correctedX, precision).equals(ZERO)) return null;
            return (ONE
                    .add(fth(correctedX, precision))
                    .multiply(foth(correctedX, precision))
                    .divide(log3.calculate(correctedX, precision), HALF_UP)
                    .setScale(precision.scale(), HALF_EVEN));
        }
    }
}
