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

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Equation {

    @Test
    public void sampleTests() {
        assertEquals(new BigInteger("12"), differentiate("12x+2", 3));
        assertEquals(new BigInteger("5"), differentiate("x^2-x", 3));
        assertEquals(new BigInteger("-20"), differentiate("-5x^2+10x+4", 3));
    }

    @Test
    public void test() {
        differentiate("x^2-x", 4);
        differentiate("-5x^2+12x-2", 3);
    }

    @Test
    public void te() {
        List<String> list = Arrays.asList(
                "-x", "2x", "-3x^2", "5x^3", "+2x^4", "+4", "-5"
        );
        list.stream().map(Term::new).forEach(System.out::println);

    }

    public static BigInteger differentiate(String equation, long x) {
        List<Integer> coefficients = new ArrayList<>();
        List<Integer> powers = new ArrayList<>();
        int i = 0;
        StringBuilder result = new StringBuilder();
        String term = "";
        while (i < equation.length()) {
            //
            if (equation.charAt(i) == '+' || equation.charAt(i) == '-') {
                //System.out.println("Term we have is : "+term);
                result.append(getCoefficient(term) >= 0 ? "+" : "");
                result.append(differentiate(term));
                term = "";
            }
            term += equation.charAt(i);
            System.out.println("term is : " + term + "\t\tresult is : " + result);
            i++;
        }
        System.out.println("Result : " + result);
        System.out.println("--------------------");
        // Your code here!
        return null;
    }

    @Test
    public void test_differentiate() {
        System.out.println(differentiate("2x") + " == 2");
        System.out.println(differentiate("-2x^2") + " == -4x");
        System.out.println(differentiate("100") + " == 0");
        System.out.println(differentiate("5x^2") + "== +10x");
        System.out.println(differentiate("-x") + " == -1");
    }

    private static String differentiate(String term) {
        if (term.isEmpty()) return "";
        //x^n = nx^n-1
        //c = 0
        //cx = c
        int coefficient = getCoefficient(term);
        int power = getPower(term);
        if (power == 0) return String.valueOf(0);
        if (power == 1) return String.valueOf(coefficient);
        return (coefficient * power) + "x" + (power > 2 ? power - 1 : "");
    }

    private static int getCoefficient(String term) {
        if (!term.contains("x")) {
            term = term.substring(0, term.indexOf("x"));
            if (!term.matches("[+-]?[0-9]+")) {
                return Integer.parseInt(term + 1);
            }
            return Integer.parseInt(term);
        }
        return Integer.parseInt(term);
    }

    private static int getPower(String term) {
        if (!term.contains("x")) return 0;
        if (!term.contains("^")) return 1;
        return Integer.parseInt(term.substring(term.indexOf("^") + 1));
    }
}

class Term {
    final String REGEX = "([-+]?)([\\d]?)(x)?([\\^][\\d])?";
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
        term.setPower(term.getPower() - 1);
        return term;
    }
}