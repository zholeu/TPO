package org.example.trigonometric;


import org.example.FuncHelper;

import static java.math.BigDecimal.ONE;
import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;
import static java.math.MathContext.DECIMAL128;
import static java.math.RoundingMode.HALF_EVEN;


import java.math.BigDecimal;
import java.math.MathContext;

public class Sin implements FuncHelper {
//    private final Sin sin;


    public Sin() {

        super();
    }

    @Override
    public BigDecimal calculate(final BigDecimal x, final BigDecimal precision)
            throws ArithmeticException {

        double X = x.doubleValue();

        double PI2 = Math.PI * 2;
//    System.out.println("PI2 - "+PI2);
        int i = 0;
        BigDecimal sum = new BigDecimal(0), prev;
//    System.out.println("sum - "+sum);


        if (X >= 0) {
            while (X > PI2) {
                X -= PI2;
            }
        }
        else if (X < 0){
            while (X < PI2) {
                X += PI2;
            }
        }
        BigDecimal c = new BigDecimal(2);


        do {
            prev = sum;
            sum = sum.add(minusOnePow(i).multiply(prod(X, 2 * i + 1)));
            i++;
//      System.out.println("prev - "+prev);
//      System.out.println("now - "+sum);
//      System.out.println("1 - "+prev.subtract(sum));

        } while (new BigDecimal("0.1").pow(precision.scale()).compareTo(prev.subtract(sum).abs()) < 0);


        return sum.setScale(precision.scale(), HALF_EVEN);
    }

    private static BigDecimal minusOnePow(int n){
//    System.out.println("minusOnePow - "+BigDecimal.valueOf(1 - (n % 2) * 2));

        return BigDecimal.valueOf(1 - (n % 2) * 2);
    }
    //x - (x^3)/3! + (x^5)/5! - (x^7)/7! +

    private static BigDecimal prod(double x, int n){
        BigDecimal accum = new BigDecimal(1);

        for (int i = 1; i <= n; i++){
            accum = accum.multiply( new BigDecimal(x / i));
        }


        return accum;
    }
}
