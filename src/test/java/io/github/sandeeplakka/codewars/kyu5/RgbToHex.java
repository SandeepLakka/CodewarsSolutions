package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
RGB To Hex Conversion

The rgb function is incomplete. Complete it so that passing in RGB decimal values
will result in a hexadecimal representation being returned. Valid decimal values for RGB are 0 - 255.
Any values that fall out of that range must be rounded to the closest valid value.

Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.

The following are examples of expected output values:
rgb(255, 255, 255) // returns FFFFFF
rgb(255, 255, 300) // returns FFFFFF
rgb(0, 0, 0)       // returns 000000
rgb(148, 0, 211)   // returns 9400D3

Categories : Algorithms
 */
public class RgbToHex {

    @Test
    public void sampleTests() {
        assertEquals("000000", rgb(0, 0, 0), "For input: (0, 0, 0)");
        assertEquals("010203", rgb(1, 2, 3), "For input: (1, 2, 3)");
        assertEquals("FFFFFF", rgb(255, 255, 255), "For input: (255, 255, 255)");
        assertEquals("FEFDFC", rgb(254, 253, 252), "For input: (254, 253, 252)");
        assertEquals("00FF7D", rgb(-20, 275, 125), "For input: (-20, 275, 125)");
    }

    public static String rgb(int r, int g, int b) {

        return convertToHex(r) +
                convertToHex(g) +
                convertToHex(b);
    }

    private static String convertToHex(int decimal) {
        Map<Integer, Character> hexCodes = new HashMap<>();
        for (int i = 0; i < 16; i++) {
            char ch;
            if (i >= 10) {
                ch = (char) ('A' + (i - 10));
            } else {
                ch = (char) ('0' + (i));
            }
            hexCodes.put(i, ch);
        }

        if (decimal <= 0) return "00";
        if (decimal >= 255) return "FF";
        StringBuilder builder = new StringBuilder();
        int rem;
        while (decimal > 0) {
            rem = decimal % 16;
            builder.append(hexCodes.get(rem));
            decimal /= 16;
        }
        if (builder.length() == 1) builder.append("0");
        return builder.reverse().toString();
    }
}
