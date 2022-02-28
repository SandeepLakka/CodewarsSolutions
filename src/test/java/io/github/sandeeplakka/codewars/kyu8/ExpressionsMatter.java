package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Expressions Matter

Task

    Given three integers a, b, c, return the largest number obtained after
    inserting the following operators and brackets: +, *, ()
    In other words , try every combination of a,b,c with [*+()] , and return the Maximum Obtained
    Consider an Example :

With the numbers are 1, 2 and 3 , here are some ways of placing signs and brackets:

    1 * (2 + 3) = 5
    1 * 2 * 3 = 6
    1 + 2 * 3 = 7
    (1 + 2) * 3 = 9

So the maximum value that you can obtain is 9.
Notes

    The numbers are always positive.
    The numbers are in the range (1 ≤ a,b,c ≤ 10).
    You can use the same operation more than once.
    It's not necessary to place all the signs and brackets.
    Repetition in numbers may occur .
    You cannot swap the operands. For instance, in the given example you cannot get expression (1 + 3) * 2 = 8.

Examples:

expressionsMatter(1,2,3)  ==>  return 9
Explanation:
After placing signs and brackets, the Maximum value obtained from the expression (1+2) * 3 = 9.

expressionsMatter(1,1,1)  ==>  return 3
Explanation:
After placing signs, the Maximum value obtained from the expression is 1 + 1 + 1 = 3.

expressionsMatter(9,1,1)  ==>  return 18
Explanation:
After placing signs and brackets, the Maximum value obtained from the expression is 9 * (1+1) = 18.

Categories : Fundamentals, Algorithms, Numbers, Basic Language Features
 */
public class ExpressionsMatter {
    @Test
    public void checkSmallValues() {
        assertEquals(6, expressionsMatter(2, 1, 2));
        assertEquals(3, expressionsMatter(1, 1, 1));
        assertEquals(4, expressionsMatter(2, 1, 1));
        assertEquals(9, expressionsMatter(1, 2, 3));
        assertEquals(5, expressionsMatter(1, 3, 1));
        assertEquals(8, expressionsMatter(2, 2, 2));
    }

    @Test
    public void checkIntermediateValues() {
        assertEquals(20, expressionsMatter(5, 1, 3));
        assertEquals(105, expressionsMatter(3, 5, 7));
        assertEquals(35, expressionsMatter(5, 6, 1));
        assertEquals(8, expressionsMatter(1, 6, 1));
        assertEquals(14, expressionsMatter(2, 6, 1));
        assertEquals(48, expressionsMatter(6, 7, 1));
    }

    @Test
    public void checkMixedValues() {
        assertEquals(60, expressionsMatter(2, 10, 3));
        assertEquals(27, expressionsMatter(1, 8, 3));
        assertEquals(126, expressionsMatter(9, 7, 2));
        assertEquals(20, expressionsMatter(1, 1, 10));
        assertEquals(18, expressionsMatter(9, 1, 1));
        assertEquals(300, expressionsMatter(10, 5, 6));
        assertEquals(12, expressionsMatter(1, 10, 1));
    }

    public static int expressionsMatter(int a, int b, int c) {
        // Your Code here... Happy Coding!
        return Math.max(a + b + c,
                Math.max(a + b * c,
                        Math.max(a * b + c,
                                Math.max(a * b * c,
                                        Math.max((a + b) * c, a * (b + c))))));
    }
}