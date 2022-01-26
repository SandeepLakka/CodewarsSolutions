package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Description:

Create a function that gives a personalized greeting. This function takes two parameters: name and owner.

Use conditionals to return the proper message:

case --> return
name equals owner --> 'Hello boss'
otherwise --> 'Hello guest'

Categories : Fundamentals, Conditional Statements
Control Flow, Basic Language Features
 */
class GrassHopperPersonalizedMessage {
    @Test
    public void basicTests() {
        assertEquals("Hello boss",
                greet("Daniel", "Daniel"),
                "For inputs \"Daniel\" and \"Daniel\"");
        assertEquals("Hello guest",
                greet("Greg", "Daniel"),
                "For inputs \"Greg\" and \"Daniel\"");
    }

    static String greet(String name, String owner) {
        return (name.equals(owner) ? "Hello boss" : "Hello guest");
    }
}