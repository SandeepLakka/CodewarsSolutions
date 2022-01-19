package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Description:

Encrypt this!

You want to create secret messages which can be deciphered by the Decipher this!  Here are the conditions:

    Your message is a string containing space separated words.
    You need to encrypt each word in the message using the following rules:
        The first letter must be converted to its ASCII code.
        The second letter must be switched with the last letter
    Keepin' it simple: There are no special characters in the input.

Examples:

encryptThis("Hello") => "72olle"
encryptThis("good") => "103doo"
encryptThis("hello world") => "104olle 119drlo"

Categories  : Fundamentals, Strings, Regular Expressions
Declarative Programming, Advanced Language Features, Arrays
Ciphers, Algorithms, Cryptography, Security

Related kata description:

For each word:

    the second and the last letter is switched (e.g. Hello becomes Holle)
    the first letter is replaced by its character code (e.g. H becomes 72)

Examples

decipherThis('72olle 103doo 100ya'); // 'Hello good day'
decipherThis('82yade 115te 103o'); // 'Ready set go'

 */
public class EncryptThis {

    @Test
    public void tests() {

        assertEquals("72olle", encryptThis("Hello"));
        assertEquals("103doo", encryptThis("good"));
        assertEquals("104olle 119drlo", encryptThis("hello world"));
        assertEquals("", encryptThis(""));
        assertEquals("65 119esi 111dl 111lw 108dvei 105n 97n 111ka",
                encryptThis("A wise old owl lived in an oak"));
        assertEquals("84eh 109ero 104e 115wa 116eh 108sse 104e 115eokp",
                encryptThis("The more he saw the less he spoke"));
        assertEquals("84eh 108sse 104e 115eokp 116eh 109ero 104e 104dare",
                encryptThis("The less he spoke the more he heard"));
        assertEquals("87yh 99na 119e 110to 97ll 98e 108eki 116tah 119esi 111dl 98dri",
                encryptThis("Why can we not all be like that wise old bird"));
        assertEquals("84kanh 121uo 80roti 102ro 97ll 121ruo 104ple",
                encryptThis("Thank you Piotr for all your help"));
    }

    public static String encryptThis(String text) {
        // Implement me! :)
        return Arrays.stream(text.split(" ")).map(s -> {
            if (s.length() < 1) return s;
            if (s.length() < 3) return (int) s.charAt(0) + "" + s.substring(1);
            return (int) s.charAt(0) + ("" + s.charAt(s.length() - 1) + s.substring(2, s.length() - 1) + s.charAt(1));
        }).collect(Collectors.joining(" "));
    }
}