package io.github.sandeeplakka.codewars.kyu6;

import io.github.sandeeplakka.codewars.kyu7.Helpers;
import io.github.sandeeplakka.codewars.kyu7.Node;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Fun with lists: countIf

Implement the method countIf (count_if in PHP),
which accepts a linked list (head) and a predicate function,
and returns the number of elements which apply to the given predicate.

For example: Given the list: 1 -> 2 -> 3,
and the predicate x => x >= 2, countIf / count_if should return 2,
since x >= 2 applies to both 2 and 3.

The linked list is defined as follows:

    class Node<T> {
      public T data;
      public Node<T> next;

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

Categories : Fundamentals, Lists, Data Structures, Functional Programming
Declarative Programming, Higher-order Functions, Functions, Control Flow
Basic Language Features
 */
class ListCountIf {
    @Test
    public void basicTests() {
        assertEquals(0, countIf(null, __ -> false));
        assertEquals(3, countIf(Helpers.listFromArray(1, 2, 3), __ -> true));
    }

    @Test
    public void arrayOfInts() {
        assertEquals(2, countIf(Helpers.listFromArray(1, 2, 3), x -> x <= 2));
    }

    static <T> int countIf(Node<T> head, Predicate<T> p) {
        int count = 0;
        while (head != null) {
            if (p.test(head.data)) {
                count++;
            }
            head = head.next;
        }
        return count;
    }
}