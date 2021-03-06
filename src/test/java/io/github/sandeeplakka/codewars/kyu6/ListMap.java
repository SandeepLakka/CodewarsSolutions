package io.github.sandeeplakka.codewars.kyu6;

import io.github.sandeeplakka.codewars.kyu7.Node;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
Fun with lists: map

Implement the method map, which accepts a linked list (head) and a mapping function,
and returns a new linked list (head) where every element is the
result of applying the given mapping method to each element of the original list.

For example: Given the list: 1 -> 2 -> 3,
and the mapping function x => x * 2, map should return 2 -> 4 -> 6

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
class ListMap {

    //tests
    @Test
    public void basicTests() {
        testMap(null, __ -> false, null);

        testMap(new Node<>(1, new Node<>(2, new Node<>(3))),
                x -> x,
                new Node<>(1, new Node<>(2, new Node<>(3))));

        Function<Integer, Integer> f = x -> x * 2;
        testMap(new Node<>(1, new Node<>(2, new Node<>(3))),
                f,
                new Node<>(2, new Node<>(4, new Node<>(6))));
    }

    @Test
    public void moreTests() {
        Function<Integer, Integer> f1 = x -> x + 3;
        testMap(new Node<>(1, new Node<>(2, new Node<>(3))),
                f1,
                new Node<>(4, new Node<>(5, new Node<>(6))));

        Function<Integer, Boolean> f2 = x -> x > 1;
        testMap(new Node<>(1, new Node<>(2, new Node<>(3))),
                f2,
                new Node<>(false, new Node<>(true, new Node<>(true))));

        Function<String, String> f3 = x -> x + "x";
        testMap(new Node<>("aaa", new Node<>("b", new Node<>("abc"))),
                f3,
                new Node<>("aaax", new Node<>("bx", new Node<>("abcx"))));
    }

    @Test
    public void basicTests_for_recursiveSolution() {
        testMapRecur(null, __ -> false, null);

        testMapRecur(new Node<>(1, new Node<>(2, new Node<>(3))),
                x -> x,
                new Node<>(1, new Node<>(2, new Node<>(3))));

        Function<Integer, Integer> f = x -> x * 2;
        testMapRecur(new Node<>(1, new Node<>(2, new Node<>(3))),
                f,
                new Node<>(2, new Node<>(4, new Node<>(6))));
    }

    @Test
    public void moreTests_for_recursiveSolution() {
        Function<Integer, Integer> f1 = x -> x + 3;
        testMapRecur(new Node<>(1, new Node<>(2, new Node<>(3))),
                f1,
                new Node<>(4, new Node<>(5, new Node<>(6))));

        Function<Integer, Boolean> f2 = x -> x > 1;
        testMapRecur(new Node<>(1, new Node<>(2, new Node<>(3))),
                f2,
                new Node<>(false, new Node<>(true, new Node<>(true))));

        Function<String, String> f3 = x -> x + "x";
        testMapRecur(new Node<>("aaa", new Node<>("b", new Node<>("abc"))),
                f3,
                new Node<>("aaax", new Node<>("bx", new Node<>("abcx"))));
    }


    private static <T, R> void testMap(Node<T> head, Function<T, R> f, Node<R> expected) {
        assertArrayEquals(listToArray(expected), listToArray(map(head, f)));
    }

    private static <T, R> void testMapRecur(Node<T> head, Function<T, R> f, Node<R> expected) {
        assertArrayEquals(listToArray(expected), listToArray(mapRecur(head, f)));
    }

    private static <T> Object[] listToArray(Node<T> head) {
        Collection<T> values = new LinkedList<>();
        for (; head != null; head = head.next) values.add(head.data);
        return values.toArray();
    }

    //implementation
    static <T, R> Node<R> map(Node<T> head, Function<T, R> f) {
        Node<R> returnHead = null;
        Node<R> pointer = null;
        while (head != null) {
            if (returnHead == null) {
                returnHead = new Node<>(f.apply(head.data));
                pointer = returnHead;
            } else {
                pointer.next = new Node<>(f.apply(head.data));
                pointer = pointer.next;
            }

            head = head.next;
        }
        return returnHead;
    }

    //Recursive approach
    static <T, R> Node<R> mapRecur(Node<T> head, Function<T, R> f) {
        return (head == null) ? null : new Node<>(f.apply(head.data), mapRecur(head.next, f));
    }
}