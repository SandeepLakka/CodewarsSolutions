package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Given an array of integers, find the one that appears an odd number of times.
 *
 * There will always be only one integer that appears an odd number of times.
 * Examples
 *
 * [7] should return 7, because it occurs 1 time (which is odd).
 * [0] should return 0, because it occurs 1 time (which is odd).
 * [1,1,2] should return 2, because it occurs 1 time (which is odd).
 * [0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
 * [1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
 * Categories : Fundamentals
 */
public class FindOdd {
    @Test
    public void testFindIt() {
        assertEquals(7, findIt(new int[]{7}));
		assertEquals(0, findIt(new int[]{0}));
		assertEquals(2, findIt(new int[]{1, 1, 2}));
		assertEquals(0, findIt(new int[]{0, 1, 0, 1, 0}));
		assertEquals(4, findIt(new int[]{1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1}));
		assertEquals(5, findIt(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
		assertEquals(-1, findIt(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
		assertEquals(5, findIt(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
		assertEquals(10, findIt(new int[]{10}));
		assertEquals(10, findIt(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}));
		assertEquals(1, findIt(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));


		assertEquals(7, mindBlowing(new int[]{7}));
		assertEquals(0, mindBlowing(new int[]{0}));
		assertEquals(2, mindBlowing(new int[]{1, 1, 2}));
		assertEquals(0, mindBlowing(new int[]{0, 1, 0, 1, 0}));
		assertEquals(4, mindBlowing(new int[]{1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1}));
		assertEquals(5, mindBlowing(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
		assertEquals(-1, mindBlowing(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
		assertEquals(5, mindBlowing(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
		assertEquals(10, mindBlowing(new int[]{10}));
		assertEquals(10, mindBlowing(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}));
		assertEquals(1, mindBlowing(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));

	}

	public static int findIt(int[] a) {
		return Arrays.stream(a).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				.filter(integerLongEntry -> (integerLongEntry.getValue() & 1) == 1)
				.findFirst()
				.get().getKey();
	}

	public static int mindBlowing(int[] a) {
		int xoredInt = 0;
		for (int num : a) {
			xoredInt ^= num;
		}
		return xoredInt;
	}
}