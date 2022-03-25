package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Length of missing array

You get an array of arrays.
If you sort the arrays by their length, you will see, that their length-values are consecutive.
But one array is missing!


You have to write a method, that return the length of the missing array.

Example:
[[1, 2], [4, 5, 1, 1], [1], [5, 6, 7, 8, 9]] --> 3

If the array of arrays is null/nil or empty, the method should return 0.

When an array in the array is null or empty, the method should return 0 too!
There will always be a missing element and its length will be always between the given arrays.

Categories : Algorithms, Basic Language Features, Fundamentals, Arrays
 */
public class LengthOfMissingArray {

    @Test
    public void BasicTests() {
        assertEquals(3, getLengthOfMissingArray(new Object[][]{new Object[]{1, 2},
                new Object[]{4, 5, 1, 1}, new Object[]{1}, new Object[]{5, 6, 7, 8, 9}}));
        assertEquals(2, getLengthOfMissingArray(new Object[][]{new Object[]{5, 2, 9},
                new Object[]{4, 5, 1, 1}, new Object[]{1}, new Object[]{5, 6, 7, 8, 9}}));
        assertEquals(2, getLengthOfMissingArray(new Object[][]{new Object[]{null},
                new Object[]{null, null, null}}));
        assertEquals(5, getLengthOfMissingArray(new Object[][]{new Object[]{'a', 'a', 'a'},
                new Object[]{'a', 'a'}, new Object[]{'a', 'a', 'a', 'a'}, new Object[]{'a'},
                new Object[]{'a', 'a', 'a', 'a', 'a', 'a'}}));

        assertEquals(0, getLengthOfMissingArray(new Object[][]{}));
    }

    public static int getLengthOfMissingArray(Object[][] arrayOfArrays) {

        if (arrayOfArrays == null || arrayOfArrays.length == 0) return 0;

        boolean isEmptyArrays = Arrays.stream(arrayOfArrays).anyMatch(objects -> objects == null || objects.length == 0);
        if (isEmptyArrays) return 0;

        //Arrays.stream(arrayOfArrays).forEach(val -> System.out.println(Arrays.toString(val)));
        IntSummaryStatistics stats = Arrays.stream(arrayOfArrays)
                .mapToInt(objects -> objects.length)
                .summaryStatistics();
        //min to max should be consecutive but one element is missed
        //Sum of first n numbers = n*(n+1)/2
        //sum of m-n numbers = (n*(n+1)-m*(m-1))/2
        //missing length item = (sum of m-n numbers) - (sum of lengths in input array)
        //Note: m(highest) number is the max element in the input list
        //Example
        //1 2 3 4 5 -> 15
        //Let's take input arr as 2 3 5
        //
        //2 3 5 -> (sum of 5) - (sum of 1) -> 15 - 1 -> 14
        //sum of lengths in input array = (2+3+5) = 10
        //missing length item = 14 - 10 = 4
        int hi = stats.getMax();
        int lo = stats.getMin();
        long sum = stats.getSum();
        //System.out.println("--------");
        return (int) (((hi * (hi + 1)) - (lo * (lo - 1))) / 2 - sum);
    }
}