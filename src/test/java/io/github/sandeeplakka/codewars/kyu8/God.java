package io.github.sandeeplakka.codewars.kyu8;

/*
Basic subclasses - Adam and Eve

According to the creation myths of the Abrahamic religions,
Adam and Eve were the first Humans to wander the Earth.

You have to do God's job.
The creation method must return an array of length 2 containing objects
(representing Adam and Eve). The first object in the array should be an instance of the class Man.
The second should be an instance of the class Woman.
Both objects have to be subclasses of Human. Your job is to implement the Human, Man and Woman classes.

Categories : Fundamentals
 */


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class God {

    @Test
    public void makingAdam() {
        Human[] paradise = God.create();
        assertTrue(paradise[0] instanceof Man, "Adam is a man");
    }

    @Test
    public void makingEva() {
        Human[] paradise = God.create();
        assertTrue(paradise[1] instanceof Woman, "Eva is a woman");
    }

    @Test
    public void adamAreHuman() {
        Human[] paradise = God.create();
        assertTrue(paradise[0] != null && paradise[0] instanceof Human, "Adam is of human race");
    }

    @Test
    public void evaAreHuman() {
        Human[] paradise = God.create();
        assertTrue(paradise[1] != null && paradise[1] instanceof Human, "Eva is of human race");
    }

    @Test
    public void listHaveRightLenght() {
        Human[] paradise = God.create();
        assertEquals(2, paradise.length, "It`s only two two persons on earth");
    }

    public static Human[] create() {
        //code
        return new Human[]{new Man(), new Woman()};
    }

}

//code
interface Human {

}

class Man implements Human {

}

class Woman implements Human {

}