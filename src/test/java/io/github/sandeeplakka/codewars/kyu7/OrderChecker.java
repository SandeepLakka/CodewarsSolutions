package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
Are the numbers in order?

In this Kata, your function receives an array of integers as input.
Your task is to determine whether the numbers are in ascending order.
An array is said to be in ascending order if there are no two adjacent
integers where the left integer exceeds the right integer in value.

For the purposes of this Kata, you may assume that all inputs are valid,
i.e. arrays containing only integers.

Note that an array of 0 or 1 integer(s) is automatically considered
to be sorted in ascending order since all (zero) adjacent pairs of integers
satisfy the condition that the left integer does not exceed the right integer in value.

For example:
    isAscOrder(new int[]{1,2,4,7,19}) == true
    isAscOrder(new int[]{1,2,3,4,5}) == true
    isAscOrder(new int[]{1,6,10,18,2,4,20}) == false
    isAscOrder(new int[]{9,8,7,6,5,4,3,2,1}) == false // numbers are in DESCENDING order

N.B. If your solution passes all fixed tests but fails at the random tests,
make sure you aren't mutating the input array.

Categories : Fundamentals, Mathematics, Algorithms
 */
public class OrderChecker {

    @Test
    public void singleInteger() {
        assertTrue(isAscOrder(new int[]{1}));
        assertTrue(isAscOrder(new int[]{2}));
    }

    @Test
    public void sameInteger() {
        assertTrue(isAscOrder(new int[]{1, 1}));
        assertTrue(isAscOrder(new int[]{2, 2}));
    }

    @Test
    public void arrayOf2Integers() {
        assertTrue(isAscOrder(new int[]{1, 2}));
        assertFalse(isAscOrder(new int[]{2, 1}));
    }

    @Test
    public void arrayOf3Integers() {
        assertTrue(isAscOrder(new int[]{1, 2, 3}));
        assertFalse(isAscOrder(new int[]{1, 3, 2}));
        assertTrue(isAscOrder(new int[]{1, 4, 13, 97, 508, 1047, 20058}));
        assertFalse(isAscOrder(new int[]{56, 98, 123, 67, 742, 1024, 32, 90969}));
    }

    @Test
    public void moreAdvancedCases() {
        assertTrue(isAscOrder(new int[]{1, 4, 13, 97, 508, 1047, 20058}));
        assertFalse(isAscOrder(new int[]{56, 98, 123, 67, 742, 1024, 32, 90969}));
    }

    @Test
    public void randomTest() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 100; i++) {
            int arrayLength = random.nextInt(10, 1000);
            int[] orderedArray, unorderedArray;
            do {
                List<Integer> randomValues = IntStream.range(0, arrayLength)
                        .map(x -> random.nextInt(1, arrayLength * 10))
                        .boxed().collect(Collectors.toList());
                orderedArray = randomValues.stream().mapToInt(x -> x).sorted().toArray();
                unorderedArray = randomValues.stream().mapToInt(x -> x).toArray();
            } while (Arrays.equals(orderedArray, unorderedArray));
            assertTrue(isAscOrder(orderedArray));
            assertFalse(isAscOrder(unorderedArray));
        }
    }

    public static boolean isAscOrder(int[] arr) {
        if (arr.length < 1) return true;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }

}
