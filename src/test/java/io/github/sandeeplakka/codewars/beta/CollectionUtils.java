package io.github.sandeeplakka.codewars.beta;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
Flatten a List

You get a list of Objects, those Objects can again be lists, sets or Integers.
Your Task is to write a function to flatten the nesting in the list.

Example:
Input:  [[1], 2, [[3, 4], 5], [[[]]], [[[6]]], 7, 8, []]
Output: [1, 2, 3, 4, 5, 6, 7, 8]

If the list is null or empty return an empty list.
Have fun coding :)

Categories: Lists, Algorithms

 */
public class CollectionUtils {


	@Test
	public void testEmpty() {
		List<Object> emptyList = CollectionUtils.flattenList(null);
		assertArrayEquals(new Object[0], emptyList.toArray());
	}

	@Test
	public void testFlattening() {
		List<Object> nestedList = new ArrayList<>();
		nestedList.add(5);
		List<Object> innerList = Arrays.asList(4, 3, 2);
		nestedList.add(innerList);

		List<Object> list = CollectionUtils.flattenList(nestedList);
		List<Object> testList = Arrays.asList(5, 4, 3, 2);
		assertArrayEquals(testList.toArray(), list.toArray());

	}

	//TODO: update the impl to make it work for multiple levels of nesting in correct order
	public static List<Object> flattenList(List<Object> list) {
		// Your code goes here
		List<Object> result = new ArrayList<>();
		if (list == null) return result;
		flatten(list, result);
		//list.stream().flatMap(o -> (o instanceof List) ? ((List<Object>) o).stream() : Stream.of(o)).collect(Collectors.toList());
		return result;
	}

	private static void flatten(Object item, List<Object> result) {
		if (item instanceof List) {
			for (Object val : (List<Object>) item) {
				flatten(val, result);
			}
		} else {
			result.add(item);
		}
	}

}
