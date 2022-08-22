package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
Separate The Wheat From The Chaff

Scenario

With Cereal crops like wheat or rice, before we can eat the grain kernel,
we need to remove that inedible hull, or to separate the wheat from the chaff.

Task
Given a sequence of n integers , separate the negative numbers (chaff) from positive ones (wheat). !alt

Notes
    Sequence size is at least 3
    Return a new sequence, such that negative numbers (chaff) come first, then positive ones (wheat).
    In Java , you're not allowed to modify the input Array/list/Vector
    Have no fear , it is guaranteed that there will be no zeroes . !alt
    Repetition of numbers in the input sequence could occur , so duplications are included when separating.
    If a misplaced positive number is found in the front part of the sequence, replace it with the last misplaced negative number (the one found near the end of the input). The second misplaced positive number should be swapped with the second last misplaced negative number. Negative numbers found at the head (begining) of the sequence , should be kept in place .

Input >> Output Examples:

wheatFromChaff ({7, -8, 1 ,-2}) ==> return ({-2, -8, 1, 7})
Explanation:
    Since 7 is a positive number , it should not be located at the beginning
    so it needs to be swapped with the last negative number -2.

wheatFromChaff ({-31, -5, 11 , -42, -22, -46, -4, -28 }) ==> return ({-31, -5,- 28, -42, -22, -46 , -4, 11})
Explanation:
    Since, {-31, -5} are negative numbers found at the head (beginning) of the sequence , so we keep them in place .
    Since 11 is a positive number, it's replaced by the last negative which is -28 , and so on till separation is complete.


wheatFromChaff ({-25, -48, -29, -25, 1, 49, -32, -19, -46, 1}) ==> return ({-25, -48, -29, -25, -46, -19, -32, 49, 1, 1})
Explanation:
    Since {-25, -48, -29, -25} are negative numbers found at the head (beginning) of the input , so we keep them in place .
    Since 1 is a positive number, it's replaced by the last negative which is -46 , and so on till separation is complete.
    Remember, duplications are included when separating , that's why the number 1 appeared twice at the end of the output.

Tune Your Code , There are 250 Assertions , 100.000 element For Each .
Only O(N) Complexity Solutions Will pass .

Categories : Fundamentals, Arrays, Performance
 */
public class WheatAndChaffSeperator {

    @Test
    public void checkShortLengthVectors() {

        assertArrayEquals(new long[]{-6, -4, 6, 2},
                wheatFromChaff(new long[]{2, -4, 6, -6}));
        assertArrayEquals(new long[]{-10, -3, 7},
                wheatFromChaff(new long[]{7, -3, -10}));
        assertArrayEquals(new long[]{-2, -8, 1, 7},
                wheatFromChaff(new long[]{7, -8, 1, -2}));
        assertArrayEquals(new long[]{-7, -6, 10, 8, 9},
                wheatFromChaff(new long[]{8, 10, -6, -7, 9}));
        assertArrayEquals(new long[]{-3, -6, -10, 2, 4},
                wheatFromChaff(new long[]{-3, 4, -10, 2, -6}));
        assertArrayEquals(new long[]{-2, -6, -4, -8, 1, 2},
                wheatFromChaff(new long[]{2, -6, -4, 1, -8, -2}));
    }

    @Test
    public void checkMediumLengthVectors() {

        assertArrayEquals(new long[]{-2, -37, -48, -47, 25, 41, 16},
                wheatFromChaff(new long[]{16, 25, -48, -47, -37, 41, -2}));
        assertArrayEquals(new long[]{-30, -11, -50, -5, 34, 38, 36},
                wheatFromChaff(new long[]{-30, -11, 36, 38, 34, -5, -50}));
        assertArrayEquals(new long[]{-31, -5, -28, -42, -22, -46, -4, 11},
                wheatFromChaff(new long[]{-31, -5, 11, -42, -22, -46, -4, -28}));
        assertArrayEquals(new long[]{-32, -17, -45, -2, -5, -6, 39, 46, 17},
                wheatFromChaff(new long[]{46, 39, -45, -2, -5, -6, -17, -32, 17}));
        assertArrayEquals(new long[]{-9, -8, -6, -46, -19, 1, 44},
                wheatFromChaff(new long[]{-9, -8, -6, -46, 1, -19, 44}));
        assertArrayEquals(new long[]{-37, -10, -42, -45, -31, -40, 19, 33},
                wheatFromChaff(new long[]{-37, -10, -42, 19, -31, -40, -45, 33}));
        assertArrayEquals(new long[]{-25, -48, -29, -25, -46, -19, -32, 49, 1, 1},
                wheatFromChaff(new long[]{-25, -48, -29, -25, 1, 49, -32, -19, -46, 1}));
    }

    @Test
    public void checkLengthyVectors() {
        assertArrayEquals(new long[]{-7, -35, -46, -22, -26, -5, -44, -14, 34, 43, 46},
                wheatFromChaff(new long[]{-7, -35, -46, -22, 46, 43, -44, -14, 34, -5, -26}));
        assertArrayEquals(new long[]{-46, -50, -28, -45, -27, -40, -24, -46, 34, 47, 35, 10},
                wheatFromChaff(new long[]{-46, -50, -28, -45, -27, -40, 10, 35, 34, 47, -46, -24}));
        assertArrayEquals(new long[]{-33, -14, -19, -45, -12, -21, -10, -3, 41, 4, 31, 41, 16},
                wheatFromChaff(new long[]{-33, -14, 16, 31, 4, 41, -10, -3, -21, -12, -45, 41, -19}));
        assertArrayEquals(new long[]{-17, -45, -12, -29, -24, -8, -19, 4, 40, 31, 10, 21, 7, 1},
                wheatFromChaff(new long[]{-17, 7, -12, 10, 4, -8, -19, -24, 40, 31, -29, 21, -45, 1}));
        assertArrayEquals(new long[]{-16, -27, -7, -31, -34, -43, -44, -18, -24, -46, 39, 50, 3, 9, 44},
                wheatFromChaff(new long[]{-16, 44, -7, -31, 9, -43, -44, -18, 50, 39, -46, -24, 3, -34, -27}));
    }

    @Test
    public void checkEdgeNegatives() {

        assertArrayEquals(new long[]{-22, -20, -32},
                wheatFromChaff(new long[]{-22, -20, -32}));
        assertArrayEquals(new long[]{-46, -3, -15, -5},
                wheatFromChaff(new long[]{-46, -3, -15, -5}));
        assertArrayEquals(new long[]{-46, -17, -48, -5, -21},
                wheatFromChaff(new long[]{-46, -17, -48, -5, -21}));
        assertArrayEquals(new long[]{-38, -46, -19, -50, -3, -6},
                wheatFromChaff(new long[]{-38, -46, -19, -50, -3, -6}));
        assertArrayEquals(new long[]{-43, -39, -3, -48, -26, -8, -11},
                wheatFromChaff(new long[]{-43, -39, -3, -48, -26, -8, -11}));
        assertArrayEquals(new long[]{-16, -3, -26, -33, -3, -31, -6, -14},
                wheatFromChaff(new long[]{-16, -3, -26, -33, -3, -31, -6, -14}));
        assertArrayEquals(new long[]{-45, -40, -22, -4, -39, -50, -20, -20},
                wheatFromChaff(new long[]{-45, -40, -22, -4, -39, -50, -20, -20}));
        assertArrayEquals(new long[]{-47, -10, -21, -16, -9, -10, -12, -35, -12, -44},
                wheatFromChaff(new long[]{-47, -10, -21, -16, -9, -10, -12, -35, -12, -44}));
        assertArrayEquals(new long[]{-14, -5, -10, -39, -15, -12, -50, -3, -34, -15, -48},
                wheatFromChaff(new long[]{-14, -5, -10, -39, -15, -12, -50, -3, -34, -15, -48}));
        assertArrayEquals(new long[]{-20, -30, -26, -14, -15, -30, -44, -38, -35, -38, -10, -44},
                wheatFromChaff(new long[]{-20, -30, -26, -14, -15, -30, -44, -38, -35, -38, -10, -44}));
        assertArrayEquals(new long[]{-15, -45, -23, -2, -35, -37, -24, -13, -19, -6, -26, -11, -34},
                wheatFromChaff(new long[]{-15, -45, -23, -2, -35, -37, -24, -13, -19, -6, -26, -11, -34}));
    }

    @Test
    public void checkEdgePositives() {

        assertArrayEquals(new long[]{9, 9, 20},
                wheatFromChaff(new long[]{9, 9, 20}));
        assertArrayEquals(new long[]{34, 17, 37, 45},
                wheatFromChaff(new long[]{34, 17, 37, 45}));
        assertArrayEquals(new long[]{18, 9, 27, 45, 35},
                wheatFromChaff(new long[]{18, 9, 27, 45, 35}));
        assertArrayEquals(new long[]{3, 6, 24, 46, 42, 18},
                wheatFromChaff(new long[]{3, 6, 24, 46, 42, 18}));
        assertArrayEquals(new long[]{22, 43, 50, 38, 33, 1, 36},
                wheatFromChaff(new long[]{22, 43, 50, 38, 33, 1, 36}));
        assertArrayEquals(new long[]{2, 34, 48, 19, 20, 16, 5, 45},
                wheatFromChaff(new long[]{2, 34, 48, 19, 20, 16, 5, 45}));
        assertArrayEquals(new long[]{50, 16, 39, 11, 16, 50, 6, 36, 25},
                wheatFromChaff(new long[]{50, 16, 39, 11, 16, 50, 6, 36, 25}));
        assertArrayEquals(new long[]{21, 22, 9, 3, 7, 26, 13, 26, 25, 15},
                wheatFromChaff(new long[]{21, 22, 9, 3, 7, 26, 13, 26, 25, 15}));
        assertArrayEquals(new long[]{31, 22, 24, 25, 17, 12, 11, 14, 38, 15, 22},
                wheatFromChaff(new long[]{31, 22, 24, 25, 17, 12, 11, 14, 38, 15, 22}));
        assertArrayEquals(new long[]{24, 4, 48, 15, 25, 5, 5, 10, 32, 37, 37, 11},
                wheatFromChaff(new long[]{24, 4, 48, 15, 25, 5, 5, 10, 32, 37, 37, 11}));
        assertArrayEquals(new long[]{49, 10, 5, 40, 26, 17, 25, 24, 30, 34, 13, 36, 21},
                wheatFromChaff(new long[]{49, 10, 5, 40, 26, 17, 25, 24, 30, 34, 13, 36, 21}));
        assertArrayEquals(new long[]{28, 44, 44, 41, 24, 50, 28, 27, 50, 1, 25, 34, 11, 45},
                wheatFromChaff(new long[]{28, 44, 44, 41, 24, 50, 28, 27, 50, 1, 25, 34, 11, 45}));
    }

    public static long[] wheatFromChaff(long[] values) {
        int left = 0;
        int right = values.length - 1;
        long[] result = Arrays.copyOf(values, values.length);
        int counter = 0;
        while (left < right) {
            while (left < result.length && result[left] < 0) left++;
            while (right > 0 && result[right] >= 0) right--;
            if (left < right) {
                long temp = result[left];
                result[left] = result[right];
                result[right] = temp;
            }
            if (left >= result.length || right <= 0) break;
        }
        return result;
    }

}
