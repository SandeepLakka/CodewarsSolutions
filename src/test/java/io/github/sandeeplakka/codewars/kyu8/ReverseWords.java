package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Reversed Words

Complete the solution so that it reverses all of the words within the string passed in.

Example:
"The greatest victory is that which requires no battle"
-->
"battle no requires which that is victory greatest The"

Categories : Algorithms, Strings
 */
public class ReverseWords {
    @Test
    public void testReverseWords() {
        assertEquals("eating like I", reverseWords("I like eating"));
        assertEquals("flying like I", reverseWords("I like flying"));
        assertEquals("nice is world The", reverseWords("The world is nice"));
        assertEquals("nice so not is world The", reverseWords("The world is not so nice"));
        assertEquals("beatiful is Life", reverseWords("Life is beatiful"));
        assertEquals("won! we hello Hello", reverseWords("Hello hello we won!"));
    }

    @Test
    public void testReverseWordsV1() {
        assertEquals("eating like I", reverseWordsV1("I like eating"));
        assertEquals("flying like I", reverseWordsV1("I like flying"));
        assertEquals("nice is world The", reverseWordsV1("The world is nice"));
        assertEquals("nice so not is world The", reverseWordsV1("The world is not so nice"));
        assertEquals("beatiful is Life", reverseWordsV1("Life is beatiful"));
        assertEquals("won! we hello Hello", reverseWordsV1("Hello hello we won!"));
    }

    @Test
    public void testReverseWordsV2() {
        assertEquals("eating like I", reverseWordsV2("I like eating"));
        assertEquals("flying like I", reverseWordsV2("I like flying"));
        assertEquals("nice is world The", reverseWordsV2("The world is nice"));
        assertEquals("nice so not is world The", reverseWordsV2("The world is not so nice"));
        assertEquals("beatiful is Life", reverseWordsV2("Life is beatiful"));
        assertEquals("won! we hello Hello", reverseWordsV2("Hello hello we won!"));
    }


    public static String reverseWords(String str) {
        String[] words = str.split(" ");
        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", words);
    }

    //learned that Collections can be reverse just like that
    public static String reverseWordsV1(String str) {
        List<String> words = Arrays.asList(str.split(" "));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    //don't like this much as too many string manipulations
    public static String reverseWordsV2(String str) {
        return Arrays.stream(str.split(" ")).reduce((result, right) -> right + " " + result).orElse("");
    }


}