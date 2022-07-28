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
		assertEquals("Bilal Djaghout", smash(new String[] { "Bilal", "Djaghout" }));
	}
	
	@Test
	public void validateEmpty() {
		assertEquals("", smash(new String[] {}));
	}

	
	@Test
	public void validateOneWord() {
		assertEquals("Bilal", smash(new String[] {"Bilal"}));
	}
  
  
	public static String smash(String... words) {
    return String.join(" ", words);
  }
}
