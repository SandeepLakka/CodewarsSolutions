package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Meeting

John has invited some friends. His list is:
s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";

Could you make a program that
    makes this string uppercase
    gives it sorted in alphabetical order by last name.

When the last names are the same, sort them by first name.
Last name and first name of a guest come in the result between parentheses separated by a comma.

So the result of function meeting(s) will be:
"(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)"

It can happen that in two distinct families with the same family name two people have the same first name too.

Notes
You can see another examples in the "Sample tests".

Categories : Fundamentals
 */
class Meeting {

    private static void testing(String s, String exp) {
        System.out.println("Testing:\n" + s);
        String ans = meeting(s);
        System.out.println("Actual: " + ans);
        System.out.println("Expect: " + exp);
        System.out.println(ans.equals(exp));
        assertEquals(exp, ans);
        System.out.println("--------------");
        System.out.println("Testing with v1\n:" + s);
        ans = meetingV1(s);
        System.out.println("Actual: " + ans);
        System.out.println("Expect: " + exp);
        System.out.println(ans.equals(exp));
        assertEquals(exp, ans);
    }

    @Test
    public void test() {
        testing("Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn",
                "(ARNO, ANN)(BELL, JOHN)(CORNWELL, ALEX)(DORNY, ABBA)(KERN, LEWIS)(KORN, ALEX)(META, GRACE)(SCHWARZ, VICTORIA)(STAN, MADISON)(STAN, MEGAN)(WAHL, ALEXIS)");
        testing("John:Gates;Michael:Wahl;Megan:Bell;Paul:Dorries;James:Dorny;Lewis:Steve;Alex:Meta;Elizabeth:Russel;Anna:Korn;Ann:Kern;Amber:Cornwell",
                "(BELL, MEGAN)(CORNWELL, AMBER)(DORNY, JAMES)(DORRIES, PAUL)(GATES, JOHN)(KERN, ANN)(KORN, ANNA)(META, ALEX)(RUSSEL, ELIZABETH)(STEVE, LEWIS)(WAHL, MICHAEL)");
        testing("Alex:Arno;Alissa:Cornwell;Sarah:Bell;Andrew:Dorries;Ann:Kern;Haley:Arno;Paul:Dorny;Madison:Kern",
                "(ARNO, ALEX)(ARNO, HALEY)(BELL, SARAH)(CORNWELL, ALISSA)(DORNY, PAUL)(DORRIES, ANDREW)(KERN, ANN)(KERN, MADISON)");

    }

    public static String meeting(String s) {
        // your code
        return Arrays.stream(s.split(";"))
                .map(String::toUpperCase)
                .map(val -> val.split(":"))
                .sorted((o1, o2) -> {
                    if (o1[1].compareTo(o2[1]) == 0) {
                        return o1[0].compareTo(o2[0]);
                    } else {
                        return o1[1].compareTo(o2[1]);
                    }
                })
                .map(strings -> String.format("(%s, %s)", strings[1], strings[0]))
                .collect(Collectors.joining());
    }

    //clever
    public static String meetingV1(String s) {
        return Arrays.stream(s.toUpperCase().split(";"))
                .map(guest -> guest.replaceAll("(\\w+):(\\w+)", "($2, $1)"))
                .sorted()
                .collect(Collectors.joining(""));
    }
}
