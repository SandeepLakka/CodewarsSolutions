package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Triple Trouble

Create a function that will return a string that combines all the
letters of the three inputted strings in groups.
Taking the first letter of all the inputs and grouping them next to each other.
Do this for every letter, see example below!

E.g. Input: "aa", "bb" , "cc" => Output: "abcabc"

Note: You can expect all the inputs to be the same length.

Categories : Puzzles
 */
public class TripleTrouble {
    @Test
    public void tests_v1_impl() {
        assertEquals("ttlheoiscstk", tripleTrouble("this", "test", "lock"));
        assertEquals("abcabc", tripleTrouble("aa", "bb", "cc"));
        assertEquals("Batman", tripleTrouble("Bm", "aa", "tn"));
        assertEquals("LexLuthor", tripleTrouble("LLh", "euo", "xtr"));
    }

    @Test
    public void tests_v2_impl() {
        assertEquals("ttlheoiscstk", tripleTroubleV2("this", "test", "lock"));
        assertEquals("abcabc", tripleTroubleV2("aa", "bb", "cc"));
        assertEquals("Batman", tripleTroubleV2("Bm", "aa", "tn"));
        assertEquals("LexLuthor", tripleTroubleV2("LLh", "euo", "xtr"));
    }

    public static String tripleTroubleV2(String one, String two, String three) {
        return IntStream.range(0, one.length())
                .flatMap(i -> IntStream.of(one.charAt(i), two.charAt(i), three.charAt(i)))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String tripleTrouble(String one, String two, String three) {
        return IntStream.range(0, one.length())
                .mapToObj(value -> String.format("%s%s%s", one.charAt(value), two.charAt(value), three.charAt(value)))
                .collect(Collectors.joining());
    }
}