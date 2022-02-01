package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Find the next perfect square!

You might know some pretty large perfect squares. But what about the NEXT one?

Complete the findNextSquare method that finds the next integral perfect
square after the one passed as a parameter.
Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.

If the parameter is itself not a perfect square then -1 should be returned.
You may assume the parameter is non-negative.

Examples:(Input --> Output)

121 --> 144
625 --> 676
114 --> -1 since 114 is not a perfect square

Categories : Fundamentals, Numbers, Algebra, Mathematics, Algorithms

 */
public class NumberFun {
    @Test
    public void test1() {
        assertEquals(144, findNextSquare(121));
    }


    @Test
    public void test2() {
        assertEquals(-1, findNextSquare(155));
    }

    @Test
    public void test3() {
        assertEquals(320356, findNextSquare(319225));
    }

    @Test
    public void test4() {
        assertEquals(15241630849L, findNextSquare(15241383936L));
    }

    @Test
    public void test5() {
        assertEquals(-1, findNextSquare(342786627));
    }

    public static long findNextSquare(long sq) {
        long n = (long) Math.sqrt(sq);
        if (n * n != sq) return -1;
        return (n + 1) * (n + 1);
    }
}