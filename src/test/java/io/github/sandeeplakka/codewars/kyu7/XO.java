package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
Exes and Ohs

Description:
Check to see if a string has the same amount of 'x's and 'o's.
The method must return a boolean and be case insensitive.
The string can contain any char.

Examples input/output:
XO("ooxx") => true
XO("xooxx") => false
XO("ooxXm") => true
XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
XO("zzoo") => false

Categories : Fundamentals
 */
public class XO {

    @Test
    public void testSomething1() {
        assertTrue(getXO("xxxooo"));
    }

    @Test
    public void testSomething2() {
        assertTrue(getXO("xxxXooOo"));
    }

    @Test
    public void testSomething3() {
        assertFalse(getXO("xxx23424esdsfvxXXOOooo"));
    }

    @Test
    public void testSomething4() {
        assertFalse(getXO("xXxxoewrcoOoo"));
    }

    @Test
    public void testSomething5() {
        assertFalse(getXO("XxxxooO"));
    }

    @Test
    public void testSomething6() {
        assertTrue(getXO("zssddd"));
    }

    @Test
    public void testSomething7() {
        assertFalse(getXO("Xxxxertr34"));
    }

    public static boolean getXO(String str) {

        // Good Luck!!
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) == 'X' || str.charAt(i) == 'x' ? 1 : 0;
            sum += str.charAt(i) == 'O' || str.charAt(i) == 'o' ? -1 : 0;
        }
        return sum == 0;
    }
}