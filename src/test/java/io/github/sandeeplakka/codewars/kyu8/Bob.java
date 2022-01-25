package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
The Story:

Bob is working as a bus driver. However, he has become extremely popular amongst the city's residents.
With so many passengers wanting to get aboard his bus,
he sometimes has to face the problem of not enough space left on the bus!
He wants you to write a simple program telling him if he will be able to fit all the passengers.

Task Overview:

You have to write a function that accepts three parameters:

    cap is the amount of people the bus can hold excluding the driver.
    on is the number of people on the bus excluding the driver.
    wait is the number of people waiting to get on to the bus excluding the driver.

If there is enough space, return 0, and if there isn't, return the number of passengers he can't take.
Usage Examples:

cap = 10, on = 5, wait = 5 --> 0 # He can fit all 5 passengers
cap = 100, on = 60, wait = 50 --> 10 # He can't fit 10 of the 50 waiting

Categories : Fundamentals, Numbers
 */
class Bob {
    @Test
    public void testBob() {
        assertEquals(0, Bob.enough(10, 5, 5), "Should return 0.");
        assertEquals(10, Bob.enough(100, 60, 50), "Should return 10.");
        assertEquals(0, Bob.enough(20, 5, 5), "Should return 0.");
    }

    static int enough(final int capacity, final int alreadyOn, final int waiting) {
        return Math.max(0, waiting + alreadyOn - capacity);
    }
}