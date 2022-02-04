package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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