package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Convert boolean values to strings 'Yes' or 'No'.
 * Complete the method that takes a boolean value
 * and return a "Yes" string for true, or a "No" string for false.
 *
 * Categories: Fundamentals, Booleans, Best Practices
 * https://www.codewars.com/kata/53369039d7ab3ac506000467
 */
public class ConvertBooleanToYesNoStrings {

    public static final String YES  = "Yes";
    public static final String NO  = "No";

    @Test
    public void testBoolToWord(){
        assertEquals(YES, boolToWord(true));
        assertEquals(NO, boolToWord(false));
    }

    public String boolToWord(boolean b){
        return b ? YES : NO;
    }

}
