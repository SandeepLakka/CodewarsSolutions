package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Total amount of points

Our football team finished the championship.
The result of each match look like "x:y".
Results of all matches are recorded in the collection.
For example: ["3:1", "2:2", "0:1", ...]
Write a function that takes such collection and counts the points of our team in the championship.
Rules for counting points for each match:
    if x>y - 3 points
    if x<y - 0 point
    if x=y - 1 point

Notes:
    there are 10 matches in the championship
    0 <= x <= 4
    0 <= y <= 4

Categories : Fundamentals, Algorithms, Mathematics, Numbers
 */
public class TotalPoints {
    @Test
    public void basicTestsForPoints() {
        assertEquals(30, points(new String[]
                {"1:0", "2:0", "3:0", "4:0", "2:1", "3:1", "4:1", "3:2", "4:2", "4:3"}));

        assertEquals(10, points(new String[]
                {"1:1", "2:2", "3:3", "4:4", "2:2", "3:3", "4:4", "3:3", "4:4", "4:4"}));

        assertEquals(0, points(new String[]
                {"0:1", "0:2", "0:3", "0:4", "1:2", "1:3", "1:4", "2:3", "2:4", "3:4"}));

        assertEquals(15, points(new String[]
                {"1:0", "2:0", "3:0", "4:0", "2:1", "1:3", "1:4", "2:3", "2:4", "3:4"}));

        assertEquals(12, points(new String[]
                {"1:0", "2:0", "3:0", "4:4", "2:2", "3:3", "1:4", "2:3", "2:4", "3:4"}));
    }

    @Test
    public void basicTestsForBetter() {
        assertEquals(30, better(new String[]
                {"1:0", "2:0", "3:0", "4:0", "2:1", "3:1", "4:1", "3:2", "4:2", "4:3"}));

        assertEquals(10, better(new String[]
                {"1:1", "2:2", "3:3", "4:4", "2:2", "3:3", "4:4", "3:3", "4:4", "4:4"}));

        assertEquals(0, better(new String[]
                {"0:1", "0:2", "0:3", "0:4", "1:2", "1:3", "1:4", "2:3", "2:4", "3:4"}));

        assertEquals(15, better(new String[]
                {"1:0", "2:0", "3:0", "4:0", "2:1", "1:3", "1:4", "2:3", "2:4", "3:4"}));

        assertEquals(12, better(new String[]
                {"1:0", "2:0", "3:0", "4:4", "2:2", "3:3", "1:4", "2:3", "2:4", "3:4"}));
    }


    public static int points(String[] games) {
        return Arrays.stream(games).map(s -> s.split(":")).map(strings -> {
            int x = Integer.parseInt(strings[0]);
            int y = Integer.parseInt(strings[1]);
            return (x > y) ? 3 : ((x < y) ? 0 : 1);
        }).mapToInt(Integer::intValue).sum();
    }

    //This is better than above as it has lesser intermediate operations
    public static int better(String[] games) {
        return Arrays.stream(games)
                .mapToInt(value -> value.charAt(0) - value.charAt(2))
                .map(result -> result > 0 ? 3 : result == 0 ? 1 : 0)
                .sum();
    }
}