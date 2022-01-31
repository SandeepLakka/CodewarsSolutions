package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
String repeat

Description:

Write a function called repeatStr which repeats the given string string exactly n times.

repeatStr(6, "I") // "IIIIII"
repeatStr(5, "Hello") // "HelloHelloHelloHelloHello"

Categories : Fundamentals
 */
public class StringRepeat {
    @Test
    public void test4a() {
        assertEquals("aaaa", repeatStr(4, "a"));
        assertEquals("aaaa", repeatStrV1(4, "a"));
    }

    @Test
    public void test3Hello() {
        assertEquals("HelloHelloHello", repeatStr(3, "Hello"));
        assertEquals("HelloHelloHello", repeatStrV1(3, "Hello"));
    }

    @Test
    public void test5empty() {
        assertEquals("", repeatStr(5, ""));
        assertEquals("", repeatStrV1(5, ""));
    }

    @Test
    public void test0a() {
        assertEquals("", repeatStr(0, "kata"));
        assertEquals("", repeatStrV1(0, "kata"));
    }

    public static String repeatStr(final int repeat, final String string) {
        return IntStream
                .range(0, repeat)
                .mapToObj(s -> string)
                .collect(Collectors.joining());
    }

    public static String repeatStrV1(final int repeat, final String string) {
        return Collections.nCopies(repeat, string).stream().collect(Collectors.joining());
    }
}
