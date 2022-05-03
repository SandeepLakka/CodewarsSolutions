package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static io.github.sandeeplakka.codewars.kyu7.Helpers.listFromArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Fun with lists: length

Description:
Implement the method length, which accepts a linked list (head),
and returns the length of the list.
For example: Given the list: 1 -> 2 -> 3 -> 4, length should return 4.

The linked list is defined as follows:

class Node {
  public Object data;
  public Node next;

  Node(T data, Node next) {
    this.data = data;
    this.next = next;
  }

  Node(T data) {
    this(data, null);
  }
}

Note: the list may be null and can hold any type of value.
Good luck!

Categories : Fundamentals, Lists, Data Structures
 */
public class ListLength {
    @Test
    public void basicTestsForIterativeSolution() {
        assertEquals(0, lengthIterative(null));
        assertEquals(3, lengthIterative(listFromArray(1, 2, 3)));
        assertEquals(3, lengthIterative(listFromArray("aaa", "b", "abc")));
        assertEquals(4, lengthIterative(listFromArray(1, 2, 3, 4)));
    }

    @Test
    public void basicTestForRecursiveSolution() {
        assertEquals(0, lengthRecur(null));
        assertEquals(3, lengthRecur(listFromArray(1, 2, 3)));
        assertEquals(3, lengthRecur(listFromArray("aaa", "b", "abc")));
        assertEquals(4, lengthRecur(listFromArray(1, 2, 3, 4)));
    }

    static <T> int lengthIterative(Node<T> head) {
        if (head == null) return 0;
        int length = 1;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    static <T> int lengthRecur(Node<T> head) {
        if (head == null) return 0;
        return 1 + lengthRecur(head.next);
    }
}


//helper and support code
class Helpers {
    public static <T> Node<T> listFromArray(T... arr) {
        Node<T> pointer = new Node<>(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            T val = arr[i];
            Node<T> curNode = new Node<>(val);
            Node<T> last = pointer;
            while (last.next != null) {
                last = last.next;
            }
            last.next = curNode;
        }
        return pointer;
    }
}

class Node<T> {
    public T data;
    public Node<T> next;

    Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    Node(T data) {
        this(data, null);
    }
}