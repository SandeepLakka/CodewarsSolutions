package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Find Mean

Find the mean (average) of a list of numbers in an array.
Information

To find the mean (average) of a set of numbers add all of the numbers together and divide by the number of values in the list.

For an example list of 1, 3, 5, 7

1. Add all of the numbers
1+3+5+7 = 16

2. Divide by the number of values in the list. In this example there are 4 numbers in the list.
16/4 = 4

3. The mean (or average) of this list is 4

Categories : Arrays, Lists, Fundamentals
*/
public class GrassHopperMeaner {
  @Test
  public void test1() {
    assertEquals(1, findAverage(new int[]{1}));
  }

  @Test
  public void test2() {
    assertEquals(4, findAverage(new int[]{1, 3, 5, 7}));
  }

  @Test
  public void test3() {
    assertEquals(-5, findAverage(new int[]{-10,-5,-5,0}));
  }
  @Test
  public void test4() {
    assertEquals(0, findAverage(new int[]{0}));
  }
  @Test
  public void test5() {
    Random rand = new Random();
    int[] arr = new int[50];
    int sum = 0;
    for (int i = 0; i < 50; ++i) {
        arr[i] = rand.nextInt(100)+1;
        sum += arr[i];
    }
    assertEquals(sum/50, findAverage(arr));
  }
  public static int findAverage(int[] nums) {
    IntSummaryStatistics stats = IntStream.of(nums).summaryStatistics();
    return (int)(stats.getSum()/stats.getCount());
  }

  public static double findAverageV1(int[] nums) {
    return IntStream.of(nums).summaryStatistics().getAverage();
  }
  
}
