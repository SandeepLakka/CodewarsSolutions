package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Sort and Star



You will be given a list of strings. You must sort it alphabetically
(case-sensitive, and based on the ASCII values of the chars) and then return the first value.
The returned value must be a string, and have "***" between each of its letters.
You should not remove or add elements from/to the array.

Categories : Fundamentals, Strings, Arrays

 */
public class SortAndStar {

    @Test
    public void testFixed() {
        assertEquals("b***i***t***c***o***i***n",
                twoSort(new String[]{"bitcoin", "take", "over", "the", "world", "maybe", "who", "knows", "perhaps"}));
        assertEquals("a***r***e",
                twoSort(new String[]{"turns", "out", "random", "test", "cases", "are", "easier",
                        "than", "writing", "out", "basic", "ones"}));
        assertEquals("a***b***o***u***t",
                twoSort(new String[]{"lets", "talk", "about", "javascript", "the", "best", "language"}));
        assertEquals("c***o***d***e",
                twoSort(new String[]{"i", "want", "to", "travel", "the", "world", "writing", "code", "one", "day"}));
        assertEquals("L***e***t***s",
                twoSort(new String[]{"Lets", "all", "go", "on", "holiday", "somewhere", "very", "cold"}));
    }

    public static String twoSort(String[] s) {
        if (s.length == 0) return null;

        String result = s[0];
        for (String value : s) {
            if (value.charAt(0) < result.charAt(0)) {
                result = value;
            }
        }
        return String.join("***", result.split(""));
    }
}