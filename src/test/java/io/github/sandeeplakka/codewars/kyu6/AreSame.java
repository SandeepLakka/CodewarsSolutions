package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Description:

Given two arrays a and b write a function comp(a, b) that
checks whether the two arrays have the "same" elements,
with the same multiplicities (the multiplicity of a member is the number of times it appears).
"Same" means, here, that the elements in b are the elements in a squared, regardless of the order.

Examples

Valid arrays

a = [121, 144, 19, 161, 19, 144, 19, 11]
b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]

comp(a, b) returns true because in b 121 is the square of 11,
14641 is the square of 121, 20736 the square of 144,
361 the square of 19, 25921 the square of 161, and so on.
It gets obvious if we write b's elements in terms of squares:

a = [121, 144, 19, 161, 19, 144, 19, 11]
b = [11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19]

Invalid arrays

If, for example, we change the first number to something else, comp is not returning true anymore:

a = [121, 144, 19, 161, 19, 144, 19, 11]
b = [132, 14641, 20736, 361, 25921, 361, 20736, 361]

comp(a,b) returns false because in b 132 is not the square of any number of a.

a = [121, 144, 19, 161, 19, 144, 19, 11]
b = [121, 14641, 20736, 36100, 25921, 361, 20736, 361]

comp(a,b) returns false because in b 36100 is not the square of any number of a.

Remarks : a or b might be [] pr null.

Categories : Fundamentals
 */
public class AreSame {

    @Test
    public void tests() {
        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
        assertEquals(true, comp(a, b));

        a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        b = new int[]{11 * 11, 121 * 121, 144 * 144, 190 * 190, 161 * 161, 19 * 19, 144 * 144, 19 * 19};
        assertEquals(false, comp(a, b));

        a = new int[]{};
        b = new int[]{1};
        assertEquals(false, comp(a, b));

        a = new int[]{};
        b = new int[]{};
        assertEquals(true, comp(a, b));

        a = new int[]{};
        b = null;
        assertEquals(false, comp(a, b));

        a = new int[]{121, 144, 19, 161, 19, 144, 19, 11, 1008};
        b = new int[]{11 * 11, 121 * 121, 144 * 144, 190 * 190, 161 * 161, 19 * 19, 144 * 144, 19 * 19};
        assertEquals(false, comp(a, b));

        a = new int[]{121, 1440, 191, 161, 19, 144, 195, 11};
        b = new int[]{11 * 11, 121 * 121, 1440 * 1440, 191 * 191, 161 * 161, 19 * 19, 144 * 144, 195 * 195};
        assertEquals(true, comp(a, b));

        a = new int[]{3, 4};
        b = new int[]{0, 25};
        assertEquals(false, comp(a, b));

        a = new int[]{4, 4};
        b = new int[]{1, 31};
        assertEquals(false, comp(a, b));

    }

    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null) return false;
        if (a.length == 0 && b.length == 0) return true;
        if (a.length == 0 || b.length == 0) return false;
        //Bad practice to mutate inputs
        //Arrays.sort(a);
        //Arrays.sort(b);
        int[] aa = Arrays.stream(a).sorted().toArray();
        int[] bb = Arrays.stream(b).sorted().toArray();

        int i = 0;
        while (i < aa.length) {
            if (aa[i] * aa[i] != bb[i]) return false;
            i++;
        }
        return true;
    }
}