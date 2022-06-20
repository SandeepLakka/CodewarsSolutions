package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExclamationRemover {

    @Test
    public void testSimpleString1() {
        assertEquals("Hello World", removeExclamationMarks("Hello World!"));
    }

    @Test
    public void testSimpleString2() {
        assertEquals("Hello World", removeExclamationMarks("Hello World!!!"));
    }

    @Test
    public void testSimpleString3() {
        assertEquals("Hi Hello", removeExclamationMarks("Hi! Hello!"));
    }

    @Test
    public void testRandomString() {
        String rand1, rand2, rand3, rand4;
        rand1 = randomString();
        rand2 = randomString();
        rand3 = randomString();
        rand4 = randomString();
        String expected = String.format("%s%s %s%s", rand1, rand2, rand3, rand4);
        String rs = String.format("%s!%s %s!%s", rand1, rand2, rand3, rand4);
        assertEquals(expected, removeExclamationMarks(rs));
    }

    private String randomString() {
        Random random = new Random();
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZbcdefghijklmnopqrstuvwxyz";
        return IntStream.range(0, 10)
                .mapToObj(__ -> abc.charAt(random.nextInt(abc.length())))
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    static String removeExclamationMarks(String s) {
        return s.replaceAll("!", "");
    }
}