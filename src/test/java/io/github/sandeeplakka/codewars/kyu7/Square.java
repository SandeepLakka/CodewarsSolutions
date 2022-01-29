package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
You're a square!

A square of squares

You like building blocks. You especially like building blocks that are squares.
And what you even like more, is to arrange them into a square of square building blocks!

However, sometimes, you can't arrange them into a square.
Instead, you end up with an ordinary rectangle!
Those blasted things! If you just had a way to know
whether you're currently working in vain… Wait!
That's it! You just have to check if your number of building blocks is a perfect square.
Task

Given an integral number, determine if it's a square number:

    In mathematics, a square number or perfect square is an integer that is the square of an integer;
    in other words, it is the product of some integer with itself.

The tests will always use some integral number,
so don't worry about that in dynamic typed languages.

Examples

-1  =>  false
 0  =>  true
 3  =>  false
 4  =>  true
25  =>  true
26  =>  false

Categories : Fundamentals
 */
public class Square {
    @Test
    public void shouldWorkForSomeExamples() {
        assertFalse(isSquare(-1), "negative numbers aren't square numbers");
        assertTrue(isSquare(0), "0 is a square number (0 * 0)");
        assertFalse(isSquare(3), "3 isn't a square number");
        assertTrue(isSquare(4), "4 is a square number (2 * 2)");
        assertTrue(isSquare(25), "25 is a square number (5 * 5)");
        assertFalse(isSquare(26), "26 isn't a square number");
    }

    public static boolean isSquare(int n) {
        if (n < 0) return false;
        if (n < 2) return true;
        //TODO this can be converted in binary search style to reduce the number of iterations
        for (int i = 2; i * i <= n; i++) {
            if (i * i == n) {
                System.out.println(" i is " + i + " for n" + n);
                return true;
            }
        }
        return false; // fix me!
    }
}