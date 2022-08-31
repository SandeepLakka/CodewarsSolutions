package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HexTests {
    @Test
    public void SampleTests() {
        Hex FF = new Hex(255);
        assertEquals("0xFF", FF.toString());
        assertEquals(256, FF.valueOf() + 1);
        assertEquals("0xFF", FF.toJSON());
        assertEquals(FF, new Hex(255));
        assertEquals("0xFE", FF.minus(1).toString());
        assertEquals("0x0", FF.minus(FF).toString());
        assertEquals("0xF", new Hex(10).plus(5).toString());
        assertEquals(32, Hex.parse("0x20"));
        assertEquals(512, Hex.parse("200"));

    }
}

//TODO write efficient approach of dealing with Hex codes
public class Hex {

    private final String hexCode;
    private final static int HEX_RADIX = 16;

    public Hex(int value) {
        this.hexCode = "0x" + Integer.toString(value, HEX_RADIX).toUpperCase();
    }

    public int valueOf() {
        String val = this.hexCode.substring(2);
        return Integer.valueOf(val, HEX_RADIX);
    }

    public String toJSON() {
        return this.toString();
    }

    public String toString() {
        return this.hexCode;
    }

    public Hex plus(Hex other) {
        int result = other.valueOf();
        result += this.valueOf();
        return new Hex(result);
    }

    public Hex minus(Hex other) {
        int result = other.valueOf();
        result -= this.valueOf();
        return new Hex(result);
    }

    public Hex plus(int number) {
        return new Hex(this.valueOf() + number);
    }

    public Hex minus(int number) {
        return new Hex(this.valueOf() - number);
    }

    public static int parse(String string) {
        String val = string.startsWith("0x") ? string.substring(2) : string;
        return Integer.parseInt(val, HEX_RADIX);
    }

    public boolean equals(Object other) {
        if (other == null) return false;
        if (!(other instanceof Hex)) return false;
        return ((Hex) other).valueOf() == this.valueOf();
    }
}