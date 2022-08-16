package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Common Denominators


You will have a list of rationals in the form

{ {numer_1, denom_1} , ... {numer_n, denom_n} }
or
[ [numer_1, denom_1] , ... [numer_n, denom_n] ]
or
[ (numer_1, denom_1) , ... (numer_n, denom_n) ]

where all numbers are positive ints. You have to produce a result in the form:

(N_1, D) ... (N_n, D)
or
[ [N_1, D] ... [N_n, D] ]
or
[ (N_1', D) , ... (N_n, D) ]
or
{{N_1, D} ... {N_n, D}}
or
"(N_1, D) ... (N_n, D)"

depending on the language (See Example tests) in which D is as small as possible and

N_1/D == numer_1/denom_1 ... N_n/D == numer_n,/denom_n.

Example:

convertFracs [(1, 2), (1, 3), (1, 4)] `shouldBe` [(6, 12), (4, 12), (3, 12)]

Note:
Due to the fact that the first translations were written long ago - more than 6 years -
these first translations have only irreducible fractions.

Newer translations have some reducible fractions.
To be on the safe side it is better to do a bit more work by simplifying fractions even if they don't have to be.

Note for Bash:
input is a string, e.g "2,4,2,6,2,8" output is then "6 12 4 12 3 12"

Categories : Fundamentals, Algorithms, Mathematics

 */
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