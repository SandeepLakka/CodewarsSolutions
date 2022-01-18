package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
In a certain kingdom, strange mathematics is taught at school.
Its main difference from ordinary mathematics is that the numbers in it are not ordered in ascending order,
but lexicographically, as in a dictionary (first by the first digit, then,
if the first digit is equal, by the second, and so on). In addition,
we do not consider an infinite set of natural numbers, but only the first n numbers.

So, for example, if n = 11, then the numbers in strange mathematics are ordered as follows:

1, 10, 11, 2, 3, 4, 5, 6, 7, 8, 9.

Help your students to learn this science: write a function that receives two integer numbers: n
(total amount of numbers in strange mathematics) and k (number from sequence)
and returns the location of a given number k in the order defined in strange mathematics.

For example, if n = 11 and k = 2, the function should return 4 as the answer.

Input: 1 <= n <= 100 000 , 1 <= k <= n.

Output: position of the number k in sequence of the first n natural numbers in lexicographic order.
Numbering starts with 1.

Examples:

strange_math(11, 2) == 4
strange_math(15, 5) == 11
strange_math(15, 15) == 7

Categories : Fundamentals, Sorting, Algorithms, Arrays
 */
public class Strange {

    @Test
    public void tests() {
        assertEquals(4, Strange.mathematics(11, 2), "For n=11 and k=2: ");
        assertEquals(11, Strange.mathematics(15, 5), "For n=15 and k=5: ");
        assertEquals(7, Strange.mathematics(15, 15), "For n=15 and k=15: ");
    }

    public static int mathematics(int n, int k) {
        // your solution here :)
        int[] arr = IntStream.rangeClosed(0, n)
                .mapToObj(String::valueOf).sorted()
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) return i;
        }
        return -1;
    }
}