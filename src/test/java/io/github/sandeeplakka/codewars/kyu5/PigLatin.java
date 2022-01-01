package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

Simple Pig Latin

Move the first letter of each word to the end of it,
then add "ay" to the end of the word. Leave punctuation marks untouched.
Examples

pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
pigIt('Hello world !');     // elloHay orldway !

Categories : Algorithms, Regular Expressions, Declarative Programming,
Advanced Language Features, Fundamentals, Strings
 */
public class PigLatin {

    @Test
    public void tests() {
        assertEquals("igPay atinlay siay oolcay", pigIt("Pig latin is cool"));
        assertEquals("elloHay orldway !", pigIt("Hello world !"));
        assertEquals("hisTay siay ymay tringsay", pigIt("This is my string"));
        assertEquals("Oay emporatay oay oresmay !", pigIt("O tempora o mores !"));

        assertEquals("igPay atinlay siay oolcay", mindBlownVersion("Pig latin is cool"));
        assertEquals("elloHay orldway !", mindBlownVersion("Hello world !"));
        assertEquals("hisTay siay ymay tringsay", mindBlownVersion("This is my string"));
        assertEquals("Oay emporatay oay oresmay !", mindBlownVersion("O tempora o mores !"));

    }

    public static String pigIt(String str) {

        return Arrays.stream(str.split("\\s"))
                .map(s -> s.matches("\\w+") ? (s.length() > 1 ? s.substring(1) + s.charAt(0) : s) + "ay" : s)
                .collect(Collectors.joining(" "));
    }

    public static String mindBlownVersion(String str) {
        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
    }
}