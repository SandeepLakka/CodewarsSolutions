package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Usage of ternary operation in java

Task:

Complete function saleHotdogs/SaleHotDogs/sale_hotdogs,
function accept 1 parameters:n, n is the number of customers to buy hotdogs,
different numbers have different prices (refer to the following table),
return a number that the customer need to pay how much money.

number              price (cents)
n < 5               100
n >= 5 and n < 10   95
n >= 10             90

Categories : Fundamentals
 */
public class SaleHotdogs {
    @Test
    public void BasicTests() {
        assertEquals(100, saleHotdogs(1));
        assertEquals(400, saleHotdogs(4));
        assertEquals(475, saleHotdogs(5));
        assertEquals(855, saleHotdogs(9));
        assertEquals(900, saleHotdogs(10));
        assertEquals(9000, saleHotdogs(100));
    }

    public static int saleHotdogs(final int n) {
        // show me the code
        return n < 5 ? n * 100 : (n < 10) ? n * 95 : n * 90;
    }
}