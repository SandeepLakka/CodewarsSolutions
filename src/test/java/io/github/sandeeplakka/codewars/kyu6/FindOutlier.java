package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

You are given an array (which will have a length of at least 3, but could be very large)
containing integers. The array is either entirely comprised of odd integers or
entirely comprised of even integers except for a single integer N.
Write a method that takes the array as an argument and returns this "outlier" N.

Examples

[2, 4, 0, 100, 4, 11, 2602, 36] Should return: 11 (the only odd number)
[160, 3, 1719, 19, 11, 13, -21] Should return: 160 (the only even number)

Categories : Algorithms
 */
public class FindOutlier {

    @Test
    public void tests() {

        int[] exampleTest1 = {2, 6, 8, -10, 3};
        int[] exampleTest2 = {206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781};
        int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};
        int[] exampleTest4 = {11, 2, 4, 0, 100, 4, 12, 2602, 36};

        assertEquals(3, find(exampleTest1));
        assertEquals(206847684, find(exampleTest2));
        assertEquals(0, find(exampleTest3));
        assertEquals(11, find(exampleTest4));

        assertEquals(3, cleverSolution(exampleTest1));
        assertEquals(206847684, cleverSolution(exampleTest2));
        assertEquals(0, cleverSolution(exampleTest3));
        assertEquals(11, cleverSolution(exampleTest4));

    }

    static int find(int[] integers) {
        boolean isEvenPreviously = (integers[0] & 1) == 0;
        boolean isEvenNow = false;

        for (int i = 1; i < integers.length; i++) {
            isEvenNow = (integers[i] & 1) == 0;
            if (isEvenPreviously != isEvenNow) {
                boolean tieBreaker = (integers[getNeighborIndex(i, integers.length)] & 1) == 0;
                if (isEvenPreviously == tieBreaker) return integers[i];
                else return integers[i - 1];
            }
        }
        return -1;
    }

    //inspiration
    static int cleverSolution(int[] integers) {
        int bitCount = 0;
        for (int i = 0; i < 3; i++) {
            bitCount += Math.abs(integers[i] & 1);
        }
        //Mixed cases : 0 0 1 => sum of 1 and odd is outlier || 1 1 0 => sum of 2 and even is outlier
        //Pure cases  : 0 0 0 => sum of 1 and odd is outlier || 1 1 1 => sum of 3 and even is outlier
        //If odd then 1 will be the last bit   || If even then 0 will be the last bit

        int parityBit = (bitCount < 2) ? 1 : 0;
        return IntStream.of(integers)
                .parallel()
                .filter(value -> (Math.abs(value) & 1) == parityBit)
                .findAny().getAsInt();

        //Minor Improvements which can be done are following:
        //If the number we are chasing is odd, then no need to go for Math.abs()
    }


    //Helpers
    private static int getNeighborIndex(int current, int length) {
        return current - 1 > 0 && current - 1 < length ? current - 1 : current + 1;
    }


}