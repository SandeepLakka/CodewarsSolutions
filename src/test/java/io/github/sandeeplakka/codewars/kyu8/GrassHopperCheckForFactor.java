package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/*
Grasshopper - Check for factor

This function should test if the factor is a factor of base.
Return true if it is a factor or false if it is not.

About factors
Factors are numbers you can multiply together to get another number.

2 and 3 are factors of 6 because: 2 * 3 = 6
    You can find a factor by dividing numbers.
    If the remainder is 0 then the number is a factor.
    You can use the mod operator (%) in most languages to check for a remainder

For example 2 is not a factor of 7 because: 7 % 2 = 1
Note: base is a non-negative number, factor is a positive number.

Categories : Mathematics, Fundamentals

 */
public class GrassHopperCheckForFactor {

    @Test
    public void basicTests() {
        assertTrue(checkForFactor(10, 2));
        assertTrue(checkForFactor(63, 7));
        assertTrue(checkForFactor(2450, 5));
        assertTrue(checkForFactor(24612, 3));
    }


    public static boolean checkForFactor(int base, int factor) {
        return base % factor == 0;
    }
}