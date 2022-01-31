package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringRepeat {
    @Test
    public void test4a() {
        assertEquals("aaaa", repeatStr(4, "a"));
    }

    @Test
    public void test3Hello() {
        assertEquals("HelloHelloHello", repeatStr(3, "Hello"));
    }

    @Test
    public void test5empty() {
        assertEquals("", repeatStr(5, ""));
    }

    @Test
    public void test0a() {
        assertEquals("", repeatStr(0, "kata"));
    }

    public static String repeatStr(final int repeat, final String string) {
        return IntStream
                .range(0, repeat)
                .mapToObj(s -> string)
                .collect(Collectors.joining());
    }
}
