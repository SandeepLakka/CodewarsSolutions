package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Returning Strings

Make a function that will return a greeting statement that uses an input;
your program should return, "Hello, <name> how are you doing today?".

[Make sure you type the exact thing I wrote or the program may not execute properly]

Categories : Fundamentals, Strings
 */
public class ReturningStrings {

    public static String getStr() {
        int min = 10;
        int max = 50;
        int len = (int) Math.floor(Math.random() * (max - min + 1) + min);
        StringBuilder builder = new StringBuilder();
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < len; i++) {
            int r = (int) (Math.random() * alpha.length());
            char ch = alpha.charAt(r);
            builder.append(ch);
        }
        return builder.toString();
    }

    @RepeatedTest(10)
    public void testSomething() {
        String rand = getStr();
        String exp = "Hello, " + rand + " how are you doing today?";
        assertEquals(exp, greet(rand));
    }

    //finally, got hang of String method format
    public static String greet(String name) {
        // Your code here
        return String.format("Hello, %s how are you doing today?", name);
    }
}