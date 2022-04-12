package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Sum of prime-indexed elements

In this Kata, you will be given an integer array and your task is to return
the sum of elements occupying prime-numbered indices.

The first element of the array is at index 0.
Good luck!

Categories : Consonant value, Fundamentals, Lists, Data Structures, Numbers
 */
class SumOfPrimeIndexedElements {

    @Test
    public void basicTests() {
        assertEquals(0, solve(new int[]{}));
        assertEquals(7, solve(new int[]{1, 2, 3, 4}));
        assertEquals(13, solve(new int[]{1, 2, 3, 4, 5, 6}));
        assertEquals(47, solve(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
    }

    public int solve(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        List<Integer> primeIndices = getPrimesTill(arr.length);
        return primeIndices.stream().mapToInt(idx -> arr[idx]).sum();

    }

    public List<Integer> getPrimesTill(int range) {
        boolean[] isNotPrime = new boolean[range];
        for (int i = 2; i * i < range; i++) {
            for (int j = 2 * i; j < range; j += i) {
                isNotPrime[j] = true;
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}