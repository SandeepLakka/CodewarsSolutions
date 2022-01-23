package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperMarketQueue {

    @Test
    public void testNormalCondition() {
        assertEquals(9, solveSuperMarketQueue(new int[]{2, 2, 3, 3, 4, 4}, 2));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(0, solveSuperMarketQueue(new int[]{}, 1));
    }

    @Test
    public void testSingleTillManyCustomers() {
        assertEquals(15, solveSuperMarketQueue(new int[]{1, 2, 3, 4, 5}, 1));
    }

    @Test
    public void testBigSize() {
        assertEquals(113, solveSuperMarketQueue(new int[]{29, 18, 6, 23, 25, 29, 24, 17, 10, 8, 8, 22,
                20, 16, 13, 17, 7, 21, 7, 11, 18, 26, 25, 1, 18, 29, 16, 26,
                7, 11, 13, 20, 12, 6, 23, 3, 10, 9, 8, 5, 6, 18, 19, 26, 5, 15, 4, 15, 1, 4}, 7));
    }


    @Test
    public void testNormalConditionWithPQ() {
        assertEquals(9, solveSuperMarketQueueUsingPriorityQueue(new int[]{2, 2, 3, 3, 4, 4}, 2));
    }

    @Test
    public void testEmptyArrayWithPQ() {
        assertEquals(0, solveSuperMarketQueueUsingPriorityQueue(new int[]{}, 1));
    }

    @Test
    public void testSingleTillManyCustomersWithPQ() {
        assertEquals(15, solveSuperMarketQueueUsingPriorityQueue(new int[]{1, 2, 3, 4, 5}, 1));
    }

    @Test
    public void testBigSizeWithPQ() {
        assertEquals(113, solveSuperMarketQueue(new int[]{29, 18, 6, 23, 25, 29, 24, 17, 10, 8, 8, 22,
                20, 16, 13, 17, 7, 21, 7, 11, 18, 26, 25, 1, 18, 29, 16, 26,
                7, 11, 13, 20, 12, 6, 23, 3, 10, 9, 8, 5, 6, 18, 19, 26, 5, 15, 4, 15, 1, 4}, 7));
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        int[] queues = new int[n];
        for (int i = 0; i < customers.length; i++) {
            int minValue = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int j = 0; j < n; j++) {
                if (queues[j] < minValue) {
                    minValue = queues[j];
                    minIdx = j;
                }
            }
            queues[minIdx] += customers[i];
        }
        return Arrays.stream(queues).max().getAsInt();
    }

    //better using heap/priority Queues
    public int solveSuperMarketQueueUsingPriorityQueue(int[] customers, int n) {
        //Adding queues with initial values of zero
        //Default PQ which has natural sorting order  : minHeap : Minimum element at the top
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.nCopies(n, 0));
        //For each customer, add fresh customer waiting time to the minimum value node in queue
        for (int customerTime : customers) {
            queue.add(queue.poll() + customerTime);
        }
        //Get the node with maximum value, this can be either fetched by polling PQ n times
        //when n is the input till size. or we can use Collections to find out max elem of PQ
        return Collections.max(queue);
    }

}