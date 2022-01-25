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
public class CaesarCipher {

    @Test
    public void test1() {
        String u = "I should have known that you would have a perfect answer for me!!!";
        List<String> v = Arrays.asList("J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!");
        assertEquals(u, CaesarCipher.demovingShift(CaesarCipher.movingShift(u, 1), 1));
        assertEquals(v, CaesarCipher.movingShift(u, 1));
    }

    @Test
    public void test2() {
        String u = "O CAPTAIN! my Captain! our fearful trip is done;";
        assertEquals(u, CaesarCipher.demovingShift(CaesarCipher.movingShift(u, 1), 1));
    }

    @Test
    public void test3() {
        String u = "For you bouquets and ribbon'd wreaths--for you the shores a-crowding;";
        assertEquals(u, CaesarCipher.demovingShift(CaesarCipher.movingShift(u, 1), 1));
    }

    @Test
    public void test4() {
        String u = "Exult, O shores, and ring, O bells! But I, with mournful tread, Walk the deck my Captain lies, Fallen cold and dead. ";
        assertEquals(u, CaesarCipher.demovingShift(CaesarCipher.movingShift(u, 1), 1));
    }

    @Test
    public void testa() {
        String u = " uoxIirmoveNreefckgieaoiEcooqo";
        List<String> v = Arrays.asList(" xscOp", "zvygqA", "ftuwud", "adaxmh", "Edqrut");
        assertEquals(u, CaesarCipher.demovingShift(CaesarCipher.movingShift(u, 2), 2));
        assertEquals(v, CaesarCipher.movingShift(u, 2));
    }

    @Test
    public void testb() {
        String u = "uaoQop jx eh osr okaKv vzagzwpxagokBKriipmc U";
        List<String> v = Arrays.asList("wdsVuw sh", " qu dii h", "evGs uzbi", "caudhoxuM", "Wewxfdu O");
        assertEquals(u, CaesarCipher.demovingShift(CaesarCipher.movingShift(u, 2), 2));
        assertEquals(v, CaesarCipher.movingShift(u, 2));
    }

    @Test
    public void testc() {
        String u = "kgpiqislyhvmffdzlyehjiIteAaaotcoapk bbMgaHlda";
        List<String> v = Arrays.asList("mjtnwpaui", "shztutqdr", "ycffGseBc", "dsyiviyu ", "noAvqYdwu");
        assertEquals(u, CaesarCipher.demovingShift(CaesarCipher.movingShift(u, 2), 2));
        assertEquals(v, CaesarCipher.movingShift(u, 2));
    }

    @Test
    public void testd() {
        String u = "abcdefghjuty";
        List<String> v = Arrays.asList("bdf", "hjl", "nps", "eek", "");
        assertEquals(u, CaesarCipher.demovingShift(CaesarCipher.movingShift(u, 1), 1));
        assertEquals(v, CaesarCipher.movingShift(u, 1));
    }

    @Test
    public void teste() {
        String u = "abcdefghjuty1234";
        List<String> v = Arrays.asList("bdfh", "jlnp", "seek", "1234", "");
        assertEquals(u, CaesarCipher.demovingShift(CaesarCipher.movingShift(u, 1), 1));
        assertEquals(v, CaesarCipher.movingShift(u, 1));
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
        List<String> result = new ArrayList<>();

        return splitString(builder);
    }


    public static String demovingShift(List<String> s, int shift) {
        int idx = 0;
        StringBuilder builder = new StringBuilder();
        for (String str : s) {
            for (int i = 0; i < str.length(); i++) {
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

    @Test
    public void testSplitString() {
        splitString(new StringBuilder("wdsVuw sh qu dii hevGs uzbicau"));
        splitString(new StringBuilder("mjtnwpauishztutqdrycffGseBcdsyiviyu noAvqYdwu"));

    }

    //help from friend @sruthiReddy65 ; Thanks buddy
    public static List<String> splitString(StringBuilder input) {
        int length = input.length();
        List<String> list = new ArrayList<>();
        if (length % 5 == 0) {
            int div = length / 5;
            for (int i = 0; i < length; i = i + div) {
                list.add(input.substring(i, i + div));
            }
        } else {
            int div = length / 5;
            int i = 0;
            int sizeOfParts = div + 1;
            while (i <= length) {
                if (i + sizeOfParts > length) {
                    list.add(input.substring(i));
                } else {
                    list.add(input.substring(i, i + sizeOfParts));
                }
                i = i + sizeOfParts;
            }
        }
        return list;
    }
}