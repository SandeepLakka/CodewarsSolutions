package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
Find numbers which are divisible by given number

Complete the function which takes two arguments and returns all numbers which are divisible by the given divisor. First argument is an array of numbers and the second is the divisor.
Example

divisibleBy([1, 2, 3, 4, 5, 6], 2) == [2, 4, 6]

Categories : Algorithms, Arrays
 */
public class EvenNumbers {

    @Test
    public void testSimple() {
        assertArrayEquals(new int[]{2, 4, 6}, divisibleBy(new int[]{1, 2, 3, 4, 5, 6}, 2));
        assertArrayEquals(new int[]{3, 6}, divisibleBy(new int[]{1, 2, 3, 4, 5, 6}, 3));
        assertArrayEquals(new int[]{0, 4}, divisibleBy(new int[]{0, 1, 2, 3, 4, 5, 6}, 4));
    }

    public static int[] divisibleBy(int[] numbers, int divider) {
        return IntStream.of(numbers).filter(value -> value % divider == 0).toArray();
    }
}