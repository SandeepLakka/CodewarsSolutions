package io.github.sandeeplakka.codewars.kyu6;

import io.github.sandeeplakka.codewars.kyu7.Helpers;
import io.github.sandeeplakka.codewars.kyu7.Node;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

/*
Fun with lists: filter

Implement the method filter, which accepts a linked list (head) and a predicate function,
and returns a new linked list (head) which only contains the elements which apply to the given predicate.

For example: Given the list: 1 -> 2 -> 3, and the predicate x => x >= 2,
filter should return 2 -> 3, since x >= 2 applies to both 2 and 3.

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
class ListFilter {

    //Tests
    @Test
    public void basicTests() {
        Helpers.testFilter(filter(null, __ -> false), null);
        Helpers.testFilter(
                filter(new Node<>(1, new Node<>(2, new Node<>(3))), x -> true),
                new Node<>(1, new Node<>(2, new Node<>(3))));
    }

    @Test
    public void arrayOfInts() {
        Helpers.testFilter(
                filter(new Node<>(1, new Node<>(2, new Node<>(3))), x -> x <= 2),
                new Node<>(1, new Node<>(2)));
        Helpers.testFilter(
                filter(new Node<>(1, new Node<>(2, new Node<>(3))), x -> x == 1),
                new Node<>(1));
    }

    //implementation
    static <T> Node<T> filter(Node<T> head, Predicate<T> p) {
        Node<T> returnHead = null, pointer = null;
        while (head != null) {

            if (p.test(head.data)) {
                if (returnHead == null) {
                    returnHead = new Node<>(head.data);
                    pointer = returnHead;
                } else {
                    pointer.next = new Node<>(head.data);
                    pointer = pointer.next;
                }
            }

            head = head.next;
        }
        return returnHead;
    }
}