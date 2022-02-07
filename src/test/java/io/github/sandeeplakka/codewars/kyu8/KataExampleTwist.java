package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
Kata Example Twist

This is an easy twist to the example kata
(provided by Codewars when learning how to create your own kata).

Add the value "codewars" to the array websites/Websites 1,000 times.

String[] websites = {};
return websites;

Categories : Fundamentals
 */
public class KataExampleTwist {
    @Test
    public void test() {
        String[] websites = KataExampleTwist.kataExampleTwist();
        assertTrue(websites.length > 0, "The array is still empty");
        assertEquals(1000, websites.length, "The array does not equal 1,000");
        boolean allCodewars = true;
        for (String website : websites) {
            if (!"codewars".equals(website)) {
                allCodewars = false;
                break;
            }
        }
        assertTrue(allCodewars, "Every element in the array must contain the value \"codewars\"");
    }

    //finally got the hang of Collections nCopies method
    public static String[] kataExampleTwist() {
        return Collections.nCopies(1000, "codewars").toArray(new String[]{});
    }
}