package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Max {
    @Test
    public void tests() {

        assertEquals(0, sequence(new int[]{}),
                "Empty arrays should have a max of 0");
        assertEquals(6, sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}),
                "Array [-2, 1, -3, 4, -1, 2, 1, -5, 4] should have a max of 6");
        assertEquals(7, sequence(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}),
                "Array [-2, -3, 4, -1, -2, 1, 5, -3] should return 7");
        assertEquals(0, sequence(new int[]{-1, -2, -3, -4, -5, -6}),
                "Array [-1, -2, -3, -4, -5, -6] (with all negative values) should return 0");
        assertEquals(155, sequence(new int[]{7, 4, 11, -11, 39, 36, 10, -6, 37, -10, -32, 44, -26, -34, 43, 43}), "Should work on this too");


    }

    public static int sequence(int[] arr) {
        int curSum = 0;
        int maxSum = 0; //Integer.MIN_VALUE; //Problem statement requires to only consider non-negative values
        for (int val : arr) {
            curSum += val;
            if (curSum < val) curSum = val;
            if (maxSum < curSum) maxSum = curSum;
        }
        return maxSum;
    }
}