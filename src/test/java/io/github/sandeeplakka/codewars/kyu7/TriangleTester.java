package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
Is this a triangle?
Implement a function that accepts 3 integer values a, b, c.
The function should return true if a triangle can be built
with the sides of given length and false in any other case.

(In this case, all triangles must have surface greater than 0 to be accepted).

Categories : Fundamentals, Mathematics, Algorithms, Numbers, Utilities
 */
class TriangleTester {

    @Test
    public void publicTests() {
        assertTrue(isTriangle(1, 2, 2));
        assertFalse(isTriangle(7, 2, 2));

        assertTrue(isTriangleV1(1, 2, 2));
        assertFalse(isTriangleV1(7, 2, 2));


    }

    @Test
    public void changingSidesTest() {
        assertFalse(isTriangle(1, 2, 3));
        assertFalse(isTriangle(1, 3, 2));
        assertFalse(isTriangle(3, 1, 2));

        assertFalse(isTriangle(1, 2, 5));
        assertFalse(isTriangle(1, 5, 2));
        assertFalse(isTriangle(5, 1, 2));

        assertFalse(isTriangleV1(1, 2, 3));
        assertFalse(isTriangleV1(1, 3, 2));
        assertFalse(isTriangleV1(3, 1, 2));

        assertFalse(isTriangleV1(1, 2, 5));
        assertFalse(isTriangleV1(1, 5, 2));
        assertFalse(isTriangleV1(5, 1, 2));


    }

    @Test
    public void triangleTypes() {
        assertTrue(isTriangle(4, 2, 3));
        assertTrue(isTriangle(5, 1, 5));
        assertTrue(isTriangle(2, 2, 2));

        assertTrue(isTriangleV1(4, 2, 3));
        assertTrue(isTriangleV1(5, 1, 5));
        assertTrue(isTriangleV1(2, 2, 2));
    }

    @Test
    public void NegativeTypes() {
        assertFalse(isTriangle(-1, 2, 3));
        assertFalse(isTriangle(1, -2, 3));
        assertFalse(isTriangle(1, 2, -3));
        assertFalse(isTriangle(-5, 1, 3));
        assertFalse(isTriangle(0, 2, 3));

        assertFalse(isTriangleV1(-1, 2, 3));
        assertFalse(isTriangleV1(1, -2, 3));
        assertFalse(isTriangleV1(1, 2, -3));
        assertFalse(isTriangleV1(-5, 1, 3));
        assertFalse(isTriangleV1(0, 2, 3));
    }

    //
    //Wiki definition of triangle condition on the sides barring degenerate triangles
    // The triangle inequality states that the sum of the lengths
    // of any two sides of a triangle must be greater than
    // or equal to the length of the third side.
    // A triangle with three given positive side lengths exists
    // if and only if those side lengths satisfy the triangle inequality.
    //
    public static boolean isTriangle(int a, int b, int c) {
        if (a + b + c == 0) return false;
        int max = Math.max(a, Math.max(b, c));
        int sumOfTwoSides = a + b + c - max;
        return sumOfTwoSides > max;
    }

    //better
    public static boolean isTriangleV1(int a, int b, int c) {
        return a + b > c && b + c > a && c + a > b;
    }
}