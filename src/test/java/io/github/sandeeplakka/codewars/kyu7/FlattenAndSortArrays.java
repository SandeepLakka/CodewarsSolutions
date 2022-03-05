package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
Flatten and sort an array

Challenge:

Given a two-dimensional array of integers, return the flattened version of the array with all the integers in the sorted (ascending) order.

Example:

Given [[3, 2, 1], [4, 6, 5], [], [9, 7, 8]], your function should return [1, 2, 3, 4, 5, 6, 7, 8, 9].

Categories : Fundamentals, Arrays, Sorting, Algorithms, Lambdas, Functional Programming,
Functions, Declarative Programming, Control Flow, Basic Language Features
 */
public class FlattenAndSortArrays {

	@Test
	public void exampleTest() {
		assertArrayEquals(new int[]{},
				flattenAndSort(new int[][]{}));
		assertArrayEquals(new int[]{1},
				flattenAndSort(new int[][]{{}, {1}}));
		assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
				flattenAndSort(new int[][]{{3, 2, 1}, {7, 9, 8}, {6, 4, 5}}));
		assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 100},
				flattenAndSort(new int[][]{{1, 3, 5}, {100}, {2, 4, 6}}));
		assertArrayEquals(new int[]{111, 222, 333, 444, 555, 666, 777, 888, 999},
				flattenAndSort(new int[][]{{111, 999}, {222}, {333}, {444}, {888}, {777}, {666}, {555}}));
	}

	@Test
	public void basicTest() {
		assertArrayEquals(new int[]{0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9},
				flattenAndSort(new int[][]{{9, 7, 5, 3, 1}, {8, 6, 4, 2, 0}, {}, {1}}));
		assertArrayEquals(new int[]{-2, -1, -1, 0, 1, 1, 1, 2, 3},
				flattenAndSort(new int[][]{{1}, {}, {1}, {}, {}, {-1, -2, -1}, {0, 3}, {1}, {2}}));
		assertArrayEquals(new int[]{64, 100, 202, 303, 503, 504, 2500, 4096},
				flattenAndSort(new int[][]{{}, {}, {64}, {}, {504, 503}, {4096}, {}, {303}, {202}, {2500}, {}, {100}}));
		assertArrayEquals(new int[]{0, 18, 27, 35, 46, 54, 63, 72, 81, 90},
				flattenAndSort(new int[][]{{90, 81, 72}, {63, 54, 35}, {}, {46}, {27, 18, 0}}));
		assertArrayEquals(new int[]{-1, -1, -1, 0, 0, 0, 1, 1, 1},
				flattenAndSort(new int[][]{{1}, {}, {1}, {1}, {0}, {-1}, {}, {0}, {-1}, {0}, {-1}}));
		assertArrayEquals(new int[]{-9, -8, -7, -6, -5, -4, -3, -2, -1},
				flattenAndSort(new int[][]{{-9, -8, -7, -6, -5, -4, -3, -2, -1}}));
		assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
				flattenAndSort(new int[][]{{9, 8, 7, 6, 5, 4, 3, 2, 1}}));
	}

	public static int[] flattenAndSort(int[][] array) {
		return Stream.of(array).flatMapToInt(IntStream::of).sorted().toArray();
	}

}
