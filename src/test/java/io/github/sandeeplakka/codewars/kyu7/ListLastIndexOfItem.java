package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListLastIndexOfItem {

    @Test
    public void basicTests() {
        assertEquals(-1, lastIndexOf(null, 17));
        assertEquals(1, lastIndexOf(Helpers.listFromArray(1, 2, 3), 2));
        assertEquals(0, lastIndexOf(Helpers.listFromArray("aaa", "b", "abc"), "aaa"));
        assertEquals(0, lastIndexOf(Helpers.listFromArray(17, "17", 1.2), 17));
        assertEquals(1, lastIndexOf(Helpers.listFromArray(17, "17", 1.2), "17"));
        assertEquals(3, lastIndexOf(Helpers.listFromArray(1, 2, 3, 3), 3));
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
