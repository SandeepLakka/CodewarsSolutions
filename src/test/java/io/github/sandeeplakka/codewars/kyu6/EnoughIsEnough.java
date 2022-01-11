package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
Enough is enough!

Alice and Bob were on a holiday.
Both of them took many pictures of the places they've been,
and now they want to show Charlie their entire collection.
However, Charlie doesn't like these sessions, since the motive usually repeats.
He isn't fond of seeing the Eiffel tower 40 times.
He tells them that he will only sit during the session if they show the same motive at most N times.
Luckily, Alice and Bob are able to encode the motive as a number.
Can you help them to remove numbers such that their list contains each number only up to N times,
without changing the order?
Task

Given a list lst and a number N,
create a new list that contains each number of lst at most N times without reordering.
For example if N = 2, and the input is [1,2,3,1,2,1,2,3],
you take [1,2,3,1,2], drop the next [1,2] since this would lead to 1 and 2 being in the result 3 times,
and then take 3, which leads to [1,2,3,1,2,3].

Examples

deleteNth(new int[] {20,37,20,21}, 1) // return [20,37,21]
deleteNth(new int[] {1,1,3,3,7,2,2,2,2}, 3) // return [1, 1, 3, 3, 7, 2, 2, 2]

Categories : Fundamentals, Lists, Data Structures

 */
public class EnoughIsEnough {

    @Test
    public void tests() {
        assertArrayEquals(new int[]{20, 37, 21},
                deleteNth(new int[]{20, 37, 20, 21}, 1));
        assertArrayEquals(new int[]{1, 1, 3, 3, 7, 2, 2, 2},
                deleteNth(new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2}, 3));
        assertArrayEquals(new int[]{},
                deleteNth(new int[]{1, 2, 3, 4, 5, 6, 7}, 0));
        assertArrayEquals(new int[]{20, 37, 21},
                deleteNth(new int[]{20, 37, 20, 21}, 1));
        assertArrayEquals(new int[]{1, 1, 3, 3, 7, 2, 2, 2},
                deleteNth(new int[]{1, 1, 3, 3, 7, 2, 2, 2, 2}, 3));
        assertArrayEquals(new int[]{1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5},
                deleteNth(new int[]{1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1}, 3));
        assertArrayEquals(new int[]{1, 1, 1, 1, 1},
                deleteNth(new int[]{1, 1, 1, 1, 1}, 5));
        assertArrayEquals(new int[]{}, deleteNth(new int[]{}, 5));
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        Map<Integer, Integer> counts = new LinkedHashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int elem : elements) {
            if (counts.getOrDefault(elem, 0) < maxOccurrences) {
                counts.put(elem, counts.getOrDefault(elem, 0) + 1);
                list.add(elem);
            }
        }
//		for(int elem : elements){
//			if (counts.containsKey(elem)){
//				list.add(elem);
//				counts.put(elem,counts.get(elem)-1);
//				if(counts.get(elem)==0) counts.remove(elem);
//			}
//		}

//		System.out.println(
//				String.format("--------------\n# Map : %s\n# List : %s\n# K : %d\n--------------------",
//						counts,list,maxOccurrences));
        return list.stream().flatMapToInt(integer -> IntStream.of(integer.intValue())).toArray();
    }

}