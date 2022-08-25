package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String result = null;
        if (matcher.find()) {
            result = matcher.group(1) + (matcher.group(2).isEmpty() ? 1 : stringify(matcher));
        }
        return result;
    }

    private static String stringify(Matcher matcher) {
        int len = matcher.group(2).length();
        int nextVal = Integer.parseInt(matcher.group(2)) + 1;
        String appender = String.format("%0" + len + "d", nextVal);
        return appender;
    }
}
