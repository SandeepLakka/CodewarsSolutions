package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleChars {
    @Test
    void fixedTests1_for_doubleChar() {
        assertEquals("SSttrriinngg", doubleChar("String"));
        assertEquals("HHeelllloo  WWoorrlldd", doubleChar("Hello World"));
        assertEquals("11223344!!__  ", doubleChar("1234!_ "));
    }

    @Test
    void fixedTests2_for_doubleChar() {
        HashMap<String, String> h = new HashMap<>();
        h.put("Peanut Butter", "PPeeaannuutt  BBuutttteerr");
        h.put("Adidas", "AAddiiddaass");
        h.put("1337", "11333377");
        h.put("illuminati", "iilllluummiinnaattii");
        h.put("Scrub Lords", "SSccrruubb  LLoorrddss");
        h.put("123456", "112233445566");
        h.put("____ _ _ __ ___ _ ____ ", "________  __  __  ____  ______  __  ________  ");
        h.put("!#%G#DGY^RC", "!!##%%GG##DDGGYY^^RRCC");
        h.put("Kanye 2020", "KKaannyyee  22002200");
        h.put("Donald Duck", "DDoonnaalldd  DDuucckk");
        h.put("Bernie Sanders is Bae", "BBeerrnniiee  SSaannddeerrss  iiss  BBaaee");
        h.put("(-_-)", "((--__--))");
        h.put("bruh", "bbrruuhh");
        List<String> ar = h.keySet().stream().unordered().collect(Collectors.toList());
        Collections.shuffle(ar);
        IntStream.range(0, ar.size()).forEach(i -> assertEquals(h.get(ar.get(i)), doubleChar(ar.get(i))));
    }

    @Test
    void fixedTests1_for_doubleCharV1() {
        assertEquals("SSttrriinngg", doubleCharV1("String"));
        assertEquals("HHeelllloo  WWoorrlldd", doubleCharV1("Hello World"));
        assertEquals("11223344!!__  ", doubleCharV1("1234!_ "));
    }

    @Test
    void fixedTests2_for_doubleCharV1() {
        HashMap<String, String> h = new HashMap<>();
        h.put("Peanut Butter", "PPeeaannuutt  BBuutttteerr");
        h.put("Adidas", "AAddiiddaass");
        h.put("1337", "11333377");
        h.put("illuminati", "iilllluummiinnaattii");
        h.put("Scrub Lords", "SSccrruubb  LLoorrddss");
        h.put("123456", "112233445566");
        h.put("____ _ _ __ ___ _ ____ ", "________  __  __  ____  ______  __  ________  ");
        h.put("!#%G#DGY^RC", "!!##%%GG##DDGGYY^^RRCC");
        h.put("Kanye 2020", "KKaannyyee  22002200");
        h.put("Donald Duck", "DDoonnaalldd  DDuucckk");
        h.put("Bernie Sanders is Bae", "BBeerrnniiee  SSaannddeerrss  iiss  BBaaee");
        h.put("(-_-)", "((--__--))");
        h.put("bruh", "bbrruuhh");
        List<String> ar = h.keySet().stream().unordered().collect(Collectors.toList());
        Collections.shuffle(ar);
        IntStream.range(0, ar.size()).forEach(i -> assertEquals(h.get(ar.get(i)), doubleCharV1(ar.get(i))));
    }


    public static String doubleChar(String s) {
        //enter your code here
        return Arrays.stream(s.split(""))
                .map(val -> val + val)
                .collect(Collectors.joining());
    }

    public static String doubleCharV1(String s) {
        return s.codePoints()
                .collect(
                        StringBuilder::new,
                        (builder, chr) -> builder.appendCodePoint(chr).appendCodePoint(chr),
                        StringBuilder::append
                ).toString();
    }
}