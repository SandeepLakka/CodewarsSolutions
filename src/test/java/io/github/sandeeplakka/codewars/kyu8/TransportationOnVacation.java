package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Transportation on vacation

After a hard quarter in the office you decide to get some rest on a vacation.
So you will book a flight for you and your girlfriend and try to leave all the mess behind you.

You will need a rental car in order for you to get around in your vacation.
The manager of the car rental makes you some good offers.

Every day you rent the car costs $40.
If you rent the car for 7 or more days, you get $50 off your total.
Alternatively, if you rent the car for 3 or more days, you get $20 off your total.

Write a code that gives out the total amount for different days(d).

Categories : Fundamentals
 */
public class TransportationOnVacation {
  @Test
  public void under3Tests() {
    assertEquals(40, rentalCarCost(1));
    assertEquals(80, rentalCarCost(2));
  }

  @Test
  public void under7Tests() {
    assertEquals(100, rentalCarCost(3));
    assertEquals(140, rentalCarCost(4));
    assertEquals(180, rentalCarCost(5));
    assertEquals(220, rentalCarCost(6));
  }

  @Test
  public void over7Tests() {
    assertEquals(230, rentalCarCost(7));
    assertEquals(270, rentalCarCost(8));
    assertEquals(310, rentalCarCost(9));
    assertEquals(350, rentalCarCost(10));
  }

  public static int rentalCarCost(int d) {
    return d * 40 + (d >= 7 ? -50 : (d >= 3 ? -20 : 0));
  }
}
