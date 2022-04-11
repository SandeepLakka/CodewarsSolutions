package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Description:

If you're faced with an input box, like this:

                                           +--------------+
  Enter the price of the item, in dollars: |              |
                                           +--------------+

do you put the $ sign in, or not? Inevitably,
some people will type a $ sign and others will leave it out.
The instructions could be made clearer -
but that won't help those annoying people who never read instructions anyway.

A better solution is to write code that can handle
the input whether it includes a $ sign or not.

So, we need a simple function that converts a string representing a number
(possibly with a $ sign in front of it) into the number itself.

Remember to consider negative numbers (the - sign may come either before or after the $ sign, if there is one),
and any extraneous space characters (leading, trailing, or around the $ sign)
that the users might put in. You do not need to handle trailing characters other than spaces
(e.g. "1.2 3"). If the given string does not represent a number,
(either with or without a $ sign), return 0.0

Categories : Fundamentals, Basic Language Features
 */
public class UnwantedDollars {
    @Test
    public void moneyValue() {
        assertEquals(12.34, moneyValue("12.34"), 1e-9);
        assertEquals(5.67, moneyValue(" $5.67"), 1e-9);
        assertEquals(-0.89, moneyValue("-0.89"), 1e-9);
        assertEquals(-0.10, moneyValue("-$ 0.1"), 1e-9);
        assertEquals(-2.3456, moneyValue("$-2.3456"), 1e-9);
        assertEquals(7, moneyValue("007"), 1e-9);
        assertEquals(89.0, moneyValue(" $ 89"), 1e-9);
        assertEquals(0.11, moneyValue("   .11"), 1e-9);
        assertEquals(0.20, moneyValue("$.2"), 1e-9);
        assertEquals(-0.34, moneyValue("-.34"), 1e-9);
        assertEquals(0.0, moneyValue("$$$"), 1e-9);

        assertEquals(12.34, moneyValueV1("12.34"), 1e-9);
        assertEquals(5.67, moneyValueV1(" $5.67"), 1e-9);
        assertEquals(-0.89, moneyValueV1("-0.89"), 1e-9);
        assertEquals(-0.10, moneyValueV1("-$ 0.1"), 1e-9);
        assertEquals(-2.3456, moneyValueV1("$-2.3456"), 1e-9);
        assertEquals(7, moneyValueV1("007"), 1e-9);
        assertEquals(89.0, moneyValueV1(" $ 89"), 1e-9);
        assertEquals(0.11, moneyValueV1("   .11"), 1e-9);
        assertEquals(0.20, moneyValueV1("$.2"), 1e-9);
        assertEquals(-0.34, moneyValueV1("-.34"), 1e-9);
        assertEquals(0.0, moneyValueV1("$$$"), 1e-9);
    }

    public static double moneyValue(String money) {
        money = money.trim();
        if (money.contains("$")) {
            money = money.replaceAll("\\s*\\$\\s*", "").split("\\s")[0].trim();
        }
        if (money.trim().length() == 0 || money.trim().equals("-")) return 0.0D;
        return Double.parseDouble(money);
    }

    public static double moneyValueV1(String money) {
        try {
            return Double.parseDouble(money.replaceAll("[ $]", ""));
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
