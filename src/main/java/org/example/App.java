package org.example;


import org.example.logariphmic.Ln;
import org.example.logariphmic.Log;
import org.example.trigonometric.*;

import java.io.IOException;
import java.math.BigDecimal;

public class App {

    public static void main(String[] args) throws IOException {
        final Cos cos = new Cos();
        CsvWriter.write(
                "csv/cos.csv",
                cos,
                new BigDecimal(-1),
                new BigDecimal(1),
                new BigDecimal("0.1"),
                new BigDecimal("0.0000000001"));

        final Sin sin = new Sin();
        CsvWriter.write(
                "csv/sin.csv",
                sin,
                new BigDecimal(-1),
                new BigDecimal(1),
                new BigDecimal("0.1"),
                new BigDecimal("0.0000000001"));

        final Tan tan = new Tan();
        CsvWriter.write(
                "csv/tan.csv",
                tan,
                new BigDecimal(-1),
                new BigDecimal(1),
                new BigDecimal("0.1"),
                new BigDecimal("0.0000000001"));

        final Sec sec = new Sec();
        CsvWriter.write(
                "csv/sec.csv",
                sec,
                new BigDecimal(-1),
                new BigDecimal(1),
                new BigDecimal("0.1"),
                new BigDecimal("0.0000000001"));

        final Csc csc = new Csc();
        CsvWriter.write(
                "csv/csc.csv",
                csc,
                new BigDecimal(-1),
                new BigDecimal(1),
                new BigDecimal("0.11"),
                new BigDecimal("0.0000000001"));

        final Cot cot = new Cot();
        CsvWriter.write(
                "csv/cot.csv",
                cot,
                new BigDecimal(-1),
                new BigDecimal(1),
                new BigDecimal("0.11"),
                new BigDecimal("0.0000000001"));

        final Ln ln = new Ln();
        CsvWriter.write(
                "csv/ln.csv",
                ln,
                new BigDecimal(1),
                new BigDecimal(20),
                new BigDecimal("0.1"),
                new BigDecimal("0.0000000001"));

        final Log log3 = new Log(3);
        CsvWriter.write(
                "csv/log3.csv",
                log3,
                new BigDecimal(1),
                new BigDecimal(20),
                new BigDecimal("0.1"),
                new BigDecimal("0.00000000001"));

        final Log log2 = new Log(2);
        CsvWriter.write(
                "csv/log2.csv",
                log2,
                new BigDecimal(1),
                new BigDecimal(20),
                new BigDecimal("0.1"),
                new BigDecimal("0.00000000001"));

        final Log log10 = new Log(10);
        CsvWriter.write(
                "csv/log10.csv",
                log10,
                new BigDecimal(1),
                new BigDecimal(20),
                new BigDecimal("0.1"),
                new BigDecimal("0.00000000001"));

        final Function func = new Function();
        CsvWriter.write(
                "csv/func.csv",
                func,
                new BigDecimal(-1),
                new BigDecimal(1),
                new BigDecimal("0.11"),
                new BigDecimal("0.00000000001"));
    }
}
