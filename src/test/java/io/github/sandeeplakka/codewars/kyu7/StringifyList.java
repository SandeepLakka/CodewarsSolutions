package com.example.kyu5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringifyList {

    @Test
    public void sampleTests() {
        assertEquals("1 -> 2 -> 3 -> null", stringify(new Node(1, new Node(2, new Node(3)))));
        assertEquals("0 -> 1 -> 4 -> 9 -> 16 -> null", stringify(new Node(0, new Node(1, new Node(4, new Node(9, new Node(16)))))));
        assertEquals("null", stringify(null));
    }

    public static String stringify(Node list) {
        List<String> result = new ArrayList<>();
        while (list != null){
            result.add(list.getData()+"");
            list = list.getNext();
        }
        result.add("null");

        return String.join(" -> ",result);
    }

}

class Node {
    private int data;
    private Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}
