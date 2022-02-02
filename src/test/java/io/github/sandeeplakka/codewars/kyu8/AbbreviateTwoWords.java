package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Abbreviate a Two Word Name

Write a function to convert a name into initials.
This kata strictly takes two words with one space in between them.

The output should be two capital letters with a dot separating them.

It should look like this:

Sam Harris => S.H
patrick feeney => P.F

Categories : Fundamentals, Strings, Arrays
 */
public class AbbreviateTwoWords {

    @Test
    public void tests() {
        assertEquals("S.L", abbrevName("Sandeep Lakka"));
        assertEquals("S.H", abbrevName("Sam Harris"));
        assertEquals("P.F", abbrevName("Patrick Feenan"));
        assertEquals("E.C", abbrevName("Evan Cole"));
        assertEquals("P.F", abbrevName("P Favuzzi"));
        assertEquals("D.M", abbrevName("David Mendieta"));
        assertEquals("Z.K", abbrevName("Zenon Kapusta"));
        assertEquals("G.C", abbrevName("george clooney"));
        assertEquals("M.M", abbrevName("marky mark"));
        assertEquals("E.D", abbrevName("eliza doolittle"));
        assertEquals("R.W", abbrevName("reese witherspoon"));
    }

    public static String abbrevName(String name) {
        String res = Character.toUpperCase(name.charAt(0)) + ".";
        for (int i = 0; i < name.length() - 1; i++) {
            if (Character.isWhitespace(name.charAt(i))) {
                res += Character.toUpperCase(name.charAt(i + 1));
                break;
            }
        }
        return res;
    }
}