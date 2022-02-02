package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Consonant value

Description:

Given a lowercase string that has alphabetic characters only and no spaces,
return the highest value of consonant substrings.
Consonants are any letters of the alphabet except "aeiou".

We shall assign the following values: a = 1, b = 2, c = 3, .... z = 26.

For example, for the word "zodiacs", let's cross out the vowels. We get: "z o d ia cs"

-- The consonant substrings are: "z", "d" and "cs"
and the values are z = 26, d = 4 and cs = 3 + 19 = 22. The highest is 26.
solve("zodiacs") = 26

For the word "strength", solve("strength") = 57
-- The consonant substrings are: "str" and "ngth"
with values "str" = 19 + 20 + 18 = 57 and "ngth" = 14 + 7 + 20 + 8 = 49. The highest is 57.


More examples in test cases. Good luck!

Categories : Fundamentals, Strings
 */
public class ConsonantValue {

    @Test
    public void tests_solve() {
        assertEquals(26, solve("zodiacs"));
        assertEquals(57, solve("strength"));
        assertEquals(80, solve("chruschtschov"));
        assertEquals(38, solve("khrushchev"));
        assertEquals(73, solve("catchphrase"));
        assertEquals(103, solve("twelfthstreet"));
        assertEquals(80, solve("mischtschenkoana"));
    }

    @Test
    public void tests_solveV1() {
        assertEquals(26, solveV1("zodiacs"));
        assertEquals(57, solveV1("strength"));
        assertEquals(80, solveV1("chruschtschov"));
        assertEquals(38, solveV1("khrushchev"));
        assertEquals(73, solveV1("catchphrase"));
        assertEquals(103, solveV1("twelfthstreet"));
        assertEquals(80, solveV1("mischtschenkoana"));
    }

    public static int solve(final String s) {
        return Arrays.stream(s.split("[aeiou]+"))
                .mapToInt(str -> str.chars().map(val -> val - 'a' + 1).sum())
                .max()
                .orElse(-1);
    }

    public static int solveV1(final String s) {
        int highestSofar = 0;
        int curHigh = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                if (highestSofar < curHigh) highestSofar = curHigh;
                curHigh = 0;
            } else {
                curHigh += (ch - 'a' + 1);
            }
        }
        return highestSofar;
    }
}