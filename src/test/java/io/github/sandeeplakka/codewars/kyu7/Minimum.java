package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;


import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Form The Minimum

Task
Given a list of digits, return the smallest number that could be formed from these digits,
using the digits only once (ignore duplicates).

Notes:

    Only positive integers will be passed to the function (> 0 ), no negatives or zeros.
    Input >> Output Examples

minValue ({1, 3, 1})  ==> return (13)
Explanation:
(13) is the minimum number could be formed from {1, 3, 1} , Without duplications

minValue({5, 7, 5, 9, 7})  ==> return (579)
Explanation:
(579) is the minimum number could be formed from {5, 7, 5, 9, 7} , Without duplications

minValue({1, 9, 3, 1, 7, 4, 6, 6, 7}) return  ==> (134679)
Explanation:
(134679) is the minimum number could be formed from {1, 9, 3, 1, 7, 4, 6, 6, 7} ,
Without duplications

Enjoy Learning !!
Zizou

Categories : Fundamentals

 */
public class Minimum {

    @Test
    public void testSomething() {
        assertEquals(13, minValue(new int[]{1, 3, 1}));
        assertEquals(457, minValue(new int[]{4, 7, 5, 7}));
        assertEquals(148, minValue(new int[]{4, 8, 1, 4}));
        assertEquals(579, minValue(new int[]{5, 7, 9, 5, 7}));
        assertEquals(678, minValue(new int[]{6, 7, 8, 7, 6, 6}));
        assertEquals(45679, minValue(new int[] {5, 6, 9, 9, 7, 6, 4}));
		assertEquals(134679, minValue(new int[] {1, 9, 1, 3, 7, 4, 6, 6, 7}));
		assertEquals(356789, minValue(new int[] {3, 6, 5, 5, 9, 8, 7, 6, 3, 5, 9}));
    }

    public static int minValue(int[] values) {
        return IntStream.of(values).distinct().sorted().reduce(0, (l, r) -> l * 10 + r);
    }

}
