package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Paginating a huge book

Johnny is working as an intern for a publishing company,
and was tasked with cleaning up old code.
He is working on a program that determines how many digits are in
all the page numbers in a book with pages from 1 to n (inclusive).

For example, a book with 4 pages has 4 digits (one for each page)
while a 12-page book has 15 (9 for 1-9, plus 2 each for 10, 11, 12).

Johnny's boss, looking to future-proof, demanded that the new program
be able to handle books up to 400,000,000,000,000,000 pages.

Categories: Refactoring, Performance

 */
public class BookNum {

    @Test
    public void testFour() {
        assertEquals(4, pageDigits(4));
    }

    @Test
    public void testTwelve() {
        assertEquals(15, pageDigits(12));
    }

    @Test
    public void testOneHundred() {
        assertEquals(192, pageDigits(100));
    }

    @Test
    //OutOfMemoryError : Java heap space for input : 765819893 for pageDigits impl
    public void testHugeNumbers() {
        assertEquals(-1, pageDigits(76581989L/*93160L*/));
    }

    //naive approach : works slowly for large inputs
    public static long pageDigits(long pages) {
        System.out.println("pages : " + pages);
        long rTotal = 0;
        List<Long> vals = LongStream.rangeClosed(1, pages).map(BookNum::getLength).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        long vall = vals.stream().mapToLong(value -> value).sum();
        System.out.println(vall);
        for (long i = 1; i <= pages; i++) {
            rTotal += getLength(i);
        }
        return rTotal;
    }

    private static long getLength(long val) {
        long cnt = 0;
        while (val > 0) {
            cnt++;
            val /= 10;
        }
        return cnt;
    }


    //TODO : Performant impl
    public static long pageDigitsV1(long pages) {
        return -1;
    }

}