package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*


You probably know the "like" system from Facebook and other pages. People can "like" blog posts, pictures or other items. We want to create the text that should be displayed next to such an item.

Implement the function which takes an array containing the names of people that like an item. It must return the display text as shown in the examples:

[]                                -->  "no one likes this"
["Peter"]                         -->  "Peter likes this"
["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 others like this"

Note: For 4 or more names, the number in "and 2 others" simply increases.
Categories : Fundamentals, Formatting, Algorithms, Strings
 */
class WhoLikesIt {

    @Test
    public void staticTests() {
        assertEquals("no one likes this", whoLikesIt());
        assertEquals("Peter likes this", whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", whoLikesIt("Alex", "Jacob", "Mark", "Max"));

        assertEquals("no one likes this", stringFormatVersion());
        assertEquals("Peter likes this", stringFormatVersion("Peter"));
        assertEquals("Jacob and Alex like this", stringFormatVersion("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", stringFormatVersion("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", stringFormatVersion("Alex", "Jacob", "Mark", "Max"));
    }

    public static String whoLikesIt(String... names) {
        //Do your magic here
        if (names == null || names.length == 0) return "no one likes this";
        if (names.length == 1) return names[0] + " likes this";
        if (names.length == 2) return names[0] + " and " + names[1] + " like this";
        if (names.length == 3) return names[0] + ", " + names[1] + " and " + names[2] + " like this";
        if (names.length > 3) return names[0] + ", " + names[1] + " and " + (names.length - 2) + " others like this";
        return "";
    }

    public static String stringFormatVersion(String... names) {
        switch (names.length) {
            case 0:
                return "no one likes this";
            case 1:
                return String.format("%s likes this", names[0]);
            case 2:
                return String.format("%s and %s like this", names[0], names[1]);
            case 3:
                return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
            default:
                return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
        }
    }
}