package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
Cat years, Dog years

Kata Task
I have a cat and a dog.
I got them at the same time as kitten/puppy. That was humanYears years ago.
Return their respective ages now as [humanYears,catYears,dogYears]

NOTES:
    humanYears >= 1
    humanYears are whole numbers only
Cat Years
    15 cat years for first year
    +9 cat years for second year
    +4 cat years for each year after that
Dog Years
    15 dog years for first year
    +9 dog years for second year
    +5 dog years for each year after that

References
    http://www.catster.com/cats-101/calculate-cat-age-in-cat-years
    http://www.slate.com/articles/news_and_politics/explainer/2009/05/a_dogs_life.html

Categories : Fundamentals
 */
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