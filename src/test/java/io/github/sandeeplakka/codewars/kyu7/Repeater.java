package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Thinkful - String Drills: Repeater

Write a function named repeater() that takes two arguments (a string and a number),
and returns a new string where the input string is repeated that many times.

Example:
(Input1, Input2 --> Output)
"a", 5 --> "aaaaa"


Categories : Fundamentals
 */
public class Repeater {

    @Test
    public void testSomething() {
        assertEquals("aaaaa", repeat("a", 5));
        assertEquals("NaNaNaNaNaNaNaNaNaNaNaNaNaNaNaNa", repeat("Na", 16));
        assertEquals("Wub Wub Wub Wub Wub Wub ", repeat("Wub ", 6));
    }

    public static String repeat(String string, long n) {
        return LongStream.range(0, n)
                .mapToObj(value -> string)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}