package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

/*

    Primes in numbers
    Given a positive number n > 1 find the prime factor decomposition of n. The result will be a string with the following form :

    "(p1**n1)(p2**n2)...(pk**nk)"

    with the p(i) in increasing order and n(i) empty if n(i) is 1.

    Example: n = 86240 should return "(2**5)(5)(7**2)(11)"

    Categories: Fundamentals, Numbers, Mathematics, Algorithms, Utilities
 */
public class PrimesInNumbers {

    @Test
    public void test_getPrimes() {
        assertEquals("(2**5)(5)(7**2)(11)", getPrimes(86240));
        assertEquals("(7919)", getPrimes(7919));
        assertEquals("(2**2)(3**3)(5)(7)(11**2)(17)", getPrimes(7775460));
        assertEquals("(7**2)(11)(43)(643)", getPrimes(14902811));
        assertEquals("(2**3)(191)(19489)", getPrimes(29779192));
        assertTimeout(Duration.ofMillis(12000), () -> assertEquals("(7537)(123863)", getPrimes(933555431)));
    }

    @Test
    public void test_factors() {
        assertEquals("(2**5)(5)(7**2)(11)", factors(86240));
        assertEquals("(7919)", factors(7919));
        assertEquals("(2**2)(3**3)(5)(7)(11**2)(17)", factors(7775460));
        assertEquals("(7**2)(11)(43)(643)", factors(14902811));
        assertEquals("(2**3)(191)(19489)", factors(29779192));

        assertTimeout(Duration.ofMillis(12000), () -> assertEquals("(7537)(123863)", factors(933555431)));
    }

    //to the point
    //better than getPrimes(int number) interms of time and space (may not be in Big O terms but still better)
    public static String factors(int number) {
        StringBuilder result = new StringBuilder();
        for (int factor = 2; factor <= number; ++factor) {
            int count;
            for (count = 0; number % factor == 0; ++count) {
                number /= factor;
            }
            if (count > 0) {
                result.append("(").append(factor).append((count > 1 ? "**" + count : "")).append(")");
            }
        }
        return result.toString();
    }

    //old school version
    public String getPrimes(int number) {
        //long start = System.currentTimeMillis();
        boolean[] primes = new boolean[number + 1];
        Map<Integer, Integer> powers = new LinkedHashMap<>();
        StringBuilder primeFactors = new StringBuilder();
        Arrays.fill(primes, true);

        int i = 2;
        for (; i * i <= number; i++) {
            if (!primes[i]) continue;
            if (number % i != 0) continue;
            int maxPower = 0;
            //int num=number;
            for (int k = i * i; k <= number; k += i) {
                primes[k] = false;
                int power = 0;
                while (number % i == 0) {
                    number /= i;
                    power++;
                }
                if (power > maxPower) maxPower = power;
            }
            if (primes[i] && maxPower > 0) {
                powers.put(i, maxPower);
                //number /= (int)Math.pow(i,maxPower);
            }
        }

        for (; i <= number; i++) {
            if (!primes[i]) continue;
            if (number % i == 0) {
                number /= i;
                powers.put(i, 1);
            }

        }


        powers.forEach((k, v) -> {

            primeFactors.append("(").append(k);
            if (v > 1) primeFactors.append("**").append(v);
            primeFactors.append(")");
        });

        //System.out.println("Took : "+(System.currentTimeMillis()-start)+" ms ");
        return primeFactors.toString();
    }
}
