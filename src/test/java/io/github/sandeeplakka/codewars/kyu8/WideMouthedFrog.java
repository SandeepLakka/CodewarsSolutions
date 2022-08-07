package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
The Wide-Mouthed frog!

The wide-mouth frog is particularly interested in the eating habits of other creatures.
He just can't stop asking the creatures he encounters what they like to eat.
But, then he meets the alligator who just LOVES to eat wide-mouthed frogs!
When he meets the alligator, it then makes a tiny mouth.
Your goal in this kata is to create complete the mouth_size method
this method takes one argument animal which corresponds to the animal encountered by the frog.
If this one is an alligator (case-insensitive) return small otherwise return wide

Categories : Strings, Logic, Fundamentals
 */
public class WideMouthedFrog {

    @Test
    public void fixedTests() {
        assertEquals("wide", mouthSize("toucan"));
        assertEquals("wide", mouthSize("ant bear"));
        assertEquals("small", mouthSize("alligator"));
        assertEquals("wide", mouthSize("not an alligator"));
    }

    public static String mouthSize(String animal) {
        return animal.equalsIgnoreCase("alligator") ? "small" : "wide";
    }
}