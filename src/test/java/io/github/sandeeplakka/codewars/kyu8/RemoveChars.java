package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
It's pretty straightforward. Your goal is to create a function that removes the first and last characters of a string.
You're given one parameter, the original string.
You don't have to worry with strings with less than two characters.


 */
public class RemoveChars {

    @Test
    public void tests() {
        assertEquals("loquen", remove("eloquent"));
        assertEquals("ountr", remove("country"));
        assertEquals("erso", remove("person"));
        assertEquals("lac", remove("place"));
        assertEquals("oopss", remove("ooopsss"));
    }

    public static String remove(String str) {
        return str.length() > 2 ? str.substring(1, str.length() - 1) : str;
    }
}