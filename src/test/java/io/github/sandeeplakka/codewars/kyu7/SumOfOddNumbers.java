package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Sum of odd numbers
 * Given the triangle of consecutive odd numbers:
 *              1
 *           3     5
 *        7     9    11
 *    13    15    17    19
 * 21    23    25    27    29
 * ...
 *
 * Calculate the sum of the numbers in the nth row of this triangle (starting at index 1) e.g.:
 *
 * rowSumOddNumbers(1); // 1
 * rowSumOddNumbers(2); // 3 + 5 = 8
 * Categories: Fundamentals, Arrays, Lists, Data Structures, Numbers
 * Arithmetic, Mathematics, Algorithms
 * https://www.codewars.com/kata/55fd2d567d94ac3bc9000064/java
 */
public class SumOfOddNumbers {
    @Test
    public void testRowSumOddNumbers(){
        int tc1 = 1, er1 = 1;
        int tc2 = 2, er2 = 8;
        int tc3 = 5, er3 = 125;
        assertAll(
                () -> assertEquals(er1, rowSumOddNumbers(tc1)),
                () -> assertEquals(er2, rowSumOddNumbers(tc2)),
                () -> assertEquals(er3, rowSumOddNumbers(tc3))
        );
    }

    //Writing this out on paper will have the answer as number cubed
    public int rowSumOddNumbers(int n){
        return n*n*n;
    }
}
