package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Word a10n (abbreviation)

The word i18n is a common abbreviation of internationalization in the developer community,
used instead of typing the whole word and trying to spell it correctly.
Similarly, a11y is an abbreviation of accessibility.

Write a function that takes a string and turns any and all "words"
(see below) within that string of length 4 or greater into an abbreviation,
following these rules:
    A "word" is a sequence of alphabetical characters.
    By this definition, any other character like a space or hyphen
    (eg. "elephant-ride") will split up a series of letters into two words
    (eg. "elephant" and "ride").
    The abbreviated version of the word should have the first letter,
    then the number of removed characters,
    then the last letter (eg. "elephant ride" => "e6t r2e").

Example
abbreviate("elephant-rides are really fun!")
//          ^^^^^^^^*^^^^^*^^^*^^^^^^*^^^*
// words (^):   "elephant" "rides" "are" "really" "fun"
//                123456     123     1     1234     1
// ignore short words:               X              X

// abbreviate:    "e6t"     "r3s"  "are"  "r4y"   "fun"
// all non-word characters (*) remain in place
//                     "-"      " "    " "     " "     "!"
=== "e6t-r3s are r4y fun!"

Categories : Fundamentals, Strings

 */
public class Abbreviator {

    private Abbreviator abbreviator;

    @BeforeEach
    public void init() {
        abbreviator = new Abbreviator();
    }

    @Test
    public void te() {
        assertEquals("e6t-r3s are r4y fun!",
                abbreviator.abbreviate("elephant-rides are really fun!"));
        assertEquals("m8c'cat. cat-a", abbreviator.abbreviate("monolithic'cat. cat-a"));
    }

    public String abbreviate(String string) {
        StringBuilder result = new StringBuilder();
        StringBuilder holder = new StringBuilder();

        for (char ch : string.toCharArray()) {
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                holder.append(ch);
            } else {
                result.append(a11te(holder.toString())).append(ch);
                holder = new StringBuilder();
            }
        }
        result.append(a11te(holder.toString()));

        return result.toString();
    }

    private String a11te(String input) {
        if (input.length() < 4) {
            return input;
        } else {
            return input.substring(0, 1) + (input.length() - 2) + input.charAt(input.length() - 1);
        }
    }

}