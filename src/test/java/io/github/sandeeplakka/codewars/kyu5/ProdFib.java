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