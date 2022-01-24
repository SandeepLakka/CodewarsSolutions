package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
First Variation on Caesar Cipher

The action of a Caesar cipher is to replace each plaintext letter
(plaintext letters are from 'a' to 'z' or from 'A' to 'Z')
with a different one a fixed number of places up or down the alphabet.

This program performs a variation of the Caesar shift.
The shift increases by 1 for each character (on each iteration).

If the shift is initially 1, the first character of the message to be encoded will be shifted by 1,
the second character will be shifted by 2, etc...


You will also implement a "demovingShift" function with two parameters
Decoding: parameters and return of function "demovingShift"

    an array of strings: s (possibly resulting from "movingShift", with 5 strings)

    an int shift

"demovingShift" returns a string.

Example:

u = "I should have known that you would have a perfect answer for me!!!"
movingShift(u, 1) returns :

v = ["J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!"]
(quotes added in order to see the strings and the spaces,
your program won't write these quotes, see Example Test Cases)

and demovingShift(v, 1) returns u.

#Ref: Caesar Cipher : http://en.wikipedia.org/wiki/Caesar_cipher

Categories : Fundamentals, Ciphers, Algorithms, Cryptography, Security, Strings, Utilities

 */
//TODO Implementation pending
public class CaesarCipher {

    @Test
    public void test1() {
        String u = "I should have known that you would have a perfect answer for me!!!";
        List<String> v = Arrays.asList("J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!");
        assertEquals(v, movingShift(u, 1));
        assertEquals(u, demovingShift(movingShift(u, 1), 1));
    }

    @Test
    public void test2() {
        String u = " uoxIirmoveNreefckgieaoiEcooqo";
        List<String> v = Arrays.asList(" xscOp", "zvygqA", "ftuwud", "adaxmh", "Edqrut");
        assertEquals(v, movingShift(u, 2));
        assertEquals(u, demovingShift(movingShift(u, 2), 2));
    }

    public static List<String> movingShift(String s, int shift) {
        //
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                char ch = (char) ('a' + (s.charAt(i) - 'a' + shift + i) % 26);
                builder.append(ch);
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                char ch = (char) ('A' + (s.charAt(i) - 'A' + shift + i) % 26);
                builder.append(ch);
            } else {
                builder.append(s.charAt(i));
            }
        }
        System.out.println(">" + builder.toString() + "<");
        List<String> result = new ArrayList<>();

        int i = 0;
        while (i < builder.length()) {
            int endL = i + builder.length() / 5 + 1 > builder.length() ? builder.length() : i + builder.length() / 5 + 1;
            System.out.println("-- >" + builder.substring(i, endL) + "<");
            result.add(builder.substring(i, endL));
            i = endL;
        }
        return result;
    }


    public static String demovingShift(List<String> s, int shift) {
        //
        int idx = 0;
        StringBuilder builder = new StringBuilder();
        for (String str : s) {
            for (int i = 0; i < str.length(); i++) {
                System.out.println("char is >" + str.charAt(i) + "<");
                if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    char ch = (char) ('z' + (str.charAt(i) - 'z' - shift - i - idx) % 26);
                    builder.append(ch);
                } else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                    char ch = (char) ('Z' + (str.charAt(i) - 'Z' - shift - i - idx) % 26);
                    builder.append(ch);
                } else {
                    builder.append(str.charAt(i));
                }
            }
            idx += str.length();
        }
        return builder.toString();
    }
}