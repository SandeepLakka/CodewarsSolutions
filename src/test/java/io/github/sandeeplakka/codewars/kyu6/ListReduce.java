package io.github.sandeeplakka.codewars.kyu6;

import io.github.sandeeplakka.codewars.kyu7.Node;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Fun with lists: reduce

Implement the method reduce, which accepts three arguments:

    linked list (head)
    bi-function - (accumulated_value, current_element_data)
    initial value

This method should return the result of applying the given function on every element
with the accumulating result, starting with the initial value.

For example:

Given the list: 1 -> 2 -> 3, the function (acc, curr) => acc + curr
and an initial value of 0, reduce should return 6, because:

    (0, 1) and the function (acc, curr) => acc + curr gives 1
    (1, 2) and the function (acc, curr) => acc + curr gives 3
    (3, 3) and the function (acc, curr) => acc + curr gives 6

Another example:

Given the list: 1 -> 2 -> 3 -> 4, the function (acc, curr) => acc * curr
and an initial value of 1, reduce should return 24

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
class ListReduce {

    //tests
    @Test
    public void basicTests() {
        assertEquals(0, (int) reduce(null, Integer::sum, 0));
        assertEquals(6, (int) reduce(
                new Node<>(1,
                        new Node<>(2,
                                new Node<>(3)
                        )
                ), Integer::sum, 0)
        );
        assertEquals(24, (int) reduce(
                new Node<>(1,
                        new Node<>(2,
                                new Node<>(3,
                                        new Node<>(4)
                                )
                        )
                ), (a, b) -> a * b, 1)
        );
        assertEquals("abc", reduce(
                new Node<>("a",
                        new Node<>("b",
                                new Node<>("c")
                        )
                ), String::concat, "")
        );
    }

    //implementation
    static <T> T reduce(Node<T> head, BiFunction<T, T, T> f, T init) {
        T result = init;
        while (head != null) {
            result = f.apply(result, head.data);
            head = head.next;
        }
        return result;
    }
}