package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
The Office II - Boredom Score

Every now and then people in the office moves teams or departments.
Depending what people are doing with their time they can become more or less boring.
Time to assess the current team.

You will be provided with an array of Person objects with each
instance containing the name and department for a staff member.

public class Person {
  public final String name;        // name of the staff member
  public final String department;  // department they work in
}

Each department has a different boredom assessment score, as follows:

accounts = 1
finance = 2
canteen = 10
regulation = 3
trading = 6
change = 6
IS = 8
retail = 5
cleaning = 4
pissing about = 25

Depending on the cumulative score of the team, return the appropriate sentiment:

<=80: 'kill me now'
< 100 & > 80: 'i can handle this'
100 or over: 'party time!!'

Other Kata's:
The Office I - Outed
The Office III - Broken Photocopier
The Office IV - Find a Meeting Room
The Office V - Find a Chair

Categories : Fundamentals, Objects, Arrays
 */
public class TheOfficePart2 {
    private static final String KILL_ME_NOW = "kill me now";
    private static final String CAN_HANDLE = "i can handle this";
    private static final String PARTY_TIME = "party time!!";

    private Map<String, Integer> map = new HashMap<>();

    {
        loadMap();
    }


    private void loadMap() {
        map.put("accounts", 1);
        map.put("finance", 2);
        map.put("canteen", 10);
        map.put("regulation", 3);
        map.put("trading", 6);
        map.put("change", 6);
        map.put("IS", 8);
        map.put("retail", 5);
        map.put("cleaning", 4);
        map.put("pissing about", 25);
    }


    @Test
    public void basic1() {
        Person[] staff = {
                new Person("tim", "change"),
                new Person("jim", "accounts"),
                new Person("randy", "canteen"),
                new Person("sandy", "change"),
                new Person("andy", "change"),
                new Person("katie", "IS"),
                new Person("laura", "change"),
                new Person("saajid", "IS"),
                new Person("alex", "trading"),
                new Person("john", "accounts"),
                new Person("mr", "finance")
        };
        assertEquals("kill me now", boredom(staff));
        assertEquals("kill me now", boredomClever(staff));
    }

    @Test
    public void basic2() {
        Person[] staff = {
                new Person("tim", "IS"),
                new Person("jim", "finance"),
                new Person("randy", "pissing about"),
                new Person("sandy", "cleaning"),
                new Person("andy", "cleaning"),
                new Person("katie", "cleaning"),
                new Person("laura", "pissing about"),
                new Person("saajid", "regulation"),
                new Person("alex", "regulation"),
                new Person("john", "accounts"),
                new Person("mr", "canteen")
        };
        assertEquals("i can handle this", boredom(staff));
        assertEquals("i can handle this", boredomClever(staff));
    }

    @Test
    public void basic3() {

        Person[] staff = {
                new Person("tim", "accounts"),
                new Person("jim", "accounts"),
                new Person("randy", "pissing about"),
                new Person("sandy", "finance"),
                new Person("andy", "change"),
                new Person("katie", "IS"),
                new Person("laura", "IS"),
                new Person("saajid", "canteen"),
                new Person("alex", "pissing about"),
                new Person("john", "retail"),
                new Person("mr", "pissing about")
        };
        assertEquals("party time!!", boredom(staff));
        assertEquals("party time!!", boredomClever(staff));
    }

    public String boredom(Person[] staff) {
        long sum = Arrays.stream(staff)
                .mapToInt(value -> map.getOrDefault(value.getDepartment(), 0))
                .sum();
        return sum <= 80 ? KILL_ME_NOW : sum < 100 ? CAN_HANDLE : PARTY_TIME;
    }


    public static String boredomClever(Person[] staff) {
        return java.util.Optional.of(staff)
                .map(o -> java.util.Arrays.stream(staff)
                        .map(s -> s.department)
                        .mapToInt(d -> "JHYAB  EDFFC".charAt((d.charAt(0) * 4 + d.charAt(1) * 5 + d.length()) % 12) - '@')
                        //.peek(System.out::println)
                        .sum())
                .map(x -> x > 99 ? PARTY_TIME : x > 80 ? CAN_HANDLE : KILL_ME_NOW)
                .get();
    }

    class Person {
        String name;    // team member's name
        String department;  // department they work in

        public Person(String name, String department) {
            this.name = name;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }
    }
}