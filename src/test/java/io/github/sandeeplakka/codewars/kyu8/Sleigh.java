package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
Sleigh Authentication



Christmas is coming and many people dreamed of having a ride with Santa's sleigh.
But, of course, only Santa himself is allowed to use this wonderful transportation.
And in order to make sure, that only he can board the sleigh,
there's an authentication mechanism.

Your task is to implement the authenticate() method of the sleigh,
which takes the name of the person, who wants to board the sleigh and a secret password.
If, and only if, the name equals "Santa Claus" and the password is "Ho Ho Ho!"
(yes, even Santa has a secret password with uppercase and lowercase letters
and special characters :D), the return value must be true. Otherwise it should return false.

Examples:

sleigh.authenticate("Santa Claus", "Ho Ho Ho!") # must return True
sleigh.authenticate("Santa', 'Ho Ho Ho!") # must return False
sleigh.authenticate("Santa Claus", "Ho Ho!") # must return False
sleigh.authenticate("jhoffner", "CodeWars") # Nope, even Jak

Categories : Fundamentals

 */
public class Sleigh {

    @Test
    public void test_authentication() {
        assertTrue(authenticate("Santa Claus", "Ho Ho Ho!"));
        assertFalse(authenticate("Santa", "Ho Ho Ho!"));
        assertFalse(authenticate("Santa Claus", "Ho Ho Ho"));
    }

    @Test
    public void test_authentication2() {
        assertFalse(authenticate(" Santa Claus ", "Ho Ho Ho!"));
        assertFalse(authenticate("SantaClaus", "Ho Ho Ho!"));
        assertFalse(authenticate("Santa", "Ho Ho Ho!"));
        assertFalse(authenticate("Santa Claus", "Ho Ho Ho"));
        assertFalse(authenticate("Santa Claus", "Ho Ho Ho !"));
        assertFalse(authenticate("Santa Claus", " Ho Ho Ho! "));
    }

    public static Boolean authenticate(String name, String password) {
        if (name == null || password == null || name.isEmpty() || password.isEmpty()) {
            return false;
        }
        return name.equals("Santa Claus") && password.equals("Ho Ho Ho!");
    }
}