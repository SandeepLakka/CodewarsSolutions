package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*


The prime numbers are not regularly spaced. For example from 2 to 3 the gap is 1.
From 3 to 5 the gap is 2. From 7 to 11 it is 4.
Between 2 and 50 we have the following pairs of 2-gaps primes: 3-5, 5-7, 11-13, 17-19, 29-31, 41-43

A prime gap of length n is a run of n-1 consecutive composite numbers between two successive primes
(see: http://mathworld.wolfram.com/PrimeGaps.html).

We will write a function gap with parameters:

    g (integer >= 2) which indicates the gap we are looking for

    m (integer > 2) which gives the start of the search (m inclusive)

    n (integer >= m) which gives the end of the search (n inclusive)

    n won't go beyond 1100000.

In the example above gap(2, 3, 50) will return [3, 5] or (3, 5) or {3, 5}
which is the first pair between 3 and 50 with a 2-gap.

So this function should return the first pair of two prime numbers spaced with
a gap of g between the limits m, n if these numbers exist otherwise null

Examples:

    gap(2, 5, 7) --> [5, 7] or (5, 7) or {5, 7}

    gap(2, 5, 5) --> nil. In C++ {0, 0}. In F# [||]. In Kotlin, Dart and Prolog return []`

    gap(4, 130, 200) --> [163, 167] or (163, 167) or {163, 167}

([193, 197] is also such a 4-gap primes between 130 and 200 but it's not the first pair)

    gap(6,100,110) --> nil or {0, 0} or ... : between 100 and 110 we have 101, 103, 107, 109
    but 101-107is not a 6-gap because there is 103in between and 103-109is not a 6-gap because
    there is 107 in between.

    You can see more examples of return in Sample Tests.


Ref : https://en.wikipedia.org/wiki/Prime_gap

Categories : Fundamentals, Numbers

 */
class GapInPrimes {

    @Test
    public void tests() {
        assertEquals("[101, 103]", Arrays.toString(getPrimes(2, 100, 110)));
        assertEquals("[103, 107]", Arrays.toString(getPrimes(4, 100, 110)));
        assertEquals(null, getPrimes(6, 100, 110));
        assertEquals("[359, 367]", Arrays.toString(getPrimes(8, 300, 400)));
        assertEquals("[337, 347]", Arrays.toString(getPrimes(10, 300, 400)));
        assertEquals("[30109, 30113]", Arrays.toString(getPrimes(4, 30000, 100000)));
        assertEquals("[30091, 30097]", Arrays.toString(getPrimes(6, 30000, 100000)));
        assertEquals("[30161, 30169]", Arrays.toString(getPrimes(8, 30000, 100000)));
        assertEquals(null, getPrimes(11, 30000, 100000));
        assertEquals("[1000037, 1000039]", Arrays.toString(getPrimes(2, 1000000, 1100000)));
        assertEquals("[10000139, 10000141]", Arrays.toString(getPrimes(2, 10000000, 11000000)));
    }

    private static long[] getPrimes(int g, long m, long n) {
        int em = (int) m;
        int en = (int) n;
        boolean[] primes = new boolean[en + 1];
        Arrays.fill(primes, true);
        for (int i = 2; i * i <= en; i++) {
            for (int j = i * i; j <= en; j += i) {
                primes[j] = false;
            }
        }
        long previous = primes[em] ? em : -1;
        for (int i = em + 1; i <= en; i++) {
            if (primes[i]) {
                if (i != -1 && (i - previous) == g) return new long[]{previous, i};
                previous = i;
            }
        }
        return null;
    }

    //TODO : Need to write a better algorithm to get primes in the range m,n
    // instead of finding whole range of n if there is algorithm exists

}