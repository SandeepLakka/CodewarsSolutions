package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Given an array of ones and zeroes, convert the equivalent binary value to an integer.

Eg: [0, 0, 0, 1] is treated as 0001 which is the binary representation of 1.

Examples:

Testing: [0, 0, 0, 1] ==> 1
Testing: [0, 0, 1, 0] ==> 2
Testing: [0, 1, 0, 1] ==> 5
Testing: [1, 0, 0, 1] ==> 9
Testing: [0, 0, 1, 0] ==> 2
Testing: [0, 1, 1, 0] ==> 6
Testing: [1, 1, 1, 1] ==> 15
Testing: [1, 0, 1, 1] ==> 11

However, the arrays can have varying lengths, not just limited to 4.

Categories : Fundamentals, Arrays
 */
public class BinaryArrayToNumber {

    @Test
    public void tests_convertBinaryArrayToInt() {
        tests(this::convertBinaryArrayToInt);
    }

    @Test
    public void tests_clever() {
        tests(this::clever);
    }


    public int convertBinaryArrayToInt(List<Integer> binary) {
        return (int) IntStream.range(0, binary.size())
                .mapToDouble(index -> binary.get(index) * Math.pow(2, binary.size() - index - 1))
                .sum();
    }

    public int clever(List<Integer> binary) {
        return binary.stream().reduce((x, y) -> x * 2 + y).get();
    }

    //Helper testing method
    public void tests(Function<List<Integer>, Integer> function) {
        List<List<Integer>> tests = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            List<Integer> temp = new ArrayList<>();

            for (int j = 0; j < Math.floor(Math.random() * 5) + 4; j++) {
                temp.add((int) Math.round(Math.random() * 1));
            }

            tests.add(temp);
        }

        tests.forEach((test) -> {
            String s = test.toString();
            String ans = "";

            for (char c : s.toCharArray()) {
                int value = Character.getNumericValue(c);

                if (value == 1 || value == 0) {
                    ans += c;
                }
            }

            int solution = Integer.parseInt(ans, 2);

            System.out.println("Testing: " + s + " ==> " + solution);

            assertEquals(solution, function.apply(test));
        });
    }
}