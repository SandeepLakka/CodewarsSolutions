package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
List Filtering

Description:

In this kata you will create a function that takes a list of non-negative integers
and strings and returns a new list with the strings filtered out.
Example

filterList(Arrays.asList(1, 2, "a", "b")) => Arrays.asList(1,2)
filterList(Arrays.asList(1, 2, "a", "b", 0, 15)) => Arrays.asList(1,2,0,15)
filterList(Arrays.asList(1, 2, "a", "b", "aasf", "1", "123", 231)) => Arrays.asList(1, 2, 231)

Categories : Fundamentals, Lists, Data Structures, Filtering, Algorithms

 */
public class ListFiltering {

    @Test
    public void examples() {
        assertEquals(Arrays.asList(new Object[]{1, 2}),
                filterList(Arrays.asList(new Object[]{1, 2, "a", "b"})));
        assertEquals(Arrays.asList(new Object[]{1, 0, 15}),
                filterList(Arrays.asList(new Object[]{1, "a", "b", 0, 15})));
        assertEquals(Arrays.asList(new Object[]{1, 2, 123}),
                filterList(Arrays.asList(new Object[]{1, 2, "aasf", "1", "123", 123})));
    }

    @Test
    public void extras() {
        assertEquals(Arrays.asList(new Object[0]),
                filterList(Arrays.asList(new Object[]{"a", "b", "1"})));
        assertEquals(Arrays.asList(new Object[]{1, 2}),
                filterList(Arrays.asList(new Object[]{1, 2, "a", "b"})));
    }


    public static List filterList(final List list) {
        return (List) list.stream()
                .filter(s -> s instanceof Integer)
                .collect(Collectors.toList());
    }
}