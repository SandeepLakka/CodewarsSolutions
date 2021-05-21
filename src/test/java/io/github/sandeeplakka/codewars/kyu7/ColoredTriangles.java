package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Coloured Triangles
 * A coloured triangle is created from a row of colours,
 * each of which is red, green or blue. Successive rows,
 * each containing one fewer colour than the last, are generated by
 * considering the two touching colours in the previous row.
 * If these colours are identical, the same colour is used in the new row.
 * If they are different, the missing colour is used in the new row.
 * This is continued until the final row, with only a single colour, is generated.
 *
 * The different possibilities are:
 *
 * Colour here:        G G        B G        R G        B R
 * Becomes colour:      G          R          B          G
 *
 * With a bigger example:
 *
 * R R G B R G B B
 *  R B R G B R B
 *   G G B R G G
 *    G R G B G
 *     B B R R
 *      B G R
 *       R B
 *        G
 *
 * You will be given the first row of the triangle as a string and its your job to return
 * the final colour which would appear in the bottom row as a string.
 * In the case of the example above, you would the given RRGBRGBB you should return G.
 *
 *     The input string will only contain the uppercase letters R, G, B and there will
 *     be at least one letter so you do not have to test for invalid input.
 *     If you are only given one colour as the input, return that colour.
 *
 * Adapted from the 2017 British Informatics Olympiad
 *
 * Categories:Algorithms, Strings
 * https://www.codewars.com/kata/5a25ac6ac5e284cfbe000111/java
 */
public class ColoredTriangles {

    @Test
    public void testTriangleWithRegularInputs(){
        String tc1 = "RR";
        String tc2 = "RG";
        String tc3 = "RBG";
        String tc4 = "RRGBRGBB";
        String tc5 = "RRGGBB";
        String tc6 = "RRGBRGBB";

        char er1 = 'R';
        char er2 = 'B';
        char er3 = 'B';
        char er4 = 'G';
        char er5 = 'G';
        char er6 = 'G';

        assertEquals(er1, triangle(tc1));
        assertEquals(er2, triangle(tc2));
        assertEquals(er3, triangle(tc3));
        assertEquals(er4, triangle(tc4));
        assertEquals(er5, triangle(tc5));
        assertEquals(er6, triangle(tc6));
    }

    @Test
    public void testTriangleWithLongerInputs(){
        lookupTable.clear();;
        assertEquals('R', triangle(getString("R",2,2.5f)));
        assertEquals('R', triangle(getString("R",3,2.5f)));
        assertEquals('G', triangle(getString("GGG",3,2.5f)));
        assertEquals('B', triangle(getString("RG",3,2.5f)));
    }

    //TODO : Need to check why memoized recursive approach is slower than normal recursion
    @Test
    public void testMemoizedTriangleWithLongerInputs(){
        assertEquals('R', memoized_triangle(getString("R",2,2.5f)));
        assertEquals('R', memoized_triangle(getString("R",3,2.5f)));
        assertEquals('G', memoized_triangle(getString("GGG",3,2.5f)));
        assertEquals('B', memoized_triangle(getString("RG",3,2.5f)));
    }

    private static String getString(String character, int tenthPower, float multiplier) {
        return IntStream.range(0,(int)(Math.pow(10,tenthPower)*multiplier)).mapToObj(operand -> character).collect(Collectors.joining());
    }


    public char triangle(String row){
        if(row.length() == 1){
            return row.charAt(0);
        }
        if(row.length() == 2){
            switch (row){
                case "RR": case "BG": case "GB":
                    return 'R';
                case "GG": case "RB": case "BR":
                    return 'G';
                case "BB": case "RG": case "GR":
                    return 'B';
            }
        }

        String reducedString = IntStream.range(0, row.length() - 1)
                .mapToObj(o -> String.valueOf(triangle(row.substring(o, o + 2))))
                .collect(Collectors.joining());

        return triangle(reducedString);

    }

    Map<String,String> lookupTable = new HashMap<>();

    public char memoized_triangle(String row){
        if(row.length() == 1){
            return row.charAt(0);
        }
        if(row.length() == 2){
            if(lookupTable.containsKey(row)) return lookupTable.get(row).charAt(0);
            switch (row){
                case "RR": case "BG": case "GB":
                    return 'R';
                case "GG": case "RB": case "BR":
                    return 'G';
                case "BB": case "RG": case "GR":
                    return 'B';
            }
        }

        if(lookupTable.containsKey(row)) {
            return memoized_triangle(lookupTable.get(row));
        }

        String reducedString = IntStream.range(0, row.length() - 1)
                .mapToObj(o -> String.valueOf(memoized_triangle(row.substring(o, o + 2))))
                .collect(Collectors.joining());

        //return memoized_triangle(lookupTable.put(row, reducedString)); // little cryptic to understand
        lookupTable.put(row, reducedString);
        return memoized_triangle(reducedString);

    }

//Work for debugging and testing

/*
    public static String nextString(String string){
        if (string.length() == 1) {
            lookupTable.put(string,string);
            return string;
        }
        if(string.length() == 2){
            if(lookupTable.containsKey(string)) return lookupTable.get(string);
            return String.valueOf(getCharStr(string));
        }
        if(lookupTable.containsKey(string)) return lookupTable.get(string);

        String res = nextString(string.substring(0,2))+ nextString(string.substring(1));
        lookupTable.put(string,res);
        return res;
    }


    private static Character getCharStr(String str){
        Character retVal = null;
        switch (str){
            case "RR":
            case "BG":
            case "GB":
                retVal = 'R'; break;
            case "GG":
            case "RB":
            case "BR":
                retVal = 'G'; break;
            case "BB":
            case "RG":
            case "GR":
                retVal = 'B'; break;
        }
        lookupTable.put(str,retVal.toString());
        return retVal;
    }


    public char reduce(String row){
        List<Character> colors = new ArrayList<Character>();
        colors.add('Y'); colors.add('N'); colors.add('M');

        if(row.length() == 1){
            return row.charAt(0);
        }else if(row.length() == 2){
            colors.removeAll(Arrays.asList(row.charAt(0),row.charAt(1)));
            return (colors.size() == 1 ? colors.get(0) : row.charAt(0));
        }else{
            String reducedString = IntStream.range(0,row.length()-1)
                    .mapToObj(o -> String.valueOf(reduce(row.substring(o,o+2))))
                    .collect(Collectors.joining());
            return reduce(reducedString);
        }
    }

    private static String getRandomString(int length) {
        Random random = new Random();
        List<String> list = Arrays.asList(new String[]{"R","G","B"});
        return IntStream.range(0,(int)Math.pow(10,length)).mapToObj(operand -> list.get(random.nextInt(3))).collect(Collectors.joining());
    }*/
}
