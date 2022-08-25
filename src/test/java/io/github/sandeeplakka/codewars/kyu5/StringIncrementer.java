package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
String incrementer

Your job is to write a function which increments a string, to create a new string.

    If the string already ends with a number, the number should be incremented by 1.
    If the string does not end with a number. the number 1 should be appended to the new string.

Examples:
foo -> foo1
foobar23 -> foobar24
foo0042 -> foo0043
foo9 -> foo10
foo099 -> foo100

Attention: If the number has leading zeros the amount of digits should be considered.

Categories : Regular Expressions, Strings
 */
public class StringIncrementer {

    @Test
    public void exampleTests() {
        assertEquals("foobar001", incrementString("foobar000"));
        assertEquals("foo1", incrementString("foo"));
        assertEquals("foobar002", incrementString("foobar001"));
        assertEquals("foobar100", incrementString("foobar99"));
        assertEquals("foobar100", incrementString("foobar099"));
        assertEquals("1", incrementString(""));
    }

    public static String incrementString(String str) {
        Pattern pattern = Pattern.compile("([^\\d]*)([\\d]*)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group(1) + (matcher.group(2).isEmpty() ? 1 : stringify(matcher));
        }
        return null;
    }

    private static String stringify(Matcher matcher) {
        int len = matcher.group(2).length();
        int nextVal = Integer.parseInt(matcher.group(2)) + 1;
        return String.format("%0" + len + "d", nextVal);
    }
}
