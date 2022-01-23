package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PinValidator {

    @Test
    public void validPins() {
        assertTrue(validatePin("1234"));
        assertTrue(validatePin("0000"));
        assertTrue(validatePin("1111"));
        assertTrue(validatePin("123456"));
        assertTrue(validatePin("098765"));
        assertTrue(validatePin("000000"));
        assertTrue(validatePin("090909"));
    }

    @Test
    public void nonDigitCharacters() {
        assertFalse(validatePin("a234"));
        assertFalse(validatePin(".234"));
    }

    @Test
    public void invalidLengths() {
        assertFalse(validatePin("1"));
        assertFalse(validatePin("12"));
        assertFalse(validatePin("123"));
        assertFalse(validatePin("12345"));
        assertFalse(validatePin("1234567"));
        assertFalse(validatePin("-1234"));
        assertFalse(validatePin("1.234"));
        assertFalse(validatePin("00000000"));
    }

    public static boolean validatePin(String pin) {
        // Your code here...
        return pin.matches("\\d{4}|\\d{6}");
    }

}