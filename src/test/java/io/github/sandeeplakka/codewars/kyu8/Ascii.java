package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
get character from ASCII Value

Write a function getChar() which takes a number
and returns the corresponding ASCII char for that value.

Example:
get_char(65)  should return:  'A'

For ASCII table, you can refer to http://www.asciitable.com/
Categories : Fundamentals
 */
public class Ascii {
    @Test
    public void testChar() {
        assertEquals('7', getChar(55));
        assertEquals('8', getChar(56));
        assertEquals('9', getChar(57));
        assertEquals(':', getChar(58));
        assertEquals(';', getChar(59));
        assertEquals('<', getChar(60));
        assertEquals('=', getChar(61));
        assertEquals('>', getChar(62));
        assertEquals('?', getChar(63));
        assertEquals('@', getChar(64));
        assertEquals('A', getChar(65));
        assertEquals(0, Character.compare('!', getChar(33)), "getChar should return a `char`");
    }

    @Test
    public void testExceptionals() {
        assertThrows(IllegalArgumentException.class,
                () -> getChar(-128));
        assertThrows(IllegalArgumentException.class,
                () -> getChar(256));

    }

    public static char getChar(int c) {
        //Thought that there's some utility method to convert
        //Didn't think that typecasting is the only easier way
        if (c < 0 || c > 255) {
            throw new IllegalArgumentException("Invalid char code, " +
                    "Please give code between 0 and 255 (both inclusive)");
        }
        return (char) c;
    }
}