package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Remove String Spaces

Simple, remove the spaces from the string, then return the resultant string.

Categories : Fundamentals, Strings, Arrays

 */
public class RemoveSpacesInString {
    @Test
    public void testSomething() {
        assertEquals("8j8mBliB8gimjB8B8jlB",
                noSpace("8 j 8   mBliB8g  imjB8B8  jl  B"));
        assertEquals("88Bifk8hB8BB8BBBB888chl8BhBfd",
                noSpace("8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd"));
        assertEquals("8aaaaaddddr",
                noSpace("8aaaaa dddd r     "));
        assertEquals("jfBmgklf8hg88lbe8",
                noSpace("jfBm  gk lf8hg  88lbe8 "));
        assertEquals("8jaam",
                noSpace("8j aam"));

        assertEquals("8j8mBliB8gimjB8B8jlB",
                noSpaceV1("8 j 8   mBliB8g  imjB8B8  jl  B"));
        assertEquals("88Bifk8hB8BB8BBBB888chl8BhBfd",
                noSpaceV1("8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd"));
        assertEquals("8aaaaaddddr",
                noSpaceV1("8aaaaa dddd r     "));
        assertEquals("jfBmgklf8hg88lbe8",
                noSpaceV1("jfBm  gk lf8hg  88lbe8 "));
        assertEquals("8jaam",
                noSpaceV1("8j aam"));


    }

    public static String noSpace(final String x) {
        int length = x.length();
        for (char ch : x.toCharArray()) {
            if (Character.isWhitespace(ch)) length--;
        }
        char[] res = new char[length];
        int idx = 0;
        for (int i = 0; i < x.length(); i++) {
            if (!Character.isWhitespace(x.charAt(i))) {
                res[idx++] = x.charAt(i);
            }
        }
        return new String(res);
    }

    public static String noSpaceV1(final String x) {
        return String.join("", x.split("\\s"));
    }
}