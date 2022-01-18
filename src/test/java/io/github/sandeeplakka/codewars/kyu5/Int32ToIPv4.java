package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Take the following IPv4 address: 128.32.10.1

This address has 4 octets where each octet is a single byte (or 8 bits).

    1st octet 128 has the binary representation: 10000000
    2nd octet 32 has the binary representation: 00100000
    3rd octet 10 has the binary representation: 00001010
    4th octet 1 has the binary representation: 00000001

So 128.32.10.1 == 10000000.00100000.00001010.00000001

Because the above IP address has 32 bits,
we can represent it as the unsigned 32 bit number: 2149583361

Complete the function that takes an unsigned 32 bit number
and returns a string representation of its IPv4 address.

Examples

2149583361 ==> "128.32.10.1"
32         ==> "0.0.0.32"
0          ==> "0.0.0.0"

Categories : Algorithms, Networks, Bits, Binary, Utilities
 */
public class Int32ToIPv4 {

	@Test
	public void tests_longToIp() {
		assertEquals("128.114.17.104", longToIP(2154959208L));
		assertEquals("0.0.0.0", longToIP(0));
		assertEquals("128.32.10.1", longToIP(2149583361L));
		assertEquals("61.124.223.59", longToIP(1031593787));
		assertEquals("26.70.224.141", longToIP(440852621));
	}

	@Test
	public void tests_cleaner() {
		assertEquals("128.114.17.104", cleaner(2154959208L));
		assertEquals("0.0.0.0", cleaner(0));
		assertEquals("128.32.10.1", cleaner(2149583361L));
		assertEquals("61.124.223.59", cleaner(1031593787));
		assertEquals("26.70.224.141", cleaner(440852621));
	}

	public static String longToIP(long ip) {
		// Java doesn't have uint32, so here we use long to represent int32
		long firstOctet = 4278190080l;
		int firstShift = 24;
		long secondOctet = 16711680;
		int secondShift = 16;
		long thirdOctet = 65280;
		int thirdShift = 8;
		long fourthOctet = 255;

		StringBuilder builder = new StringBuilder();
		builder.append((ip & firstOctet) >> firstShift).append(".");
		builder.append((ip & secondOctet) >> secondShift).append(".");
		builder.append((ip & thirdOctet) >> thirdShift).append(".");
		builder.append((ip & fourthOctet));

		return builder.toString();
	}

	public static String cleaner(long ip) {
		return String.format("%d.%d.%d.%d", (ip >>> 24), (ip >> 16) & 0xff, (ip >> 8) & 0xff, ip & 0xff);
	}
}
