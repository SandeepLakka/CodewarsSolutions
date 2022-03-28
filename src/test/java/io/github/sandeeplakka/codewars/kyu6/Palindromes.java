package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Longest Palindrome

Find the length of the longest substring in the given string s that is the same in reverse.
As an example, if the input was “I like racecars that go fast”, the substring (racecar) length would be 7.
If the length of the input string is 0, the return value must be 0.

Example:

"a" -> 1
"aab" -> 2
"abcde" -> 1
"zzbaabcd" -> 4
"" -> 0

Categories : Fundamentals
 */
public class Palindromes {

    @Test
    public void basicTests() {
        assertEquals(1, longestPalindrome("a"));
        assertEquals(2, longestPalindrome("aa"));
        assertEquals(2, longestPalindrome("baa"));
        assertEquals(2, longestPalindrome("aab"));
        assertEquals(1, longestPalindrome("zyabyz"));
        assertEquals(4, longestPalindrome("baabcd"));
        assertEquals(9, longestPalindrome("baablkj12345432133d"));
    }

    @Test
    public void twistedTests() {
        assertEquals(63,
                longestPalindrome("!loj!bu 7u y8z6rh.pqxwc3aka2r?t. .t?r2aka3cwxqp.hr6z8y u7 ub!jolnwc?jui tpt"));
        assertEquals(34,
                longestPalindrome("ieic!e9ovmgf ld ee dl fgmvo9e!ciei6hx4vqozz!h zo0u7"));
        assertEquals(54,
                longestPalindrome("9eu!mw fx5jzn7v9yr  e469fx!?11?!xf964e  ry9v7nzj5xf wm!u4x"));
        assertEquals(68,
                longestPalindrome("?ihuw7bl?fn2t4 cvr5 oo9rv  zl.vct r sv6yuyjuk5m5  " +
                        "5m5kujyuy6vs r tcv.lz  vr9oo 5rvci?b cs rcet!"));
        assertEquals(46,
                longestPalindrome("pe1ftuq?xt ur? m1hml0eppe0lmh1m ?ru tx?qutf1ep"));
        assertEquals(51,
                longestPalindrome("wyz0z jj8mswgu e0q8 f29o p!2glzs gc.q6f2nkukn2f6q.cg szlg2!p o92f 8q!tp"));
        assertEquals(91,
                longestPalindrome("e 0zwm3 adng8i?v898?zl5hci00hc842u0qpuq5s 8.zq42b1v0v1b24qz.8 " +
                        "s5qupq0u248ch00ich5lz?898v?i8gnda 32"));
        assertEquals(33,
                longestPalindrome("pa8024r8jn49nv2?563i365?2vn94nj8r420qc"));
    }

    public static int longestPalindrome(final String s) {
        int highest = -1;
        //if(s.length() <= 1 ) return 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String str = s.substring(i, j);
                String revStr = new StringBuilder(str).reverse().toString();
                //could've tried linear time complexity palindrome check, but going with these for now
                if (str.equals(revStr)) {
                    int length = j - i;
                    if (highest < length) {
                        highest = length;
                    }
                }
            }
        }
        return highest; //your code here
    }

    public static int longestPalRec(final String s, int l) {
        return -1;
    }
}