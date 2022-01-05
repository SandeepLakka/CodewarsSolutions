package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Complete the function that accepts a string parameter, and reverses each word in the string.
All spaces in the string should be retained.

Examples

"This is an example!" ==> "sihT si na !elpmaxe"
"double  spaces"      ==> "elbuod  secaps"

Categories : Fundamentals, Strings
 */
public class ReverseWords {

    @Test
    public void tests_reverseWords() {
        assertEquals("ehT kciuq nworb xof spmuj revo eht yzal .god",
                reverseWords("The quick brown fox jumps over the lazy dog."));
        assertEquals("elppa", reverseWords("apple"));
        assertEquals("a b c d", reverseWords("a b c d"));
        assertEquals("elbuod  decaps  sdrow", reverseWords("double  spaced  words"));
        assertEquals("   ", reverseWords("   "));
        assertEquals("a", reverseWords("a"));
        assertEquals("", reverseWords(""));
        assertEquals("sihT si eht tsrif .ecnetnes  sihT si eht .dnoces",
                reverseWords("This is the first sentence.  This is the second."));

    }

    @Test
    public void tests_reverse() {
        assertEquals(".god", reverse("dog."));
        assertEquals("elppa", reverse("apple"));
        assertEquals("d c b a", reverse("a b c d"));
        assertEquals("sdrow  decaps  elbuod", reverse("double  spaced  words"));
    }

    public static String reverseWords(final String original) {
        System.out.println("input string is " + original);
        String[] tokens = original.split("\\s");
        System.out.println("tokens are " + Arrays.toString(tokens));
        String tmp = original;
        for (String token : tokens) {
            tmp = tmp.replaceFirst(token, reverse(token));
        }
        System.out.println("final string is " + tmp);
        return tmp;
    }

    private static String reverse(String s) {
        byte[] bytes = new byte[s.length()];
        IntStream.iterate(s.length() - 1, i -> i - 1).limit(s.length())
                .forEach(value -> bytes[s.length() - value - 1] = s.getBytes()[value]);
        return new String(bytes);
    }
}