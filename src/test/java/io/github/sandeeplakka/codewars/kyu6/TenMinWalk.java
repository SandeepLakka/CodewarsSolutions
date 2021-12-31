package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*

You live in the city of Cartesia where all roads are laid out in a perfect grid.
You arrived ten minutes too early to an appointment,
so you decided to take the opportunity to go for a short walk.
The city provides its citizens with a Walk Generating App on their phones.
Everytime you press the button it sends you an array of one-letter strings
representing directions to walk (eg. ['n', 's', 'w', 'e']).
You always walk only a single block for each letter (direction)
and you know it takes you one minute to traverse one city block,
so create a function that will return true if the walk the app gives you
will take you exactly ten minutes (you don't want to be early or late!) and will, of course,
return you to your starting point. Return false otherwise.

Note: you will always receive a valid array containing a
random assortment of direction letters ('n', 's', 'e', or 'w' only).
It will never give you an empty array (that's not a walk, that's standing still!).

Categories : Fundamentals, Arrays

 */
public class TenMinWalk {

    private static final char[][] fail = new char[][]{
            new char[]{'n'},
            new char[]{'n', 's'},
            new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'},
            new char[]{'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's', 'e', 'w'},
            new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 'n'},
            new char[]{'e', 'e', 'e', 'w', 'n', 's', 'n', 's', 'e', 'w'},
            new char[]{'n', 'e', 'n', 'e', 'n', 'e', 'n', 'e', 'n', 'e'},
            new char[]{'n', 'w', 'n', 'w', 'n', 'w', 'n', 'w', 'n', 'w'},
            new char[]{'s', 'e', 's', 'e', 's', 'e', 's', 'e', 's', 'e'},
            new char[]{'s', 'w', 's', 'w', 's', 'w', 's', 'w', 's', 'w'}
    };

    private static final char[][] pass = new char[][]{
            new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'},
            new char[]{'e', 'w', 'e', 'w', 'n', 's', 'n', 's', 'e', 'w'},
            new char[]{'n', 's', 'e', 'w', 'n', 's', 'e', 'w', 'n', 's'}
    };

    @Test
    public void differentSet() {
        assertFalse(isValid(fail[0]));
        assertFalse(isValid(fail[1]));
        assertFalse(isValid(fail[2]));
        assertFalse(isValid(fail[3]));
        assertFalse(isValid(fail[4]));
        assertFalse(isValid(fail[5]));
        assertFalse(isValid(fail[6]));
        assertFalse(isValid(fail[7]));
        assertFalse(isValid(fail[8]));
        assertFalse(isValid(fail[9]));
        assertTrue(isValid(pass[0]));
        assertTrue(isValid(pass[1]));
        assertTrue(isValid(pass[2]));
    }

    @Test
    public void tests() {
        assertTrue(isValid(new char[]{'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));
        assertFalse(isValid(new char[]{'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e', 'w', 'e'}));
        assertFalse(isValid(new char[]{'w'}));
        assertFalse(isValid(new char[]{'n', 'n', 'n', 's', 'n', 's', 'n', 's', 'n', 's'}));

        assertTrue(isValid(new char[]{'e', 'e', 'e', 'e', 's', 'w', 'w', 'w', 'w', 'n'}));
        assertFalse(isValid(new char[]{'e', 'e', 'e', 'e', 'w', 'w', 'w', 'w', 'w', 'n'}));

    }

    public static boolean isValid(char[] walk) {
        if (walk.length != 10) return false;
        Map<Character, Character> complementaries = new HashMap<>();

        complementaries.put('n', 's');
        complementaries.put('s', 'n');
        complementaries.put('e', 'w');
        complementaries.put('w', 'e');

        Map<Character, Integer> walks = new HashMap<>();
        for (char side : walk) {
            if (walks.containsKey(complementaries.get(side)) && walks.get(complementaries.get(side)) > 0) {
                walks.put(complementaries.get(side), walks.get(complementaries.get(side)) - 1);
            } else {
                walks.put(side, walks.getOrDefault(side, 0) + 1);
            }
        }

        return walks.values().stream().reduce((a, b) -> a + b).get() == 0;
    }
}