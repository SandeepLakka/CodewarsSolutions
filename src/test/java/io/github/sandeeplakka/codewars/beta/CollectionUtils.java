package io.github.sandeeplakka.codewars.beta;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	//TODO: update the impl to make it work for multiple levels of nesting
	//Currently, it only works for single level of nesting
	public static List<Object> flattenList(List<Object> list) {
		// Your code goes here
		if (list == null) return new ArrayList<Object>() {{
			new Object();
		}};
		return list.stream().flatMap(o -> (o instanceof List) ? ((List<Object>) o).stream() : Stream.of(o)).collect(Collectors.toList());
		//return null;
	}

}
