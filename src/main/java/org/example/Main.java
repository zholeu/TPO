package org.example;

import org.example.trigonometric.*;

import java.math.BigDecimal;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final BigDecimal DEFAULT_PRECISION = new BigDecimal("0.0001");

    public static void main(String[] args) {


        final Sin sin = new Sin();
        final BigDecimal expected = new BigDecimal("0.0972");
        System.out.println(sin.calculate(new BigDecimal(-113), DEFAULT_PRECISION));
//        assertEquals(expected, sin.calculate(new BigDecimal(-113), DEFAULT_PRECISION));
        final Cos cos = new Cos();
        final BigDecimal expected2 = new BigDecimal("-0.8797");
        System.out.println(cos.calculate(new BigDecimal(-543), DEFAULT_PRECISION));

        final Cot cot = new Cot();
        final BigDecimal expected3 = new BigDecimal("0.1380");
        System.out.println(cot.calculate(new BigDecimal(14), DEFAULT_PRECISION));

        final Csc csc = new Csc();
        final BigDecimal expected4 = new BigDecimal("0.1380");
        System.out.println(csc.calculate(new BigDecimal(14), DEFAULT_PRECISION));

        final Sec sec = new Sec();
        final BigDecimal expected5 = new BigDecimal("0.1380");
        System.out.println(sec.calculate(new BigDecimal(14), DEFAULT_PRECISION));

        final Function function = new Function();
        final BigDecimal expected6 = new BigDecimal("0.1380");
        System.out.println(function.calculate(new BigDecimal(0), DEFAULT_PRECISION));
    }
}