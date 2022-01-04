package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/*
My friend John and I are members of the "Fat to Fit Club (FFC)".
John is worried because each month a list with the weights of members is published
and each month he is the last on the list which means he is the heaviest.

I am the one who establishes the list so I told him: "Don't worry any more,
I will modify the order of the list". It was decided to attribute a "weight" to numbers.
The weight of a number will be from now on the sum of its digits.

For example 99 will have "weight" 18, 100 will have "weight" 1 so in the list 100 will come before 99.

Given a string with the weights of FFC members in normal order can you give
this string ordered by "weights" of these numbers?

Example:
"56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes:
"100 180 90 56 65 74 68 86 99"

When two numbers have the same "weight", let us class them as if they were strings
(alphabetical ordering) and not numbers:

180 is before 90 since, having the same "weight" (9), it comes before as a string.
All numbers in the list are positive numbers and the list can be empty.

Notes : It may happen that the input string have leading, trailing whitespaces
and more than a unique whitespace between two consecutive numbers

Categories : Algorithms, Numbers
 */
public class WeightSort {

    @Test
    public void tests_orderWeight() {
        assertNull(orderWeight(null));
        assertEquals("", orderWeight(""));
        assertEquals("100 180 90 56 65 74 68 86 99", orderWeight("56 65 74 100 99 68 86 180 90"));
        assertEquals("2000 103 123 4444 99", orderWeight("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999",
                orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }

    @Test
    public void tests_cleanerSoln() {
        assertNull(orderWeight(null));
        assertEquals("", cleanerSoln(""));
        assertEquals("100 180 90 56 65 74 68 86 99", cleanerSoln("56 65 74 100 99 68 86 180 90"));
        assertEquals("2000 103 123 4444 99", cleanerSoln("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999",
                cleanerSoln("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }


    private static int getWeight(String number) {
        return (int) number.chars().map(Character::getNumericValue).sum();
    }

    public static String orderWeight(String strng) {
        if (strng == null || strng.trim().length() == 0) return strng;
        // your code
        return Arrays.stream(strng.trim().split(" "))
                .sorted((o1, o2) -> (getWeight(o1) == getWeight(o2)) ?
                        String.CASE_INSENSITIVE_ORDER.compare(o1, o2) :
                        getWeight(o1) - getWeight(o2))
                .collect(Collectors.joining(" "));
    }

    public static String cleanerSoln(String strng) {
        if (Objects.isNull(strng) || strng.trim().isEmpty()) return strng;
        return Arrays.stream(strng.trim().split("\\s+"))
                .sorted(Comparator.comparing(WeightSort::getWeight)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.joining(" "));
    }

}