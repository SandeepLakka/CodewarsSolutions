package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
Complete the solution so that it splits the string into pairs of two characters. If the string contains an odd number of characters then it should replace the missing second character of the final pair with an underscore ('_').

Examples:

StringSplit.solution("abc") // should return {"ab", "c_"}
StringSplit.solution("abcdef") // should return {"ab", "cd", "ef"}

Categories : Algorithms, Regular Expressions, Declarative Programming
Advanced Language Features, Fundamentals, Strings
 */
public class StringSplit {

    @Test
    public void tests_solution() {
        assertArrayEquals(new String[]{"ab", "c_"}, solution("abc"));
        assertArrayEquals(new String[]{"ab", "cd", "ef"}, solution("abcdef"));
    }

    @Test
    public void tests_cryptic() {
        assertArrayEquals(new String[]{"ab", "c_"}, cryptic("abc"));
        assertArrayEquals(new String[]{"ab", "cd", "ef"}, cryptic("abcdef"));
    }


    public static String[] solution(String s) {
        //Write your code here
        s = (s.length() & 1) == 0 ? s : s.concat("_");
        String[] result = new String[s.length() / 2];
        for (int i = 0; i < s.length() - 1; i += 2) {
            result[i / 2] = s.substring(i, i + 2);
        }
        return result;
    }

    //TODO understand the regex
    public static String[] cryptic(String s) {
        s = (s.length() & 1) == 0 ? s : s.concat("_");
        //?<= Positive Look behind, \G denoting prev match end
        return s.split("(?<=\\G.{2})");
        /*
        Following works fine for Pattern and Matcher but not for String class methods which expect regex
            Pattern.compile(".{2}")
            .matcher("abcdefghi_")
            .results()
            .forEach(e -> System.out.println(e.group()));
         */
    }

}