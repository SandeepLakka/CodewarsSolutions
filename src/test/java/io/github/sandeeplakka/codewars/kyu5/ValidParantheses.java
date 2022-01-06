package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/*
Write a function that takes a string of parentheses, and determines if the order of the parentheses is valid.
The function should return true if the string is valid, and false if it's invalid.
Examples

"()"              =>  true
")(()))"          =>  false
"("               =>  false
"(())((()())())"  =>  true

Constraints

0 <= input.length <= 100

Along with opening (() and closing ()) parenthesis, input may contain any valid ASCII characters.
Furthermore, the input string may be empty and/or not contain any parentheses at all.
Do not treat other forms of brackets as parentheses (e.g. [], {}, <>).

Categories : Algorithms, Validation, Utilities
 */
public class ValidParantheses {

    @Test
    public void tests_validParentheses() {
        assertFalse(validParentheses("()()((()"), "Test failed for input: ()()((()");
        assertTrue(validParentheses("()"), "Test failed for input: ()");
        assertTrue(validParentheses("()()"), "Test failed for input: ()()");
        assertTrue(validParentheses("(())"), "Test failed for input: (())");
        assertFalse(validParentheses(")"), "Test failed for input: )");
        assertFalse(validParentheses(""), "Test failed for input: ");
        assertFalse(validParentheses("())"), "Test failed for input: ())");
        assertTrue(validParentheses("((((()))))"), "Test failed for input: ((((()))))");
        assertFalse(validParentheses("()))"), "Test failed for input: (()))");
        assertFalse(validParentheses("()()()())"), "Test failed for input: ()()()())");
        assertTrue(validParentheses("(()()()())(())"), "Test failed for input: (()()()())(())");
        assertFalse(validParentheses("(((((((("), "Test failed for input: ((((((((");
        assertTrue(validParentheses("(())((()((()))))"), "Test failed for input: (())((()((()))))");
        assertFalse(validParentheses("())("), "Test failed for input: ())(");
        assertFalse(validParentheses(")()()()("), "Test failed for input: )()()()(");
        assertFalse(validParentheses("(()()))("), "Test failed for input: (()()))(");
        assertFalse(validParentheses(")()("), "Test failed for input: )()(");
        assertFalse(validParentheses("())(()"), "Test failed for input: ())(()");
        assertFalse(validParentheses("())(()"), "Test failed for input: ())(()");
        assertTrue(validParentheses("wugwbguegb"), "Test failed for input: wugwbguegb");
        assertFalse(validParentheses("()SDGH#*)DDHGDFGHOHOSHG((fdfdughohg*$YGSg49)"),
                "Test failed for input: ()SDGH#*)DDHGDFGHOHOSHG((fdfdughohg*$YGSg49)");

    }

    @Test
    public void tests_getBracketString() {
        assertEquals("", getBracketString(""));
        assertEquals("()()()", getBracketString("(hello)()(world)"));
        assertEquals("(()))", getBracketString("hey(there(buddy)friend))"));
        assertNull(getBracketString(null));
        assertEquals("", getBracketString("hey there!!"));
    }

    private final static String VALID_BRACKETS = "()";

    public static boolean validParentheses(String parens) {
        //Put code below
        String input = parens;
        if (input == null || input.isEmpty()) return false;

        //this step is not at all necessary but written out of curiosity
        //If this is removed, having filter to select '(,)'
        //in the following for loop will be enough to handle problem
        //So, please excuse :)
        String filteredInput = getBracketString(input);

        Stack<Character> stack = new Stack<>();
        for (char character : filteredInput.toCharArray()) {
            if (character == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else {
                stack.push(character);
            }
        }
        return stack.isEmpty();
    }

    static String getBracketString(String input) {
        if (input == null) return null;
        String bracketStr = "";

        for (char ch : input.toCharArray()) {
            if (VALID_BRACKETS.indexOf(ch) != -1) {
                bracketStr = bracketStr.concat(String.valueOf(ch));
            }
        }

        return bracketStr;
    }
}