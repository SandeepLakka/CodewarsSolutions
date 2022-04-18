package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Find Maximum and Minimum Values of a List

Your task is to make two functions (max and min, or maximum and minimum, etc., depending on the language) 
that receive a list of integers as input and return, respectively, the largest and lowest number in that list.

Examples (Input -> Output)

* [4,6,2,1,9,63,-134,566]         -> max = 566, min = -134
* [-52, 56, 30, 29, -54, 0, -110] -> min = -110, max = 56
* [42, 54, 65, 87, 0]             -> min = 0, max = 87
* [5]                             -> min = 5, max = 5

Notes
    You may consider that there will not be any empty arrays/vectors.

Categories: Fundamentals, Basic Language Features
 */
public class MinAndMaxOfListOrArray {

    private final Random rand = new Random();

    @Test
    public void fixedMin() {
        assertEquals(-110, min(new int[]{-52, 56, 30, 29, -54, 0, -110}));
        assertEquals(0, min(new int[]{42, 54, 65, 87, 0}));
        assertEquals(1, min(new int[]{1, 2, 3, 4, 5, 10}));
        assertEquals(-10, min(new int[]{-1, -2, -3, -4, -5, -10}));
    }

    @Test
    public void fixedMax() {
        assertEquals(56, max(new int[]{-52, 56, 30, 29, -54, 0, -110}));
        assertEquals(566, max(new int[]{4, 6, 2, 1, 9, 63, -134, 566}));
        assertEquals(5, max(new int[]{5}));
        assertEquals(555, max(new int[]{534, 43, 2, 1, 3, 4, 5, 5, 443, 443, 555, 555}));
    }

    @Test
    public void randomTests() {
        for (int i = 0; i < 10; i++) {
            int randLng = 2 + (rand.nextInt(14) % 15);
            List<Integer> randList = new ArrayList<>();

            for (int l = 0; l < randLng; l++) {
                randList.add(rand.nextInt());
            }

            assertEquals(Long.valueOf(Collections.min(randList)),
                    Long.valueOf(min(randList.stream().mapToInt(e -> e).toArray())));
            assertEquals(Long.valueOf(Collections.max(randList)),
                    Long.valueOf(max(randList.stream().mapToInt(e -> e).toArray())));
        }
    }

    public int min(int[] list) {
        int result = Integer.MAX_VALUE;
        for (int val : list) {
            if (val < result) {
                result = val;
            }
        }
        return result;
    }

    public int max(int[] list) {
        return IntStream.of(list).max().getAsInt();
    }
}