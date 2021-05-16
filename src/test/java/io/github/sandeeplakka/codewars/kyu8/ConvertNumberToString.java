package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * We need a function that can transform a number into a string.
 *
 * What ways of achieving this do you know?
 *
 * Examples:
 * 123 --> "123"
 * 999 --> "999"
 *
 * Categories: Fundamentals, Type Casting, Numbers, Strings
 * https://www.codewars.com/kata/5265326f5fda8eb1160004c8
 */
public class ConvertNumberToString {

    @Test
    public void testNumberToString(){
        performTests(this::numberToString_v1);
        performTests(numberToString_v2);
        performTests(numberToString_v3);
    }

    //Traditional method
    public String numberToString_v1(int number){
        return String.valueOf(number);
    }
    //Java 8 Function impl ver1
    public Function<Integer, String> numberToString_v2 = number -> Integer.toString(number);
    //Java 8 Function impl ver2
    public Function<Integer, String> numberToString_v3 = number -> ""+number;

    public void performTests(Function<Integer,String> functionToBeTested){
        final int TC1 = 67;
        final int TC2 = -123;
        final int TC3 = 999;
        final int TC4 = Integer.valueOf(100);

        final String ER1 = "67";
        final String ER2 = "-123";
        final String ER3 = "999";
        final String ER4 = "100";

        assertEquals(ER1, functionToBeTested.apply(TC1));
        assertEquals(ER2, functionToBeTested.apply(TC2));
        assertEquals(ER3, functionToBeTested.apply(TC3));
        assertEquals(ER4, functionToBeTested.apply(TC4));
    }

}
