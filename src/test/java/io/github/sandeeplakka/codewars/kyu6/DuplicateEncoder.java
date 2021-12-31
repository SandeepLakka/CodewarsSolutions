package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if that character appears only once in the original string, or ")" if that character appears more than once in the original string. Ignore capitalization when determining if a character is a duplicate.
Examples

"din"      =>  "((("
"recede"   =>  "()()()"
"Success"  =>  ")())())"
"(( @"     =>  "))(("

Categories : Fundamentals, Strings, Arrays

 */
public class DuplicateEncoder {
    @Test
    public void tests() {
        assertEquals("(((", encode("din"));
        assertEquals("()()()", encode("recede"));
        assertEquals(")())())", encode("Success"));
        assertEquals("))((", encode("(( @"));

        assertEquals("(((", imperative("din"));
        assertEquals("()()()", imperative("recede"));
        assertEquals(")())())", imperative("Success"));
        assertEquals("))((", imperative("(( @"));

    }

    static String encode(String word) {

        Map<String, Long> map = Arrays.stream(word.toLowerCase().split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return Arrays.stream(word.toLowerCase().split(""))
                .map(chr -> map.get(chr) > 1 ? ")" : "(")
                .collect(Collectors.joining());
    }

    static String imperative(String word) {
        Map<Character, Integer> visited = new HashMap<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            Character character = Character.isUpperCase(word.charAt(i)) ?
                    Character.toLowerCase(word.charAt(i)) : word.charAt(i);
            visited.put(character, visited.getOrDefault(character, 0) + 1);
        }
        for (int i = 0; i < word.length(); i++) {
            Character character = Character.isUpperCase(word.charAt(i)) ?
                    Character.toLowerCase(word.charAt(i)) : word.charAt(i);
            if (visited.get(character) > 1) {
                result.append(")");
            } else {
                result.append("(");
            }
        }
        return result.toString();
    }
}
