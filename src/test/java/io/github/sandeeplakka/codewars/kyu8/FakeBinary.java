package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeBinary {

    @Test
    public void testSomething() {
        assertEquals("01011110001100111", fakeBin("45385593107843568"));
        assertEquals("101000111101101", fakeBin("509321967506747"));
        assertEquals("011011110000101010000011011", fakeBin("366058562030849490134388085"));
    }

    @Test
    public void testFakeBinV1() {
        assertEquals("01011110001100111", fakeBinV1("45385593107843568"));
        assertEquals("101000111101101", fakeBinV1("509321967506747"));
        assertEquals("011011110000101010000011011", fakeBinV1("366058562030849490134388085"));
    }

    public static String fakeBin(String numberString) {
        if (numberString == null || numberString.length() == 0) return numberString;
        return Arrays.stream(numberString.split(""))
                .map(val -> Integer.parseInt(val) >= 5 ? "1" : "0")
                .collect(Collectors.joining());
    }

    public static String fakeBinV1(String numberString) {
        return numberString.chars().map(val -> val >= '5' ? '1' : '0')
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}