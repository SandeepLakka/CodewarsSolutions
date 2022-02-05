package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Area or Perimeter

You are given the length and width of a 4-sided polygon.
The polygon can either be a rectangle or a square.
If it is a square, return its area. If it is a rectangle, return its perimeter.

area_or_perimeter(6, 10) --> 32
area_or_perimeter(3, 3) --> 9

Note: for the purposes of this kata you will assume that it is a square if its length and width are equal,
otherwise it is a rectangle.

Categories : Fundamentals

 */
public class AreaOrPerimeter {
    @Test
    public void testSomething() {
        assertEquals(9, areaOrPerimeter(3, 3));
        assertEquals(16, areaOrPerimeter(4, 4));
        assertEquals(32, areaOrPerimeter(6, 10));
    }

    public static int areaOrPerimeter(int l, int w) {
        // code away...
        return l == w ? l * w : 2 * (l + w);
    }
}