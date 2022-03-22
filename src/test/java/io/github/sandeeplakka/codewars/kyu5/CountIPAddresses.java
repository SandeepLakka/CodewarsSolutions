package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Count IP Addresses

Implement a function that receives two IPv4 addresses,
and returns the number of addresses between them (including the first one, excluding the last one).

All inputs will be valid IPv4 addresses in the form of strings.
The last address will always be greater than the first one.
Examples

ips_between("10.0.0.0", "10.0.0.50")  ==   50
ips_between("10.0.0.0", "10.0.1.0")   ==  256
ips_between("20.0.0.10", "20.0.1.0")  ==  246

Categories : Algorithms, Parsing, Strings
 */
public class CountIPAddresses {

    @Test
    public void test1() {
        assertEquals(50, ipsBetween("10.0.0.0", "10.0.0.50"));
        assertEquals(246, ipsBetween("20.0.0.10", "20.0.1.0"));
        assertEquals(256, ipsBetween("10.0.0.0", "10.0.1.0"));
    }

    private static int[] getOctets(String ipAddress) {
        return Arrays.stream(ipAddress.split("\\.")).mapToInt(Integer::parseInt).toArray();
    }

    public static long ipsBetween(String start, String end) {
        int[] startOctets = getOctets(start);
        int[] endOctets = getOctets(end);
        long sum = 0;
        for (int i = 3; i >= 0; i--) {
            sum += (endOctets[i] - startOctets[i]) * Math.pow(256, 3 - i);
        }
        return sum;
    }
}
