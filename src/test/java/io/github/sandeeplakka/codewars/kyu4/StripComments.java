package io.github.sandeeplakka.codewars.kyu4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StripComments {

    @Test
    public void stripComments() {
        assertEquals(
                "apples, pears\ngrapes\nbananas",
                StripComments.stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"#", "!"})
        );

        assertEquals(
                "a\nc\nd",
                StripComments.stripComments("a #b\nc\nd $e f g", new String[]{"#", "$"})
        );

    }

    public static String stripComments(String text, String[] commentSymbols) {
        //System.out.println("Input is " + text + "\n and commentSymbols are " + Arrays.toString(commentSymbols));
        final String REGEX = "\\s*[" + String.join("", commentSymbols) + "].*";
        //System.out.println(text.replaceAll(REGEX, ""));
        return text.replaceAll(REGEX, "");//.replaceAll("\\s.*$","");
    }

}
