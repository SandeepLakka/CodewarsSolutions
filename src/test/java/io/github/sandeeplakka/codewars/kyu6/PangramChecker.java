package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
Description:

A pangram is a sentence that contains every single letter of the alphabet at least once.
For example,
the sentence "The quick brown fox jumps over the lazy dog" is a pangram,
because it uses the letters A-Z at least once (case is irrelevant).

Given a string, detect whether or not it is a pangram.
Return True if it is, False if not. Ignore numbers and punctuation.

Categories : Fundamentals, Strings, Data Structures
 */
public class PangramChecker {
    @Test
    public void tests() {
        String pangram1 = "The quick brown fox jumps over the lazy dog";
        assertTrue(check(pangram1));
        assertTrue(checkV1(pangram1));

        String pangram2 = "Cwm fjord bank glyphs vext quiz";
        assertTrue(check(pangram2));
        assertTrue(checkV1(pangram2));

        String pangram3 = "Pack my box with five dozen liquor jugs."; // Sorry kids
        assertTrue(check(pangram3));
        assertTrue(checkV1(pangram3));

        String pangram4 = "How quickly daft jumping zebras vex.";
        assertTrue(check(pangram4));
        assertTrue(checkV1(pangram4));

        String pangram5 = "ABCD45EFGH,IJK,LMNOPQR56STUVW3XYZ";
        assertTrue(check(pangram5));
        assertTrue(checkV1(pangram5));

        String nonPangram1 = "This is not a pangram";
        assertFalse(check(nonPangram1));
        assertFalse(checkV1(nonPangram1));

        String nonPangram2 = "You shall not pass!";
        assertFalse(check(nonPangram2));
        assertFalse(checkV1(nonPangram2));

        String nonPangram3 = "abcdefghijklmopqrstuvwxyz";
        assertFalse(check(nonPangram3));
        assertFalse(checkV1(nonPangram3));

        String nonPangram4 = "A pangram is a sentence that contains every single letter of the alphabet at least once.";
        assertFalse(check(nonPangram4));
        assertFalse(checkV1(nonPangram4));


    }

    public boolean check(String sentence) {
        Set<Integer> charSet = new HashSet<Integer>();
        sentence.toLowerCase()
                .replaceAll("[^a-z]", "")
                .chars().forEach(value -> charSet.add(value));
        return charSet.size() == 26;
    }

    public boolean checkV1(String sentense) {
        return sentense.chars().filter(Character::isAlphabetic)
                .map(chr -> Character.isUpperCase(chr) ? Character.toLowerCase(chr) : chr)
                .distinct().count() == 26;
    }
}