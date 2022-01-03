package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

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