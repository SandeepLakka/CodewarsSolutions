package io.github.sandeeplakka.codewars.kyu4;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeFormatter {
    @Test
    public void exampleTests() {
        assertEquals("1 second", formatDurationV1(1));
        assertEquals("1 minute and 2 seconds", formatDurationV1(62));
        assertEquals("2 minutes", formatDurationV1(120));
        assertEquals("1 hour", formatDurationV1(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", formatDurationV1(3662));
        assertEquals("99 days, 15 hours, 9 minutes and 14 seconds", formatDurationV1(8608154));
    }

    //inspired code
    public String formatDurationV1(int input) {
        if (input == 0) return "now";

        int minSecs = 60;
        int hrSecs = 60 * minSecs;
        int daySecs = 24 * hrSecs;
        int yearSecs = 365 * daySecs;
        int[] seconds = new int[]{yearSecs, daySecs, hrSecs, minSecs, 1};
        String[] values = new String[]{" year", " day", " hour", " minute", " second"};
        Queue<StringBuilder> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int val = input / seconds[i];
            if (val != 0) {
                queue.add(new StringBuilder().append(val).append(values[i]).append(val == 1 ? "" : "s"));
            }
            input = input % seconds[i];
        }
        if (queue.size() == 1) {
            return queue.poll().toString();
        }

        while (!queue.isEmpty()) {
            sb.append(queue.poll());
            if (queue.size() == 1) {
                sb.append(" and ");
            } else if (queue.size() > 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

}