package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Descending Order

Description:

Your task is to make a function that can take any non-negative integer
as an argument and return it with its digits in descending order.
Essentially, rearrange the digits to create the highest possible number.

Examples:

Input: 42145 Output: 54421
Input: 145263 Output: 654321
Input: 123456789 Output: 987654321

Categories : Fundamentals, Functions, Control Flow, Basic Language Features
 */
public class DescendingOrder {
    @Test
    public void test_sortDesc() {
        assertEquals(0, sortDesc(0));
        assertEquals(51, sortDesc(15));
        assertEquals(987654321, sortDesc(123456789));
        assertEquals(2110, sortDesc(1021));
        assertEquals(987654321, sortDesc(123495678));
    }

    @Test
    public void test_similarComplexitySolution() {
        assertEquals(0, similarComplexitySolution(0));
        assertEquals(51, similarComplexitySolution(15));
        assertEquals(987654321, similarComplexitySolution(123456789));
        assertEquals(2110, similarComplexitySolution(1021));
        assertEquals(987654321, similarComplexitySolution(123495678));
    }


    public static int sortDesc(final int num) {
        //Your code
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        int n = num;
        while (n > 0) {
            queue.add(n % 10);
            n /= 10;
        }
        int max = 0;
        while (queue.size() > 0) {
            max = max * 10 + queue.poll();
        }
        return max;
    }

    public static int similarComplexitySolution(final int num) {
        return Integer.parseInt(
                Arrays.stream(String.valueOf(num).split(""))
                        .sorted(Collections.reverseOrder())
                        .collect(Collectors.joining())
        );
    }
}