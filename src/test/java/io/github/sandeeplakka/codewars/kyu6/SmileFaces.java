package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

Given an array (arr) as an argument complete the function countSmileys that should return the total number of smiling faces.

Rules for a smiling face:

    Each smiley face must contain a valid pair of eyes. Eyes can be marked as : or ;
    A smiley face can have a nose but it does not have to. Valid characters for a nose are - or ~
    Every smiling face must have a smiling mouth that should be marked with either ) or D

No additional characters are allowed except for those mentioned.

Valid smiley face examples: :) :D ;-D :~)
Invalid smiley faces: ;( :> :} :]
Example

countSmileys([':)', ';(', ';}', ':-D']);       // should return 2;
countSmileys([';D', ':-(', ':-)', ';~)']);     // should return 3;
countSmileys([';]', ':[', ';*', ':$', ';-D']); // should return 1;

Note:

In case of an empty array return 0. You will not be tested with invalid input (input will always be an array). Order of the face (eyes, nose, mouth) elements will always be the same.
Categories : Fundamentals, Regular Expressions, Declarative Programming, Advanced Language Features, Strings
*/

public class SmileFaces {

    @Test
    public void test1() {
        List<String> a = new ArrayList<String>();
        a.add(":)");
        a.add(":D");
        a.add(":-}");
        a.add(":-()");
        assertEquals(2, countSmileys(a));
        assertEquals(2, initialVersion(a));

    }

    @Test
    public void test2() {
        List<String> a = new ArrayList<String>();
        a.add(":)");
        a.add("XD");
        a.add(":0}");
        a.add("x:-");
        a.add("):-");
        a.add("D:");
        assertEquals(1, countSmileys(a));
        assertEquals(1, initialVersion(a));

    }

    @Test
    public void test4() {
        List<String> a = new ArrayList<String>();
        a.add(":)");
        a.add(":D");
        a.add("X-}");
        a.add("xo)");
        a.add(":X");
        a.add(":-3");
        a.add(":3");
        assertEquals(2, countSmileys(a));
        assertEquals(2, initialVersion(a));

    }

    @Test
    public void test5() {
        List<String> a = new ArrayList<String>();
        a.add(":)");
        a.add(":)");
        a.add("x-]");
        a.add(":ox");
        a.add(";-(");
        a.add(";-)");
        a.add(";~(");
        a.add(":~D");
        assertEquals(4, countSmileys(a));
        assertEquals(4, initialVersion(a));

    }

    public static int countSmileys(List<String> arr) {
        // Just Smile :)

        return (int) arr.stream().filter(x -> x.matches("[:;][-~]?[)D]")).count();

    }

    public static int initialVersion(List<String> arr) {
        Pattern pattern = Pattern.compile("^[:;]{1}[-~]?[)D]{1}$");
        int count = 0;
        for (String val : arr) {
            Matcher matcher = pattern.matcher(val);
            if (matcher.find()) count++;
        }
        return count;
    }
}