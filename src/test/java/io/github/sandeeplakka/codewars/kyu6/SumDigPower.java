package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Take a Number And Sum Its Digits Raised To The Consecutive Powers And ....¡Eureka!!

The number 89 is the first integer with more than one digit
that fulfills the property partially introduced in the title of this kata.
What's the use of saying "Eureka"? Because this sum gives the same number.

In effect: 89 = 8^1 + 9^2

The next number in having this property is 135.
See this property again: 135 = 1^1 + 3^2 + 5^3

We need a function to collect these numbers,
that may receive two integers a, b that defines the range [a, b] (inclusive)
and outputs a list of the sorted numbers in the range that fulfills the property described above.

Let's see some cases:
sum_dig_pow(1, 10) == [1, 2, 3, 4, 5, 6, 7, 8, 9]
sum_dig_pow(1, 100) == [1, 2, 3, 4, 5, 6, 7, 8, 9, 89]

If there are no numbers of this kind in the range [a, b] the function should output an empty list.
sum_dig_pow(90, 100) == []

Enjoy it!!

Categories : Fundamentals, Control Flow, Basic Language Features, Mathematics, Algorithms, Numbers
Functions, Sorting, Declarative Programming
 */
class SumDigPower {
    private static void testing(long a, long b, long[] res) {
        assertEquals(Arrays.toString(res),
                Arrays.toString(sumDigPow(a, b).toArray()));
    }

    @Test
    @DisplayName("Basic Tests")
    public void test() {
        testing(1, 10, new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        testing(1, 100, new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 89});
        testing(10, 100, new long[]{89});
        testing(90, 100, new long[]{});
        testing(90, 150, new long[]{135});
        testing(50, 150, new long[]{89, 135});
        testing(10, 150, new long[]{89, 135});
    }

    public static List<Long> sumDigPow(long a, long b) {
        // your code
        return LongStream.rangeClosed(a, b)
                .filter(SumDigPower::isNumberEurekaWorthy)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isNumberEurekaWorthy(long number) {
        int idx = 0;
        int actual = 0;
        long expected = number;
        final int len = String.valueOf(number).length();
        while (number > 0) {
            long val = number % 10;
            actual += Math.pow(val, len - idx);
            number /= 10;
            idx++;
        }
        return actual == expected;
    }
}