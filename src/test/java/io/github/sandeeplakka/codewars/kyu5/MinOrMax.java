package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/*
Min or Max - Tricky Version

Description

In this kata you're given 3 values: a: int, b: int, symbol: char
Your task is to return the max / min value of (a, b), depending on symbol:
If the symbol is > return the max value, if < return the min value. (you can assume inputs are valid)
Examples

solve(2, 1, '>') => 2
solve(2, 1, '<') => 1

So what's tricky ?

Your code cannot contain any of the following char sequences: \\u if ? . for while switch
This means you're not allowed to use conditionals
( if / ?: / switch / while / for ) or import or use any built in functions / tools.

Input range:
−10000<a,b<10000

Do you really want a hint?
look at the tags

Categories : Puzzles, Fundamentals, Games, Binary, Control Flow, Basic Language Features
 */
public class MinOrMax {


    @Test
    @Disabled
    final void antiCheat() {
        try {
            Files.lines(Paths.get("src/test/java/io/github/sandeeplakka/codewars/kyu5/MinOrMax.java"))
                    .forEach(line -> {
                        String detected = detectTriggers(line);
                        if (detected != null) {
                            fail("Anti-Cheat Triggered for: '" + detected + "'");
                        }
                    });
        } catch (IOException e) {
            fail("file opening failed");
        }
    }

    private final String[] triggers = new String[]{
            "\\u", "if", "?", ".", "for", "while", "switch"
    };

    private String detectTriggers(String line) {
        line = line.toLowerCase();
        for (String trigger : triggers) if (line.contains(trigger)) return trigger;
        return null;
    }

    private void doTest(int a, int b, char c) {
        assertEquals(
                c == '>' ? Math.max(a, b) : Math.min(a, b),
                solve(a, b, c),
                "{ a = " + a + " | b = " + b + " | symbol = " + c + " }\n"
        );
    }

    @Test
    final void fixedTests() {
        doTest(0, 1, '>');
        doTest(0, 1, '<');
        doTest(2, 1, '>');
        doTest(2, 1, '<');
        doTest(0, -1, '>');
        doTest(0, -1, '<');
        doTest(8, 7, '>');
        doTest(8, 7, '<');
    }

    @Test
    final void randomTests() {
        Random r = new Random();
        boolean[] bs = new boolean[]{true, false, true};
        for (int i = 0; i < 1000; i++) {
            doTest(
                    (bs[r.nextInt(3)] ? 1 : -1) * r.nextInt(10000),   // a
                    (bs[r.nextInt(3)] ? 1 : -1) * r.nextInt(10000),   // b
                    r.nextBoolean() ? '>' : '<'                       // symbol
            );
        }
    }


    //--Implementation--------------------------------------------
    public static int solve(int x, int y, char symbol) {
        // good luck ;)
        int[] vals = {min(x, y), max(x, y)};
        return vals[(symbol - 60) / 2];
    }

    private static int max(int x, int y) {
        int abs = absbit32(x, y);
        return (x + y + abs) / 2;
    }

    private static int min(int x, int y) {
        int abs = absbit32(x, y);
        return (x + y - abs) / 2;
    }

    private static int absbit32(int x, int y) {
        int sub = x - y;
        int mask = (sub >> 31);
        return (sub ^ mask) - mask;
    }

}

/*
< - 60
> - 62
 */