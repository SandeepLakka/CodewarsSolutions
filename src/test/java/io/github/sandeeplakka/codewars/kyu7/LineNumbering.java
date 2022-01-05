package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

Your team is writing a fancy new text editor and you've been tasked with implementing the line numbering.
Write a function which takes a list of strings and returns each line prepended by the correct number.
The numbering starts at 1. The format is n: string. Notice the colon and space in between.

Examples:

number(Arrays.asList()) # => []
number(Arrays.asList("a", "b", "c")) // => ["1: a", "2: b", "3: c"]

Categories : Fundamentals, Arrays, Iterators, Control Flow
Object-oriented Programming, Basic Language Features
 */
public class LineNumbering {

    @Test
    public void tests_number() {
        assertEquals(Arrays.asList(),
                number(Arrays.asList()));
        assertEquals(Arrays.asList("1: a", "2: b", "3: c"),
                number(Arrays.asList("a", "b", "c")));
        assertEquals(Arrays.asList("1: ", "2: ", "3: ", "4: ", "5: "),
                number(Arrays.asList("", "", "", "", "")));
    }

    @Test
    public void tests_improved() {
        assertEquals(Arrays.asList(),
                improved(Arrays.asList()));
        assertEquals(Arrays.asList("1: a", "2: b", "3: c"),
                improved(Arrays.asList("a", "b", "c")));
        assertEquals(Arrays.asList("1: ", "2: ", "3: ", "4: ", "5: "),
                improved(Arrays.asList("", "", "", "", "")));
    }


    public static List<String> number(List<String> lines) {
        AtomicInteger integer = new AtomicInteger(1);
        return lines.stream().map(s -> integer.getAndAdd(1) + ": " + s).collect(Collectors.toList());
    }

    public static List<String> improved(List<String> lines) {
        if (lines.size() == 0) return lines;
        return IntStream.range(0, lines.size())
                .mapToObj(n -> String.format("%d: %s", n + 1, lines.get(n)))
                .collect(Collectors.toList());
    }
}