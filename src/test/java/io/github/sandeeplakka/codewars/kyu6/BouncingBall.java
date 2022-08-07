package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Bouncing Balls

A child is playing with a ball on the nth floor of a tall building.
The height of this floor, h, is known.

He drops the ball out of the window. The ball bounces (for example),
to two-thirds of its height (a bounce of 0.66).

His mother looks out of a window 1.5 meters from the ground.

How many times will the mother see the ball pass in front of her window
(including when it's falling and bouncing?

Three conditions must be met for a valid experiment:
    Float parameter "h" in meters must be greater than 0
    Float parameter "bounce" must be greater than 0 and less than 1
    Float parameter "window" must be less than h.
If all three conditions above are fulfilled, return a positive integer, otherwise return -1.

Note:
The ball can only be seen if the height of the rebounding ball is strictly greater than the window parameter.

Examples:
- h = 3, bounce = 0.66, window = 1.5, result is 3
- h = 3, bounce = 1, window = 1.5, result is -1	//	(Condition 2) not fulfilled.

Categories : Puzzles, Algorithms, Mathematics

 */
public class BouncingBall {


    @Test
    public void test0() {
        assertEquals(1, bouncingBall(2.0, 0.5, 1.0));
    }

    @Test
    public void test1() {
        assertEquals(3, bouncingBall(3.0, 0.66, 1.5));
    }

    @Test
    public void test2() {
        assertEquals(15, bouncingBall(30.0, 0.66, 1.5));
    }

    @Test
    public void test3() {
        assertEquals(21, bouncingBall(30, 0.75, 1.5));
    }

    @Test
    public void test4() {
        assertEquals(3, bouncingBall(30, 0.4, 10));
    }

    @Test
    public void test5() {
        assertEquals(3, bouncingBall(40, 0.4, 10));
    }

    @Test
    public void test6() {
        assertEquals(-1, bouncingBall(10, 0.6, 10));
    }

    @Test
    public void test7() {
        assertEquals(-1, bouncingBall(40, 1, 10));
    }

    @Test
    public void test8() {
        assertEquals(-1, bouncingBall(-5, 0.66, 1.5));
    }

    @Test
    public void test9() {
        assertEquals(-1, bouncingBall(5, -1, 1.5));
    }

    public static int bouncingBall(double h, double bounce, double window) {

        //invalid cases
        if (h <= 0 || !(bounce > 0 && bounce < 1) || window >= h) {
            return -1;
        }

        //valid ones
        int count = 1;
        double reboundHeight = h * bounce;
        while (reboundHeight > window) {
            count += 2;
            reboundHeight = reboundHeight * bounce;
        }

        return count;
    }
}