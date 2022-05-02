package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Fun with lists: indexOf

Implement the method indexOf (index_of in PHP), which accepts a linked list (head) and a value,
and returns the index (zero based) of the first occurrence of that value if exists, or -1 otherwise.
For example: Given the list: 1 -> 2 -> 3 -> 3, and the value 3, indexOf / index_of should return 2.
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
public class ListIndexOfItem {

    @Test
    public void basicTests() {
        assertEquals(-1, indexOf(null, 17));
        assertEquals(1, indexOf(listFromArray(1, 2, 3), 2));
        assertEquals(0, indexOf(listFromArray("aaa", "b", "abc"), "aaa"));
        assertEquals(0, indexOf(listFromArray(17, "17", 1.2), 17));
        assertEquals(1, indexOf(listFromArray(17, "17", 1.2), "17"));
        assertEquals(2, indexOf(listFromArray(1, 2, 3, 3), 3));
    }

    @Test
    public void moreTests() {
        Node<Integer> head = listFromArray(66, 30, -68, 86, 99, 90, 34, 70, -3, -7, -49, -9, -18, -29, 51,
                60, 22, -32, 66, 1, 6, -87, 40, -8, 79, 57, 29, 77, -97, 64, 76, -46, 7, 13, -91, -64, -48, -4,
                -46, -85, -5, -29, 31, -80, 7, -99, -14, 61, 53, -6, -70, 21, -32, -36, -83, -72, 33, -19, -23,
                43, 94, -38, 67, 24, -46, -74, 22, 5, -24, -44, -60, 81, 81, 46, -72, 1, -19, -29, -5, -58, -98,
                32, 29, 87, 96, -34, -28, -69, 20, -85, 32, -45, 4, 96, -41, -64, 1, 15, 12, -39);
        assertEquals(99, indexOf(head, -10));

        head = listFromArray(-1, 38, -80, -29, 93, 37, -4, 54, -52, -82, -80, 45, 48, -85, -28, -30,
                93, 71, -30, 88, 50, -39, 28, 41, -19, 10, -4, 67, 43, -56, -93, -91, 58, 43, 74, -33, -67, 44, -18,
                -65, -85, 86, -60, 80, -12, -60, 97, 29, -87, -6, 60, 36, 79, 32, -61, -59, 16, 97, -81, 9, -82, 34,
                5, -32, -100, -35, 41, 43, -45, -3, -39, 80, 94, 92, 43, -77, -45, -63, -20, -95, 87, -67, -34, -40,
                36, 76, 37, -69, -71, -39, 15, -86, -25, 49, -50, 53);
        assertEquals(95, indexOf(head, -64));
    }


    //implementation

    static <T> int indexOf(Node<T> head, T value) {
        int index = -1;
        while (head != null) {
            index++;
            if (head.data.equals(value)) return index;
            head = head.next;
        }
        return index;
    }


    // helper and given code

    static class Node<T> {
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

    private <T> Node<T> listFromArray(T... items) {
        Node<T> head = new Node<>(items[0]);
        Node<T> linkHead = head;
        for (int i = 1; i < items.length; i++) {
            head.next = new Node<>(items[i]);
            head = head.next;
        }
        return linkHead;
    }
}
