package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
The highest profit wins!

Story:

Ben has a very simple idea to make some profit:
he buys something and sells it again. Of course,
this wouldn't give him any profit at all if he was
simply to buy and sell it at the same price.
Instead, he's going to buy it for the lowest possible price and sell it at the highest.
Task

Write a function that returns both the minimum and maximum number of the given list/array.
Examples

MinMax.minMax(new int[]{1,2,3,4,5}) == {1,5}
MinMax.minMax(new int[]{2334454,5}) == {5, 2334454}
MinMax.minMax(new int[]{1}) == {1, 1}

Remarks

All arrays or lists will always have at least one element,
so you don't need to check the length.
Also, your function will always get an array or a list,
you don't have to check for null, undefined or similar.

Categories : Fundamentals, Lists, Data Structures, Arrays


 */
class MinMax {

    private Random rand;

    @BeforeEach
    public void initTest() {
        rand = new Random();
    }

    @Test
    public void testExampleCases() {
        assertArrayEquals(new int[]{1, 5}, MinMax.minMax(new int[]{1, 2, 3, 4, 5}));
        assertArrayEquals(new int[]{5, 2334454}, MinMax.minMax(new int[]{2334454, 5}));
        assertArrayEquals(new int[]{1, 1}, MinMax.minMax(new int[]{1}));
    }

    @Test
    public void minMaxRandomTest() {
        for (int i = 0; i < 20; i++) {
            int r = rand.nextInt();
            assertArrayEquals(new int[]{r, r}, MinMax.minMax(new int[]{r}));
        }
    }

    public static int[] minMax(int[] arr) {
        // Your awesome code here
        if (arr.length == 1) return new int[]{arr[0], arr[0]};
        int min = arr[0];
        int max = arr[0];
        for (int val : arr) {
            if (min > val) min = val;
            if (max < val) max = val;
        }
        return new int[]{min, max};
    }
}