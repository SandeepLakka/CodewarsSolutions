package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
L1: Set Alarm

Description:

Write a function named setAlarm which receives two parameters.
The first parameter, employed, is true whenever you are employed and the second parameter,
vacation is true whenever you are on vacation.

The function should return true if you are employed and not on vacation
(because these are the circumstances under which you need to set an alarm).
It should return false otherwise. Examples:

setAlarm(true, true) -> false
setAlarm(false, true) -> false
setAlarm(false, false) -> false
setAlarm(true, false) -> true

Categories : Fundamentals, Booleans
 */
public class Alarm {

    @Test
    public void setAlarmTest() {
        assertTrue(setAlarm(true, false), "Should be true.");
        assertFalse(setAlarm(true, true), "Should be false.");
        assertFalse(setAlarm(false, false), "Should be false.");
        assertFalse(setAlarm(false, true), "Should be false.");
    }

    @Test
    public void setAlarmV1Test() {
        assertTrue(setAlarmV1(true, false), "Should be true.");
        assertFalse(setAlarmV1(true, true), "Should be false.");
        assertFalse(setAlarmV1(false, false), "Should be false.");
        assertFalse(setAlarmV1(false, true), "Should be false.");
    }


    public static boolean setAlarm(boolean employed, boolean vacation) {
        return employed && !vacation;
    }

    public static boolean setAlarmV1(boolean employed, boolean vacation) {
        return employed ^ vacation && employed;
    }

}