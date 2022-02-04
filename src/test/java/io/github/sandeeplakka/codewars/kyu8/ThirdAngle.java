package io.github.sandeeplakka.codewars.kyu8;

/*
Third Angle of a Triangle

You are given two interior angles (in degrees) of a triangle.

Write a function to return the 3rd.

Note: only positive integers will be tested.

https://en.wikipedia.org/wiki/Triangle

Categories : Fundamentals
 */

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThirdAngle {
    @Test
    public void testOtherAngle() {
        assertEquals(123, otherAngle(45, 12));
        assertEquals(70, otherAngle(50, 60));
        assertEquals(178, otherAngle(1, 1));
        assertEquals(73, otherAngle(95, 12));
    }

    @RepeatedTest(10)
    public void randomTest() {
        for (int i = 0; i < 100; i++) {
            int first = (int) (Math.random() * 60) + 1;
            int second = (int) (Math.random() * 100) + 1;
            assertEquals(180 - first - second, otherAngle(first, second));
        }
    }

    //Sum of angles of triangle is 180 degrees
    public static int otherAngle(int angle1, int angle2) {
        return 180 - (angle1 + angle2);
    }
}