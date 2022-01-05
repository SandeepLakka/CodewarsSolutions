package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
An isogram is a word that has no repeating letters, consecutive or non-consecutive.
Implement a function that determines whether a string that contains only letters is an isogram.
Assume the empty string is an isogram. Ignore letter case.

Example: (Input --> Output)

"Dermatoglyphics" --> true
"aba" --> false
"moOse" --> false (ignore letter case)

Categories : Fundamentals, Strings
 */
public class Isogram {

    @Test
    public void tests() {
        assertTrue(isIsogram("Dermatoglyphics"));
        assertTrue(isIsogram("isogram"));
        assertFalse(isIsogram("moose"));
        assertFalse(isIsogram("isIsogram"));
        assertFalse(isIsogram("aba"));
        assertFalse(isIsogram("moOse"));
        assertTrue(isIsogram("thumbscrewjapingly"));
        assertTrue(isIsogram(""));
    }

    public static boolean isIsogram(String str) {
        return str.length() == str.toLowerCase().chars().distinct()/*boxed().collect(toSet())*/.count();
    }
}