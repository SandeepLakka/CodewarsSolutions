package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class StringToArray {
    @Test
    public void basicTests() {
        assertArrayEquals(new String[]{"Robin", "Singh"}, stringToArray("Robin Singh"));
        assertArrayEquals(new String[]{"I", "love", "arrays", "they", "are", "my", "favorite"},
                stringToArray("I love arrays they are my favorite"));
        assertArrayEquals(new String[]{"hello"}, stringToArray("hello"));
    }

    public static String[] stringToArray(String s) {
        //your code;
        return s.split("\\s+");
    }

}