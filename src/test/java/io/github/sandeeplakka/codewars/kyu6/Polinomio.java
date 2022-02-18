package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        assertEquals("x", convertStringV1(new int[]{0, 1}), "error when pol={0,1}");
        assertEquals("-1", convertStringV1(new int[]{-1, 0}), "error when pol={-1,0}");

        assertEquals("x", convertStringV2(new int[]{0, 1}), "error when pol={0,1}");
        assertEquals("-1", convertStringV2(new int[]{-1, 0}), "error when pol={-1,0}");
    }

    @Test
    public void extendedTests() {
        assertEquals("5x^4-2x^2+x", convertString(new int[]{0, 1, -2, 0, 5}));
        assertEquals("-2x^2+x+1", convertString(new int[]{1, 1, -2, 0, 0}));
        assertEquals("", convertString(new int[]{}));
        assertEquals("7x^2", convertString(new int[]{0, 0, 7, 0, 0}));
        assertEquals("1", convertString(new int[]{1, 0, 0, 0, 0}));

        assertEquals("5x^4-2x^2+x", convertStringV1(new int[]{0, 1, -2, 0, 5}));
        assertEquals("-2x^2+x+1", convertStringV1(new int[]{1, 1, -2, 0, 0}));
        assertEquals("", convertStringV1(new int[]{}));
        assertEquals("7x^2", convertStringV1(new int[]{0, 0, 7, 0, 0}));
        assertEquals("1", convertStringV1(new int[]{1, 0, 0, 0, 0}));

        assertEquals("5x^4-2x^2+x", convertStringV2(new int[]{0, 1, -2, 0, 5}));
        assertEquals("-2x^2+x+1", convertStringV2(new int[]{1, 1, -2, 0, 0}));
        assertEquals("", convertStringV2(new int[]{}));
        assertEquals("7x^2", convertStringV2(new int[]{0, 0, 7, 0, 0}));
        assertEquals("1", convertStringV2(new int[]{1, 0, 0, 0, 0}));
    }

    @Test
    public void specialTests() {
        assertEquals("x^7+5x^4-x^2+x", convertString(new int[]{0, 1, -1, 0, 5, 0, 0, 1}));
        assertEquals("-3x^6+5x^4-1", convertString(new int[]{-1, 0, 0, 0, 5, 0, -3, 0}));
        assertEquals("x^2+x-1", convertString(new int[]{-1, 1, 1}));
        assertEquals("-x^6+5x^4-x^2-2", convertString(new int[]{-2, 0, -1, 0, 5, 0, -1}));

        assertEquals("x^7+5x^4-x^2+x", convertStringV1(new int[]{0, 1, -1, 0, 5, 0, 0, 1}));
        assertEquals("-3x^6+5x^4-1", convertStringV1(new int[]{-1, 0, 0, 0, 5, 0, -3, 0}));
        assertEquals("x^2+x-1", convertStringV1(new int[]{-1, 1, 1}));
        assertEquals("-x^6+5x^4-x^2-2", convertStringV1(new int[]{-2, 0, -1, 0, 5, 0, -1}));

        assertEquals("x^7+5x^4-x^2+x", convertStringV2(new int[]{0, 1, -1, 0, 5, 0, 0, 1}));
        assertEquals("-3x^6+5x^4-1", convertStringV2(new int[]{-1, 0, 0, 0, 5, 0, -3, 0}));
        assertEquals("x^2+x-1", convertStringV2(new int[]{-1, 1, 1}));
        assertEquals("-x^6+5x^4-x^2-2", convertStringV2(new int[]{-2, 0, -1, 0, 5, 0, -1}));
    }

    //naive crude solution
    static String convertString(int[] pol) {
        if (pol.length == 0) return "";
        StringBuilder builder = new StringBuilder();

        //higher powers of x ( power > 1 )
        for (int i = pol.length - 1; i >= 2; i--) {
            if (pol[i] == 0) continue;
            //if (builder.length() > 0) {
            builder.append(pol[i] < 0 ? (pol[i] == -1 ? "-" : "") : builder.length() > 0 ? "+" : "");
            //}
            if (Math.abs(pol[i]) > 1) builder.append(pol[i]);
            builder.append("x^").append(i);
        }
        //first power of x
        if (pol.length > 1 && pol[1] != 0) {
            if (builder.length() > 0) {
                builder.append(pol[1] < 0 ? "-" : "+");
            }
            if (pol[1] > 1) builder.append(pol[1]);
            builder.append("x");
        }
        //constant
        if (Math.abs(pol[0]) > 0) {
            if (builder.length() > 0) {
                builder.append(pol[0] < 0 ? "" : "+");
            }
            builder.append(pol[0]);
        }

        return builder.toString();
    }

    //better~clever
    static String convertStringV1(final int[] pol) {
        final int len = pol.length;
        if (len == 0) return "";

        return IntStream.range(0, len)
                .map(n -> len - 1 - n)
                .filter(n -> pol[n] != 0)
                .mapToObj(n -> "" + pol[n] + (n == 1 ? "x"
                        : n != 0 ? "x^" + n : ""))
                .collect(Collectors.joining("+"))
                .replaceAll("\\b1(?=x)|\\+(?=-)", "");
    }


    //maintainable and readable
    static String convertStringV2(int[] pol) {

        StringBuilder x = new StringBuilder();

        for (int i = pol.length - 1; i >= 0; i--) {

            //Skipping all integers that are zero
            if (pol[i] != 0) {
                //SIGN
                if (pol[i] < 0) {
                    x.append("-");
                }
                //Not appending plus when the StringBuffer is empty
                else if (x.length() != 0) {
                    x.append("+");
                }

                //NUMBER
                //Skipping 1 and -1 because they become x and +x
                if (pol[i] != 1 && pol[i] != -1) {
                    x.append(Math.abs(pol[i]));
                }

                //EXPONENT
                //Adding x when exponent is one, adding x^i when exponent is >1 and skipping when exponent is 0
                if (i == 1) {
                    x.append("x");
                }
                if (i > 1) {
                    x.append("x^").append(i);
                }

                // Special Case
                // Handling the case when pol[i] is 1 or -1 and i is 0 -> adding 1 and -1
                if (Math.abs(pol[i]) == 1 && i == 0) {
                    x.append(Math.abs(pol[i]));
                }
            }
        }
        return x.toString();

    }

}