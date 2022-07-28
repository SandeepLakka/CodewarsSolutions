import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Sentence Smash

Write a function that takes an array of words and smashes them together into a sentence and returns the sentence.
You can ignore any need to sanitize words or add punctuation, but you should add spaces between each word. 
Be careful, there shouldn't be a space at the beginning or the end of the sentence!

Example:
['hello', 'world', 'this', 'is', 'great']  =>  'hello world this is great'

Categories : Strings, Arrays, Fundamentals
*/

public class SmashWords {

  @Test
  public void validate() {
    assertEquals("Bilal Djaghout", SmashWords.smash(new String[] { "Bilal", "Djaghout" }));
    assertEquals("hello world", SmashWords.smash(new String[] {"hello", "world"}));
    assertEquals("hello amazing world", SmashWords.smash(new String[] {"hello", "amazing", "world"}));
  }
  
  @Test
  public void validateEmpty() {
    assertEquals("", SmashWords.smash(new String[] {}));
  }

  
  @Test
  public void validateOneWord() {
    assertEquals("Bilal", SmashWords.smash(new String[] {"Bilal"}));
    assertEquals("Test", SmashWords.smash(new String[] {"Test"}));
  }
  
  
  public static String smash(String... words) {
    return String.join(" ", words);
  }
}
