package io.github.sandeeplakka.codewars.kyu7;

/*
Sorted? yes? no? how?

Complete the method which accepts an array of integers, and returns one of the following:

    "yes, ascending" - if the numbers in the array are sorted in an ascending order
    "yes, descending" - if the numbers in the array are sorted in a descending order
    "no" - otherwise

You can assume the array will always be valid, and there will always be one correct answer.

Categories : Fundamentals, Arrays, Sorting, Algorithms

 */
class SortedOrNot {


    //FIXME : YTD
    public static String isSortedAndHow(int[] array) {
        final String NO = "no";
        final String ASCENDING = "yes, ascending";
        final String DESCENDING = "yes, descending";
        if (array == null) return "no";

        for (int i = 1; i < array.length; i++) {
            if (array[i] > 1) {
            }
        }
        boolean isSorted;

        return "";
    }

}