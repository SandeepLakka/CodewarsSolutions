package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Reversed Strings

Complete the solution so that it reverses the string passed into it.

'world'  =>  'dlrow'
'word'   =>  'drow'

Categories : Fundamentals, Strings
 */
public class ReverseStrings {

    @Test
    public void sampleTests() {
        assertEquals("dlrow", ReverseStrings.solution("world"));
    }

    @Test
    public void someMoreSampleTests() {
        assertEquals("olleh", ReverseStrings.solution("hello"));
        assertEquals("", ReverseStrings.solution(""));
        assertEquals("h", ReverseStrings.solution("h"));
        assertEquals("selur srawedoC", ReverseStrings.solution("Codewars rules"));
    }

    public static String solution(String str) {
        // Your code here...
        char[] res = new char[str.length()];
        for (int i = str.length() - 1; i >= 0; i--) {
            res[str.length() - i - 1] = str.charAt(i);
        }
        return new String(res);
    }

}