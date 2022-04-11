package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    }

    public static double moneyValue(String money) {
        money = money.trim();
        if (money.contains("$")) {
            money = money.replaceAll("\\s*\\$\\s*", "").split("\\s")[0].trim();
        }
        if (money.trim().length() == 0 || money.trim().equals("-")) return 0.0D;
        return Double.parseDouble(money);
    }
}
