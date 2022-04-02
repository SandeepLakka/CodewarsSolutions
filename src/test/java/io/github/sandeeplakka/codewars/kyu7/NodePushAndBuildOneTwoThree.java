package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/*
Linked Lists - Push & BuildOneTwoThree

Write push() and buildOneTwoThree() functions to easily update and initialize linked lists. Try to use the push() function within your buildOneTwoThree() function.

Here's an example of push() usage:

var chained = null
chained = push(chained, 3)
chained = push(chained, 2)
chained = push(chained, 1)
push(chained, 8) === 8 -> 1 -> 2 -> 3 -> null

The push function accepts head and data parameters, where head is either a node object or null/None/nil. Your push implementation should be able to create a new linked list/node when head is null/None/nil.

The buildOneTwoThree function should create and return a linked list with three nodes: 1 -> 2 -> 3 -> null

Categories : Fundamentals, Linked Lists, Lists, Data Structures

 */
public class NodePushAndBuildOneTwoThree {

    @Test
    public void testPush() {
        assertEquals(1, push(null, 1).data, "Should be able to create a new linked list with push().");
        assertNull(push(null, 1).next, "Should be able to create a new linked list with push().");
        assertEquals(2, push(new Node(1), 2).data, "Should be able to prepend a node to an existing node.");
        assertEquals(1, push(new Node(1), 2).next.data, "Should be able to prepend a node to an existing node.");
    }

    @Test
    public void testBuild123() {
        // tests for building a linked list.
        assertEquals(1, buildOneTwoThree().data, "Value at index 0 should be 1.");
        assertEquals(2, buildOneTwoThree().next.data, "Value at index 1 should be 2.");
        assertEquals(3, buildOneTwoThree().next.next.data, "Value at index 2 should be 3.");
        assertNull(buildOneTwoThree().next.next.next, "Value at index 3 should be null.");
    }

    public static Node push(final Node head, final int data) {
        return Optional.ofNullable(head)
                .map(node -> {
                    Node curNode = new Node(data);
                    curNode.next = node;
                    return curNode;
                })
                .orElse(new Node(data));
    }

    public static Node buildOneTwoThree() {
        Node head = null;
        for (int i = 3; i > 0; i--) {
            head = push(head, i);
        }
        return head;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
