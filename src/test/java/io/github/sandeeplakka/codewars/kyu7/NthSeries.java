package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NthSeries {
    @Test
    public void test1() {
        assertEquals("1.57", NthSeries.seriesSum(5));
    }

    @Test
    public void test2() {
        assertEquals("1.77", NthSeries.seriesSum(9));
    }

    @Test
    public void test3() {
        assertEquals("1.94", NthSeries.seriesSum(15));
    }

    //naive approach
    //TODO: Implement O(1) impl using the mathematical formula for Harmonic Progression series
    public static String seriesSum(int n) {
        double start = 1;
        int diff = 3;
        double res = 0;
        while (n > 0) {
            res += 1 / start;
            start += diff;
            n--;
        }
        return String.format("%.2f", res);
    }
}