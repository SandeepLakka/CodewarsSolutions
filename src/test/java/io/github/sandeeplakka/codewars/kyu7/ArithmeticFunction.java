package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Make a function that does arithmetic!

Given two numbers and an arithmetic operator (the name of it, as a string),
return the result of the two numbers having that operator used on them.

a and b will both be positive integers, and a will always be the first number
in the operation, and b always the second.

The four operators are "add", "subtract", "divide", "multiply".

A few examples:(Input1, Input2, Input3 --> Output)

5, 2, "add"      --> 7
5, 2, "subtract" --> 3
5, 2, "multiply" --> 10
5, 2, "divide"   --> 2.5

Try to do it without using if statements!

Categories : Fundamentals, Objects, Arithmetic, Mathematics, Algorithms, Numbers

 */
class ArithmeticFunction {
    @Test
    public void testBasic() {
        assertEquals(3, arithmetic(1, 2, "add"),
                "'add' should return the two numbers added together!");
        assertEquals(6, arithmetic(8, 2, "subtract"),
                "'subtract' should return a minus b!");
        assertEquals(10, arithmetic(5, 2, "multiply"),
                "'multiply' should return a multiplied by b!");
        assertEquals(4, arithmetic(8, 2, "divide"),
                "'divide' should return a divided by b!");
    }

    public static int arithmetic(int a, int b, String operator) {
        switch (operator) {
            case "add":
                return a + b;
            case "subtract":
                return a - b;
            case "multiply":
                return a * b;
            case "divide":
                return a / b;
        }
        return -1;
    }
}