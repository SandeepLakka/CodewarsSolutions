package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Round up to the next multiple of 5

Given an integer as input, can you round it to the next
(meaning, "greater than or equal") multiple of 5?

Examples:
input:    output:
0    ->   0
2    ->   5
3    ->   5
12   ->   15
21   ->   25
30   ->   30
-2   ->   0
-5   ->   -5
etc.

Input may be any positive or negative integer (including 0).
You can assume that all inputs are valid integers.

Categories : Fundamentals

 */
public class RoundToTheNextMultipleOf5 {
    @Test
    public void basicTests() {
        int[][] arr = {
                {0, 0},
                {1, 5},
                {3, 5},
                {5, 5},
                {7, 10},
                {39, 40}
        };
        Arrays.stream(arr)
                .forEach(
                        (testCase) -> assertEquals(
                                testCase[1],
                                roundToNext5(testCase[0]),
                                "Input: " + testCase[0]));
    }

    public static int roundToNext5(int number) {
        return number % 5 == 0 ? number : number - number % 5 + 5;
    }
}
