package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
String polynomial converter

Your task is to programe:

String convertToString(int[] pol) {....}
The method returns given by a parameter, (integer array)
which represents a polynomial,
the representation of the polynomial in String format.

NOTE:
array{a, b, c, d, e,...., z}
      0  1  2  3  4 ....  n

The numbers indicate the grade of the polynomial,
where n is a positive integer always.

Some examples:
array{0,1,-2,0,5}  -> convertToString(array) -> "5x^4-2x^2+x"
array{1,1,-2,0,0}  -> convertToString(array) -> "-2x^2+x+1"
array{}  -> convertToString(array) -> ""
array{0,0,7,0,0}  -> convertToString(array) -> "7x^2"
array{1,0,0,0,0}  -> convertToString(array) -> "1"
array{0,1,-1,0,5,0,0,1}  -> convertToString(array) -> "x^7+5x^4-x^2+x"

Categories : Fundamentals
 */
public class Polinomio {

    @Test
    public void basicTests() {
        assertEquals("x", convertString(new int[]{0, 1}), "error when pol={0,1}");
        assertEquals("-1", convertString(new int[]{-1, 0}), "error when pol={-1,0}");
    }

    @Test
    public void extendedTests() {
        int[] arr;
        arr = new int[]{0, 1, -2, 0, 5};
        assertEquals("5x^4-2x^2+x", convertString(arr));
        arr = new int[]{1, 1, -2, 0, 0};
        assertEquals("-2x^2+x+1", convertString(arr));// ->
        arr = new int[]{};
        assertEquals("", convertString(arr));// -> ""
        arr = new int[]{0, 0, 7, 0, 0};
        assertEquals("7x^2", convertString(arr));// ->
        arr = new int[]{1, 0, 0, 0, 0};
        assertEquals("1", convertString(arr));// ->
        arr = new int[]{0, 1, -1, 0, 5, 0, 0, 1};
        assertEquals("x^7+5x^4-x^2+x", convertString(arr));// ->
    }

    static String convertString(int[] pol) {
        if (pol.length == 0) return "";
        StringBuilder builder = new StringBuilder();
        if (Math.abs(pol[0]) > 0) builder.append(pol[0]);
        if (pol.length > 1 && pol[1] != 0) {
            if (builder.length() > 0) {
                builder.append("+");
            }
            if (pol[1] > 1) builder.append(pol[1]);
            builder.append("x");
        }
        for (int i = 2; i < pol.length; i++) {
            if (pol[i] == 0) continue;
            if (builder.length() > 0) {
                builder.append("+");
            }
            if (Math.abs(pol[i]) > 1) builder.append(pol[i]);
            builder.append("x^").append(i);
        }
        return builder.toString();
    }

}