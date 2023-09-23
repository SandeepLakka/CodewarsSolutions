package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    Common Denominators

You will have a list of rationals in the form [ [numer_1, denom_1] , ... [numer_n, denom_n] ]

where all numbers are positive ints. You have to produce a result in the form: [ [N_1, D] ... [N_n, D] ]
N_1/D == numer_1/denom_1 ... N_n/D == numer_n,/denom_n.

Example:
convertFracs[(1, 2), (1, 3), (1, 4)] should be (6,12)(4,12)(3,12)

Categories : Fundamentals, Algorithms, Mathematics
 */
public class CommonDenominator {

    @Test
    public void test_fractions() {
        long[][] lst;
        lst = new long[][]{{1, 2}, {1, 3}, {10, 40}};
        assertEquals("(6,12)(4,12)(3,12)", convertFrac(lst));
    }

    static BiFunction<Integer, long[][], List<Long>> getValues = (value, lst) -> Arrays.stream(lst)
            .mapToLong(arr -> arr[value]).boxed().collect(Collectors.toList());

    public static String convertFrac(long[][] lst) {
        for (int i = 0; i < lst.length; i++) {
            lst[i] = refine(lst[i]);
        }

        List<Long> denominators = getValues.apply(1, lst);
        Long commonDivisor = getCommonDivisor(denominators);
        // your code
        List<String> result = new ArrayList<>();
        for (long[] arr : lst) {
            long multiplier = commonDivisor / arr[1];
            arr[0] *= multiplier;
            arr[1] *= multiplier;
            result.add(String.format("(%s,%s)", arr[0], arr[1]));
        }
        return String.join("", result);
    }

    private static Long getCommonDivisor(List<Long> denominators) {
        long commonDivisor = denominators.get(0);
        for (Long denominator : denominators) {
            commonDivisor = commonDivisor * denominator / gcd(commonDivisor, denominator);
        }
        return commonDivisor;
        //return denominators.stream().skip(1).reduce(denominators.get(0), CommonDenominator::gcd);
    }

    public static long[] refine(long[] value) {
        long divisor = gcd(value[0], value[1]);
        value[0] /= divisor;
        value[1] /= divisor;
        return value;
    }

    static long gcd(long a, long b) {
        // Everything divides 0
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
