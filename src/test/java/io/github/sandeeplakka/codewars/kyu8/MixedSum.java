package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Sum Mixed Array

Given an array of integers as strings and numbers,
return the sum of the array values as if all were numbers.

Return your answer as a number.

Categories : Fundamentals, Strings, Numbers, Arrays
 */
public class MixedSum {

    @Test
    public void test_1() {
        assertEquals(10, sum(Arrays.asList(5, "5")));
    }

    @Test
    public void test_2() {
        assertEquals(22, sum(Arrays.asList(9, 3, "7", "3")));
    }

    @Test
    public void test_3() {
        assertEquals(42, sum(Arrays.asList("5", "0", 9, 3, 2, 1, "9", 6, 7)));
    }

    @Test
    public void test_4() {
        assertEquals(41, sum(Arrays.asList("3", 6, 6, 0, "5", 8, 5, "6", 2, "0")));
    }

    @Test
    public void test_5() {
        assertEquals(45, sum(Arrays.asList("1", "5", "8", 8, 9, 9, 2, "3")));
    }

    @Test
    public void test_6() {
        assertEquals(41, sum(Arrays.asList("3", 6, 6, 0, "5", 8, 5, "6", 2, "0")));
    }

    @Test
    public void test_7() {
        assertEquals(61, sum(Arrays.asList(8, 0, 0, 8, 5, 7, 2, 3, 7, 8, 6, 7)));
    }

    /*
     * Assume input will be only of Integer or String type
     */
    public int sum(List<?> mixed) {
        int sum = 0;
        for (Object obj : mixed) {
            if (obj instanceof Integer) sum += ((Integer) obj).intValue();
            else sum += Integer.parseInt((String) obj);
        }
        return sum;
    }
}