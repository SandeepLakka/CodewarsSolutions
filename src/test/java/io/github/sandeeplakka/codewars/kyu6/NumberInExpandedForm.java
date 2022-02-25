package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Write Number in Expanded Form

You will be given a number and you will need to return it as a string in Expanded Form. For example:

Kata.expandedForm(12); # Should return "10 + 2"
Kata.expandedForm(42); # Should return "40 + 2"
Kata.expandedForm(70304); # Should return "70000 + 300 + 4"

NOTE: All numbers will be whole numbers greater than 0.

If you liked this kata, check out part 2!!
Categories : Fundamentals, Strings, Numbers, Mathematics, Algorithms
 */
public class NumberInExpandedForm {
    @Test
    public void test() {
        assertEquals("10 + 2", expandedForm(12));
        assertEquals("40 + 2", expandedForm(42));
        assertEquals("70000 + 300 + 4", expandedForm(70304));
        assertEquals("400000000 + 20000000 + 300000 + 70000 + 20 + 2", expandedForm(420370022));
        assertEquals("4000000 + 900000 + 80000 + 2000 + 300 + 40 + 2", expandedForm(4982342));
        assertEquals("9000000", expandedForm(9000000));
        assertEquals("400000000 + 3000000 + 30000 + 4000 + 500 + 70 + 3", expandedForm(403034573));
    }

    public static String expandedForm(int num) {
        //your code here
        int multiplier = 1;
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            if (num % 10 != 0) list.add(num % 10 * multiplier);
            num /= 10;
            multiplier *= 10;
        }
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(" + "));
    }
}