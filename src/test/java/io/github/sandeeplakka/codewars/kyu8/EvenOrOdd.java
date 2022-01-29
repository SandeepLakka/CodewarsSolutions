package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Even or Odd

Create a function that takes an integer as an argument
and returns "Even" for even numbers or "Odd" for odd numbers.

Categories : Fundamentals, Mathematics, Algorithms, Numbers
 */
public class EvenOrOdd {
    @Test
    public void testEvenOrOdd() {
        assertEquals("Even", even_or_odd(6));
        assertEquals("Odd", even_or_odd(7));
        assertEquals("Even", even_or_odd(0));
        assertEquals("Odd", even_or_odd(-1));
    }
    
    public static String even_or_odd(int number) {
        //Place code here
        System.out.println("number is " + number);
        return (number & 1) == 0 ? "Even" : "Odd";
    }
}