package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Find the missing term in an Arithmetic Progression



An Arithmetic Progression is defined as one in which there is a constant difference
between the consecutive terms of a given series of numbers.
You are provided with consecutive elements of an Arithmetic Progression.
There is however one hitch: exactly one term from the original series is missing
from the set of numbers which have been given to you.
The rest of the given series is the same as the original AP.
Find the missing term.

You have to write a function that receives a list, list size will always be at least 3 numbers.
The missing term will never be the first or last one.

Example
findMissing([1, 3, 5, 9, 11]) == 7

PS: This is a sample question of the facebook engineer challenge on interviewstreet.
I found it quite fun to solve on paper using math, derive the algo that way. Have fun!

Categories : Algorithms, Mathematics
 */
public class MissingTermInArithmeticProgression {

    @Test
    @DisplayName("Increasing sequence: [1, 2, 4]")
    void testIncreasing_1() {
        assertEquals(3, findMissing(new int[]{1, 2, 4}), "Incorrect answer for [1, 2, 4]");
    }

    //TODO impl the solution
    public static int findMissing(int[] numbers) {
        return -1;
    }
}
