package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestConsec {

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void tests() {
        testing(longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2), "abigailtheta");
        testing(longestConsec(new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1), "oocccffuucccjjjkkkjyyyeehh");
        testing(longestConsec(new String[]{}, 3), "");
        testing(longestConsec(new String[]{"itvayloxrp", "wkppqsztdkmvcuwvereiupccauycnjutlv", "vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2), "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck");
        testing(longestConsec(new String[]{"wlwsasphmxx", "owiaxujylentrklctozmymu", "wpgozvxxiu"}, 2), "wlwsasphmxxowiaxujylentrklctozmymu");
        testing(longestConsec(new String[]{"zone", "abigail", "theta", "form", "libe", "zas"}, -2), "");
        testing(longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 3), "ixoyx3452zzzzzzzzzzzz");
        testing(longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 15), "");
        testing(longestConsec(new String[]{"it", "wkppv", "ixoyx", "3452", "zzzzzzzzzzzz"}, 0), "");
        testing(longestConsec(new String[]{"hello", "world"}, 5), "");
    }

    public static String longestConsec(String[] strarr, int k) {
        if (strarr.length <= 0 || k <= 0 || strarr.length < k) {
            return "";
        }
        // your code
        String maxLengthString = "";
        StringBuilder builder;
        for (int i = 0; i < strarr.length - k + 1; i++) {
            builder = new StringBuilder();
            for (int j = 0; j < k; j++) {
                builder.append(strarr[i + j]);
            }
            if (builder.length() > maxLengthString.length()) maxLengthString = builder.toString();
        }
        return maxLengthString;
    }
}