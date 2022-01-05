package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Return the number (count) of vowels in the given string.

We will consider a, e, i, o, u as vowels for this Kata (but not y).

The input string will only consist of lower case letters and/or spaces.
Categories : Fundamentals, Strings, Utilities
 */
public class Vowels {

    @Test
    public void tests() {
        assertEquals(5, getCount("abracadabra"));
        assertEquals(0, getCount(""));
        assertEquals(4, getCount("pear tree"));
        assertEquals(13, getCount("o a kak ushakov lil vo kashu kakao"));
        assertEquals(168,
                getCount("tk r n m kspkvgiw qkeby lkrpbk uo thouonm fiqqb kxe ydvr n uy e " +
                        "oapiurrpli c ovfaooyfxxymfcrzhzohpek w zaa tue uybclybrrmokmjjnweshmqpmqptmszsvyayry " +
                        "kxa hmoxbxio qrucjrioli  ctmoozlzzihme tikvkb mkuf evrx a " +
                        "vutvntvrcjwqdabyljsizvh affzngslh  ihcvrrsho pbfyojewwsxcexwkqjzfvu " +
                        "yzmxroamrbwwcgo dte zulk ajyvmzulm d avgc cl frlyweezpn pezmrzpdlp yqklzd " +
                        "l ydofbykbvyomfoyiat mlarbkdbte fde pg   k nusqbvquc " +
                        "dovtgepkxotijljusimyspxjwtyaijnhllcwpzhnadrktm fy itsms ssrbhy " +
                        "zhqphyfhjuxfflzpqs mm fyyew ubmlzcze hnq zoxxrprmcdz jes  gjtzo bazvh  " +
                        "tmp lkdas z ieykrma lo  u placg x egqj kugw lircpswb dwqrhrotfaok sz " +
                        "cuyycqdaazsw  bckzazqo uomh lbw hiwy x  qinfgwvfwtuzneakrjecruw ytg " +
                        "smakqntulqhjmkhpjs xwqqznwyjdsbvsrmh pzfihwnwydgxqfvhotuzolc y mso " +
                        "holmkj  nk mbehp dr fdjyep rhvxvwjjhzpv  pyhtneuzw dbrkg dev usimbmlwheeef " +
                        "aaruznfdvu cke ggkeku unfl jpeupytrejuhgycpqhii  cdqp foxeknd djhunxyi ggaiti " +
                        "prkah hsbgwra ffqshfq hoatuiq fgxt goty"));
    }

    public static int getCount(String str) {
        List<Character> vowelsList = Arrays.asList('a', 'e', 'i', 'o', 'u');
        return (int) str.chars().filter(value -> vowelsList.contains(Character.valueOf((char) value))).count();
    }

}