package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumFct {

    @Test
    public void test1() {
        assertEquals(BigInteger.valueOf(80), perimeter(BigInteger.valueOf(5)));
    }

    @Test
    public void test2() {
        assertEquals(BigInteger.valueOf(216), perimeter(BigInteger.valueOf(7)));
    }

    @Test
    public void test3() {
        assertEquals(BigInteger.valueOf(14098308), perimeter(BigInteger.valueOf(30)));
    }

    @Test
    public void test4() {
        BigInteger r = new BigInteger("6002082144827584333104");
        assertEquals(r, SumFct.perimeter(BigInteger.valueOf(100)));
    }

    @Test
    public void test5() {
        BigInteger r = new BigInteger("2362425027542282167538999091770205712168" +
                "371625660854753765546783141099308400948230006358531927265833165504");
        assertEquals(r, SumFct.perimeter(BigInteger.valueOf(500)));
    }


    public static BigInteger perimeter(BigInteger n) {

        final BigInteger[] memo = new BigInteger[n.intValue() + 1];
        Arrays.fill(memo, BigInteger.valueOf(-1));
        memo[0] = memo[1] = BigInteger.ONE;
        for (int i = 2; i <= n.intValue(); i++) {
            memo[i] = memo[i - 1].add(memo[i - 2]);
        }

        //pmRecur(n, memo);
        return Arrays.stream(memo).reduce(BigInteger.ZERO, BigInteger::add).multiply(BigInteger.valueOf(4));
    }

    //recursive approach but scrapped it for bottom up approach above
    private static BigInteger pmRecur(BigInteger n, BigInteger[] memo) {
        if (!memo[n.intValue()].equals(BigInteger.valueOf(-1))) return memo[n.intValue()];
        memo[n.intValue()] = pmRecur(n.subtract(BigInteger.ONE), memo).add(
                pmRecur(n.subtract(BigInteger.valueOf(2)), memo)
        );
        return memo[n.intValue()];
    }
}