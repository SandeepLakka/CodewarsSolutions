package io.github.sandeeplakka.codewars.kyu4;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Permutations

In this kata you have to create all permutations of an input string and remove duplicates, if present.
This means, you have to shuffle all letters from the input in all possible orders.

Examples:
singlePermutations("a") --> ["a"]
singlePermutations("ab") --> ["ab", "ba"]
singlePermutations("aabb") --> ["aabb","abab","abba","baab","baba","bbaa"]

The order of the permutations doesn't matter.

Categories : Algorithms, Permutations, Strings
 */
class Permutations {

    @Test
    public void example0() {
        assertEquals(new ArrayList<String>(), singlePermutations("").stream().sorted().collect(Collectors.toList()));
    }

    @Test
    public void example1() {
        assertEquals(new ArrayList<>(Collections.singletonList("a")),
                singlePermutations("a").stream().sorted().collect(Collectors.toList()));
    }

    @Test
    public void example2() {
        assertEquals(new ArrayList<>(Arrays.asList("ab", "ba")),
                singlePermutations("ab").stream().sorted().collect(Collectors.toList()));
    }

    @Test
    public void example3() {
        assertEquals(new ArrayList<>(Arrays.asList("aabb", "abab", "abba", "baab", "baba", "bbaa")),
                singlePermutations("aabb").stream().sorted().collect(Collectors.toList()));
    }


    @Test
    public void uniqueLetters() {
        List<String> abcd = Arrays.asList("abcd", "abdc", "acbd", "acdb", "adbc", "adcb", "bacd", "badc", "bcad", "bcda", "bdac", "bdca",
                "cabd", "cadb", "cbad", "cbda", "cdab", "cdba", "dabc", "dacb", "dbac", "dbca", "dcab", "dcba");

        assertEquals(abcd, singlePermutations("abcd")
                .stream().sorted().collect(Collectors.toList()));
        assertEquals(abcd, singlePermutations("bcad")
                .stream().sorted().collect(Collectors.toList()));
        assertEquals(abcd, singlePermutations("dcba")
                .stream().sorted().collect(Collectors.toList()));
    }


    @Test
    public void duplicateLetters() {

        assertEquals(Collections.singletonList("aa"),
                singlePermutations("aa").stream().sorted().collect(Collectors.toList()));
        assertEquals(Arrays.asList("aaaab", "aaaba", "aabaa", "abaaa", "baaaa"),
                singlePermutations("aaaab").stream().sorted().collect(Collectors.toList()));
        assertEquals(Arrays.asList("aaaaab", "aaaaba", "aaabaa", "aabaaa", "abaaaa", "baaaaa"),
                singlePermutations("aaaaab").stream().sorted().collect(Collectors.toList()));
    }

    @Test
    public void example4() {
        assertEquals(Collections.singletonList("aa"), singlePermutations("aa").stream().sorted().collect(Collectors.toList()));
    }


    private Set<String> singlePermutations(String a) {
        Set<String> result = new HashSet<>();
        singlePermutations(a, 0, a.length() - 1, result);
        return result;
    }

    public static void singlePermutations(String input, int left, int right, Set<String> list) {
        if (left == right) {
            list.add(input);
            return;
        }
        for (int i = left; i <= right; i++) {
            input = swap(input, i, left);
            singlePermutations(input, left + 1, right, list);
            input = swap(input, left, i);
        }
    }

    private static String swap(String input, int i, int left) {
        char[] charArr = input.toCharArray();
        char temp = charArr[i];
        charArr[i] = charArr[left];
        charArr[left] = temp;
        return new String(charArr);
    }
}