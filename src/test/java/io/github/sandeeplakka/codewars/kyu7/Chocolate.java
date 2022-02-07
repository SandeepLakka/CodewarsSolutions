package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Breaking chocolate problem

Description:

Your task is to split the chocolate bar of given dimension n x m into small squares.
Each square is of size 1x1 and unbreakable.
Implement a function that will return minimum number of breaks needed.
For example if you are given a chocolate bar of size 2 x 1 you can split it to single squares in just one break,
but for size 3 x 1 you must do two breaks.
If input data is invalid you should return 0
(as in no breaks are needed if we do not have any chocolate to split).
Input will always be a non-negative integer.

Categories : Algorithms, Numbers
 */
public class Chocolate {

    @Test
    public void testBreakChocolate() {
        assertEquals(24, Chocolate.breakChocolate(5, 5));
        assertEquals(27, Chocolate.breakChocolate(7, 4));
        assertEquals(0, Chocolate.breakChocolate(1, 1));
        assertEquals(0, Chocolate.breakChocolate(0, 0),
                "What If I Told You There is No Chocolate?");
        assertEquals(5, Chocolate.breakChocolate(6, 1));
    }

    public static int breakChocolate(int n, int m) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        return m * n - 1;
    }
}