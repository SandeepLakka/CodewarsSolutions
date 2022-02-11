package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Sum without highest and lowest number

Description:
Task

Sum all the numbers of a given array ( cq. list ),
except the highest and the lowest element ( by value, not by index! ).

The highest or lowest element respectively is a single element at each edge,
even if there are more than one with the same value.

Mind the input validation.

Example
{ 6, 2, 1, 8, 10 } => 16
{ 1, 1, 11, 2, 3 } => 6

Input validation
If null is given instead of an array, or the given array is an empty list or a list with only 1 element, return 0.

Categories : Fundamentals, Basic Language Features
 */
public class SumWithHighestAndLowest {

    @Test
    public void BasicTests() {
        assertEquals(16, sum(new int[]{6, 2, 1, 8, 10}));
    }

    @Test
    public void SumOnlyOneElement() {
        assertEquals(0, sum(new int[]{6}));
    }

    @Test
    public void SumOnlyTwoElements() {
        assertEquals(0, sum(new int[]{6, 7}));
    }

    @Test
    public void SumPositives() {
        assertEquals(16, sum(new int[]{6, 2, 1, 8, 10}));
    }

    @Test
    public void SumPositivesWithDoubleMax() {
        assertEquals(17, sum(new int[]{6, 0, 1, 10, 10}));
    }

    @Test
    public void SumNegatives() {
        assertEquals(-28, sum(new int[]{-6, -20, -1, -10, -12}));
    }

    @Test
    public void SumMixed() {
        assertEquals(3, sum(new int[]{-6, 20, -1, 10, -12}));
    }

    @Test
    public void SumEmptyArray() {
        assertEquals(0, sum(new int[0]));
    }

    @Test
    public void SumNullArray() {
        assertEquals(0, sum(null));
    }

    public static int sum(int[] numbers) {
        if (numbers == null || numbers.length < 2) return 0;
        IntSummaryStatistics statistics = IntStream.of(numbers).summaryStatistics();
        return (int) (statistics.getSum() - (statistics.getMin() + statistics.getMax()));
    }
}