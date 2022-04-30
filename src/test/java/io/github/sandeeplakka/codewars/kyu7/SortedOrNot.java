package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void testForAscending() {
        assertEquals("yes, ascending", isSortedAndHow(new int[]{1, 3, 5, 6, 7}));
        assertEquals("yes, ascending", isSortedAndHow(new int[]{1, 10, 100}));
    }

    @Test
    public void testForDescending() {
        assertEquals("yes, descending", isSortedAndHow(new int[]{100, 30, 15, 6}));
        assertEquals("yes, descending", isSortedAndHow(new int[]{100, 10, 1}));
    }

    @Test
    public void testForEquals() {
        assertEquals("no", isSortedAndHow(new int[]{1, 3, 5, 6, 2}));
        assertEquals("no", isSortedAndHow(new int[]{1, 10, 5}));
    }

    @Test
    public void randomTestsForNo() {

        assertEquals("no",
                isSortedAndHow(new int[]{-1451, -863, 11279, -2629, -3385, 19488, 13739}));
        assertEquals("no",
                isSortedAndHow(new int[]{-2548, 17025, -8292, 3950, -4727, 4337, 11716, 13285,
                        18485, 4388, -4406, 7382, 16573, 830, 10178, -4942, -9588, -5846, 831,
                        -2899, -7017, -7520, 9005, 9109, 14424, 3294, 3669, 7837, 10620, -8890,
                        11966, 9254, 4801, 7699, 763, 19850, 16131, 3192, 9493, 19940, 14822, -1181,
                        5558, -6802, -5345, 14038, -3887, 16708, -9876, 17174, 15256, 12534, -
                        4565, 3682, 3953, -3582, 13930, 6226, 13708, -2769, 15437, 11913, 15951,
                        -3313, -4681, -7889, 15732, -7299, 8794, -9068, 11916, -8602, 9589, 15564,
                        -5390, 7767, 11392, -8613, 672, 17522, 1565, -4948, 16435, 1766, 10063,
                        5743, 19371, 115, 160, -3088, -2810, 12869, -8629, 18184, 5397, 2357, 18341,
                        14233, 4547, 10764, 2216, 3568, -7217, -4926, 978, 6187, 4486, 17283, 18916,
                        6637, 13966, 15866, -3216, 6482, 12153, -2093, 11653, 4242, 3553, 8139, 7695,
                        19146, 19710, 5288, 18537, -5215, 4957, -8373, 9565, -4902, 7088, 4359, 8582,
                        19229, 3527, 865, 1322, 18378, 12198, -8169, 4924, -1263, -5937, -3997, 3565,
                        19181, -268, -7190, 14169, 15907, -337, 4394, -3408, -8238, 730, 14085, 16651,
                        286, 13140, 2538, 8532, 4270, -120}));
    }

    @Test
    public void randomTestsForYesAscending() {
        assertEquals("yes, ascending",
                isSortedAndHow(new int[]{-8582, -4387, 1100, 6332, 8115, 15349, 19322}));
        assertEquals("yes, ascending",
                isSortedAndHow(new int[]{-9271, -7481, -6137, -5730, -5467, -4485, -3980,
                        -3758, -2580, -2298, -1682, -1465, -1462, -1141, -684, 1455, 1531,
                        1686, 2331, 4260, 4486, 4586, 4607, 5176, 5256, 5904, 7166, 7181,
                        8498, 8835, 8882, 9114, 10204, 10812, 11293, 12039, 12421, 12451,
                        12839, 13195, 13294, 13329, 13942, 14157, 14286, 15061, 15206,
                        15580, 16435, 16835, 17380, 17510, 18341, 18427, 18508, 19009, 19245}));
        assertEquals("yes, ascending",
                isSortedAndHow(new int[]{-10000, -9993, -9992, -9989, -9987, -9987, -9987, -9986,
                        -9985, -9983, -9979, -9973, -9969, -9959, -9939, -9936, -9936, -9934, -9930,
                        -9930, -9923, -9923, -9918, -9916, -9913, -9912, -9911, -9905, -9904, -9904,
                        -9904, -9903, -9891, -9888, -9886, -9881, -9880, -9878, -9877, -9876, -9874,
                        -9874, -9874, -9873, -9872, -9871, -9870, -9867, -9865, -9861, -9861, -9860,
                        -9859, -9857, -9857, -9853, -9852, -9848, -9845, -9841, -9841, -9840, -9839,
                        -9837, -9835, -9832, -9832, -9825, -9823, -9822, -9822, -9820, -9817, -9812,
                        -9811, -9805, -9803, -9802, -9799, -9799, -9799, -9793, -9791, -9790, -9786,
                        -9783, -9780, -9776, -9771, -9767, -9767, -9761}));
    }

    @Test
    public void randomTestsForYesDescending() {
        assertEquals("yes, descending",
                isSortedAndHow(new int[]{19459, 19061, 18900, 18778, 18643, 18530, 18528, 18483,
                        18436, 18432, 17423, 17183, 17083, 17059, 17052, 16905, 16845, 16612,
                        16447, 16366, 16359, 16099, 15490, 15340, 15329, 15070, 15042, 14823,
                        14805, 14455, 14420, 13755, 13607, 13435, 13418, 13284, 13244, 13166,
                        13127, 13007, 12903, 12815, 12776, 12769, 12654, 12227, 12164, 12122,
                        12045, 11921, 11774, 11770, 11631, 11559, 11422, 11317, 10970, 10706,
                        10638, 10562, 9722, 9580, 9547, 9544, 9464, 9432, 9315, 9070, 8867,
                        8491, 8467, 8399, 8189, 8154, 8039, 7756, 7484, 7452, 7417, 7363,
                        7332, 7052, 6780, 6717, 6549, 6520, 6469, 6460, 6199, 5632, 5610,
                        5139, 5044, 4845, 4834, 4502, 4135, 3614, 3554, 3319, 2157, 2023,
                        1985, 1428, 1264, 1174, 1121, 1025, 778, 768, 721, 579, 529, 422,
                        66, -128, -426, -433, -823, -972, -1399, -1571, -1813, -1994, -2281,
                        -2308, -2585, -2619, -2755, -2786, -3213, -3272, -3586, -3619, -3650,
                        -3811, -3933, -3951, -4130, -4266, -4444, -4697, -5275, -5336, -5703,
                        -5711, -5824, -5856, -5881, -5994, -6070, -6087, -6314, -6559, -6927,
                        -6990, -7106, -7252, -7288, -7312, -7339, -7346, -7604, -7638, -7697,
                        -8007, -8107, -8140, -8267, -8295, -8332, -8339, -8497, -8707, -8718,
                        -8795, -8923, -9029, -9184, -9307, -9664, -9783, -9996, -9996}));
    }

    public static String isSortedAndHow(int[] array) {
        final String NO = "no";
        final String ASCENDING = "yes, ascending";
        final String DESCENDING = "yes, descending";
        if (array == null) return "no";

        boolean isSorted = true;
        boolean isAscending = array[0] <= array[array.length - 1];

        for (int i = 1; i < array.length; i++) {
            if (isAscending) {
                if (array[i - 1] > array[i]) {
                    isSorted = false;
                    break;
                }
            } else {
                if (array[i - 1] < array[i]) {
                    isSorted = false;
                    break;
                }
            }
        }

        isAscending = isAscending && isSorted;

        return (isSorted ? (isAscending ? ASCENDING : DESCENDING) : NO);
    }

}