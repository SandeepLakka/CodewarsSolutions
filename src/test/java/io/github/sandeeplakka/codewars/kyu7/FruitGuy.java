package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

/*
Help the Fruit Guy



Our fruit guy has a bag of fruit (represented as an array of strings) where some fruits are rotten.
He wants to replace all the rotten pieces of fruit with fresh ones.
For example, given ["apple","rottenBanana","apple"]
the replaced array should be ["apple","banana","apple"].
Your task is to implement a method that accepts an array of strings containing fruits
should return an array of strings where all the rotten fruits are replaced by good ones.

Notes

    If the array is null/nil/None or empty you should return empty array ([]).
    The rotten fruit name will be in this camelcase (rottenFruit).
    The returned array should be in lowercase.


Categories : Arrays, Strings, Fundamentals

 */
public class FruitGuy {

    @Test
    public void testEmptyFruit() {
        assertEquals(0, removeRotten(new String[0]).length);
    }

    @Test
    public void testAllRottenArray() {
        String[] rotten = new String[]{"rottenApple", "rottenBanana",
                "rottenApple", "rottenPineapple", "rottenKiwi"};
        String[] expected = new String[]{"apple", "banana",
                "apple", "pineapple", "kiwi"};
        assertArrayEquals(expected, removeRotten(rotten));
    }

    @Test
    public void testNullArray() {
        assertNotNull(removeRotten(null));
    }

    @Test
    public void testGoodRottenArray() {
        String[] rotten = new String[]{"apple", "rottenBanana", "rottenApple", "pineapple", "kiwi"};
        String[] expected = new String[]{"apple", "banana", "apple", "pineapple", "kiwi"};

        String[] actual;
        try {
            actual = removeRotten(rotten);
        } catch (Throwable e) {
            // see https://github.com/Codewars/codewars.com/issues/21 -> Resolved (07/2018)
            throw new AssertionError("exception during test: " + e, e);
        }
        assertArrayEquals(expected, actual);

    }

    public static String[] removeRotten(String[] fruitBasket) {
        if (fruitBasket == null) return new String[0];
        return Arrays.stream(fruitBasket).map(FruitGuy::stockFreshItems).toArray(String[]::new);

    }

    private static String stockFreshItems(String fruit) {
        return fruit.replaceFirst("rotten", "").toLowerCase(Locale.ROOT);
    }

}