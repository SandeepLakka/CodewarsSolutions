package io.github.sandeeplakka.codewars.kyu4;

/*
Create a function that differentiates a polynomial for a given value of x.

Your function will receive 2 arguments: a polynomial as a string, and a point to evaluate the equation as an integer.
Assumptions:
    There will be a coefficient near each x, unless the coefficient equals 1 or -1.
    There will be an exponent near each x, unless the exponent equals 0 or 1.
    All exponents will be greater or equal to zero

Examples:
differenatiate("12x+2", 3)      ==>   12
differenatiate("x^2+3x+2", 3)   ==>   9

Categories : Fundamentals, Algorithms, Numbers, Strings, Integers
 */

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Equation {

    @Test
    public void sampleTestsV1() {
        assertEquals(new BigInteger("12"), differentiate("12x+2", 3));
        assertEquals(new BigInteger("5"), differentiate("x^2-x", 3));
        assertEquals(new BigInteger("-20"), differentiate("-5x^2+10x+4", 3));
    }

    @Test
    public void sampleTestV0() {
        List<String> list = Arrays.asList(
                "-x", "2x", "-3x^2", "5x^3", "+2x^4", "+4", "-5"
                //dx :   -1 ,  2  ,  -6x   ,  15x^2,  8x^3  ,  0  ,   0
                //val:   -1 ,  2  ,  -18   ,  135  ,   216  ,  0  ,   0
        );
        BigInteger[] expectedVals = new BigInteger[]{
                BigInteger.valueOf(-1), BigInteger.valueOf(2), BigInteger.valueOf(-18),
                BigInteger.valueOf(135), BigInteger.valueOf(216), BigInteger.valueOf(0),
                BigInteger.valueOf(0)
        };
        assertArrayEquals(expectedVals, list.stream()
                .map(Term::new)
                .map(Term::differentiatedTerm)
                .map(term -> term.returnValue(3)).toArray(BigInteger[]::new));

    }

    public static BigInteger differentiate(String equation, long x) {
        List<String> terms = new ArrayList<>();
        StringBuilder term = new StringBuilder();
        for (int i = 0; i < equation.length(); i++) {
            if ((equation.charAt(i) == '+' || equation.charAt(i) == '-') && i != 0) {
                terms.add(term.toString());
                term = new StringBuilder();
            }
            term.append(equation.charAt(i));
            if (i == equation.length() - 1) {
                terms.add(term.toString());
            }
        }
        return terms.stream().map(Term::new)
                .map(Term::differentiatedTerm)
                .map(differentiatedTerm -> differentiatedTerm.returnValue(x))
                .reduce(BigInteger.ZERO, (result, value) -> result = result.add(value));
    }
}

class Term {
    final String REGEX = "([-+]?)([\\d]*)(x)?([\\^][\\d]*)?";
    final Pattern pattern = Pattern.compile(REGEX);

    private boolean isPositive;
    private int coefficient;
    private String variable;
    private int power;

    public Term(Term term) {
        power = term.getPower();
        coefficient = term.getCoefficient();
        variable = term.getVariable();
        isPositive = term.isPositive();
    }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean positive) {
        isPositive = positive;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public Term() {
    }

    public Term(String term) {
        Matcher matcher = pattern.matcher(term);
        if (matcher.find()) {
            isPositive = !matcher.group(1).equals("-");
            coefficient = matcher.group(2).isEmpty() ? 1 : Integer.parseInt(matcher.group(2));
            variable = matcher.group(3) == null ? null : matcher.group(3);
            if (variable != null) {
                power = matcher.group(4) == null ? 1 : Integer.parseInt(matcher.group(4).substring(1));
            }
        }
    }

    @Override
    public String toString() {
        return "Term{" +
                "isPositive=" + isPositive +
                ", coefficient=" + coefficient +
                ", variable='" + variable + '\'' +
                ", power=" + power +
                '}';
    }


    public BigInteger returnValue(long value) {
        //constants
        if (coefficient == 0) return BigInteger.ZERO;

        BigInteger result = BigInteger.valueOf(coefficient);

        if (this.power > 0) {
            BigInteger poweredValue = BigInteger.valueOf(value).pow(power);
            result = result.multiply(poweredValue);
        }
        if (!this.isPositive) {
            result = result.negate();
        }
        return result;
    }

    public Term differentiatedTerm() {
        Term term = new Term(this);
        if (power <= 1) {
            if (term.getVariable() == null) {
                term.setCoefficient(0);
            } else {
                term.setVariable(null);
            }
        }
        term.setCoefficient(term.getCoefficient() * term.getPower());
        term.setPower(term.getPower() == 0 ? 0 : term.getPower() - 1);
        return term;
    }
}