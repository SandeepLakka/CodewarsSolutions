package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
Linked Lists - Get Nth

Implement a GetNth() function that takes a linked list and an integer index
and returns the node stored at the Nth index position.
GetNth() uses the C numbering convention that the first node is index 0, the second is index 1, ... and so on.
So for the list 42 -> 13 -> 666, GetNth() with index 1 should return Node(13);

getNth(1 -> 2 -> 3 -> null, 0).data === 1
getNth(1 -> 2 -> 3 -> null, 1).data === 2

The index should be in the range [0..length-1].
If it is not, GetNth() should throw/raise an exception.
You should also raise an exception if the list is empty/null/None.

Inspired by Stanford Professor Nick Parlante's excellent Linked List teachings.

http://cslibrary.stanford.edu/103/LinkedListBasics.pdf
http://cslibrary.stanford.edu/105/LinkedListProblems.pdf

Categories : Fundamentals, Linked Lists, Lists, Data Structures
 */
public class GetNthNode {
    @Test
    public void test2() {
        Node n = new Node();
        n.data = 1337;
        n.next = new Node();
        n.next.data = 42;
        n.next.next = new Node();
        n.next.next.data = 23;

        assertEquals(getNth(n, 0), 1337);
        assertEquals(getNth(n, 1), 42);
        assertEquals(getNth(n, 2), 23);

    }

    @Test
    public void testNull() {
        assertThrows(IllegalArgumentException.class, () -> getNth(null, 0));
    }


    @Test
    public void testWrongIdx() {
        assertThrows(IllegalArgumentException.class, () -> getNth(new Node(), 1));
    }

    public static int getNth(Node n, int index) {
        // WORK HERE
        if (n == null) throw new IllegalArgumentException("Input list must not be null");
        int curIndex = 0;
        while (n != null) {
            if (index == curIndex) {
                return n.data;
            }
            curIndex++;
            n = n.next;
        }
        throw new IllegalArgumentException("Index " + index + " should be within the [0-" + curIndex + "]");
    }

    static class Node {
        public int data;
        public Node next = null;
    }
}
