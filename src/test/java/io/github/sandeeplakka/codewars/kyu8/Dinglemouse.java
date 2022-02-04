package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Dinglemouse {

    @Test
    public void one() {
        assertArrayEquals(new int[]{1, 15, 15}, Dinglemouse.humanYearsCatYearsDogYears(1));
        assertArrayEquals(new int[]{1, 15, 15}, Dinglemouse.humanYearsCatYearsDogYearsV1(1));
        assertArrayEquals(new int[]{1, 15, 15}, Dinglemouse.humanYearsCatYearsDogYearsV2(1));
    }

    @Test
    public void two() {
        assertArrayEquals(new int[]{1, 15, 15}, Dinglemouse.humanYearsCatYearsDogYears(1));
        assertArrayEquals(new int[]{1, 15, 15}, Dinglemouse.humanYearsCatYearsDogYearsV1(1));
        assertArrayEquals(new int[]{1, 15, 15}, Dinglemouse.humanYearsCatYearsDogYearsV2(1));
    }

    @Test
    public void ten() {
        assertArrayEquals(new int[]{1, 15, 15}, Dinglemouse.humanYearsCatYearsDogYears(1));
        assertArrayEquals(new int[]{1, 15, 15}, Dinglemouse.humanYearsCatYearsDogYearsV1(1));
        assertArrayEquals(new int[]{1, 15, 15}, Dinglemouse.humanYearsCatYearsDogYearsV2(1));
    }

    public static int[] humanYearsCatYearsDogYears(final int humanYears) {
        // Your code here!
        switch (humanYears) {
            case 1:
                return new int[]{1, 15, 15};
            case 2:
                return new int[]{2, 24, 24};
            default:
                return new int[]{humanYears, 24 + (humanYears - 2) * 4, 24 + (humanYears - 2) * 5};
        }
    }

    public static int[] humanYearsCatYearsDogYearsV1(final int humanYears) {
        // Your code here!
        int catYears = 0;
        int dogYears = 0;
        switch (humanYears) {
            default:
                catYears += (humanYears - 2) * 4;
                dogYears += (humanYears - 2) * 5;
            case 2:
                catYears += 9;
                dogYears += 9;
            case 1:
                catYears += 15;
                dogYears += 15;
        }
        return new int[]{humanYears, catYears, dogYears};
    }

    public static int[] humanYearsCatYearsDogYearsV2(final int humanYears) {
        return new int[]{
                humanYears,
                humanYears == 1 ? 15 : 16 + 4 * humanYears,
                humanYears == 1 ? 15 : 14 + 5 * humanYears
        };
    }

}