package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
Anagram Detection

Description:

An anagram is the result of rearranging the letters of a word to produce a new word
(see wikipedia).

Note: anagrams are case-insensitive

Complete the function to return true if the two arguments given are anagrams of each other;
return false otherwise.

Examples
"foefet" is an anagram of "toffee"
"Buckethead" is an anagram of "DeathCubeK"

Categories : Fundamentals, Strings

 */
public class AnagramDetector {

    @Test
    public void exampleTests() {
        assertTrue(isAnagram("foefet", "toffee"));
        assertTrue(isAnagram("Buckethead", "DeathCubeK"));
        assertTrue(isAnagram("Twoo", "Woot"));
    }

    @Test
    public void moreTests() {
        assertFalse(isAnagram("dumble", "bumble"));
        assertFalse(isAnagram("ound", "round"));
        assertFalse(isAnagram("apple", "pale"));

    }

    //naive
    public static boolean isAnagram(String test, String original) {
        if (test.length() != original.length()) return false;
        char[] testChars = test.toLowerCase().toCharArray();
        char[] origChars = original.toLowerCase().toCharArray();
        for (char testChar : testChars) {
            boolean isFound = false;
            for (char origChar : origChars) {
                if (testChar == origChar) {
                    isFound = true;
                    break;
                }
            }
            if (!isFound) return false;
        }
        return true;
    }
}