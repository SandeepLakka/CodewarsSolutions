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
        assertTimeout(Duration.ofMillis(16000), () -> assertEquals("(7537)(123863)", getPrimes(933555431)));
    }

    public String getPrimes(int number){
        //long start = System.currentTimeMillis();
        boolean[] primes = new boolean[number+1];
        Map<Integer, Integer> powers = new LinkedHashMap<>();
        StringBuilder primeFactors = new StringBuilder();
        Arrays.fill(primes, true);

        primes[0] = false;
        primes[1] = false;

        for(int i = 2; i*i <= number; i++){
            int num=number;
            int power = 0;
            while (num %i == 0){
                power++;
                num /=i;
            }
            for(int k = i*i ; k <= number; k+=i){
                primes[k] = false;
            }
        }
        for (int i = 2; number > 0 && i <= number; i++) {
            //System.out.println("checking for number : " + number);
            if (!primes[i]) continue;
            int power = 0;
            //int num = number;
            while (number % i == 0) {
                number /= i;
                power++;
            }
            if(power > 0 ) powers.put(i,power);
            //if (power > 0) primeFactors.append("(" + (power > 1 ? i + "**" + power + ")" : i + ")"));
        }
        powers.entrySet().stream().forEach(entry -> {
            primeFactors.append("(").append(entry.getKey());
            if(entry.getValue() > 1) primeFactors.append("**").append(entry.getValue());
            primeFactors.append(")");
        });

        //long end = System.currentTimeMillis();
        //System.out.println("Took : "+(end-start)+" ms ");
        return primeFactors.toString();
    }
}
