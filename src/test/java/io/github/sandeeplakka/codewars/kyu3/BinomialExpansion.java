package io.github.sandeeplakka.codewars.kyu3;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
The purpose of this kata is to write a program that can do some algebra.
Write a function expand that takes in an expression with a single, one character variable, and expands it.
The expression is in the form (ax+b)^n where a and b are integers which may be positive or negative,
x is any single character variable, and n is a natural number.
If a = 1, no coefficient will be placed in front of the variable.
If a = -1, a "-" will be placed in front of the variable.

The expanded form should be returned as a string in the form ax^b+cx^d+ex^f...
where a, c, and e are the coefficients of the term, x is the original one character variable
that was passed in the original expression and b, d, and f, are the powers
that x is being raised to in each term and are in decreasing order.
If the coefficient of a term is zero, the term should not be included.
If the coefficient of a term is one, the coefficient should not be included.
If the coefficient of a term is -1, only the "-" should be included.
If the power of the term is 0, only the coefficient should be included.
If the power of the term is 1, the caret and power should be excluded.

Examples:

KataSolution.expand("(x+1)^2");      // returns "x^2+2x+1"
KataSolution.expand("(p-1)^3");      // returns "p^3-3p^2+3p-1"
KataSolution.expand("(2f+4)^6");     // returns "64f^6+768f^5+3840f^4+10240f^3+15360f^2+12288f+4096"
KataSolution.expand("(-2a-4)^0");    // returns "1"
KataSolution.expand("(-12t+43)^2");  // returns "144t^2-1032t+1849"
KataSolution.expand("(r+0)^203");    // returns "r^203"
KataSolution.expand("(-x-1)^2");     // returns "x^2+2x+1"

Categories : Algorithms, Mathematics, Numbers, Algebra
 */
public class BinomialExpansion {

    @Test
    public void tests_expand() {
        assertEquals("81t^2", expand("(9t-0)^2"));
        assertEquals("x^2+2x+1", expand("(x+1)^2"));
        assertEquals("p^3-3p^2+3p-1", expand("(p-1)^3"));
        assertEquals("64f^6+768f^5+3840f^4+10240f^3+15360f^2+12288f+4096", expand("(2f+4)^6"));
        assertEquals("1", expand("(-2a-4)^0"));
        assertEquals("144t^2-1032t+1849", expand("(-12t+43)^2"));
        assertEquals("r^203", expand("(r+0)^203"));
        assertEquals("x^2+2x+1", expand("(-x-1)^2"));
        assertEquals("-n^5-60n^4-1440n^3-17280n^2-103680n-248832", expand("(-n-12)^5"));
        assertEquals("-v^5+5v^4-10v^3+10v^2-5v+1", expand("(-v+1)^5"));
    }

    @Test
    public void tests_getNcX() {
        assertEquals(BigInteger.ONE, getNcX(100, 0));
        assertEquals(BigInteger.valueOf(2), getNcX(2, 1));
        assertEquals(BigInteger.valueOf(3), getNcX(3, 2));
        assertEquals(BigInteger.valueOf(6), getNcX(4, 2));
    }

    @Test
    public void tests_getCoefficient() {
        assertEquals(BigInteger.ONE, getCoefficient(1, 2));
        assertEquals(BigInteger.valueOf(-8), getCoefficient(-2, 3));
        assertEquals(BigInteger.valueOf(81), getCoefficient(-3, 4));
        assertEquals(BigInteger.valueOf(16), getCoefficient(4, 2));
    }

    @Test
    public void tests_getVal() {
        assertEquals(-2, getVal("-2"));
        assertEquals(2, getVal("2"));
        assertEquals(-22, getVal("-22"));
        assertEquals(-22222, getVal("-22222"));
        assertEquals(2323, getVal("+2323"));
        assertEquals(-1, getVal("-"));
        assertEquals(1, getVal(""));
        assertEquals(1, getVal("+"));
        assertEquals(123, getVal("123"));
    }

    public String expand(String expr) {

        int leftCoefficient;
        String leftTerm;
        int rightCoefficient;
        String rightTerm;
        int power;
        StringBuilder builder = new StringBuilder();
        Pattern pattern = Pattern.compile("\\(([-]?\\d*)([a-zA-Z]?)([+-]?\\d*)([a-zA-Z]?)\\)\\^(\\d*)");
        Matcher matcher = pattern.matcher(expr);
        if (matcher.find()) {
            //System.out.println("------------" + expr + "-------------------------------");
            leftTerm = matcher.group(2);
            leftCoefficient = getVal(matcher.group(1));
            rightCoefficient = getVal(matcher.group(3));
            rightTerm = matcher.group(4);
            power = Integer.parseInt(matcher.group(5));

            if (power == 0) {
                return "1";
            }
            if (leftTerm.isEmpty() && leftCoefficient == 0) {
                BigInteger prod = BigInteger.valueOf(rightCoefficient).pow(power);
                return (prod.compareTo(BigInteger.ONE) > 0 ? prod : "") +
                        rightTerm +
                        "^" +
                        power;
            }
            if (rightTerm.isEmpty() && rightCoefficient == 0) {
                BigInteger prod = BigInteger.valueOf(leftCoefficient).pow(power);
                return (prod.compareTo(BigInteger.ONE) > 0 ? prod : "") +
                        leftTerm +
                        "^" +
                        power;
            }

            int number = 0;
            while (number <= power) {
                BigInteger coeff = getNcX(power, number)
                        .multiply(getCoefficient(leftCoefficient, power - number))
                        .multiply(getCoefficient(rightCoefficient, number));
                boolean isOnlyProduct = ((power == number || leftTerm.isEmpty()) &&
                        ((number == 0) || rightTerm.isEmpty()));
                System.out.println(power + "," + number + "," + isOnlyProduct + " : " + coeff);

                if (coeff.compareTo(BigInteger.ZERO) < 0 && coeff.abs().equals(BigInteger.ONE) && !isOnlyProduct)
                    builder.append("-");
                if (coeff.abs().compareTo(BigInteger.ONE) > 0 || (coeff.abs().equals(BigInteger.ONE) && isOnlyProduct)) {
                    builder.append(coeff);
                }
                if (!leftTerm.isEmpty()) {
                    if (power - number != 0) builder.append(leftTerm);
                    if (power - number > 1) builder.append("^").append(power - number);
                }
                if (!rightTerm.isEmpty()) {
                    if (number != 0) builder.append(rightTerm);
                    if (number > 1) builder.append("^").append(number);
                }
                if (number != power) builder.append("+");
                number++;
            }

        }
        return builder.toString().replaceAll("\\+-", "-"); //Hack
    }


    private int getVal(String coefficient) {
        boolean isNegative = coefficient.trim().startsWith("-");
        int value;
        value = coefficient.matches("[+-]?\\d+") ? Integer.parseInt(coefficient) : (isNegative ? -1 : 1);

        return value;
    }

    private static BigInteger getNcX(int number, int idx) {
        if (idx == 0) return BigInteger.ONE;
        if (idx == 1) return BigInteger.valueOf(number);
        return BigInteger.valueOf(number).multiply(getNcX(number - 1, idx - 1))
                .divide(BigInteger.valueOf(idx));
    }

    private static BigInteger getCoefficient(int constant, int power) {
        return BigInteger.valueOf((long) Math.pow(constant, power));
    }
}
