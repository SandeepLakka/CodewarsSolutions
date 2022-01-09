package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
Description:

Write a function that takes a string of braces,
and determines if the order of the braces is valid.
It should return true if the string is valid, and false if it's invalid.

This Kata is similar to the Valid Parentheses Kata ( See kyu5.ValidParantheses implementation),
but introduces new characters: brackets [], and curly braces {}.

All input strings will be nonempty, and will only consist of parentheses,
brackets and curly braces: ()[]{}.
What is considered Valid?

A string of braces is considered valid if all braces are matched with the correct brace.

Examples

"(){}[]"   =>  True
"([{}])"   =>  True
"(}"       =>  False
"[(])"     =>  False
"[({})](]" =>  False

Categories : Algorithms, Validation, Utilities
 */
public class BraceChecker {

    @Test
    public void testValid() {
        assertTrue(isValid("()"));
        assertTrue(isValid("[]"));
        assertTrue(isValid("{}"));
        assertTrue(isValid("(){}[]"));
        assertTrue(isValid("([{}])"));
        assertTrue(isValid("({})[({})]"));
        assertTrue(isValid("(({{[[]]}}))"));
        assertTrue(isValid("{}({})[]"));
    }

    @Test
    public void testInvalid() throws Exception {
        assertFalse(isValid("[(])"));
        assertFalse(isValid("(}"));
        assertFalse(isValid("(})"));
        assertFalse(isValid(")(}{]["));
        assertFalse(isValid("())({}}{()][]["));
        assertFalse(isValid("(((({{"));
        assertFalse(isValid("}}]]))}])"));
    }

    public boolean isValid(String braces) {
        char[] inputChars = braces.toCharArray();
        ArrayDeque<Character> myStack = new ArrayDeque<>();
        for (char eachChar : inputChars) {
            if (eachChar == '[' || eachChar == '(' || eachChar == '{') {
                myStack.push(eachChar);
                continue;
            }
            if (myStack.isEmpty()) {
                return false;
            }
            char top = myStack.pop();
            switch (eachChar) {
                case ')':
                    if (top == '(') {
                        break;
                    }
                    return false;
                case '}':
                    if (top == '{') {
                        break;
                    }
                    return false;
                case ']':
                    if (top == '[') {
                        break;
                    }
                    return false;
            }
        }
        if (myStack.isEmpty()) {
            return true;
        }
        return false;
    }

}