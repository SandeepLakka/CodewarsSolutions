package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

Description:

In a factory a printer prints labels for boxes. For one kind of boxes the printer has to use colors which,
for the sake of simplicity, are named with letters from a to m.

The colors used by the printer are recorded in a control string.
For example a "good" control string would be aaabbbbhaijjjm meaning that the printer used three times color a,
four times color b, one time color h then one time color a...

Sometimes there are problems: lack of colors, technical malfunction and a "bad" control string is produced
e.g. aaaxbbbbyyhwawiwjjjwwm with letters not from a to m.

You have to write a function printer_error which given a string will return the
error rate of the printer as a string representing a rational whose numerator is the number of errors
and the denominator the length of the control string. Don't reduce this fraction to a simpler expression.

The string has a length greater or equal to one and contains only letters from ato z.

Examples:

s="aaabbbbhaijjjm"          -->     printer_error(s) => "0/14"
s="aaaxbbbbyyhwawiwjjjwwm"  -->     printer_error(s) => "8/22"

Categories : Fundamentals

 */
public class Printer {

    @Test
    public void tests() {
        String s = "aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";
        String er = "3/56";
        assertEquals(er, printerError(s));
        assertEquals(er, clever(s));

        s = "aaabbbbhaijjjm";
        er = "0/14";
        assertEquals(er, printerError(s));
        assertEquals(er, clever(s));

        s = "kkkwwwaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";
        er = "6/60";
        assertEquals(er, printerError(s));
        assertEquals(er, clever(s));

        s = "kkkwwwaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyzuuuuu";
        er = "11/65";
        assertEquals(er, printerError(s));
        assertEquals(er, clever(s));

    }

    public static String printerError(String s) {
        final Pattern pattern = Pattern.compile("[n-z]");
        Matcher matcher = pattern.matcher(s);
        int errorCount = 0;
        while (matcher.find()) errorCount++;
        return new StringBuilder(errorCount + "").append("/").append(s.length()).toString();
    }

    public static String clever(String s) {
        return s.chars().filter(c -> c > 'm').count() + "/" + s.length();
        //return s.replaceAll("[a-m]", "").length() + "/" + s.length();
    }
}