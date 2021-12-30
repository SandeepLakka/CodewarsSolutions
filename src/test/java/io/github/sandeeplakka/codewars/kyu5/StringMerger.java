package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 *
 * At a job interview, you are challenged to write an algorithm to check if a given string, s, can be formed from two other strings, part1 and part2.
 *
 * The restriction is that the characters in part1 and part2 should be in the same order as in s.
 *
 * The interviewer gives you the following example and tells you to figure out the rest from the given test cases.
 *
 * For example:
 *
 * 'codewars' is a merge from 'cdw' and 'oears':
 *
 *     s:  c o d e w a r s   = codewars
 * part1:  c   d   w         = cdw
 * part2:    o   e   a r s   = oears
 *
 * Categories : Algorithms, Strings
 */
public class StringMerger {

    @Test
    public void testIsMerge(){
        assertTrue(isMerge("Bananas from Bahamas","Bahas", "Bananas from am"));
        assertFalse(isMerge("haveIt", "hav","It"));
        assertTrue(isMerge("hello", "","hello"));
        assertTrue(isMerge("hello","hello",""));
        assertFalse(isMerge("string","merger","stuff"));

    }

    //Recursive approach
    public static boolean isMerge(String s, String part1, String part2){

        if(s.length() == 0 && part1.length() ==  0 && part2.length() == 0) return  true;

        if(s.length() == 0) return false;

        boolean isFirstMatches = (part1.length() > 0 && part1.charAt(0) == s.charAt(0))
                &&  isMerge(s.substring(1), part1.substring(1), part2);
        boolean isSecondMatches =(part2.length() > 0 && part2.charAt(0) == s.charAt(0))
                &&  isMerge(s.substring(1), part1, part2.substring(1));
        return isFirstMatches || isSecondMatches;
    }

    //This is not handling duplicates  : e.g: isMerge("Bananas from Bahamas","Bahas", "Bananas from am") returns false
    public static boolean isMergeV1(String s, String part1, String part2) {
        System.out.println("s is "+s);
        System.out.println("part1 is "+part1);
        System.out.println("part2 is "+part2);

        char[] part1Chars = part1.toCharArray();
        char[] part2Chars = part2.toCharArray();
        char[] sChars = s.toCharArray();
        String formed = "";
        int idx1 = 0;
        int idx2 = 0;
        int idx  = 0;
        for(int i = 0 ; i < sChars.length; i++){
            if(idx < part1Chars.length && sChars[i]  == part1Chars[idx]){
                idx++;
                formed += sChars[i];
                continue;
            }
            if(idx < part2Chars.length && sChars[i] == part2Chars[idx]) {
                idx++;
                formed += sChars[i];
            }
        }
        System.out.println("formed is "+formed+" (idx1,idx2) = ("+idx1+","+idx2+")"+" length of orig string is "+s.length());
        return idx1 == part1Chars.length && idx2 == part2Chars.length && formed.equals(s);
    }

}