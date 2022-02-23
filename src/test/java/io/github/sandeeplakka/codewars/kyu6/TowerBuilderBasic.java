package io.github.sandeeplakka.codewars.kyu6;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Build Tower

Build a pyramid-shaped tower given a positive integer number of floors.
A tower block is represented with "*" character.

For example, a tower with 3 floors looks like this:
[
  "  *  ",
  " *** ",
  "*****"
]

And a tower with 6 floors looks like this:
[
  "     *     ",
  "    ***    ",
  "   *****   ",
  "  *******  ",
  " ********* ",
  "***********"
]

Categories : Fundamentals, Strings, Basic Language Features

 */
public class TowerBuilderBasic {

    //Commented out because the local and pipeline JDK is configured as JDK8
/*    @Test
    @DisabledForJreRange(max = JRE.JAVA_8)
    public void BasicTests() {
        assertEquals(String.join(",", "*"),
                String.join(",", towerBuilder(1)));
        assertEquals(String.join(",", " * ", "***"),
                String.join(",", towerBuilder(2)));
        assertEquals(String.join(",", "  *  ", " *** ", "*****"),
                String.join(",", towerBuilder(3)));

        assertEquals(String.join(",", "*"),
                String.join(",", towerBuilderV1(1)));
        assertEquals(String.join(",", " * ", "***"),
                String.join(",", towerBuilderV1(2)));
        assertEquals(String.join(",", "  *  ", " *** ", "*****"),
                String.join(",", towerBuilderV1(3)));
    }*/

    public void BasicTests1() {
        assertEquals(String.join(",", "*"),
                String.join(",", towerBuilderV2(1)));
        assertEquals(String.join(",", " * ", "***"),
                String.join(",", towerBuilderV2(2)));
        assertEquals(String.join(",", "  *  ", " *** ", "*****"),
                String.join(",", towerBuilderV2(3)));
    }


    //JRE 11 version
    //Commented out because the local and pipeline JDK is configured as JDK8
/*    public static String[] towerBuilder(int nFloors) {
        System.out.println("floors : " + nFloors);
        int max = 2 * nFloors - 1;
        String[] tower = new String[nFloors];
        int iter = 0;
        for (int i = 1; i <= nFloors; i++) {
            int spaces = (max - (2 * i - 1)) / 2;
            if (spaces == 0) {
                tower[iter] = "*".repeat(2 * i - 1);
            } else {
                tower[iter] = " ".repeat(spaces) + "*".repeat(2 * i - 1) + " ".repeat(spaces);
            }
            iter++;
        }
        return tower;
    }*/

    //JRE 11 better version
    //Commented out because the local and pipeline JDK is configured as JDK8
/*    public static String[] towerBuilderV1(int n) {
        String[] t = new String[n];
        String e;

        //tricky code
        for (int i = 0; i < n; i++)
            t[i] = (e = " ".repeat(n - i - 1)) + "*".repeat(i + i + 1) + e;

        return t;
    }*/

    public static String[] towerBuilderV2(int nFloors) {
        String[] arr = new String[nFloors];

        int numOfCharOnEachFloor = 2 * nFloors - 1;

        for (int i = nFloors; i > 0; i--) {
            StringBuilder s = new StringBuilder("*");
            for (int j = i - 1; j > 0; j--) {
                s = new StringBuilder(String.format("*%s*", s));
            }
            while (s.length() < numOfCharOnEachFloor) {
                s = new StringBuilder(String.format(" %s ", s));
            }
            arr[i - 1] = s.toString();
        }
        return arr;
    }
}