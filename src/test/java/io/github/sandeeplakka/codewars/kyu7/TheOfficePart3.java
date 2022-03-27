package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
The Office III - Broken Photocopier

The bloody photocopier is broken... Just as you were sneaking around the office to print off your favourite binary code!
Instead of copying the original, it reverses it: '1' becomes '0' and vice versa.
Given a string of binary, return the version the photocopier gives you as a string.

Other Kata's:

The Office I - Outed
The Office II - Boredeom Score
The Office IV - Find a Meeting Room
The Office V - Find a Chair

Categories : Fundamentals, Strings, Arrays

 */
public class TheOfficePart3 {

    @Test
    public void tests() {
        // assertEquals("expected", "actual");
        assertEquals("0", broken("1"));
        assertEquals("01111111010010000001100110111", broken("10000000101101111110011001000"));
        assertEquals("011101", broken("100010"));

        assertEquals("0", brokenCleverly("1"));
        assertEquals("01111111010010000001100110111", brokenCleverly("10000000101101111110011001000"));
        assertEquals("011101", brokenCleverly("100010"));
    }

    @Test
    public void moreTests() {
        assertEquals("10001001100100000001010000111100110", broken("01110110011011111110101111000011001"));
        assertEquals("011111110110110101011", broken("100000001001001010100"));
        assertEquals("000", broken("111"));
        assertEquals("000101010100110100010011110111", broken("111010101011001011101100001000"));
        assertEquals("010010001010101001100101110100001", broken("101101110101010110011010001011110"));

        assertEquals("10001001100100000001010000111100110", brokenCleverly("01110110011011111110101111000011001"));
        assertEquals("011111110110110101011", brokenCleverly("100000001001001010100"));
        assertEquals("000", brokenCleverly("111"));
        assertEquals("000101010100110100010011110111", brokenCleverly("111010101011001011101100001000"));
        assertEquals("010010001010101001100101110100001", brokenCleverly("101101110101010110011010001011110"));
    }

    //1^1 = 0
    //0^1 = 1

    public static String broken(final String x) {
        // Your code here
        return Arrays.stream(x.split(""))
                .mapToInt(Integer::parseInt)
                .map(val -> val ^ 1)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());
    }

    public static String brokenCleverly(final String x) {
        return x.chars()
                .map(i -> (i + 1) % 2)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

}