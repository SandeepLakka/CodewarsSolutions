package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
Description:
Task

You will be given an array of numbers.
You have to sort the odd numbers in ascending order while leaving the even numbers at their original positions.

Examples

[7, 1]  =>  [1, 7]
[5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]

Categories : Fundamentals, Arrays
 */
public class SortTheOdd {
    @Test
    public void tests() {
        assertArrayEquals(new int[]{1, 3, 2, 8, 5, 4}, sortArray(new int[]{5, 3, 2, 8, 1, 4}));
        assertArrayEquals(new int[]{1, 3, 5, 8, 0}, sortArray(new int[]{5, 3, 1, 8, 0}));
        assertArrayEquals(new int[]{}, sortArray(new int[]{}));
        assertArrayEquals(new int[]{1, 3, 2, 8, 5, 4, 11},
                sortArray(new int[]{5, 3, 2, 8, 1, 4, 11}));
        assertArrayEquals(new int[]{2, 22, 1, 5, 4, 11, 37, 0},
                sortArray(new int[]{2, 22, 37, 11, 4, 1, 5, 0}));
        assertArrayEquals(new int[]{1, 1, 5, 11, 2, 11, 111, 0},
                sortArray(new int[]{1, 111, 11, 11, 2, 1, 5, 0}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                sortArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                sortArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 8, 7, 6, 9},
                sortArray(new int[]{0, 1, 2, 3, 4, 9, 8, 7, 6, 5}));
    }

    public static int[] sortArray(int[] array) {
        List<Integer> oddIndices = IntStream.range(0, array.length)
                .filter(value -> (array[value] & 1) == 1)
                .boxed()
                .collect(Collectors.toList());
        boolean isOddsSorted = false;
        int lastUnsortedOddIndex = oddIndices.size() - 1;
        while (!isOddsSorted) {
            isOddsSorted = true;
            for (int i = 0; i < lastUnsortedOddIndex; i++) {
                int currIndex = oddIndices.get(i);
                int nextIndex = oddIndices.get(i + 1);
                if (array[currIndex] > array[nextIndex]) {
                    swap(array, currIndex, nextIndex);
                    isOddsSorted = false;
                }
            }
            lastUnsortedOddIndex--;
        }
        return array;
    }

    private static void swap(int[] array, int a, int b) {
        array[a] ^= array[b];
        array[b] ^= array[a];
        array[a] ^= array[b];
    }
}