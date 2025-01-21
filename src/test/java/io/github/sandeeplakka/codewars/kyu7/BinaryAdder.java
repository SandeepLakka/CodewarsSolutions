package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Binary Addition

Implement a function that adds two numbers together and returns their sum in binary.
The conversion can be done before, or after the addition.

The binary number returned should be a string.

Examples:(Input1, Input2 --> Output (explanation)))

1, 1 --> "10" (1 + 1 = 2 in decimal or 10 in binary)
5, 9 --> "1110" (5 + 9 = 14 in decimal or 1110 in binary)

Categories : Binary, Fundamentals
 */
public class BinaryAdder {

    @ParameterizedTest(name = "a = {1}, b = {2}")
    @CsvSource("""
                           10,    1,   1
                            1,    0,   1
                            1,    1,   0
                          100,    2,   2
                       111111,   51,  12
                         1110,    5,   9
                        10100,   10,  10
                     11001000,  100, 100
                1000000000001, 4096,   1
                1111111111111111111111111111111, 0, 2147483647
            """)
    @DisplayName("Basic tests")
    void basicTests(String expected, int a, int b) {
        assertEquals(expected, BinaryAdder.binaryAddition(a, b));
    }

    @Test
    @DisplayName("Random tests")
    void randomTests() {
        int top = Integer.MAX_VALUE / 2;
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        for (int i = 0; i < 40; i++) {
            int a = rand.nextInt(top), b = rand.nextInt(top);
            assertEquals(Integer.toBinaryString(a + b), BinaryAdder.binaryAddition(a, b),
                    String.format("a = %d, b = %d", a, b));
        }
    }

    public static String binaryAddition(int a, int b) {
        var res = a + b;
        StringBuilder sb = new StringBuilder();
        int value = 2;
        while (res > 0) {
            sb.append(res % value);
            res /= value;
        }
        return sb.reverse().toString();
    }
}