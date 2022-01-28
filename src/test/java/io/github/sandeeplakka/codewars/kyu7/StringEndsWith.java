package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
String ends with?

Complete the solution so that it returns true
if the first argument(string) passed in ends with the 2nd argument (also a string).

Examples:

solution('abc', 'bc') // returns true
solution('abc', 'd') // returns false

Categories : Fundamentals, Strings
 */
public class StringEndsWith {

    @Test
    public void testSomething() {
        assertTrue(solution("abc", "bc"));
        assertFalse(solution("abc", "d"));
        assertFalse(solution(null, "abcd"));
        assertFalse(solution("abcd", null));
    }


    @Test
    public void testToMakeSure() {
        check("samurai", "ai", true);
        check("sumo", "omo", false);
        check("ninja", "ja", true);
        check("sensei", "i", true);
        check("samurai", "ra", false);
        check("abc", "abcd", false);
        check("abc", "abc", true);
        check("abcabc", "bc", true);
        check("ails", "fails", false);
        check("fails", "ails", true);
        check("this", "fails", false);
        check("this", "", true);
        check(":-)", ":-(", false);
        check("!@#$%^&*() :-)", ":-)", true);
        check("abc\n", "abc", false);
    }

    private static void check(String str, String ending, boolean expected) {
        boolean result = solution(str, ending);
        assertEquals(expected, result, "Expected solution(\"" + str + "\", \"" + ending + "\") to return " + expected);
    }

    public static boolean solution(String str, String ending) {
        return str != null && ending != null && str.endsWith(ending);
    }
}