package com.example.kyu5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Convert a linked list to a string

Task

Create a function stringify which accepts an argument list and returns a string representation of the list. 
The string representation of the list starts with the value of the current Node, specified by its data property, 
followed by a whitespace character, an arrow and another whitespace character (" -> "), followed by the rest of the list. 
The end of the string representation of a list must always end with null. 

For example, given the following list:

`new Node(1, new Node(2, new Node(3)))`

its string representation would be: `"1 -> 2 -> 3 -> null"`

Note that null itself is also considered a valid linked list. 
In that case, its string representation would simply be "null".

For the simplicity of this Kata, you may assume that any Node in this Kata may only contain non-negative integer values. 
For example, you will not encounter a Node whose data is "Hello World".


Categories: Linked Lists, Recursion, Algorithms
*/
public class StringifyList {

    @Test
    public void sampleTests() {
        assertEquals("1 -> 2 -> 3 -> null", stringify(new Node(1, new Node(2, new Node(3)))));
        assertEquals("0 -> 1 -> 4 -> 9 -> 16 -> null", stringify(new Node(0, new Node(1, new Node(4, new Node(9, new Node(16)))))));
        assertEquals("null", stringify(null));
    }

    @Test
    public void fixedTest() {
        assertEquals("23 -> null", stringify(new Node(23)));
        assertEquals("4 -> 25 -> null", stringify(new Node(4, new Node(25))));
        assertEquals("1 -> 3 -> 6 -> 10 -> 15 -> 21 -> 28 -> 36 -> 45 -> 55 -> null", stringify(new Node(1, new Node(3, new Node(6, new Node(10, new Node(15, new Node(21, new Node(28, new Node(36, new Node(45, new Node(55))))))))))));
        assertEquals("1 -> 1 -> 2 -> 3 -> 5 -> 8 -> 13 -> null", stringify(new Node(1, new Node(1, new Node(2, new Node(3, new Node(5, new Node(8, new Node(13)))))))));
        assertEquals("0 -> 1 -> 1 -> 2 -> 3 -> 5 -> 8 -> 13 -> 21 -> 34 -> 55 -> 89 -> 144 -> 233 -> 377 -> 610 -> 987 -> 1597 -> null", stringify(new Node(0, new Node(1, new Node(1, new Node(2, new Node(3, new Node(5, new Node(8, new Node(13, new Node(21, new Node(34, new Node(55, new Node(89, new Node(144, new Node(233, new Node(377, new Node(610, new Node(987, new Node(1597))))))))))))))))))));
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
