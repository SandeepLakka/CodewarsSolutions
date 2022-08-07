package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
A Strange Trip to the Market

You're on your way to the market when you hear beautiful music coming from a nearby street performer.
The notes come together like you wouln't believe as the musician puts together patterns of tunes.
As you wonder what kind of algorithm you could use to shift octaves by 8 pitches or something silly like that,
it dawns on you that you have been watching the musician for some 10 odd minutes.
You ask, "how much do people normally tip for something like this?"
The artist looks up. "It's always gonna be about tree fiddy."

It was then that you realize the musician was a 400 foot tall beast from the paleolithic era!
The Loch Ness Monster almost tricked you!

There are only 2 guaranteed ways to tell if you are speaking to The Loch Ness Monster:
A) it is a 400 foot tall beast from the paleolithic era;
B) it will ask you for tree fiddy.

Since Nessie is a master of disguise,
the only way accurately tell is to look for the phrase "tree fiddy".
Since you are tired of being grifted by this monster,
the time has come to code a solution for finding The Loch Ness Monster.
Note that the phrase can also be written as "3.50" or "three fifty".

Categories : Regular Expressions, Strings, Fundamentals
 */
public class Nessie {

    @Test
    public void testBasicTrue() {
        String n = "Your girlscout cookies are ready to ship. Your total comes to tree fiddy";
        System.out.println(n);
        assertTrue(isLockNessMonster(n));
    }

    @Test
    public void testBasic2True() {
        String n = "Howdy Pardner. Name's Pete Lexington. I reckon you're the kinda stiff who carries about tree fiddy?";
        System.out.println(n);
        assertTrue(isLockNessMonster(n));
    }

    @Test
    public void testDifficultTrue() {
        String n = "I'm from Scottland. I moved here to be with my family sir. Please, $3.50 would go a long way to help me find them";
        System.out.println(n);
        assertTrue(isLockNessMonster(n));
    }

    @Test
    public void testVeryDifficultFalse() {
        String n = "Hello there! I just learned additions, Do you know that when we add 100 to 3250, it becomes 3350 ?";
        System.out.println(n);
        assertFalse(isLockNessMonster(n));
    }

    @Test
    public void testBasicFalse() {
        String n = "Yo, I heard you were on the lookout for  Let me know if you need assistance.";
        System.out.println(n);
        assertFalse(isLockNessMonster(n));
    }

    @Test
    public void testHarderFalse() {
        String n = "I will absolutely, positively, never give that darn Lock Ness Monster any of my three dollars and fifty cents";
        System.out.println(n);
        assertFalse(isLockNessMonster(n));
    }

    @Test
    public void testHardestFalse() {
        String n = "Did I ever tell you about my run with that paleolithic beast? He tried all sorts of ways to get at my three dolla and fitty cent? I told him 'this is MY 4 dolla!'. He just wouldn't listen. ";
        System.out.println(n);
        assertFalse(isLockNessMonster(n));
    }

    public static boolean isLockNessMonster(String s) {
        //FIND THE LOCH NESS MONSTER. SAVE YOUR TREE FIDDY
        String regex = ".*(tree fiddy|three fifty|3\\.50).*";
        return s.matches(regex);
        //return false;
    }
}