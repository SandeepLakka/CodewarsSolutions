package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Maximum Length Difference
You are given two arrays a1 and a2 of strings.
Each string is composed with letters from a to z.
Let x be any string in the first array and y be any string in the second array.

Find max(abs(length(x) − length(y)))

If a1 and/or a2 are empty return -1.
Example:

a1 = ["hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"]
a2 = ["cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"]
mxdiflg(a1, a2) --> 13

Categories : Fundamentals
 */
class MaxDiffLength {

    @Test
    @DisplayName("Fixed Tests V1")
    public void testV1() {
        String[] s1, s2;
        s1 = new String[]{"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis",
                "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"};
        s2 = new String[]{"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};
        assertEquals(13, mxdiflg(s1, s2)); // 13
    }

    @Test
    @DisplayName("Fixed Tests V2")
    public void testV2() {
        String[] s1, s2;
        s1 = new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"};
        s2 = new String[]{"bbbaaayddqbbrrrv"};
        assertEquals(10, mxdiflg(s1, s2)); // 10
        s1 = new String[]{"ccct", "tkkeeeyy", "ggiikffsszzoo", "nnngssddu",
                "rrllccqqqqwuuurdd", "kkbbddaakkk"};
        s2 = new String[]{"tttxxxxxxgiiyyy", "ooorcvvj", "yzzzhhhfffaaavvvpp",
                "jjvvvqqllgaaannn", "tttooo", "qmmzzbhhbb"};
        assertEquals(14, mxdiflg(s1, s2)); // 14
        s1 = new String[]{};
        s2 = new String[]{"bbbaaayddqbbrrrv"};
        assertEquals(-1, mxdiflg(s1, s2));
        s1 = new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"};
        s2 = new String[]{};
        assertEquals(-1, mxdiflg(s1, s2));
        s1 = s2 = new String[]{};
        assertEquals(-1, mxdiflg(s1, s2));
        s1 = s2 = null;
        assertEquals(-1, mxdiflg(s1, s2));

    }

    public static int mxdiflg(String[] a1, String[] a2) {
        if (a1 == null || a2 == null | a1.length == 0 || a2.length == 0) {
            return -1;
        }

        int hiOne, hiTwo, loOne, loTwo;
        hiOne = loOne = a1[0].length();
        hiTwo = loTwo = a2[0].length();

        for (String str : a1) {
            if (hiOne < str.length()) {
                hiOne = str.length();
            }
            if (loOne > str.length()) {
                loOne = str.length();
            }
        }

        for (String str : a2) {
            if (hiTwo < str.length()) {
                hiTwo = str.length();
            }
            if (loTwo > str.length()) {
                loTwo = str.length();
            }
        }

        return Math.max(
                Math.abs(hiOne - loTwo),
                Math.abs(loOne - hiTwo)
        );
    }
}