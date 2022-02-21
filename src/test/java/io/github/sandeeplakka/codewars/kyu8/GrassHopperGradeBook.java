package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Grasshopper - Grade book

Description:
Grade book

Complete the function so that it finds the average of the three scores passed
to it and returns the letter value associated with that grade.

Numerical Score 	Letter Grade
90 <= score <= 100 	'A'
80 <= score < 90 	'B'
70 <= score < 80 	'C'
60 <= score < 70 	'D'
0 <= score < 60 	'F'

Tested values are all between 0 and 100.
There is no need to check for negative values or values greater than 100.
Fundamentals
 */
public class GrassHopperGradeBook {

    @Test
    public void test1() {
        assertEquals('A', getGrade(95, 90, 93));
        assertEquals('A', getGrade(100, 85, 96));
        assertEquals('A', getGrade(92, 93, 94));
        assertEquals('A', getGrade(100, 100, 100));

        assertEquals('A', getGradeV1(95, 90, 93));
        assertEquals('A', getGradeV1(100, 85, 96));
        assertEquals('A', getGradeV1(92, 93, 94));
        assertEquals('A', getGradeV1(100, 100, 100));

        assertEquals('A', getGradeV2(95, 90, 93));
        assertEquals('A', getGradeV2(100, 85, 96));
        assertEquals('A', getGradeV2(92, 93, 94));
        assertEquals('A', getGradeV2(100, 100, 100));
    }

    @Test
    public void test2() {
        assertEquals('B', getGrade(70, 70, 100));
        assertEquals('B', getGrade(82, 85, 87));
        assertEquals('B', getGrade(84, 79, 85));

        assertEquals('B', getGradeV1(70, 70, 100));
        assertEquals('B', getGradeV1(82, 85, 87));
        assertEquals('B', getGradeV1(84, 79, 85));

        assertEquals('B', getGradeV2(70, 70, 100));
        assertEquals('B', getGradeV2(82, 85, 87));
        assertEquals('B', getGradeV2(84, 79, 85));
    }

    @Test
    public void test3() {
        assertEquals('C', getGrade(70, 70, 70));
        assertEquals('C', getGrade(75, 70, 79));
        assertEquals('C', getGrade(60, 82, 76));

        assertEquals('C', getGradeV1(70, 70, 70));
        assertEquals('C', getGradeV1(75, 70, 79));
        assertEquals('C', getGradeV1(60, 82, 76));

        assertEquals('C', getGradeV2(70, 70, 70));
        assertEquals('C', getGradeV2(75, 70, 79));
        assertEquals('C', getGradeV2(60, 82, 76));
    }

    @Test
    public void test4() {
        assertEquals('D', getGrade(65, 70, 59));
        assertEquals('D', getGrade(66, 62, 68));
        assertEquals('D', getGrade(58, 62, 70));

        assertEquals('D', getGradeV1(65, 70, 59));
        assertEquals('D', getGradeV1(66, 62, 68));
        assertEquals('D', getGradeV1(58, 62, 70));

        assertEquals('D', getGradeV2(65, 70, 59));
        assertEquals('D', getGradeV2(66, 62, 68));
        assertEquals('D', getGradeV2(58, 62, 70));
    }

    @Test
    public void test5() {
        assertEquals('F', getGrade(44, 55, 52));
        assertEquals('F', getGrade(48, 55, 52));
        assertEquals('F', getGrade(58, 59, 60));
        assertEquals('F', getGrade(0, 0, 0));

        assertEquals('F', getGradeV1(44, 55, 52));
        assertEquals('F', getGradeV1(48, 55, 52));
        assertEquals('F', getGradeV1(58, 59, 60));
        assertEquals('F', getGradeV1(0, 0, 0));

        assertEquals('F', getGradeV2(44, 55, 52));
        assertEquals('F', getGradeV2(48, 55, 52));
        assertEquals('F', getGradeV2(58, 59, 60));
        assertEquals('F', getGradeV2(0, 0, 0));
    }

    public static char getGrade(int s1, int s2, int s3) {
        int avg = (s1 + s2 + s3) / 3;
        return avg >= 90 ? 'A' : avg >= 80 ? 'B' : avg >= 70 ? 'C' : avg >= 60 ? 'D' : 'F';
    }

    //This kata problem is attempted to try this solution :))
    public static char getGradeV1(int s1, int s2, int s3) {
        //Dividing by 3 gives us the average in range 0-100,
        //Diving it further by 10 gives us value in range 0-10
        //Rounding down does not cause any harm, even more,
        //it is as per requirement
        switch ((s1 + s2 + s3) / 30) {
            case 10:
            case 9:
                return 'A';
            case 8:
                return 'B';
            case 7:
                return 'C';
            case 6:
                return 'D';
            default:
                return 'F';
        }
    }

    public static char getGradeV2(int s1, int s2, int s3) {
        //Dividing by 3 gives us the average in range 0-100,
        //Diving it further by 10 gives us value in range 0-10
        //Rounding down does not cause any harm, even more,
        //it is as per requirement
        return "FFFFFFDCBAA".charAt((s1 + s2 + s3) / 30);
    }


}