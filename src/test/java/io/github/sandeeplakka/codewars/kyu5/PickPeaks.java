package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PickPeaks {


    private static String[] msg = {"should support finding peaks",
            "should support finding peaks, but should ignore peaks on the edge of the array",
            "should support finding peaks; if the peak is a plateau, it should only return the position of the first element of the plateau",
            "should support finding peaks; if the peak is a plateau, it should only return the position of the first element of the plateau",
            "should support finding peaks, but should ignore peaks on the edge of the array",
            "should support finding peaks, but should ignore peaks on the edge of the array",
            "should support finding peaks, despite the plateau",
            "should support finding peaks",
            "should return an object with empty arrays if the input is an empty array",
            "should return an object with empty arrays if the input does not contain any peak"};

    private static int[][] array = {{1, 2, 3, 6, 4, 1, 2, 3, 2, 1},
            {3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 3},
            {3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 2, 2, 1},
            {2, 1, 3, 1, 2, 2, 2, 2, 1},
            {2, 1, 3, 1, 2, 2, 2, 2},
            {2, 1, 3, 2, 2, 2, 2, 5, 6},
            {2, 1, 3, 2, 2, 2, 2, 1},
            {1, 2, 5, 4, 3, 2, 3, 6, 4, 1, 2, 3, 3, 4, 5, 3, 2, 1, 2, 3, 5, 5, 4, 3},
            {},
            {1, 1, 1, 1}};

    private static int[][] posS = {{3, 7},
            {3, 7},
            {3, 7, 10},
            {2, 4},
            {2},
            {2},
            {2},
            {2, 7, 14, 20},
            {},
            {}};

    private static int[][] peaksS = {{6, 3},
            {6, 3},
            {6, 3, 2},
            {3, 2},
            {3},
            {3},
            {3},
            {5, 6, 5, 5},
            {},
            {}};

    @Test
    public void sampleTests() {
        for (int n = 0; n < 5; n++) {
            final int[] p1 = posS[n], p2 = peaksS[n];
            Map<String, List<Integer>> expected = new HashMap<String, List<Integer>>() {{
                put("pos", Arrays.stream(p1).boxed().collect(Collectors.toList()));
                put("peaks", Arrays.stream(p2).boxed().collect(Collectors.toList()));
            }},
                    actual = PickPeaks.getPeaks(array[n]);
            assertEquals(expected, actual, msg[n]);
        }
    }


    @Test
    public void moreTests() {
        for (int n = 5; n < msg.length; n++) {
            final int[] p1 = posS[n], p2 = peaksS[n];
            Map<String, List<Integer>> expected = new HashMap<String, List<Integer>>() {{
                put("pos", Arrays.stream(p1).boxed().collect(Collectors.toList()));
                put("peaks", Arrays.stream(p2).boxed().collect(Collectors.toList()));
            }},
                    actual = PickPeaks.getPeaks(array[n]);
            assertEquals(expected, actual, msg[n]);
        }
    }

    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        List<Integer> peaks = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        int peak = arr.length != 0 ? arr[0] : 0;
        int idx = 0;
        boolean isUpward = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > peak) {
                peak = arr[i];
                idx = i;
                isUpward = true;
            }
            if (arr[i] < peak) {
                if (isUpward && idx != 0 && idx != arr.length) {
                    peaks.add(peak);
                    pos.add(idx);
                }
                peak = arr[i];
                idx = i;
                isUpward = false;
            }
        }

        Map<String, List<Integer>> result = new HashMap<>();
        result.put("pos", pos);
        result.put("peaks", peaks);

        return result;
    }
}