package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
