package io.github.sandeeplakka.codewars.kyu7;

import java.util.Collection;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//helper and support code
public class Helpers {
    @SafeVarargs
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

    public static <T> void testFilter(Node<T> output, Node<T> expected) {
        assertArrayEquals(listToArray(expected), listToArray(output));
    }

    private static <T> Object[] listToArray(Node<T> head) {
        Collection<T> values = new LinkedList<>();
        for (; head != null; head = head.next) values.add(head.data);
        return values.toArray();
    }
}
