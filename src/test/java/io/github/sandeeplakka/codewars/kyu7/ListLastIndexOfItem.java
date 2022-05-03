package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Fun with lists: lastIndexOf

Implement the method lastIndexOf (last_index_of in PHP),
which accepts a linked list (head) and a value, and returns
the index (zero based) of the last occurrence of that value if exists, or -1 otherwise.

For example: Given the list: 1 -> 2 -> 3 -> 3, and the value 3, lastIndexOf / last_index_of should return 3.

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
public class ListLastIndexOfItem {

    @Test
    public void basicTests() {
        assertEquals(-1, lastIndexOf(null, 17));
        assertEquals(1, lastIndexOf(Helpers.listFromArray(1, 2, 3), 2));
        assertEquals(0, lastIndexOf(Helpers.listFromArray("aaa", "b", "abc"), "aaa"));
        assertEquals(0, lastIndexOf(Helpers.listFromArray(17, "17", 1.2), 17));
        assertEquals(1, lastIndexOf(Helpers.listFromArray(17, "17", 1.2), "17"));
        assertEquals(3, lastIndexOf(Helpers.listFromArray(1, 2, 3, 3), 3));
        assertEquals(2, lastIndexOf(Helpers.listFromArray(1, 1, 1), 1));
    }

    @Test
    public void randomTests() {
        assertEquals(-1,
                lastIndexOf(Helpers.listFromArray(-23, 39, 37, 99, 98, 45, -39, -5, 65, -37, -51,
                        -28, -15, -39, 95, 16, -58, -23, 30, 38, -32, -12, -34, -88, -13, 88, 49,
                        -86, -85, 99, 17, -14, 37, -89, 42, -58, -95, -54, 20), -60));

        assertEquals(-1,
                lastIndexOf(Helpers.listFromArray(-21, -67, 45, -24, -93, 8, -20, -97, -95, 30, 7,
                                -47, 82, 73, -79, 90, -1, 44, 73, 70, 35, 78, -39, 22, 81, 40, 61),
                        -48));
        assertEquals(66,
                lastIndexOf(Helpers.listFromArray(84, 22, -65, -72, 29, -77, 76, 62, 45, 17, -15,
                                56, 95, -93, 69, -84, 66, -9, -88, 93, -90, -5, -86, 26, -58, -72, 18, 8,
                                -92, -89, -6, -45, -99, -32, -19, -39, -85, -30, 81, 39, -15, -52, 23, 30,
                                46, 50, -29, 61, -7, 44, 10, -30, 93, 16, 48, -54, 1, 23, -20, -75, -41, 12,
                                88, 32, -74, -31, -48, -38, 87, -4, 94, 24, 41, -9, 80, -36, -31),
                        -48));
        assertEquals(-1,
                lastIndexOf(Helpers.listFromArray(18, -15, 99, 48, 25, -18, 41, 2, -62, 52, 44, 33,
                        -18, -9, 64, -14, -61, 55, -88, -55, 96, -69, 8, -39, 99, -28, -51, -71, 97, -82, -77, 18,
                        50, 81, 83, 38, 22, -74, 54, 19, -40, 53, 59, -44, -51, 19, -47, 16, -55, 64, 2, 92, 23,
                        79, 84, 11, -14, 70, -20, 46, 52, -19, 1, 95, -22, 52, -61, 47, -13, 93, 94, 16,
                        -84, -31, -33, -36, -63, -10, 65, 20, 73, 78), -58));
        assertEquals(-1,
                lastIndexOf(Helpers.listFromArray(-18, -13, 64, -43, 79, 43, 33, 54, 39, 84, -71, -40,
                        -62, 29, -93, -40, -51, 35, -88, -51, 10, 88, 66, 70, 95), -31));
    }

    static <T> int lastIndexOf(Node<T> head, T value) {
        int index = -1;
        int returnIndex = -1;
        while (head != null) {
            index++;
            if (head.data.equals(value)) {
                returnIndex = index;
            }
            head = head.next;
        }
        return returnIndex;
    }
}
