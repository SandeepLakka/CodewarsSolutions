package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Description:
altERnaTIng cAsE <=> ALTerNAtiNG CaSe

Define toAlternatingCase such that each lowercase letter becomes uppercase
and each uppercase letter becomes lowercase.

For example:

toAlternativeString("hello world") == "HELLO WORLD"
toAlternativeString("HELLO WORLD") == "hello world"
toAlternativeString("hello WORLD") == "HELLO world"
toAlternativeString("HeLLo WoRLD") == "hEllO wOrld"
toAlternativeString("12345") == "12345" // Non-alphabetical characters are unaffected
toAlternativeString("1a2b3c4d5e") == "1A2B3C4D5E"
toAlternativeString("toAlternatingCase") == "TOaLTERNATINGcASE"

As usual, your function/method should be pure, i.e. it should not mutate the original string.
Categories : Fundamentals

 */
public class StringUtils {

    @Test
    public void fixedTests() {
        assertEquals("HELLO WORLD", toAlternativeString("hello world"));
        assertEquals("hello world", toAlternativeString("HELLO WORLD"));
        assertEquals("HELLO world", toAlternativeString("hello WORLD"));
        assertEquals("hEllO wOrld", toAlternativeString("HeLLo WoRLD"));
        assertEquals("Hello World",
                toAlternativeString(toAlternativeString("Hello World")));
        assertEquals("12345", toAlternativeString("12345"));
        assertEquals("1A2B3C4D5E", toAlternativeString("1a2b3c4d5e"));
        assertEquals("TOaLTERNATINGcASE", toAlternativeString("toAlternatingCase"));
    }

    @Test
    public void kataTitleTests() {
        assertEquals("ALTerNAtiNG CaSe", toAlternativeString("altERnaTIng cAsE"));
        assertEquals("altERnaTIng cAsE", toAlternativeString("ALTerNAtiNG CaSe"));
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE",
                toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe",
                toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }


    //Can be written bit cleaner
    public static String toAlternativeString(String string) {
        // your code here!
        char[] chars = new char[string.length()];
        int[] s = string.chars()
                .map(operand -> !Character.isAlphabetic((char) operand) ? operand :
                        operand <= 'Z' ? operand - 'A' + 'a' :
                                operand - 'a' + 'A').toArray();
        for (int i = 0; i < s.length; i++) {
            chars[i] = (char) s[i];
        }
        return new String(chars);
    }
}