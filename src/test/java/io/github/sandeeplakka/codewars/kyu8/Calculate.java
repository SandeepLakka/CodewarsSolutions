package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Calculate BMI

Description:
Write function bmi that calculates body mass index (bmi = weight / height2).

if bmi <= 18.5 return "Underweight"
if bmi <= 25.0 return "Normal"
if bmi <= 30.0 return "Overweight"
if bmi > 30 return "Obese"

Categories  : Fundamentals
 */
public class Calculate {

    @Test
    public void testBMI() {
        assertEquals("Underweight", bmi(50, 1.80));
        assertEquals("Normal", bmi(80, 1.80));
        assertEquals("Overweight", bmi(90, 1.80));
        assertEquals("Obese", bmi(100, 1.80));
    }

    public static String bmi(double weight, double height) {
        double bmi = weight / (height * height);
        if (bmi <= 18.5) return "Underweight";
        if (bmi <= 25.0) return "Normal";
        if (bmi <= 30.0) return "Overweight";
        return "Obese";
    }
}