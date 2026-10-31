package com.xiling.math.Problem;

import java.text.DecimalFormat;

public class DivisionProblem extends Problem{

    private final int numerator;
    private final int denominator;
    private final DecimalFormat df;

    public DivisionProblem(int denominator, int answer) {
        this.setAnswer(answer);
        this.denominator = denominator;
        this.numerator = answer * denominator;
        this.df = new DecimalFormat("#,###");
    }

    @Override
    public void display() {
        IO.println(String.format("%s", df.format(numerator) +
                " / " + String.format("%s", df.format(denominator))));
    }
}
