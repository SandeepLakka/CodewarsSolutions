package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
Make the Deadfish Swim

Write a simple parser that will parse and run Deadfish.

Deadfish has 4 commands, each 1 character long:

    i increments the value (initially 0)
    d decrements the value
    s squares the value
    o outputs the value into the return array

Invalid characters should be ignored.

Deadfish.parse("iiisdoso") =- new int[] {8, 64};

Categories : Algorithms, Parsing, Strings
 */
public class DeadFish {

    @Test
    public void tests() {
        assertArrayEquals(new int[]{8, 64}, parse("iiisdoso"));
        assertArrayEquals(new int[]{8, 64, 3600}, parse("iiisdosodddddiso"));
    }

    @Test
    public void testsV2() {
        assertArrayEquals(new int[]{0}, parse("ssisdoi"));
        assertArrayEquals(new int[]{0, 0}, parse("dsdosod"));
        assertArrayEquals(new int[]{1, 1}, parse("iossois"));
        assertArrayEquals(new int[]{0, 1}, parse("oiosisi"));
        assertArrayEquals(new int[]{0, 0, -1}, parse("oodoids"));
        assertArrayEquals(new int[]{-1, -2}, parse("siddodo"));
        assertArrayEquals(new int[]{1, 1, 1}, parse("sissooo"));
        assertArrayEquals(new int[]{}, parse("isdsiid"));
        assertArrayEquals(new int[]{-1, 2}, parse("dosiosd"));
        assertArrayEquals(new int[]{-1, -1}, parse("doisdoi"));
        assertArrayEquals(new int[]{1, 1, 1}, parse("ioidsoo"));
        assertArrayEquals(new int[]{0, 1}, parse("oiidido"));
        assertArrayEquals(new int[]{0}, parse("iiddoss"));
        assertArrayEquals(new int[]{1}, parse("sssdsoi"));
        assertArrayEquals(new int[]{1}, parse("iddssso"));
        assertArrayEquals(new int[]{1, 0, 0}, parse("iodosod"));
        assertArrayEquals(new int[]{-1, 1, 1, 1, 1}, parse("dosoooo"));
        assertArrayEquals(new int[]{0}, parse("ossiids"));
        assertArrayEquals(new int[]{-1}, parse("ssdodsd"));
        assertArrayEquals(new int[]{0}, parse("ssidsoi"));
        assertArrayEquals(new int[]{0, 1}, parse("sdsdoio"));
        assertArrayEquals(new int[]{1, 1, 1}, parse("siooido"));
        assertArrayEquals(new int[]{1, 0}, parse("dsssodo"));
        assertArrayEquals(new int[]{1, -1}, parse("isodsdo"));
        assertArrayEquals(new int[]{0, 1, 1}, parse("oisoosi"));
        assertArrayEquals(new int[]{-1, -1, 1}, parse("doosido"));
        assertArrayEquals(new int[]{-1, 0}, parse("sdoiodd"));
        assertArrayEquals(new int[]{-1}, parse("isdsdod"));
        assertArrayEquals(new int[]{1, 1, 1}, parse("ioodiod"));
        assertArrayEquals(new int[]{1, 16}, parse("isoisso"));
        assertArrayEquals(new int[]{0, -2, -2}, parse("osddooi"));

    }

    public static int[] parse(String data) {
        // Implement me! :)
        List<Integer> result = new ArrayList<>();
        char[] options = data.toCharArray();
        int val = 0;
        for (char ch : options) {
            switch (ch) {
                case 'i':
                    val++;
                    break;
                case 'd':
                    val--;
                    break;
                case 's':
                    val *= val;
                    break;
                case 'o':
                    result.add(val);
                    break;
            }
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
