package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripleTrouble {
    @Test
    public void tests() {
        assertEquals("ttlheoiscstk", tripleTrouble("this", "test", "lock"));
        assertEquals("abcabc", tripleTrouble("aa", "bb", "cc"));
        assertEquals("Batman", tripleTrouble("Bm", "aa", "tn"));
        assertEquals("LexLuthor", tripleTrouble("LLh", "euo", "xtr"));
    }

    public static String tripleTrouble(String one, String two, String three) {
        return IntStream.range(0, one.length())
                .mapToObj(value -> String.format("%s%s%s", one.charAt(value), two.charAt(value), three.charAt(value)))
                .collect(Collectors.joining());
    }
}