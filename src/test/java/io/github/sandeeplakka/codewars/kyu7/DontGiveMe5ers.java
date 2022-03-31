package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Don't give me five!

In this kata you get the start number and the end number of a region
and should return the count of all numbers except numbers with a 5 in it.
The start and the end number are both inclusive!

Examples:
1,9 -> 1,2,3,4,6,7,8,9 -> Result 8
4,17 -> 4,6,7,8,9,10,11,12,13,14,16,17 -> Result 12

The result may contain fives. ;-)
The start number will always be smaller than the end number.
Both numbers can be also negative!

I'm very curious for your solutions and the way you solve it.
Maybe someone of you will find an easy pure mathematics solution.


Categories : Algorithms, Basic Language Features, Fundamentals, Mathematics, Numbers, Arrays
 */
public class DontGiveMe5ers {
    @Test
    public void exampleTests() {
        assertEquals(8, dontGiveMeFive(1, 9));
        assertEquals(12, dontGiveMeFive(4, 17));
    }

    @Test
    public void moreTests() {
        assertEquals(72, dontGiveMeFive(1, 90));
        assertEquals(20, dontGiveMeFive(-4, 17));
        assertEquals(38, dontGiveMeFive(-4, 37));
        assertEquals(13, dontGiveMeFive(-14, -1));
        assertEquals(9, dontGiveMeFive(-14, -6));
    }

    public static int dontGiveMeFive(int start, int end) {
        return (int) IntStream.rangeClosed(start, end)
                .filter(value -> !String.valueOf(value).contains("5"))
                .count();
    }
}