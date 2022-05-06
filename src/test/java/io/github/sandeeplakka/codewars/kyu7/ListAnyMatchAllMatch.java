package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/*
Fun with lists: anyMatch + allMatch

Implement the methods anyMatch (any_match in PHP) & allMatch (all_match in PHP),
which accepts a linked list (head) and a predicate function,
and returns true if any / all of the elements apply to the given predicate.

For example:

Given the list: 1 -> 2 -> 3, and the predicate x => x > 1,
anyMatch / any_match should return true (both 2 & 3 are valid for this predicate),
and allMatch / all_match should return false (1 is not valid for this predicate)

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
Declarative Programming, Higher-order Functions, Functions, Control Flow, Basic Language Features
 */
class ListAnyMatchAllMatch {

    //Tests
    @Test
    public void arrayOfInts() {
        assertTrue(anyMatch(Helpers.listFromArray(1, 2, 3), x -> x > 1));
        assertFalse(allMatch(Helpers.listFromArray(1, 2, 3), x -> x > 1));
    }

    @Test
    public void basicTests() {
        assertFalse(anyMatch(null, __ -> false));
        assertFalse(anyMatch(null, __ -> true));
        assertFalse(anyMatch(Helpers.listFromArray(1, 2, 3), __ -> false));
        assertTrue(anyMatch(Helpers.listFromArray(1, 2, 3), __ -> true));

        assertTrue(allMatch(null, __ -> false));
        assertTrue(allMatch(null, __ -> true));
        assertFalse(allMatch(Helpers.listFromArray(1, 2, 3), __ -> false));
        assertTrue(allMatch(Helpers.listFromArray(1, 2, 3), __ -> true));
    }

    @Test
    public void arrayOfStrings() {
        assertTrue(anyMatch(Helpers.listFromArray("aaa", "b", "abc"), x -> x.contains("a")));
        assertFalse(anyMatch(Helpers.listFromArray("aaa", "b", "abc"), x -> x.indexOf("b") == 3));
        assertTrue(allMatch(Helpers.listFromArray("aaa", "ab", "abc"), x -> x.contains("a")));
        assertFalse(allMatch(Helpers.listFromArray("aaa", "b", "abc"), x -> x.contains("b")));
    }

    //implementation
    static <T> boolean anyMatch(Node<T> head, Predicate<T> p) {
        Node<T> pointer = head;
        while (pointer != null) {
            if (p.test(pointer.data)) return true;
            pointer = pointer.next;
        }
        return false;
    }

    static <T> boolean allMatch(Node<T> head, Predicate<T> p) {
        Node<T> pointer = head;
        while (pointer != null) {
            if (!p.test(pointer.data)) return false;
            pointer = pointer.next;
        }
        return true;
    }
}