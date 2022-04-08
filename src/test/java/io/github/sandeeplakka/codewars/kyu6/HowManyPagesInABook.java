package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HowManyPagesInABook {

    @Test
    public void testSample() {
        assertEquals(5, amountOfPages(5));
        assertEquals(17, amountOfPages(25));
        assertEquals(401, amountOfPages(1095));
        assertEquals(97, amountOfPages(185));
        assertEquals(256, amountOfPages(660));
    }

    public static int amountOfPages(int summary) {
        int noOfPages = 0;
        StringBuilder builder = new StringBuilder();
        while (summary > builder.length()) {
            builder.append(++noOfPages);
        }
        return noOfPages;
    }

}