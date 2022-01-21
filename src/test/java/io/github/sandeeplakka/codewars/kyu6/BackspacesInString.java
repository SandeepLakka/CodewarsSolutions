package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackspacesInString {
    @Test
    public void tests() {
        assertEquals("ac", cleanString("abc#d##c"));
        assertEquals("", cleanString("abc####d##c#"));
    }

    //naive
    public String cleanString(String s) {
        // your code here
        Stack<String> chars = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '#':
                    if (!chars.isEmpty()) chars.pop();
                    break;
                default:
                    chars.push("" + s.charAt(i));
            }
        }
        return chars.stream().collect(Collectors.joining());
    }
}