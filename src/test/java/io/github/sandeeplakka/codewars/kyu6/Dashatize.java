package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Given a variable n,
If n is an integer, Return a string with dash'-'marks before and after each odd integer,
but do not begin or end the string with a dash mark. If n is negative, then the negative sign should be removed.
If n is not an integer, return an empty value.

Ex:
dashatize(274) -> '2-7-4'
dashatize(6815) -> '68-1-5'
 */
public class Dashatize {


    @Test
    public void testBasic() {
        assertEquals("2-7-4", dashatize(274));
        assertEquals("5-3-1-1", dashatize(5311));
        assertEquals("86-3-20", dashatize(86320));
        assertEquals("9-7-4-3-02", dashatize(974302));

        assertEquals("2-7-4", dashatizeV1(274));
        assertEquals("5-3-1-1", dashatizeV1(5311));
        assertEquals("86-3-20", dashatizeV1(86320));
        assertEquals("9-7-4-3-02", dashatizeV1(974302));
    }

    @Test
    public void testWeird() {
        assertEquals("0", dashatize(0));
        assertEquals("1", dashatize(-1));
        assertEquals("28-3-6-9", dashatize(-28369));

        assertEquals("0", dashatizeV1(0));
        assertEquals("1", dashatizeV1(-1));
        assertEquals("28-3-6-9", dashatizeV1(-28369));
    }

    @Test
    public void testEdgeCases() {
        assertEquals("2-1-4-7-48-3-64-7", dashatize(Integer.MAX_VALUE));
        assertEquals("2-1-4-7-48-3-648", dashatize(Integer.MIN_VALUE));
        assertEquals("1-1-1-1-1-1-1-1-1-1", dashatize(-1111111111));

        assertEquals("2-1-4-7-48-3-64-7", dashatizeV1(Integer.MAX_VALUE));
        assertEquals("2-1-4-7-48-3-648", dashatizeV1(Integer.MIN_VALUE));
        assertEquals("1-1-1-1-1-1-1-1-1-1", dashatizeV1(-1111111111));
    }

    public String dashatize(int number) {
        return Arrays.stream(String.valueOf(number).split(""))
                .filter(s -> s.matches("[0-9]+"))
                .reduce("", (left, right) -> left + (
                        (Integer.parseInt(right) % 2 == 1) ?
                                (left.endsWith("-") || left.isEmpty() ? right + "-" : "-" + right + "-")
                                : right
                )).replaceAll("-$", "");
    }

    public String dashatizeV1(int number) {
        return Integer.toString(number)
                .replaceAll("([13579])", "-$1-")
                .replaceAll("--", "-")
                .replaceAll("^-|-$", "");
    }


}
