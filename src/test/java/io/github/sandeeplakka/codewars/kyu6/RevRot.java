package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Reverse or rotate?

The input is a string str of digits.
Cut the string into chunks (a chunk here is a substring of the initial string) of size sz
(ignore the last chunk if its size is less than sz).

If a chunk represents an integer such as the sum of the cubes of its digits is divisible by 2,
reverse that chunk; otherwise rotate it to the left by one position.
Put together these modified chunks and return the result as a string.

If

    sz is <= 0 or if str is empty return ""
    sz is greater (>) than the length of str it is impossible to take a chunk of size sz hence return "".

Examples:

revrot("123456987654", 6) --> "234561876549"
revrot("123456987653", 6) --> "234561356789"
revrot("66443875", 4) --> "44668753"
revrot("66443875", 8) --> "64438756"
revrot("664438769", 8) --> "67834466"
revrot("123456779", 8) --> "23456771"
revrot("", 8) --> ""
revrot("123456779", 0) --> ""
revrot("563000655734469485", 4) --> "0365065073456944"

Example of a string rotated to the left by one position:
s = "123456" gives "234561".

Categories : Fundamentals
 */
class RevRot {

    @Test
    @DisplayName("Fixed tests")
    public void tests() {
        //
        assertEquals("", revRot("1234", 0));
        assertEquals("", revRot("", 0));
        assertEquals("", revRot("1234", 5));
        String s = "733049910872815764";
        assertEquals("330479108928157", revRot(s, 5));
    }

    @Test
    @DisplayName("Fixed tests v2")
    public void testsV2() {
        String s = "73304991087281576455176044327690580265896";
        assertEquals("1994033775182780067155464327690480265895", revRot(s, 8));
        s = "73304991087281576455176044327690580265896896028";
        assertEquals("1994033775182780067155464327690480265895", revRot(s, 8));
        s = "73304991087281576455176044327690580265896896028126182265439";
        assertEquals("3304991087781576455172509672344060265896896862281621820", revRot(s, 11));
        s = "73304991087281576455176044327690580265896896028126182265439441215340989";
        assertEquals("1827801994033776455176044325690580265896875622816218206939441215340984", revRot(s, 14));

        s = "563000655734469485";
        assertEquals("0365065073456944", revRot(s, 4));
        s = "56300065573446948588855";
        assertEquals("365000556437694854888", revRot(s, 3));
        s = "56300065573446948588855200928875449742090";
        assertEquals("000365437556584964255888092880794457", revRot(s, 6));
        s = "56300065573446948588855200928875449742090827299285754137212";
        assertEquals("3755600036546948588854457882900257280902479499285754132", revRot(s, 11));
        s = "56300065573446948588855200928875449742090827299285754137212673841954794395427";
        assertEquals("6300065575446948588355200928885449742097582992728062127314573841954797", revRot(s, 10));
    }

    public static String revRot(String string, int sz) {
        if (sz <= 0 || string.isEmpty() || sz > string.length()) return "";
        // your code
        return IntStream.rangeClosed(0, string.length() / sz - 1)
                .mapToObj(i -> string.substring(i * sz, sz * (i + 1)))
                .map(s -> {
                    if (isSumEven(s)) {
                        return reverse(s);
                    } else {
                        return rotate(s);
                    }
                })
                .collect(Collectors.joining());
    }

    private static boolean isSumEven(String s) {
        return s.chars()
                .map(Character::getNumericValue)
                .map(val -> val * val * val)
                .sum() % 2 == 0;
    }

    private static String reverse(String input) {
        return new StringBuilder(input)
                .reverse()
                .toString();
    }

    private static String rotate(String input) {
        if (input.length() < 2) return input;
        return input.substring(1) + input.charAt(0);
    }
}