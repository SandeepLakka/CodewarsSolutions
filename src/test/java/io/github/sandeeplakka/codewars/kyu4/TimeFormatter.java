package io.github.sandeeplakka.codewars.kyu4;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeFormatter {

    @Test
    public void test_formatDuration() {
        testFunction(TimeFormatter::formatDuration);
    }

    @Test
    public void test_formatDurationV1() {
        testFunction(TimeFormatter::formatDurationV1);
    }

    public void testFunction(Function<Integer, String> testMethod) {
        assertEquals("1 second", testMethod.apply(1));
        assertEquals("1 minute and 2 seconds", testMethod.apply(62));
        assertEquals("2 minutes", testMethod.apply(120));
        assertEquals("1 hour", testMethod.apply(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", testMethod.apply(3662));
        assertEquals("now", testMethod.apply(0));
        assertEquals("99 days, 15 hours, 9 minutes and 14 seconds",
                testMethod.apply(8608154));
        assertEquals("182 days, 1 hour, 44 minutes and 40 seconds",
                testMethod.apply(15731080));
        assertEquals("4 years, 68 days, 3 hours and 4 minutes",
                testMethod.apply(132030240));
        assertEquals("6 years, 192 days, 13 hours, 3 minutes and 54 seconds",
                testMethod.apply(205851834));
        assertEquals("8 years, 12 days, 13 hours, 41 minutes and 1 second",
                testMethod.apply(253374061));
        assertEquals("7 years, 246 days, 15 hours, 32 minutes and 54 seconds",
                testMethod.apply(242062374));
        assertEquals("3 years, 85 days, 1 hour, 9 minutes and 26 seconds",
                testMethod.apply(101956166));
        assertEquals("1 year, 19 days, 18 hours, 19 minutes and 46 seconds",
                testMethod.apply(33243586));
    }

    public static String formatDuration(int seconds) {
        StringBuilder res = new StringBuilder();
        int[] units = new int[]{31536000, 86400, 3600, 60, 1};
        String[] labels = new String[]{"year", "day", "hour", "minute", "second"};

        if (seconds == 0) return "now";

        for (int i = 0; i < 5; i++) {
            if (seconds >= units[i]) {
                int q = seconds / units[i];
                seconds = seconds % units[i];
                res.append(res.toString().equals("") ? "" : (seconds == 0 ? " and " : ", "))
                        .append(q)
                        .append(" ")
                        .append(labels[i])
                        .append(q > 1 ? "s" : "");
            }
        }
        return res.toString();
    }

    //inspired code
    public static String formatDurationV1(int input) {
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