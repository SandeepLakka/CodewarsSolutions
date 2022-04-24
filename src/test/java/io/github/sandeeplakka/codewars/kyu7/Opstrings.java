package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    }

    public static String vertMirror(String strng) {
        // your code
        return Arrays.stream(strng.split("\n"))
                .map(StringBuilder::new)
                .map(StringBuilder::reverse)
                .map(StringBuilder::toString)
                .collect(Collectors.joining("\n"));
    }

    public static String horMirror(String strng) {
        // your code
        List<String> list = Arrays.asList(strng.split("\n"));
        Collections.reverse(list);
        return String.join("\n", list);
    }

    public static String oper(Function<String, String> operator, String s) {
        // your code and complete ... before operator
        return operator.apply(s);
    }
}