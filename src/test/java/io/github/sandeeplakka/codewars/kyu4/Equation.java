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
    public void moreTests() {
        assertEquals(new BigInteger("9"), differentiate("x^2+3x+3", 3));
        assertEquals(new BigInteger("1062300"), differentiate("1000x^2+300x+200", 531));
        assertEquals(new BigInteger("87017"), differentiate("21x^2+35x+3", 2071));
        assertEquals(new BigInteger("38509884"), differentiate("66x^3+3x^2+3", 441));
        assertEquals(new BigInteger("5962009860"), differentiate("21x^4+3x^3", 414));
        assertEquals(new BigInteger("-2480823269890144044"), differentiate("-21x^5+3x^3", 12398));
        assertEquals(new BigInteger("-2469135813"), differentiate("-x^2+3x-3", 1234567908));
        assertEquals(new BigInteger("-6045"), differentiate("-7x^5+22x^4-55x^3-94x^2+87x-56", -3));
        assertEquals(new BigInteger("-3300404885229567012"), differentiate("-123x^5+3x", 8559));
        assertEquals(new BigInteger("119769696967118"), differentiate("x^2", 59884848483559L));

        assertEquals(new BigInteger("9"), differentiateCleverly("x^2+3x+3", 3));
        assertEquals(new BigInteger("1062300"), differentiateCleverly("1000x^2+300x+200", 531));
        assertEquals(new BigInteger("87017"), differentiateCleverly("21x^2+35x+3", 2071));
        assertEquals(new BigInteger("38509884"), differentiateCleverly("66x^3+3x^2+3", 441));
        assertEquals(new BigInteger("5962009860"), differentiateCleverly("21x^4+3x^3", 414));
        assertEquals(new BigInteger("-2480823269890144044"), differentiateCleverly("-21x^5+3x^3", 12398));
        assertEquals(new BigInteger("-2469135813"), differentiateCleverly("-x^2+3x-3", 1234567908));
        assertEquals(new BigInteger("-6045"), differentiateCleverly("-7x^5+22x^4-55x^3-94x^2+87x-56", -3));
        assertEquals(new BigInteger("-3300404885229567012"), differentiateCleverly("-123x^5+3x", 8559));
        assertEquals(new BigInteger("119769696967118"), differentiateCleverly("x^2", 59884848483559L));
    }

    @Test
    public void sampleTestsV1() {
        assertEquals(new BigInteger("12"), differentiate("12x+2", 3));
        assertEquals(new BigInteger("5"), differentiate("x^2-x", 3));
        assertEquals(new BigInteger("-20"), differentiate("-5x^2+10x+4", 3));

        assertEquals(new BigInteger("12"), differentiateCleverly("12x+2", 3));
        assertEquals(new BigInteger("5"), differentiateCleverly("x^2-x", 3));
        assertEquals(new BigInteger("-20"), differentiateCleverly("-5x^2+10x+4", 3));
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

        assertArrayEquals(expectedVals, list.stream()
                .map(term -> differentiateCleverly(term, 3)).toArray(BigInteger[]::new));
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

    //kudos to this cleverness
    public static BigInteger differentiateCleverly(String equation, long x) {
        String[] terms = equation.replace("-", "+-").split("\\+");
        BigInteger res = BigInteger.ZERO;
        for (String term : terms) {
            res = res.add(getTermResult(term, x));
        }
        return res;
    }

    private static BigInteger getTermResult(String part, long x) {
        if (!part.contains("x")) {
            return BigInteger.ZERO;
        }
        part = part.startsWith("x") ? part.replace("x", "1") : part.startsWith("-x") ? part.replace("-x", "-1") : part;
        BigInteger[] arr = Arrays
                .stream(part.replace("x", "").replace("^", " ").split(" "))
                .map(BigInteger::new).toArray(BigInteger[]::new);
        return arr.length == 1 ? arr[0] : arr[0].multiply(arr[1]).multiply(BigInteger.valueOf(x).pow(arr[1].intValue() - 1));
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