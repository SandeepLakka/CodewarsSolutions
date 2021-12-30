package io.github.sandeeplakka.codewars.kyu5;

import java.util.HashMap;
import java.util.Map;

/*
 *
 * You are given a node that is the beginning of a linked list. This list always contains a tail and a loop. Your objective is to determine the length of the loop.
 *
 * Note: Use the `getNext()` method to get the following node.
 *       node.getNext()
 *
 * Categories : Algorithms, Hacking Holidays
 */
public class CanYouGetTheLoop {



    interface Node {
        Node getNext();
    }

    //Can be done more cleverly, but this is the logic that I had to solve this fast
    public int loopSize(Node node) {
        Map<Integer,Integer> list = new HashMap<>();
        Node next = node;
        while(next.getNext() != null){
            list.put(next.hashCode(), list.getOrDefault(next.hashCode(), 0)+1);
            if(list.values().stream().filter(integer -> integer == 2)
                    .findAny().isPresent()) break;
            next = next.getNext();
        }

        Node start = node;
        int startCode  = list.entrySet().stream().filter(entry -> entry.getValue() == 2)
                .findFirst().get().getKey().intValue();

        while(start.hashCode() != startCode){
            start = start.getNext();
        }

        Node nextNode = start.getNext();
        int count = 1;
        while(nextNode != start){
            count++;
            nextNode = nextNode.getNext();
        }
        return count;
    }

}
