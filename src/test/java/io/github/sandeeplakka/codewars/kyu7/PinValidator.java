package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
Regex validate PIN code

ATM machines allow 4 or 6 digit PIN codes and PIN codes cannot contain anything but exactly 4 digits or exactly 6 digits.

If the function is passed a valid PIN string, return true, else return false.
Examples (Input --> Output)

"1234"   -->  true
"12345"  -->  false
"a234"   -->  false

Categories : Fundamentals, Regular Expressions, Declarative Programming
Advanced Language Features, Strings
 */
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