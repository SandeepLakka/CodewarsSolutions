package io.github.sandeeplakka.codewars.kyu6;

/*
  Stop gninnipS My sdroW!

  Write a function that takes in a string of one or more words,
  and returns the same string, but with all five or more letter words reversed
  (Just like the name of this Kata).
  Strings passed in will consist of only letters and spaces.
  Spaces will be included only when more than one word is present.

  Examples:
  spinWords( "Hey fellow warriors" ) => returns "Hey wollef sroirraw"
  spinWords( "This is a test") => returns "This is a test"
  spinWords( "This is another test" )=> returns "This is rehtona test"
  Categories : Algorithms, Strings, Formatting
*/

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpinWords {

    @Test
    public void testSpinWords() {
        assertEquals("Hey wollef sroirraw", spinWords("Hey fellow warriors"));
        assertEquals("This is a test", spinWords("This is a test"));
        assertEquals("This is rehtona test", spinWords("This is another test"));
        assertEquals("emocleW", spinWords("Welcome"));
        assertEquals("Hey wollef sroirraw", spinWords("Hey fellow warriors"));
        assertEquals("This is a test", spinWords("This is a test"));
        assertEquals("This is rehtona test", spinWords("This is another test"));
        assertEquals("This ecnetnes is a ecnetnes", spinWords("This sentence is a sentence"));
        assertEquals("You are tsomla to the last test", spinWords("You are almost to the last test"));
        assertEquals("Just gniddik ereht is llits one more", spinWords("Just kidding there is still one more"));
        assertEquals("ylsuoireS this is the last one", spinWords("Seriously this is the last one"));
    }

    public String spinWords(String sentence) {

        return Arrays.stream(sentence.split(" "))
                .map(s -> s.length() < 5 ? s : new StringBuilder(s).reverse().toString())
                .collect(Collectors.joining(" "));

    }
}