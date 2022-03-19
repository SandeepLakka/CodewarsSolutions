package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Srot the inner ctonnet in dsnnieedcg oredr

You have to sort the inner content of every word of a string in descending order.
The inner content is the content of a word without first and the last char.

Some examples:
"sort the inner content in descending order"  -->  "srot the inner ctonnet in dsnnieedcg oredr"
"wait for me"        -->  "wiat for me"
"this kata is easy"  -->  "tihs ktaa is esay"

Words are made up of lowercase letters.
The string will never be null and will never be empty. In C/C++ the string is always nul-terminated.
Have fun coding it and please don't forget to vote and rank this kata! :-)
I have also created other katas. Take a look if you enjoyed this kata!

Categories : Algorithms, Basic Language Features, Fundamentals, Strings
 */
public class SortInnerStrings {

    @Test
    public void exampleTests() {
        assertEquals("srot the inner ctonnet in dsnnieedcg oredr",
                sortTheInnerContent("sort the inner content in descending order"));
        assertEquals("wiat for me", sortTheInnerContent("wait for me"));
        assertEquals("tihs ktaa is esay", sortTheInnerContent("this kata is easy"));
        assertEquals("hi by me", sortTheInnerContent("hi by me"));
    }

    @Test
    public void test_sort() {
        assertEquals("lle", sort("hello"));
        assertEquals("", sort("hi"));
        assertEquals("", sort("a"));
    }

    public static String sortTheInnerContent(String words) {
        return Arrays.stream(words.split(" "))
                .map(SortInnerStrings::sort)
                .collect(Collectors.joining(" "));
    }

    private static String sort(String s) {
        StringBuilder builder = new StringBuilder();
        if (s.length() <= 2) return s;
        builder.append(s.charAt(0));
        builder.append(Arrays.stream(s.substring(1, s.length() - 1)
                        .split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));
        builder.append(s.charAt(s.length() - 1));
        return builder.toString();
    }
}