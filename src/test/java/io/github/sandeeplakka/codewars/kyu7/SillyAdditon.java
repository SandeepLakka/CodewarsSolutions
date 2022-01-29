package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

 In simple terms, our method does not like the principle of carrying over numbers
  and just writes down every number it calculates :-)

 You may assume both integers are positive integers.

 Examples

 12 + 3 -> 15
 12 + 13 -> 25
 145 + 179 -> 21114


 You may assume both integers are positive integers
 and the result will not be bigger than Integer.MAX_VALUE

 Categories : Algorithms, Arithmetic, Mathematics, Numbers

 */

public class SillyAdditon {

    @Test
    @DisplayName("Real Addition")
    public void RealAddition() {
        assertEquals(13, add(2, 11));
        assertEquals(1, add(0, 1));
        assertEquals(0, add(0, 0));

        assertEquals(13, addV1(2, 11));
        assertEquals(1, addV1(0, 1));
        assertEquals(0, addV1(0, 0));
    }


    @Test
    @DisplayName("Silly additions")
    public void sillyAdditon() {
        assertEquals(214, add(16, 18));
        assertEquals(515, add(26, 39));
        assertEquals(1103, add(122, 81));
        assertEquals(3100, add(150, 250));
        assertEquals(21114, add(145, 179));
        assertEquals(31000, add(1500, 2500));

        assertEquals(214, addV1(16, 18));
        assertEquals(515, addV1(26, 39));
        assertEquals(1103, addV1(122, 81));
        assertEquals(3100, addV1(150, 250));
        assertEquals(31000, addV1(1500, 2500));
    }

    @Test
    @DisplayName("Silly Big Additions")
    public void SillyBigAdditon() {
        assertEquals(31499, add(1222, 30277));
        assertEquals(31111013, add(1236, 30977));
        assertEquals(391193, add(38810, 1383));
    }

    public int add(int a, int b) {
        Stack<String> stack = new Stack<>();
        while (a > 0 && b > 0) {
            stack.add(String.valueOf(a % 10 + b % 10));
            a /= 10;
            b /= 10;
        }
        while (a > 0) {
            stack.add(String.valueOf(a % 10));
            a /= 10;
        }
        while (b > 0) {
            stack.add(String.valueOf(b % 10));
            b /= 10;
        }

        StringBuilder res = new StringBuilder();

        if (stack.isEmpty()) return 0;

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return Integer.parseInt(res.toString());
    }

    public static int addV1(int x, int y) {
        int res = 0, m = 1;
        while (x != 0 || y != 0) {
            int s = x % 10 + y % 10;
            res += s * m;
            m *= s < 10 ? 10 : 100;
            x /= 10;
            y /= 10;
        }
        return res;
    }
}