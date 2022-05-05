package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
Product of consecutive Fib numbers
The Fibonacci numbers are the numbers in the following integer sequence (Fn):
    0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, ...
such as
    F(n) = F(n-1) + F(n-2) with F(0) = 0 and F(1) = 1.

Given a number, say prod (for product), we search two Fibonacci numbers
F(n) and F(n+1) verifying F(n) * F(n+1) = prod.

Your function productFib takes an integer (prod) and returns an array:
[F(n), F(n+1), 1] if F(n) * F(n+1) = prod.
If you don't find two consecutive F(n) verifying F(n) * F(n+1) = prod
you will return [F(n), F(n+1), 0]
F(n) being the smallest one such as F(n) * F(n+1) > prod.

Some Examples of Return:

productFib(714) # should return (21, 34, 1),
                # since F(8) = 21, F(9) = 34 and 714 = 21 * 34

productFib(800) # should return (34, 55, 0),
                # since F(8) = 21, F(9) = 34, F(10) = 55 and 21 * 34 < 800 < 34 * 55
-----
productFib(714) # should return [21, 34, 1]
productFib(800) # should return [34, 55, 0]

Note: You can see examples for your language in "Sample Tests".

Categories : Fundamentals
 */
public class ProdFib {

    @Test
    public void tests() {
        long[] r = new long[]{55, 89, 1};
        assertArrayEquals(r, productFib(4895));

        r = new long[]{89, 144, 0};
        assertArrayEquals(r, productFib(5895));
    }

    @Test
    public void test1() {
        long[] r = new long[]{55, 89, 1};
        assertArrayEquals(r, productFib(4895));
    }

    @Test
    public void test2() {
        long[] r = new long[]{89, 144, 0};
        assertArrayEquals(r, productFib(5895));
    }

    @Test
    public void test3() {
        long[] r = new long[]{6765, 10946, 1};
        assertArrayEquals(r, productFib(74049690));
    }

    @Test
    public void test4() {
        long[] r = new long[]{10946, 17711, 0};
        assertArrayEquals(r, productFib(84049690));
    }

    @Test
    public void test5() {
        long[] r = new long[]{10946, 17711, 1};
        assertArrayEquals(r, productFib(193864606));
    }

    @Test
    public void test6() {
        long[] r = new long[]{610, 987, 0};
        assertArrayEquals(r, productFib(447577));
    }

    @Test
    public void test7() {
        long[] r = new long[]{610, 987, 1};
        assertArrayEquals(r, productFib(602070));
    }

    @Test
    public void test8() {
        long[] r = new long[]{832040, 1346269, 0};
        assertArrayEquals(r, productFib(602070602070L));
    }

    @Test
    public void test9() {
        long[] r = new long[]{832040, 1346269, 1};
        assertArrayEquals(r, productFib(1120149658760L));
    }

    @Test
    public void test10() {
        long[] r = new long[]{1346269, 2178309, 1};
        assertArrayEquals(r, productFib(2932589879121L));
    }

    @Test
    public void test11() {
        long[] r = new long[]{1, 1, 1};
        assertArrayEquals(r, productFib(1));
    }

    @Test
    public void test12() {
        long[] r = new long[]{1836311903L, 2971215073L, 0};
        assertArrayEquals(r, productFib(4456077604922913920L));
    }

    @Test
    public void problemStatementGivenTests() {
        long[] result = new long[]{21, 34, 1};
        assertArrayEquals(result, productFib(714));

        result = new long[]{34, 55, 0};
        assertArrayEquals(result, productFib(800));

    }

    public static long[] productFib(long prod) {
        long fn = 0;
        long fnPlusOne = 1;
        while (fn * fnPlusOne < prod) {
            long temp = fn;
            fn = fnPlusOne;
            fnPlusOne = temp + fnPlusOne;
        }
        if (fn * fnPlusOne == prod) {
            return new long[]{fn, fnPlusOne, 1};
        }
        return new long[]{fn, fnPlusOne, 0};
    }
}