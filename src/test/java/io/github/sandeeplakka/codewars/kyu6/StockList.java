package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Help the bookseller !

A bookseller has lots of books classified in 26 categories labeled A, B, ... Z.
Each book has a code c of 3, 4, 5 or more characters.
The 1st character of a code is a capital letter which defines the book category.
In the bookseller's stocklist each code c is followed by a
space and by a positive integer n (int n >= 0) which indicates the quantity of books of this code in stock.

For example an extract of a stocklist could be:
L = ["ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"]

You will be given a stocklist (e.g. : L) and a list of categories in capital letters e.g :
M = ["A", "B", "C", "W"]
and your task is to find all the books of L with codes
belonging to each category of M and to sum their quantity according to each category.
For the lists L and M of example you have to return the string:
(A : 20) - (B : 114) - (C : 50) - (W : 0)
where A, B, C, W are the categories,
20 is the sum of the unique book of category A,
114 the sum corresponding to "BKWRK" and "BTSQZ",
50 corresponding to "CDXEF" and 0 to category 'W' since there are no code beginning with W.

If L or M are empty return string is ""

Note:
In the result codes and their values are in the same order as in M.

Categories : Fundamentals, Algorithms
 */
public class StockList {

    @Test
    public void test1() { // Ex 1: (A : 200) - (B : 1140)
        String[] art = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String[] cd = new String[]{"A", "B"};
        assertEquals("(A : 200) - (B : 1140)",
                stockSummary(art, cd));
        assertEquals("(A : 200) - (B : 1140)",
                stockSummaryV1(art, cd));
    }

    @Test
    public void test2() { // Ex 2: (A : 0) - (B : 1290) - (C : 515) - (D : 600)
        String[] art = new String[]{"BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String[] cd = new String[]{"A", "B", "C", "D"};
        assertEquals("(A : 0) - (B : 1290) - (C : 515) - (D : 600)",
                stockSummary(art, cd));
        assertEquals("(A : 0) - (B : 1290) - (C : 515) - (D : 600)",
                stockSummaryV1(art, cd));
    }

    @Test
    public void test3() { // Ex 3: (A : 0) - (B : 114) - (C : 70) - (W : 0)
        String[] art = new String[]{"CBART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"};
        String[] cd = new String[]{"A", "B", "C", "W"};
        assertEquals("(A : 0) - (B : 114) - (C : 70) - (W : 0)",
                stockSummary(art, cd));
        assertEquals("(A : 0) - (B : 114) - (C : 70) - (W : 0)",
                stockSummaryV1(art, cd));
    }

    @Test
    public void test4() { // Ex 4:(B : 364) - (R : 225) - (D : 60) - (X : 0)
        String[] art = new String[]{"ROXANNE 102", "RHODODE 123", "BKWRKAA 125", "BTSQZFG 239", "DRTYMKH 060"};
        String[] cd = new String[]{"B", "R", "D", "X"};
        assertEquals("(B : 364) - (R : 225) - (D : 60) - (X : 0)",
                stockSummary(art, cd));
        assertEquals("(B : 364) - (R : 225) - (D : 60) - (X : 0)",
                stockSummaryV1(art, cd));
    }

    @Test
    public void test5() { // Ex 4:(B : 364) - (R : 225) - (D : 60) - (X : 0)
        String[] art = new String[]{};
        String[] cd = new String[]{"B", "R", "D", "X"};
        assertEquals("",
                stockSummary(art, cd));
        assertEquals("",
                stockSummaryV1(art, cd));
    }

    @Test
    public void test6() { // Ex 4:(B : 364) - (R : 225) - (D : 60) - (X : 0)
        String[] art = new String[]{"ROXANNE 102", "RHODODE 123", "BKWRKAA 125", "BTSQZFG 239", "DRTYMKH 060"};
        String[] cd = new String[]{};
        assertEquals("",
                stockSummary(art, cd));
        assertEquals("",
                stockSummaryV1(art, cd));
    }

    // 1st parameter is the stocklist (L in example),
    // 2nd parameter is list of categories (M in example)
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {

        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) return "";

        Map<Character, Integer> register = new HashMap<>();

        Arrays.stream(lstOf1stLetter)
                .map(s -> s.charAt(0))
                .forEach(character -> register.put(character, 0));

        Arrays.stream(lstOfArt)
                .map(s -> s.split(" "))
                .forEach(strings -> {
                    char ch = strings[0].charAt(0);
                    if (register.containsKey(ch)) {
                        register.replace(ch, register.get(ch) + Integer.parseInt(strings[1].trim()));
                    }
                });

        return register.entrySet().stream()
                .map(entry -> "(" + entry.getKey() + " : " + entry.getValue() + ")")
                .collect(Collectors.joining(" - "));
    }

    public static String stockSummaryV1(String[] lstOfArt, String[] lstOf1stLetter) {

        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) return "";

        Map<String, Integer> register =
                Arrays.stream(lstOfArt)
                        .collect(
                                Collectors.groupingBy(s -> s.substring(0, 1),
                                        Collectors.summingInt(value -> Integer.parseInt(value.split(" ")[1]))
                                ));

        return Arrays.stream(lstOf1stLetter)
                .map(s -> "(" + s + " : " + register.getOrDefault(s, 0) + ")")
                .collect(Collectors.joining(" - "));
    }


}
