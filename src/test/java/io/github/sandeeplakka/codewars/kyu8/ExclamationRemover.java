package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExclamationRemover {

    @Test
    public void testSimpleString1() {
        assertEquals("Hello World", removeExclamationMarks("Hello World!"));
    }

    static String removeExclamationMarks(String s) {
        return s.replaceAll("!", "");
    }
}