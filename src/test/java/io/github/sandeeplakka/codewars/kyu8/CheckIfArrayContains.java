package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
You only need one - Beginner

Description:

You will be given an array a and a value x. All you need to do is check whether the provided array contains the value.

Array can contain numbers or strings. X can be either.

Return true if the array contains the value, false if not.

Categories : Fundamentals, Booleans, Strings, Numbers, Arrays

 */
public class CheckIfArrayContains {

    @Test
    public void basicTest() {
        assertTrue(check(new Object[]{66, 101}, 66));
        assertTrue(check(new Object[]{66, 101}, 66));
        assertFalse(check(new Object[]{78, 117, 110, 99, 104, 117, 107, 115}, 8));
        assertTrue(check(new Object[]{101, 45, 75, 105, 99, 107}, 107));
        assertTrue(check(new Object[]{80, 117, 115, 104, 45, 85, 112, 115}, 45));
        assertTrue(check(new Object[]{'t', 'e', 's', 't'}, 'e'));
        assertFalse(check(new Object[]{"what", "a", "great", "kata"}, "kat"));
        assertTrue(check(new Object[]{66, 1, "codewars", 11, "alex loves pushups"}, "alex loves pushups"));
        assertFalse(check(new Object[]{"come", "on", 110, "2500", 10, '!', 7, 15}, "Come"));
        assertTrue(check(new Object[]{"when's", "the", "next", "Katathon?", 9, 7}, "Katathon?"));
        assertFalse(check(new Object[]{8, 7, 5, "bored", "of", "writing", "tests", 115}, 45));
        assertTrue(check(new Object[]{"anyone", "want", "to", "hire", "me?"}, "me?"));
    }

    public static boolean check(Object[] a, Object x) {
        return Arrays.asList(a).contains(x);
    }

}