package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
 *
 * When working with color values it can sometimes be useful to extract the individual red, green, and blue (RGB) component values for a color. Implement a function that meets these requirements:
 *
 * Accepts a case-insensitive hexadecimal color string as its parameter (ex. "#FF9933" or "#ff9933")
 * Returns a array of <int> with the structure [r, g, b] where r, g, and b range from 0 through 255
 *
 * Note: your implementation does not need to support the shorthand form of hexadecimal notation (ie "#FFF")
 * Example
 *
 * "#FF9933" --> [255, 153, 51]
 *
 * Categories : Algorithms, Parsing, Strings

 */
public class ConvertHexStringToRGB {

    @Test
    public void testGetRGBFromHex(){
        assertArrayEquals(new int[]{17, 17, 17}, getRGBFromHex("#111111"));
        assertArrayEquals(new int[]{0, 0, 0}, getRGBFromHex("#000000"));
        assertArrayEquals(new int[]{255, 153, 51}, getRGBFromHex("#FF9933"));
        assertArrayEquals(new int[]{190, 173, 237}, getRGBFromHex("#beaded"));
        assertArrayEquals(new int[]{255, 255, 255}, getRGBFromHex("#FFFFFF"));
        assertArrayEquals(new int[]{250, 52, 86}, getRGBFromHex("#Fa3456"));
        assertArrayEquals(new int[]{5, 177, 173}, getRGBFromHex("#05b1ad"));

    }

    public int[] getRGBFromHex(String hex){
        // hex -> {r, g, b}
        int red = Integer.parseInt(hex.substring(1,3),16);
        int green = Integer.parseInt(hex.substring(3,5), 16);
        int blue = Integer.parseInt(hex.substring(5),16);
        return new int[]{red, green, blue};
    }
}
