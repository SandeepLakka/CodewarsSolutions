package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Integers: Recreation One

1, 246, 2, 123, 3, 82, 6, 41 are the divisors of number 246.
Squaring these divisors we get: 1, 60516, 4, 15129, 9, 6724, 36, 1681.
The sum of these squares is 84100 which is 290 * 290.

Task
Find all integers between m and n (m and n integers with 1 <= m <= n)
such that the sum of their squared divisors is itself a square.

We will return an array of subarrays or of tuples (in C an array of Pair) or a string.
The subarrays (or tuples or Pairs) will have two elements:
first the number the squared divisors of which is a square and then the sum of the squared divisors.

Example:

list_squared(1, 250) --> [[1, 1], [42, 2500], [246, 84100]]
list_squared(42, 250) --> [[42, 2500], [246, 84100]]


Categories : Fundamentals, Algorithms, Optimization
 */
public class SumSquaredDivisors {

    @Test
    public void test1() {
        assertEquals("[[1, 1], [42, 2500], [246, 84100]]", listSquared(1, 250));
    }

    @Test
    public void test2() {
        assertEquals("[[42, 2500], [246, 84100]]", listSquared(42, 250));
    }

    @Test
    public void test3() {
        assertEquals("[[287, 84100]]", listSquared(250, 500));
    }

    public static String listSquared(long m, long n) {
        List<Long[]> res = new ArrayList<>();
        //for each value from m to n inclusive:
        for (long iter = m; iter <= n; iter++) {
            //  find factors
            List<Long> factors = findFactors(iter);
            //  sum these factors
            long sum = factors.stream().map(val -> val * val).reduce(0L, Long::sum);
            //  take a square root and square it, if it matches, then add it to res else discard
            long root = (long) Math.sqrt(sum);
            if (root * root == sum) {
                res.add(new Long[]{iter, sum});
            }
        }
        return Arrays.toString(res.stream().map(Arrays::toString).toArray());
    }

    private static List<Long> findFactors(long iter) {
        List<Long> factors = new ArrayList<>();
        for (long i = 1; i <= iter; i++) {
            if (iter % i == 0) factors.add(i);
        }
        return factors;
    }
}
