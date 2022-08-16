package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Fracts {

    @Test
    public void test_fractions() {
        long[][] lst;
        lst = new long[][]{{1, 2}, {1, 3}, {10, 40}};
        assertEquals("(6,12)(4,12)(3,12)", convertFrac(lst));
    }

    public static String convertFrac(long[][] lst) {
        long[] numerators = Stream.of(lst).mapToLong(longs -> longs[0]).toArray();
        long[] denominators = Stream.of(lst).mapToLong(longs -> longs[1]).toArray();
        System.out.println(Arrays.toString(numerators));
        System.out.println(Arrays.toString(denominators));
        long lcm = getLcm(denominators);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numerators.length; i++) {
            long remainder = lcm / denominators[i];
            builder.append(String.format("(%d,%d)", numerators[i] * remainder, denominators[i]));
        }

        return builder.toString();
    }

    private static long getLcm(long[] denominators) {

        return 0;
    }

}
/*
2, 3, 40

 */