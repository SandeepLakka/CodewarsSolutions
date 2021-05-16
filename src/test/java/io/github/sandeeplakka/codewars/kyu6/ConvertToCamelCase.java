package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Create the method/function so that it converts dash/underscore
 * delimited words into camel casing. The first word within the output
 * should be capitalized only if the original word was capitalized
 * (known as Upper Camel Case, also often referred to as Pascal case).
 *
 * Examples
 * "the-stealth-warrior" gets converted to "theStealthWarrior"
 * "The_Stealth_Warrior" gets converted to "TheStealthWarrior"
 *
 * Categories: Algorithms, Regular Expressions, Declarative Programming
 * Advanced Language Features, Fundamentals, Strings
 *
 * https://www.codewars.com/kata/517abf86da9663f1d2000003
 */
public class ConvertToCamelCase {

    @Test
    public void testToCamelCase(){
        String tc1 = "the_Stealth_Warrior", er1 = "theStealthWarrior";
        String tc2 = "The_Stealth_Warrior", er2 = "TheStealthWarrior";
        String tc3 = "", er3  = tc3;
        String tc4 = "the stealth warrior", er4 = tc4;
        assertEquals(er1, toCamelCase(tc1));
        assertEquals(er2, toCamelCase(tc2));
        assertEquals(er3, toCamelCase(tc3));
        assertEquals(er4, toCamelCase(tc4));

    }

    static String toCamelCase(String s){
        StringBuilder sb = new StringBuilder();
        if(s == null) return null;
        String[] strs = s.split("-|_");
        sb.append(strs[0]);
        for(int i = 1; i < strs.length ; i++){
            sb.append(Character.toUpperCase(strs[i].charAt(0))+strs[i].substring(1));
        }
        return sb.toString();
    }
}
