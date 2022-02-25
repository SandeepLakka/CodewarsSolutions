package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Decode the Morse code
This kata is part of a series on the Morse code.
After you solve this kata, you may move to the next one.

In this kata you have to write a simple Morse code decoder.
While the Morse code is now mostly superseded by voice and digital data communication channels,
it still has its use in some applications around the world.

The Morse code encodes every character as a sequence of "dots" and "dashes".
For example, the letter A is coded as ·−, letter Q is coded as −−·−,
and digit 1 is coded as ·−−−−. The Morse code is case-insensitive,
traditionally capital letters are used. When the message is written in Morse code,
a single space is used to separate the character codes and 3 spaces are used to separate words.
For example, the message HEY JUDE in Morse code is ···· · −·−−   ·−−− ··− −·· ·.

NOTE: Extra spaces before or after the code have no meaning and should be ignored.

In addition to letters, digits and some punctuation, there are some special service codes,
the most notorious of those is the international distress signal SOS (that was first issued by Titanic),
that is coded as ···−−−···. These special codes are treated as single special characters,
and usually are transmitted as separate words.

Your task is to implement a function that would take the morse code as input
and return a decoded human-readable string.

For example:

MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. .")
//should return "HEY JUDE"

NOTE: For coding purposes you have to use ASCII characters . and -, not Unicode characters.

The Morse code table is preloaded for you as a dictionary, feel free to use it:

    Java: MorseCode.get(".--")

All the test strings would contain valid Morse code, so you may skip checking for errors and exceptions.
In C#, tests will fail if the solution code throws an exception, please keep that in mind.
This is mostly because otherwise the engine would simply ignore the tests, resulting in a "valid" solution.

Good luck!

After you complete this kata, you may try yourself at Decode the Morse code, advanced.

Categories : Algorithms
 */
public class MorseCodeDecoder {

    static Map<String, String> MorseCode = new HashMap<>();

    {
        initializeMorseCodeMap();
    }

    private void initializeMorseCodeMap() {
        MorseCode.put(".-", "A");
        MorseCode.put("-...", "B");
        MorseCode.put("-.-.", "C");
        MorseCode.put("-..", "D");
        MorseCode.put(".", "E");
        MorseCode.put("..-.", "F");
        MorseCode.put("--.", "G");
        MorseCode.put("....", "H");
        MorseCode.put("..", "I");
        MorseCode.put(".---", "J");
        MorseCode.put("-.-", "K");
        MorseCode.put(".-..", "L");
        MorseCode.put("--", "M");
        MorseCode.put("-.", "N");
        MorseCode.put("---", "O");
        MorseCode.put(".--.", "P");
        MorseCode.put("--.-", "Q");
        MorseCode.put(".-.", "R");
        MorseCode.put("...", "S");
        MorseCode.put("-", "T");
        MorseCode.put("..-", "U");
        MorseCode.put("...-", "V");
        MorseCode.put(".--", "W");
        MorseCode.put("-..-", "X");
        MorseCode.put("-.--", "Y");
        MorseCode.put("--..", "Z");
        MorseCode.put("-----", "0");
        MorseCode.put(".----", "1");
        MorseCode.put("..---", "2");
        MorseCode.put("...--", "3");
        MorseCode.put("....-", "4");
        MorseCode.put(".....", "5");
        MorseCode.put("-....", "6");
        MorseCode.put("--...", "7");
        MorseCode.put("---..", "8");
        MorseCode.put("----.", "9");
        MorseCode.put("...---...", "SOS");
    }

    @Test
    public void tests() {
        //TODO Check why this test case fails
        //assertEquals("MORSE CODE",decode("−− −−− ·−· ··· ·   −·−· −−− −·· ·"), "MORSE CODE");

        assertEquals("HEY JUDE", decode(".... . -.--   .--- ..- -.. ."), "HEY JUDE");
        assertEquals("A", decode(".-"), "A");
        assertEquals("E", decode("."), "E");
        assertEquals("I", decode(".."), "I");
        assertEquals("EE", decode(". ."), "EE");
        assertEquals("E E", decode(".   ."), "E E");
        assertEquals("SOS", decode("...---..."), "SOS");
        assertEquals("SOS", decode("... --- ..."), "SOS");
        assertEquals("S O S", decode("...   ---   ..."), "S O S");


    }

    public static String decode(String morseCode) {
        return Arrays.stream(morseCode.trim().split(" ")).peek(System.out::println)
                .map(code -> MorseCode.get(code) == null ? "@" : MorseCode.get(code))
                .peek(System.out::println)
                .collect(Collectors.joining()).replaceAll("@+", " ");
    }

}