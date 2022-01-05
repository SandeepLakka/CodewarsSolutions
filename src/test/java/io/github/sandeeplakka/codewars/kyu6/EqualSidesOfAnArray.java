package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

You are going to be given an array of integers.
Your job is to take that array and find an index N
where the sum of the integers to the left of N is equal to the sum of the integers to the right of N.
If there is no index that would make this happen, return -1.

For example:

Let's say you are given the array {1,2,3,4,3,2,1}:
Your function will return the index 3, because at the 3rd position of the array,
the sum of left side of the index ({1,2,3}) and the sum of the right side of the index ({3,2,1}) both equal 6.

Let's look at another one.
You are given the array {1,100,50,-51,1,1}:
Your function will return the index 1, because at the 1st position of the array,
the sum of left side of the index ({1}) and the sum of the right side of the index ({50,-51,1,1}) both equal 1.

Last one:
You are given the array {20,10,-80,10,10,15,35}
At index 0 the left side is {}
The right side is {10,-80,10,10,15,35}
They both are equal to 0 when added. (Empty arrays are equal to 0 in this problem)
Index 0 is the place where the left side and right side are equal.

Input: An integer array of length 0 < arr < 1000.
The numbers in the array can be any integer positive or negative.

Output:
The lowest index N where the side to the left of N is equal to the side to the right of N.
If you do not find an index that fits these rules, then you will return -1.

Note: If you are given an array with multiple answers, return the lowest correct index.

Categories : Fundamentals, Algorithms, Arrays

 */

public class EqualSidesOfAnArray {

    @Test
    public void tests() {
        assertEquals(3, findEvenIndex(new int[]{1, 2, 3, 4, 3, 2, 1}));
        assertEquals(1, findEvenIndex(new int[]{1, 100, 50, -51, 1, 1}));
        assertEquals(-1, findEvenIndex(new int[]{1, 2, 3, 4, 5, 6}));
        assertEquals(3, findEvenIndex(new int[]{20, 10, 30, 10, 10, 15, 35}));
        assertEquals(-1, findEvenIndex(new int[]{-8505, -5130, 1926, -9026}));
        assertEquals(1, findEvenIndex(new int[]{2824, 1774, -1490, -9084, -9696, 23094}));
        assertEquals(6, findEvenIndex(new int[]{4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
        assertEquals(-1, findEvenIndex(new int[]{8, 8}));
        assertEquals(0, findEvenIndex(new int[]{8, 0}));
        assertEquals(1, findEvenIndex(new int[]{0, 8}));
        assertEquals(0, findEvenIndex(new int[]{7, 3, -3}));
        assertEquals(0, findEvenIndex(new int[]{8}));
    }

    public static int findEvenIndex(int[] arr) {

        int totalSum = Arrays.stream(arr).sum();//.reduce(0, (a, b) -> a + b);

        if (totalSum == 0) return -1;
        if (arr.length <= 1 || totalSum - arr[0] == 0) return 0;

        int partialSum = 0;
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i - 1];
            int next = arr[i];
            partialSum += curr;
            if (totalSum - next - 2 * partialSum == 0) return i;
        }
        return -1;
    }
}