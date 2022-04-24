package io.github.sandeeplakka.codewars.kyu6;

/*
Triple Sorting - Sort & Stringify a list by 3 attributes

Tale University is a bit messy, and can't maintain an ordered list of their student.
Tale's dean wants to print a sortet list of his students by the gpa, last name and age
and post it on the walls so everybody can be impressed of his great students.

Given a list of students, sort them by (from most important to least important):
    GPA (descending)
    First letter of last name (ascending)
    Age (ascending)

And the class Student:

class Student {
    ...
  int getGpa()
  int getAge();
  String getFullName();
}

Return the sorted result as full names string, comma separated.

For Example, given the list (name, age, gpa):
    David Goodman, 23, 88
    Mark Rose, 25, 82
    Jane Doe, 22, 90
    Jane Dane, 25, 90

sort(students) should return "Jane Doe,Jane Dane,David Goodman,Mark Rose"

Categories : Algorithms, Streams, IO, Strings, Collections, Lists, Data Structures
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripleSorter {


    @Test
    public void basicTest() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(23, 88, "David Goodman"));
        students.add(new Student(25, 82, "Mark Rose"));
        students.add(new Student(22, 90, "Jane Doe"));
        students.add(new Student(25, 90, "Jane Dane"));
        assertEquals("Jane Doe,Jane Dane,David Goodman,Mark Rose",
                TripleSorter.sort(students));
    }

    @Test
    public void sameGpasAndAgesTest() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(25, 90, "Roi Foodman"));
        students.add(new Student(25, 90, "Ben Pose"));
        students.add(new Student(25, 90, "Reed Zapata"));
        students.add(new Student(25, 90, "Jane Doe"));
        assertEquals("Jane Doe,Roi Foodman,Ben Pose,Reed Zapata",
                TripleSorter.sort(students));
    }

    @Test
    public void randomTests() {
        assertEquals("276 278,812 641,396 824,413 181,539 433,333 " +
                "256,846 412,942 981,275 952,826 769", sort(new ArrayList<Student>() {{
            add(new Student(24, 95, "276 278"));
            add(new Student(52, 69, "942 981"));
            add(new Student(34, 76, "539 433"));
            add(new Student(95, 65, "826 769"));
            add(new Student(58, 89, "396 824"));
            add(new Student(68, 84, "413 181"));
            add(new Student(50, 90, "812 641"));
            add(new Student(64, 67, "275 952"));
            add(new Student(95, 69, "846 412"));
            add(new Student(35, 72, "333 256"));
        }}));

        assertEquals("570 908,742 3,762 955,428 290," +
                "167 862,745 89,223 369,489 942,877 900,106 969", sort(new ArrayList<Student>() {{
            add(new Student(29, 89, "742 3"));
            add(new Student(85, 72, "223 369"));
            add(new Student(23, 79, "167 862"));
            add(new Student(21, 76, "745 89"));
            add(new Student(45, 60, "106 969"));
            add(new Student(98, 65, "877 900"));
            add(new Student(21, 88, "762 955"));
            add(new Student(90, 87, "428 290"));
            add(new Student(57, 66, "489 942"));
            add(new Student(83, 94, "570 908"));
        }}));

        assertEquals("124 667,958 51,256 351,415 867," +
                "336 604,178 484,924 125,234 372,201 259,133 964", sort(new ArrayList<Student>() {{
            add(new Student(26, 94, "958 51"));
            add(new Student(21, 71, "178 484"));
            add(new Student(55, 98, "124 667"));
            add(new Student(61, 74, "336 604"));
            add(new Student(92, 84, "415 867"));
            add(new Student(38, 89, "256 351"));
            add(new Student(57, 65, "201 259"));
            add(new Student(34, 62, "133 964"));
            add(new Student(48, 70, "234 372"));
            add(new Student(69, 70, "924 125"));
        }}));

        assertEquals("569 193,220 807,44 231,913 759," +
                "725 966,624 579,952 946,155 680,878 327,894 110", sort(new ArrayList<Student>() {{
            add(new Student(21, 69, "878 327"));
            add(new Student(86, 79, "725 966"));
            add(new Student(55, 92, "569 193"));
            add(new Student(23, 60, "894 110"));
            add(new Student(99, 70, "155 680"));
            add(new Student(26, 84, "913 759"));
            add(new Student(31, 89, "44 231"));
            add(new Student(96, 91, "220 807"));
            add(new Student(86, 71, "952 946"));
            add(new Student(90, 76, "624 579"));
        }}));
        assertEquals("473 927,177 545,534 749,902 710," +
                "866 801,440 291,459 503,308 793,77 139,528 695", sort(new ArrayList<Student>() {{
            add(new Student(99, 76, "459 503"));
            add(new Student(62, 81, "440 291"));
            add(new Student(64, 99, "473 927"));
            add(new Student(21, 93, "534 749"));
            add(new Student(31, 60, "528 695"));
            add(new Student(22, 89, "902 710"));
            add(new Student(93, 95, "177 545"));
            add(new Student(87, 69, "308 793"));
            add(new Student(22, 66, "77 139"));
            add(new Student(61, 88, "866 801"));
        }}));
    }

    public static String sort(List<Student> students) {
        String res = students.stream()
                .sorted(
                        Comparator.comparing(Student::getGpa).reversed()
                                .thenComparing(TripleSorter::LastNameFirstChar)
                                .thenComparing(Student::getAge)
                ).map(Student::getFullName)
                .collect(Collectors.joining(","));
        System.out.println("assertEquals(\"" + res + "\", sort(" + toStr(students) + "));");
        return res;
    }

    private static Character LastNameFirstChar(Student student) {
        return student.getFullName().split(" ")[1].charAt(0);
    }

    private static String toStr(List<Student> students) {
        StringBuilder builder = new StringBuilder();
        builder.append("new ArrayList<Student>(){{\n");
        for (Student student : students) {
            builder.append("add(new Student(")
                    .append(student.getAge()).append(",")
                    .append(student.getGpa()).append(",\"")
                    .append(student.getFullName()).append("\"));")
                    .append("\n");
        }
        builder.append("}}");
        return builder.toString();
    }

    static class Student {
        private int gpa;
        private int age;
        private String fullName;

        public Student(int age, int gpa, String fullName) {
            this.gpa = gpa;
            this.age = age;
            this.fullName = fullName;
        }

        public int getGpa() {
            return gpa;
        }

        public int getAge() {
            return age;
        }

        public String getFullName() {
            return fullName;
        }
    }
}