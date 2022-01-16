package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/*
Write a function that takes an array of numbers (integers for the tests) and a target number.
It should find two different items in the array that, when added together,
give the target value. The indices of these items should then be returned in a tuple like so: (index1, index2).

For the purposes of this kata, some tests may have multiple answers;
any valid solutions will be accepted.

The input will always be valid (numbers will be an array of length 2 or greater,
and all of the items will be numbers; target will always be the sum of two different items from that array).

Based on: http://oj.leetcode.com/problems/two-sum/

twoSum [1, 2, 3] 4 === (0, 2)

Categories : Fundamentals, Arrays, Numbers, Integers, Arithmetic, Mathematics, Algorithms
 */
public class TwoSum {


    @Test
    public void tests() {
        doTest(new int[]{1, 2, 3}, new int[]{0, 2});
        doTest(new int[]{1234, 5678, 9012}, new int[]{1, 2});
        doTest(new int[]{2, 2, 3}, new int[]{0, 1});
    }

    private void doTest(int[] numbers, int[] expected) {
        int target = numbers[expected[0]] + numbers[expected[1]];
        int[] actual = twoSum(numbers, target);
        if (null == actual) {
            System.out.format("Received a null\n");
            assertNotNull(actual);
        }
        if (actual.length != 2) {
            System.out.format("Received an array that's not of length 2\n");
            assertTrue(false);
        }
        int received = numbers[actual[0]] + numbers[actual[1]];
        assertEquals(target, received);
    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null) return null;

        Map<Integer, Integer> vals = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int val = numbers[i];
            if (vals.containsKey(target - val)) return new int[]{vals.get(target - val), i};
            vals.put(val, i);
        }
        return null; // Do your magic!

    }
}