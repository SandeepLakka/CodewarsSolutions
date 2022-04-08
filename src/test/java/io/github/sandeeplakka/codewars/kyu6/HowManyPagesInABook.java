package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.log10;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HowManyPagesInABook {

    @Test
    public void testSample() {
        assertEquals(5, amountOfPages(5));
        assertEquals(17, amountOfPages(25));
        assertEquals(401, amountOfPages(1095));
        assertEquals(97, amountOfPages(185));
        assertEquals(256, amountOfPages(660));
    }

    @Test
    public void testEdges() {
        assertEquals(1, HowManyPagesInABook.amountOfPages(1));
        assertEquals(1000, HowManyPagesInABook.amountOfPages(2893));
        assertEquals(999, HowManyPagesInABook.amountOfPages(2889));
    }

    @RepeatedTest(200)
    public void testRandom() {
        int expectedPages = getRandomInt(12, pow(10, 5));
        int totalDigits = A058183(expectedPages);
        int actualPages = HowManyPagesInABook.amountOfPages(totalDigits);
        assertEquals(expectedPages, actualPages);
    }

    private int getRandomInt(int fromInclusive, int toExclusive) {
        return ThreadLocalRandom.current().nextInt(fromInclusive, toExclusive);
    }

    // see https://oeis.org/A058183
    private static int A058183(int n) {
        return n <= 0 ? 0 : (n + 1) * (floor(log10(10 * n))) - (pow(10, floor(log10(10 * n))) - 1) / (10 - 1); // not simplified on purpose
    }

    private static int pow(Number a, Number b) {
        return (int) Math.pow(a.doubleValue(), b.doubleValue());
    }

    private static int floor(Number a) {
        return (int) Math.floor(a.doubleValue());
    }

    public static int amountOfPages(int summary) {
        int noOfPages = 0;
        StringBuilder builder = new StringBuilder();
        while (summary > builder.length()) {
            builder.append(++noOfPages);
        }
        return noOfPages;
    }

}