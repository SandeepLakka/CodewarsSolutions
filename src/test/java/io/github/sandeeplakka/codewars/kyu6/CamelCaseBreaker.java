package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Break camelCase

Complete the solution so that the function will break up camel casing, using a space between words.

Example
"camelCasing"  =>  "camel Casing"
"identifier"   =>  "identifier"
""             =>  ""

Categories : Fundamentals, Strings, Formatting, Algorithms
 */
class CamelCaseBreaker {
    @Test
    public void tests() {
        assertEquals("camel Casing", camelCase("camelCasing"), "Incorrect");
        assertEquals("camel Casing Test", camelCase("camelCasingTest"), "Incorrect");
        assertEquals("camelcasingtest", camelCase("camelcasingtest"), "Incorrect");
        assertEquals("", camelCase(""), "Incorrect");
    }

    public static String camelCase(String input) {
        if (input == null || input.length() < 2) return input;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            if (Character.isUpperCase(curChar)) {
                builder.append(" ").append(curChar);
            } else {
                builder.append(curChar);
            }
        }
        return builder.toString();
    }

}