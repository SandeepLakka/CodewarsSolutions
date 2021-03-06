package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Beginner Series #1 School Paperwork

Your classmates asked you to copy some paperwork for them.
You know that there are 'n' classmates and the paperwork has 'm' pages.

Your task is to calculate how many blank pages do you need.
If n < 0 or m < 0 return 0.

Example:
n= 5, m=5: 25
n=-5, m=5:  0

Categories : Fundamentals
 */
public class Paper {

    @Test
    public void test1() {
        assertEquals(25, paperWork(5, 5), "Failed at paperWork(5,5)");
        assertEquals(25, paperWorkV1(5, 5), "Failed at paperWork(5,5)");
    }


    @Test
    public void test2() {
        assertEquals(0, paperWork(5, -5), "Failed at paperWork(5,-5)");
        assertEquals(0, paperWorkV1(5, -5), "Failed at paperWork(5,-5)");
    }

    @Test
    public void test3() {
        assertEquals(0, paperWork(-5, -5), "Failed at paperWork(-5,-5)");
        assertEquals(0, paperWorkV1(-5, -5), "Failed at paperWork(-5,-5)");
    }

    @Test
    public void test4() {
        assertEquals(0, paperWork(-5, 5), "Failed at paperWork(-5,5)");
        assertEquals(0, paperWorkV1(-5, 5), "Failed at paperWork(-5,5)");
    }

    @Test
    public void test5() {
        assertEquals(0, paperWork(5, 0), "Failed at paperWork(5,0)");
        assertEquals(0, paperWorkV1(5, 0), "Failed at paperWork(5,0)");
    }

    @Test
    public void test6() {
        assertEquals(0, paperWork(5, -5), "Failed at paperWork(5,-5)");
        assertEquals(0, paperWorkV1(5, -5), "Failed at paperWork(5,-5)");
    }

    //need to learn the bit masking technique for this
    //update: please check below paperworkV1 method for bit manipulated solution
    public static int paperWork(int n, int m) {
        return (n < 0 || m < 0) ? 0 : n * m;
    }

    // n>>31 will give -1 for negatives, 0 for non negatives ( 0 and all numbers forward )
    public static int paperWorkV1(int n, int m) {
        return (n >> 31) == -1 || (m >> 31) == -1 ? 0 : n * m;
    }
}