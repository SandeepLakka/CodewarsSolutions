package io.github.sandeeplakka.codewars.kyu7;

/*
The Office I - Outed

Your colleagues have been looking over you shoulder.
When you should have been doing your boring real job,
you've been using the work computers to smash in endless hours of codewars.

In a team meeting, a terrible, awful person declares to the group that you aren't working.
You're in trouble. You quickly have to gauge the feeling in the room
to decide whether you should gather your things and leave.

Given a Person array (meet) containing team members,
you need to assess the overall happiness rating of the group. If <= 5, return "Get Out Now!".
Else return "Nice Work Champ!".

The Person class looks like:

class Person {
  final String name;    // team member's name
  final int happiness;  // happiness rating out of 10
}

Happiness rating will be total score / number of people in the room.

Note that your boss is in the room (boss), their score is worth double it's face value
(but they are still just one person!).

Other Kata's:
The Office II - Boredom Score
The Office III - Broken Photocopier
The Office IV - Find a Meeting Room
The Office V - Find a Chair

Categories : Fundamentals, Arrays, Functions, Control Flow, Basic Language Features, Objects, Numbers
 */

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheOfficePart1 {
    final static public String GET_OUT_NOW = "Get Out Now!";
    final static public String GOODWORK = "Nice Work Champ!";

    @Test
    public void basic1() {
        Person[] meet = new Person[]{
                new Person("tim", 0),
                new Person("jim", 2),
                new Person("randy", 0),
                new Person("sandy", 7),
                new Person("andy", 0),
                new Person("katie", 5),
                new Person("laura", 1),
                new Person("saajid", 2),
                new Person("alex", 3),
                new Person("john", 2),
                new Person("mr", 0)
        };
        assertEquals("Get Out Now!", outed(meet, "laura"));
    }

    @Test
    public void basic2() {
        Person[] meet = new Person[]{
                new Person("tim", 1),
                new Person("jim", 3),
                new Person("randy", 9),
                new Person("sandy", 6),
                new Person("andy", 7),
                new Person("katie", 6),
                new Person("laura", 9),
                new Person("saajid", 9),
                new Person("alex", 9),
                new Person("john", 9),
                new Person("mr", 8)
        };
        assertEquals("Nice Work Champ!", outed(meet, "katie"));
    }

    @Test
    public void basic3() {
        Person[] meet = new Person[]{
                new Person("tim", 2),
                new Person("jim", 4),
                new Person("randy", 0),
                new Person("sandy", 5),
                new Person("andy", 8),
                new Person("katie", 6),
                new Person("laura", 2),
                new Person("saajid", 2),
                new Person("alex", 3),
                new Person("john", 2),
                new Person("mr", 8),
        };
        assertEquals("Get Out Now!", outed(meet, "john"));
    }

    public static String outed(Person[] meet, String boss) {
        return Arrays.stream(meet)
                .mapToInt(member -> member.getName().equals(boss) ? 2 * member.getHappiness() : member.getHappiness())
                .average().orElse(0) > 5 ? GOODWORK : GET_OUT_NOW;
    }

    class Person {
        String name;    // team member's name
        int happiness;  // happiness rating out of 10

        public Person(String name, int happiness) {
            this.name = name;
            this.happiness = happiness;
        }

        public String getName() {
            return name;
        }

        public int getHappiness() {
            return happiness;
        }
    }
}

