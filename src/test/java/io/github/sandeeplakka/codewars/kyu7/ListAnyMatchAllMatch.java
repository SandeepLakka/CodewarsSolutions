package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ListAnyMatchAllMatch {

    //Tests
    @Test
    public void basicTests() {
        assertFalse(anyMatch(null, __ -> false));
        assertFalse(anyMatch(null, __ -> true));
        assertTrue(allMatch(null, __ -> false));
        assertTrue(allMatch(null, __ -> true));
    }

    @Test
    public void arrayOfInts() {
        assertTrue(anyMatch(Helpers.listFromArray(1, 2, 3), x -> x > 1));
        assertFalse(allMatch(Helpers.listFromArray(1, 2, 3), x -> x > 1));
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