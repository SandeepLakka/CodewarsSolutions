package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
Enumerable Magic #25 - Take the First N Elements

Create a function that accepts a list/array and a number n,
and returns a list/array of the first n elements from the list/array.

If you need help, here's a reference:
https://docs.oracle.com/javase/6/docs/api/java/util/Arrays.html#copyOfRange(int[],%20int,%20int)

Categories : Fundamentals
 */
public class ZywOo {

    @Test
    public void basicTests() {
        assertArrayEquals(new int[]{0, 1, 2},
                take(new int[]{0, 1, 2, 3, 5, 8, 13}, 3),
                "should return the first 3 items");
        assertArrayEquals(new int[0],
                take(new int[]{0, 1, 2, 3, 5, 8, 13}, 0),
                "should return 0 items");
        assertArrayEquals(new int[0],
                take(new int[0], 3), "empty array should return empty array");
    }

    @Test
    public void randomTests() {
        for (int i = 0; i < 100; i++) {
            int n = (int) Math.floor(100 * Math.random());
            int[] randomArray = generateRandomArray();

            assertArrayEquals(solution(randomArray, n),
                    take(randomArray, n),
                    "Testing with array " + Arrays.toString(randomArray) + " and n = " + n);
        }

    }

    private int[] solution(int[] arr, int n) {
        return arr.length > 0 && arr.length > n ? Arrays.copyOfRange(arr, 0, n) : arr;
    }

    private int[] generateRandomArray() {
        int length = (int) Math.floor(100 * Math.random());
        int min = (int) Math.floor(-100 * Math.random());
        int max = (int) Math.floor(100 * Math.random());
        return new Random().ints(length, min, max).toArray();
    }

    public static int[] take(int[] arr, int n) {
        return IntStream.of(arr).limit(n).toArray();
    }
}