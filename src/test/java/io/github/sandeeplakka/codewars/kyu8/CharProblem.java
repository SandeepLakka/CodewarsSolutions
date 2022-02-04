package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Parse nice int from char problem

Ask a small girl - "How old are you?". She always says strange things... Lets help her!

For correct answer program should return int from 0 to 9.

Assume test input string always valid and
may look like "1 year old" or "5 years old", etc.. The first char is number only.

Categories : Fundamentals, Integers, Numbers, Chars
 */
public class CharProblem {
    @Test
    public void test() {
        //assuming you can decode new born baby's sounds
        assertEquals(0, howOld("0 years old"));
        //serious from now on
        assertEquals(1, howOld("1 year old"));
        assertEquals(2, howOld("2 years old"));
        assertEquals(3, howOld("3 years old"));
        assertEquals(4, howOld("4 years old"));
        assertEquals(5, howOld("5 years old"));
        assertEquals(6, howOld("6 years old"));
        assertEquals(7, howOld("7 years old"));
        assertEquals(8, howOld("8 years old"));
        assertEquals(9, howOld("9 years old"));
    }

    public static int howOld(final String herOld) {
        return Character.getNumericValue(herOld.charAt(0));
    }
}
