package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Nessie {

    @Test
    public void testBasicTrue() {
        String n = "Your girlscout cookies are ready to ship. Your total comes to tree fiddy";
        System.out.println(n);
        assertTrue(isLockNessMonster(n));
    }

    @Test
    public void testBasicFalse() {
        String n = "Yo, I heard you were on the lookout for  Let me know if you need assistance.";
        System.out.println(n);
        assertFalse(isLockNessMonster(n));
    }

    public static boolean isLockNessMonster(String s) {
        //FIND THE LOCH NESS MONSTER. SAVE YOUR TREE FIDDY
        String regex = ".*(tree fiddy|three fifty|3.50).*";
        return s.matches(regex);
        //return false;
    }
}