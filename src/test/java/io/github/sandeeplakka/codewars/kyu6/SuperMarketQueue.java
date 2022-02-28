package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
The Supermarket Queue

There is a queue for the self-checkout tills at the supermarket.
Your task is write a function to calculate the total time required for all the customers to check out!
input

    customers: an array of positive integers representing the queue.
    Each integer represents a customer, and its value is the amount of time they require to check out.
    n: a positive integer, the number of checkout tills.

output

The function should return an integer, the total time required.
Important

Please look at the examples and clarifications below, to ensure you understand the task correctly :)
Examples

queueTime([5,3,4], 1)
// should return 12
// because when there is 1 till, the total time is just the sum of the times

queueTime([10,2,3,3], 2)
// should return 10
// because here n=2 and the 2nd, 3rd, and 4th people in the
// queue finish before the 1st person has finished.

queueTime([2,3,10], 2)
// should return 12

Clarifications

    There is only ONE queue serving many tills, and
    The order of the queue NEVER changes, and
    The front person in the queue (i.e. the first element in the array/list)
    proceeds to a till as soon as it becomes free.

N.B. You should assume that all the test input will be valid, as specified above.

P.S. The situation in this kata can be likened to the more-computer-science-related
idea of a thread pool, with relation to running multiple processes at the same time:
https://en.wikipedia.org/wiki/Thread_pool

Categories : Fundamentals, Arrays, Loops, Control Flow, Basic Language Features
 */
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
        for (int customer : customers) {
            int minValue = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int j = 0; j < n; j++) {
                if (queues[j] < minValue) {
                    minValue = queues[j];
                    minIdx = j;
                }
            }
            queues[minIdx] += customer;
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