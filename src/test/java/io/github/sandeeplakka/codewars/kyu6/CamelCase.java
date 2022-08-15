package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CamelCase {

    @Test
    public void testTwoWords() {
        assertEquals("TestCase", camelCase("test case"));
    }

    @Test
    public void testThreeWords() {
        assertEquals("CamelCaseMethod", camelCase("camel case method"));
    }

    @Test
    public void testLeadingSpace() {
        assertEquals("CamelCaseWord", camelCase(" camel case word"));
    }

    @Test
    public void testTrailingSpace() {
        assertEquals("SayHello", camelCase("say hello "));
    }

    @Test
    public void testSingleLetter() {
        assertEquals("Z", camelCase("z"));
    }

    @Test
    public void testTwoSpacesBetweenWords() {
        assertEquals("AbC", camelCase("ab  c"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", camelCase(""));
    }

    private static final int NUMBER_OF_RANDOM_TESTS = 1_000;

    @Test
    public void testRandomInput() {
        Random random = ThreadLocalRandom.current();
        char[] randomLetters = generateRandomLowerCaseLetters(100, random);
        for (int i = 0; i < NUMBER_OF_RANDOM_TESTS; i++) {
            StringBuilder randomInput = new StringBuilder();
            StringBuilder expectedOutput = new StringBuilder();
            int numberOfWords = (1 + random.nextInt(5)) * (1 + random.nextInt(5)) - 1;
            for (int j = 0; j < numberOfWords; j++) {
                if (j > 0)
                    randomInput.append(' ');
                int wordLength = random.nextInt(11);
                if (wordLength > 0) {
                    int wordOffset = random.nextInt(randomLetters.length - wordLength);
                    randomInput.append(randomLetters, wordOffset, wordLength);
                    expectedOutput.append(Character.toUpperCase(randomLetters[wordOffset]));
                    if (wordLength > 1)
                        expectedOutput.append(randomLetters, wordOffset + 1, wordLength - 1);
                }
            }
            assertEquals(expectedOutput.toString(), camelCase(randomInput.toString()));
        }
    }

    protected char[] generateRandomLowerCaseLetters(int count, Random random) {
        char[] randomLetters = new char[count];
        for (int i = 0; i < randomLetters.length; i++)
            randomLetters[i] += 'a' + random.nextInt(26);
        return randomLetters;
    }

    public static String camelCase(String str) {
        // your code here
        return Arrays.stream(str.split(" ")).map(CamelCase::capitalize).collect(Collectors.joining());
    }

    private static String capitalize(String input) {
        if (input.isEmpty()) return input;
        if (input.length() == 1) return input.toUpperCase();
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

}
