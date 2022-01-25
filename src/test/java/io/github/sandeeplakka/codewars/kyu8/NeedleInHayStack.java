package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
A Needle in the Haystack

Can you find the needle in the haystack?
Write a function findNeedle() that takes an array full of junk but containing one "needle"
After your function finds the needle it should return a message (as a string) that says:
"found the needle at position " plus the index it found the needle,

so:

findNeedle(new Object[] {"hay", "junk", "hay", "hay", "moreJunk", "needle", "randomJunk"})
should return "found the needle at position 5"

Categories : Fundamentals, Arrays
 */
public class NeedleInHayStack {

    @Test
    public void tests() {
        Object[] haystack1 = {"3", "123124234", null, "needle", "world", "hay", 2, "3", true, false};
        Object[] haystack2 = {"283497238987234", "a dog", "a cat", "some random junk",
                "a piece of hay", "needle", "something somebody lost a while ago"};
        Object[] haystack3 = {1, 2, 3, 4, 5, 6, 7, 8, 8, 7, 5, 4, 3, 4, 5, 6, 67, 5,
                5, 3, 3, 4, 2, 34, 234, 23, 4, 234, 324, 324, "needle", 1, 2, 3, 4,
                5, 5, 6, 5, 4, 32, 3, 45, 54};
        assertEquals("found the needle at position 3", findNeedle(haystack1));
        assertEquals("found the needle at position 5", findNeedle(haystack2));
        assertEquals("found the needle at position 30", findNeedle(haystack3));
    }

    //As per instructions, haystack WILL contain needle so no negative scenarios
    public static String findNeedle(Object[] haystack) {
        // Your code here
        return "found the needle at position " + Arrays.asList(haystack).indexOf("needle");
    }
}