package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Moves in squared strings (I)

This kata is the first of a sequence of four about "Squared Strings".

You are given a string of n lines, each substring being n characters long: For example:
s = "abcd\nefgh\nijkl\nmnop"

We will study some transformations of this square of strings.
    Vertical mirror: vert_mirror (or vertMirror or vert-mirror)
    vert_mirror(s) => "dcba\nhgfe\nlkji\nponm"

    Horizontal mirror: hor_mirror (or horMirror or hor-mirror)
     hor_mirror(s) => "mnop\nijkl\nefgh\nabcd"

or printed:
vertical mirror   |horizontal mirror
abcd --> dcba     |abcd --> mnop
efgh     hgfe     |efgh     ijkl
ijkl     lkji     |ijkl     efgh
mnop     ponm     |mnop     abcd

Task:
    Write these two functions
and
    high-order function oper(fct, s) where
    fct is the function of one variable f to apply to the string s (fct will be one of vertMirror, horMirror)

Examples:
s = "abcd\nefgh\nijkl\nmnop"
oper(vert_mirror, s) => "dcba\nhgfe\nlkji\nponm"
oper(hor_mirror, s) => "mnop\nijkl\nefgh\nabcd"

Note:
The form of the parameter fct in oper changes according to the language.
You can see each form according to the language in "Sample Tests".

Categories : Fundamentals
 */
class Opstrings {

    @Test
    @DisplayName("Fixed Tests vertMirror")
    public void test() {
        String s, r;
        s = "hSgdHQ\nHnDMao\nClNNxX\niRvxxH\nbqTVvA\nwvSyRu";
        r = "QHdgSh\noaMDnH\nXxNNlC\nHxxvRi\nAvVTqb\nuRySvw";
        assertEquals(r, Opstrings.oper(Opstrings::vertMirror, s));
        s = "IzOTWE\nkkbeCM\nWuzZxM\nvDddJw\njiJyHF\nPVHfSx";
        r = "EWTOzI\nMCebkk\nMxZzuW\nwJddDv\nFHyJij\nxSfHVP";
        assertEquals(r, Opstrings.oper(Opstrings::vertMirror, s));
        s = "cuQW\nxOuD\nfZwp\neqFx";
        r = "WQuc\nDuOx\npwZf\nxFqe";
        assertEquals(r, Opstrings.oper(Opstrings::vertMirror, s));
        s = "CDGIdolo\nUstXfrIg\ntMqjvxWL\nBEyuCnAm\nxsxaEERa\nxZsvOiZS\nLutlBRXE\ntxshhbqE";
        r = "olodIGDC\ngIrfXtsU\nLWxvjqMt\nmAnCuyEB\naREEaxsx\nSZiOvsZx\nEXRBltuL\nEqbhhsxt";
        assertEquals(r, Opstrings.oper(Opstrings::vertMirror, s));
    }

    @Test
    @DisplayName("Fixed Tests horMirror")
    public void testHorMirror() {
        String s, r;
        s = "lVHt\nJVhv\nCSbg\nyeCt";
        r = "yeCt\nCSbg\nJVhv\nlVHt";
        assertEquals(r, Opstrings.oper(Opstrings::horMirror, s));
        s = "njMK\ndbrZ\nLPKo\ncEYz";
        r = "cEYz\nLPKo\ndbrZ\nnjMK";
        assertEquals(r, Opstrings.oper(Opstrings::horMirror, s));
        assertEquals(r, Opstrings.oper(Opstrings::horMirror, s));
        s = "QMxo\ntmFe\nWLUG\nowoq";
        r = "owoq\nWLUG\ntmFe\nQMxo";
        assertEquals(r, Opstrings.oper(Opstrings::horMirror, s));
        s = "FYvi\ndZQn\nuGef\nQoSy";
        r = "QoSy\nuGef\ndZQn\nFYvi";
        assertEquals(r, Opstrings.oper(Opstrings::horMirror, s));
    }

    public static String vertMirror(String strng) {
        return Arrays.stream(strng.split("\n"))
                .map(StringBuilder::new)
                .map(StringBuilder::reverse)
                .map(StringBuilder::toString)
                .collect(Collectors.joining("\n"));
    }

    public static String horMirror(String strng) {
        List<String> list = Arrays.asList(strng.split("\n"));
        Collections.reverse(list);
        return String.join("\n", list);
    }

    public static String oper(Function<String, String> operator, String s) {
        return operator.apply(s);
    }
}