package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Your task is to construct a building which will be a pile of n cubes.
The cube at the bottom will have a volume of n^3,
the cube above will have volume of (n-1)^3 and so on until the top which will have a volume of 1^3.

You are given the total volume m of the building.
Being given m can you find the number n of cubes you will have to build?

The parameter of the function findNb will be an integer m, and
you have to return the integer n such as n^3 + (n-1)^3 + ... + 1^3 = m
if such an n exists or -1 if there is no such n.

Examples:

findNb(1071225) --> 45
findNb(91716553919377) --> -1

Categories : Fundamentals, Optimization
 */
public class ASum {

    @Test
    public void tests_findNumberSimply() {
        assertEquals(45, findNumberSimply(1071225l));
        assertEquals(-1, findNumberSimply(91716553919377l));
        assertEquals(2022, findNumberSimply(4183059834009L));
        assertEquals(-1, findNumberSimply(24723578342962L));
        assertEquals(55100, findNumberSimply(2304422822859502500L));
    }

    @Test
    public void tests_findNumber() {
        assertEquals(45, findNumber(1071225l));
        assertEquals(-1, findNumber(91716553919377l));
        assertEquals(2022, findNumber(4183059834009L));
        assertEquals(-1, findNumber(24723578342962L));
        assertEquals(55100, findNumber(2304422822859502500L));


    }

    /* Reasoning:
     * Sum of cubes of first N natural numbers is (n(n+1)/2)^2
     * If we see our input number m equals to that equation
     * (n(n+1)/2)^2 = m
     * n(n+1)/2 = sqrt(m)
     * n^2+n = 2sqrt(m)
     * n^2 + n -2sqrt(m) = 0
     * Finding a positive root of the above quadratic equation
     * we get n = (sqrt(1+8sqrt(m))-1)/2
     */

    public long findNumberSimply(long m) {
        long left = 0, right = m;
        long mid = (left + right) >> 1;
        while (left <= right) {
            double pow = Math.pow(mid * (mid + 1) / 2, 2);
            if (pow == m) return mid;
            if (pow > m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (left + right) >> 1;
        }
        return -1;
    }

    //Overcomplicated implementation :)
    public long findNumber(long m) {
        //return -1;
        BigInteger val = findSqrt(findSqrt(BigInteger.valueOf(m))
                .multiply(BigInteger.valueOf(8))
                .add(BigInteger.ONE))
                .subtract(BigInteger.ONE).divide(BigInteger.valueOf(2));
        System.out.println("val is " + val);
        return val.longValue();
    }

    @Test
    public void testFindSqrt() {
        assertEquals(BigInteger.ONE, findSqrt(BigInteger.ONE));
        assertEquals(BigInteger.valueOf(10), findSqrt(BigInteger.TEN.multiply(BigInteger.TEN)));
        assertEquals(BigInteger.valueOf(2045253), findSqrt(BigInteger.valueOf(4183059834009l)));
        assertEquals(BigInteger.valueOf(11637900), findSqrt(BigInteger.valueOf(135440716410000l)));
        assertEquals(BigInteger.valueOf(6367096), findSqrt(BigInteger.valueOf(40539911473216l)));
    }


    //Helper
    private BigInteger findSqrt(BigInteger number) {
        BigInteger mid = number.shiftRight(1);
        BigInteger left = BigInteger.ZERO, right = number;
        if (number.equals(BigInteger.ONE)) return BigInteger.ONE;
        int noOfSteps = 1;
        BigInteger ans = null;
        while (left.compareTo(right) <= 0) {
            //System.out.println(String.format("(%d and %d) giving %d for %d",left,right,mid,number));
            BigInteger square = mid.pow(2);
            if (square.equals(number)) {
                ans = mid;
                break;
            }
            ;
            if (square.compareTo(number) < 0) {
                left = mid.add(BigInteger.ONE);
            } else {
                right = mid.subtract(BigInteger.ONE);
            }
            mid = left.add(right).shiftRight(1);
            noOfSteps++;
        }
        //System.out.println("Took "+noOfSteps+" steps to find the square root of "+number);
        return Objects.isNull(ans) ? BigInteger.valueOf(-1) : ans;
    }
}