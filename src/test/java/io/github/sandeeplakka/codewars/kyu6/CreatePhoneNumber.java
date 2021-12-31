package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

Write a function that accepts an array of 10 integers (between 0 and 9),
that returns a string of those numbers in the form of a phone number.
Example

createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) => returns "(123) 456-7890"

The returned format must be correct in order to complete this challenge.
Don't forget the space after the closing parentheses!

Categories : Algorithms, Arrays, Strings, Loops, Control Flow
Basic Language Features, Fundamentals, Formatting, Regular Expressions
Declarative Programming, Advanced Language Features

 */
public class CreatePhoneNumber {

    @Test
    public void testsForMyVersion() {
        assertEquals("(123) 456-7890", createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        assertEquals("(123) 456-7890", createPhoneNumber(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        assertEquals("(111) 111-1111", createPhoneNumber(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        assertEquals("(478) 157-9971", createPhoneNumber(new int[]{4, 7, 8, 1, 5, 7, 9, 9, 7, 1}));
        assertEquals("(780) 221-7513", createPhoneNumber(new int[]{7, 8, 0, 2, 2, 1, 7, 5, 1, 3}));
    }

    @Test
    public void testsForCleverHack() {
        assertEquals("(123) 456-7890", cleverHack(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        assertEquals("(123) 456-7890", cleverHack(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        assertEquals("(111) 111-1111", cleverHack(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        assertEquals("(478) 157-9971", cleverHack(new int[]{4, 7, 8, 1, 5, 7, 9, 9, 7, 1}));
        assertEquals("(780) 221-7513", cleverHack(new int[]{7, 8, 0, 2, 2, 1, 7, 5, 1, 3}));

    }

    @Test
    public void testsForClevererVersion() {
        assertEquals("(123) 456-7890", clevererVersion(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        assertEquals("(123) 456-7890", clevererVersion(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        assertEquals("(111) 111-1111", clevererVersion(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        assertEquals("(478) 157-9971", clevererVersion(new int[]{4, 7, 8, 1, 5, 7, 9, 9, 7, 1}));
        assertEquals("(780) 221-7513", clevererVersion(new int[]{7, 8, 0, 2, 2, 1, 7, 5, 1, 3}));
    }

    //my solution
    public static String createPhoneNumber(int[] numbers) {
        // Your code here!
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < numbers.length; i++) {
            if (i == 3) sb.append(") ");
            if (i == 6) sb.append("-");
            sb.append(numbers[i]);
        }
        return sb.toString();
    }

    //inspiration
    public static String cleverHack(int[] numbers) {
        String format = "(xxx) xxx-xxxx";
        for (int num : numbers) {
            format = format.replaceFirst("x", Integer.toString(num));
        }
        return format;
    }

    //inspiration
    public static String clevererVersion(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", Arrays.stream(numbers).boxed().toArray());
    }

}