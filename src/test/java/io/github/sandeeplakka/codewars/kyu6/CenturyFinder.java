package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CenturyFinder {

    @Test
    public void testSomething() {
        assertEquals("20th", whatCenturyV1(1999));
        assertEquals("21st", whatCentury(2011));
        assertEquals("22nd", whatCentury(2154));
        assertEquals("23rd", whatCentury(2259));
    }

    /*
    1st,2nd,3rd,4/5/6/7/8/9/0th
     */
    public static String whatCentury(int year) {
        String result;
        int yearCentury = year/100 + 1;
        result = String.valueOf(yearCentury);
        switch (yearCentury%10){
            case 1: result += "st"; break;
            case 2: result += "nd"; break;
            case 3: result += "rd"; break;
            default: result += "th"; break;
        }
        return result;
    }

    public static String whatCenturyV1(int year){
        return String.format("%d%s",
                year/100+1,
                (year%10 == 1 ? "st" : (year%10 == 2 ? "nd": ( year%10 == 3? "rd" : "th")))
        );
    }
}
