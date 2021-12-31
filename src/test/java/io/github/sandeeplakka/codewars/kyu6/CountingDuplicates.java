package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

Count the number of Duplicates

Write a function that will return the count of distinct case-insensitive alphabetic characters
and numeric digits that occur more than once in the input string.
The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.

Example

"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice

Categories : Fundamentals, Strings
 */
public class CountingDuplicates {
    @Test
    public void tests() {
        assertEquals(0, duplicateCount("abcde"));
        assertEquals(2, duplicateCount("aabbcde"));
        assertEquals(2, duplicateCount("aabBcde"));
        assertEquals(1, duplicateCount("indivisibility"));
        assertEquals(2, duplicateCount("Indivisibilities"));
        assertEquals(2, duplicateCount("aA11"));
        assertEquals(2, duplicateCount("ABBA"));

    }


    public static int duplicateCount(String text) {

        return (int) Arrays.stream(text.toLowerCase().split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(stringLongEntry -> stringLongEntry.getValue() > 1)
                .count();
    }
}