package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Array.diff
    Goal in this kata is to implement a difference function,
    which subtracts one list from another and returns the result.

    It should remove all values from list a, which are present in list b keeping their order.

    example : array_diff({1, 2}, 2, {1}, 1, *z) == {2} (z == 1)

    If a value is present in b, all of its occurrences must be removed from the other:
    example : array_diff({1, 2, 2, 2, 3}, 5, {2}, 1, *z) == {1, 3} (z == 2)

    Categories: Fundamentals, Arrays

 */
public class ArrayDifference {

    @Test
    public void testArrayDiff(){
        assertEquals(true, true);
        assertArrayEquals(new int[] {2}, arrayDiff(new int [] {1,2}, new int[] {1}));
        assertArrayEquals(new int[] {2,2}, arrayDiff(new int [] {1,2,2}, new int[] {1}));
        assertArrayEquals(new int[] {1}, arrayDiff(new int [] {1,2,2}, new int[] {2}));
        assertArrayEquals(new int[] {1,2,2}, arrayDiff(new int [] {1,2,2}, new int[] {}));
        assertArrayEquals(new int[] {}, arrayDiff(new int [] {}, new int[] {1,2}));
    }

    private static int[] arrayDiff(int[] aArray, int[] bArray) {
        return IntStream.of(aArray)
                .filter(value -> IntStream.of(bArray)
                        .noneMatch(bVal -> bVal == value)
                ).toArray();
    }
}
