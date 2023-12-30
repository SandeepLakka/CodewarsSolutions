package io.github.sandeeplakka.codewars.kyu4;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/*
    Adding Big Numbers

    We need to sum big numbers and we require your help.
    Write a function that returns the sum of two numbers. The input numbers are strings and the function must return a string.

    Example
        add("123", "321"); -> "444"
        add("11", "99");   -> "110"

    Notes
        The input numbers are big.
        The input is a string of only digits
        The numbers are positives

    Categories : Mathematics, Big Integers, Algorithms
 */
public class BigNumbersAdder {

    private final Random r = ThreadLocalRandom.current();

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource(value = {
            "1   , 1  ,    2",
            "123 , 456,    579",
            "888 , 222,    1110",
            "1372, 69 ,    1441",
            "12  , 456,    468",
            "100 , 101,    201",
            "999 , 999,    1998",
            "63829983432984289347293874, 90938498237058927340892374089, 91002328220491911630239667963"})
    @DisplayName("Sample tests")
    void basicTests(String a, String b, String expected) {
        assertEquals(expected, add(a, b));
    }

    private String randomNums() {
        int l = r.nextInt(30) + 3;
        StringBuilder s = new StringBuilder();
        boolean allZeros = true;
        for (int i = 0; i < l; i++) {
            int digit = r.nextInt(10);
            allZeros &= digit == 0;
            s.append(digit);
        }
        return allZeros ? "1" : s.toString();
    }

    @Test
    @DisplayName("Random tests")
    void randomTests() {
        for (int i = 0; i < 50; i++) {
            String s = randomNums();
            String s2 = randomNums();
            assertEquals(solve(s, s2), add(s, s2), String.format("%s + %s", s, s2));
        }
    }

    private String solve(String s, String s2) {
        StringBuilder result = new StringBuilder();
        s2 = "0".repeat(s.length() < s2.length() ? 0 : s.length() - s2.length()) + s2;
        s = "0".repeat(s2.length() < s.length() ? 0 : s2.length() - s.length()) + s;
        int remainder = 0;
        for (long i = s.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(s.charAt((int) i) + "");
            n += Integer.parseInt(s2.charAt((int) i) + "");
            n += remainder;
            remainder = n / 10;
            result.insert(0, n % 10);
        }
        result = new StringBuilder(remainder == 0 ? result.toString() : remainder + result.toString());
        while (result.toString().startsWith("0")) {
            result = new StringBuilder(result.substring(1, result.length()));
        }
        return result.toString();
    }

    @Test
    @DisplayName("Anti cheat")
    @Disabled
    void antiCheat() {
        try {
            Scanner scanner = new Scanner(new File("/workspace/solution.txt"));
            String content = scanner.useDelimiter("\\Z").next();
            if (Pattern.compile("java\\s*\\.\\s*math").matcher(content).find()) {
                fail("Using classes from java.math is not allowed!");
            }
            if (content.contains("\\u")) {
                fail("Are you trying to cheat with unicode literals? No '\\u' allowed!");
            }
        } catch (Exception e) {
            System.exit(1);
        }
    }


    //-----------------------
    public String add(String a, String b) {
        int minLength;
        String maxNumber;
        String resultString;
        //strip leading zeroes
        while (a.startsWith("0")) {
            a = a.substring(1);
        }
        while (b.startsWith("0")) {
            b = b.substring(1);
        }
        if (a.length() > b.length()) {
            minLength = b.length();
            maxNumber = a;
        } else {
            minLength = a.length();
            maxNumber = b;
        }
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        for (int idx = 0; idx < minLength; idx++) {
            int aNumberDigit = a.charAt(a.length() - 1 - idx) - '0';
            int bNumberDigit = b.charAt(b.length() - 1 - idx) - '0';
            int result = carry + aNumberDigit + bNumberDigit;
            if (result > 9) {
                carry = result / 10;
                result = result % 10;
            } else {
                carry = 0;
            }
            builder.append(result);
        }

        for (int i = minLength; i < maxNumber.length(); i++) {
            int idx = maxNumber.length() - i - 1;
            int result = carry + maxNumber.charAt(idx) - '0';
            if (result > 9) {
                carry = result / 10;
                result = result % 10;
            } else {
                carry = 0;
            }
            builder.append(result);
        }
        if (carry != 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }
}
