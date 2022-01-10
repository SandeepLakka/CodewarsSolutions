package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Given a string of words, you need to find the highest scoring word.

Each letter of a word scores points according to its position
in the alphabet: a = 1, b = 2, c = 3 etc.

You need to return the highest scoring word as a string.

If two words score the same, return the word that appears earliest in the original string.

All letters will be lowercase and all inputs will be valid.

Categories : Fundamentals, Strings, Arrays, Numbers
*/
public class HighestScoringWord {

    @Test
    public void tests() {
        assertEquals("taxi", high("man i need a taxi up to ubud"));
        assertEquals("volcano", high("what time are we climbing up to the volcano"));
        assertEquals("semynak", high("take me to semynak"));

        assertEquals("taxi", cleverAndClean("man i need a taxi up to ubud"));
        assertEquals("volcano", cleverAndClean("what time are we climbing up to the volcano"));
        assertEquals("semynak", cleverAndClean("take me to semynak"));

    }

    @Test
    public void edgeCaseTests() {
        assertEquals("aa", high("aa b"));
        assertEquals("b", high("b aa"));
        assertEquals("bb", high("bb d"));
        assertEquals("d", high("d bb"));
        assertEquals("aaa", high("aaa b"));

        assertEquals("aa", cleverAndClean("aa b"));
        assertEquals("b", cleverAndClean("b aa"));
        assertEquals("bb", cleverAndClean("bb d"));
        assertEquals("d", cleverAndClean("d bb"));
        assertEquals("aaa", cleverAndClean("aaa b"));


    }

    public String high(String s) {
        return Arrays.stream(s.split(" "))
                .sorted(Comparator
                        .comparing(HighestScoringWord::getScore).thenComparing((left, right) -> -1)).reduce((s1, s2) -> s2).get();
    }

    public String cleverAndClean(String s) {
        return Arrays.stream(s.split(" ")).max(Comparator.comparingInt(HighestScoringWord::getScore)).get();
    }

    private static int getScore(String word) {
        return word.chars().map(chr -> chr - 'a' + 1).sum();
    }

}