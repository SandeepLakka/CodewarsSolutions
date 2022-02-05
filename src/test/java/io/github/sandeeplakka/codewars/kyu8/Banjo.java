package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Are You Playing Banjo?

Description:
Create a function which answers the question "Are you playing banjo?".
If your name starts with the letter "R" or lower case "r", you are playing banjo!

The function takes a name as its only argument, and returns one of the following strings:

name + " plays banjo"
name + " does not play banjo"

Names given are always valid strings.

Categories : Fundamentals, Strings, Functions, Control Flow, Basic Language Features
 */
public class Banjo {
    @Test
    public void PeopleThatDontPlayBanjo() {
        assertEquals("Sandeep does not play banjo",
                areYouPlayingBanjo("Sandeep"), "Nope!");
        assertEquals("Adam does not play banjo",
                areYouPlayingBanjo("Adam"), "Nope!");
        assertEquals("Paul does not play banjo",
                areYouPlayingBanjo("Paul"), "Nope!");
        assertEquals("bravo does not play banjo",
                areYouPlayingBanjo("bravo"), "Nope!");
    }

    @Test
    public void PeopleThatDoPlayBanjo() {
        assertEquals("Ringo plays banjo",
                areYouPlayingBanjo("Ringo"), "Nope!");
        assertEquals("rolf plays banjo",
                areYouPlayingBanjo("rolf"), "Nope! Remember lower case counts, too!");
    }

    public static String areYouPlayingBanjo(String name) {
        return name.charAt(0) == 'R' || name.charAt(0) == 'r' ?
                name + " plays banjo" :
                name + " does not play banjo";
    }
}