package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
Description:

Let us consider this example (array written in general format):

ls = [0, 1, 3, 6, 10]

Its following parts:

ls = [0, 1, 3, 6, 10]
ls = [1, 3, 6, 10]
ls = [3, 6, 10]
ls = [6, 10]
ls = [10]
ls = []

The corresponding sums are (put together in a list): [20, 20, 19, 16, 10, 0]

The function parts_sums (or its variants in other languages)
will take as parameter a list ls and return a list of the sums of its parts as defined above.
Other Examples:

ls = [1, 2, 3, 4, 5, 6]
parts_sums(ls) -> [21, 20, 18, 15, 11, 6, 0]

Categories : Algorithms, Fundamentals, Performance

 */
class SumParts {

    @Test
    public void tests() {
        assertArrayEquals(new int[]{0}, sumParts(new int[]{}));
        assertArrayEquals(new int[]{20, 20, 19, 16, 10, 0}, sumParts(new int[]{0, 1, 3, 6, 10}));
        assertArrayEquals(new int[]{21, 20, 18, 15, 11, 6, 0}, sumParts(new int[]{1, 2, 3, 4, 5, 6}));
        assertArrayEquals(new int[]{10037855, 9293730, 9292795, 9292388, 9291934, 9291504,
                        9291414, 9291270, 2581057, 2580168, 2579358, 0},
                sumParts(new int[]{744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358}));

    }

    @Test
    public void perfTests() {
        assertArrayEquals(new int[]{1171530, 1042036, 1033375, 950097, 792215, 720515, 544407,
                        403415, 357381, 313618, 280455, 268996, 238053, 210689, 166148, 0},
                sumParts(new int[]{129494, 8661, 83278, 157882, 71700, 176108, 140992, 46034,
                        43763, 33163, 11459, 30943, 27364, 44541, 166148}));

        assertArrayEquals(new int[]{1582707, 1575246, 1486454, 1468200, 1455164, 1267659,
                        1217738, 1169411, 999865, 836807, 649477, 488709, 323666, 287889, 147381, 0},
                sumParts(new int[]{7461, 88792, 18254, 13036, 187505, 49921, 48327,
                        169546, 163058, 187330, 160768, 165043, 35777, 140508, 147381}));

        assertArrayEquals(new int[]{1473471, 1303361, 1163791, 992247, 920477, 752659,
                        619653, 586025, 504153, 501010, 364153, 293433, 171326, 80135, 0},
                sumParts(new int[]{170110, 139570, 171544, 71770, 167818, 133006, 33628,
                        81872, 3143, 136857, 70720, 122107, 91191, 80135}));

        assertArrayEquals(new int[]{1438785, 1424554, 1287012, 1113665, 1093873, 1030043,
                        943003, 927382, 871114, 805673, 612409, 458581, 361260, 182144, 0},
                sumParts(new int[]{14231, 137542, 173347, 19792, 63830, 87040, 15621,
                        56268, 65441, 193264, 153828, 97321, 179116, 182144}));

        int[] input = new int[]{654379, 430, 3358426, 885, 902, 96, 933, 672, 895, 7310034, 6749922, 905, 1319962,
                4238020, 722, 565, 558, 133, 48, 217, 5450103, 3383902, 966, 7294724,
                686, 3700414, 4961574, 278149, 245, 598, 381};
        int[] expected = new int[]{48710446, 48056067, 48055637, 44697211, 44696326, 44695424, 44695328,
                44694395, 44693723, 44692828, 37382794, 30632872, 30631967, 29312005, 25073985, 25073263, 25072698,
                25072140, 25072007, 25071959, 25071742, 19621639, 16237737, 16236771, 8942047, 8941361,
                5240947, 279373, 1224, 979, 381, 0};
        assertArrayEquals(expected, sumParts(input));
    }

    public static int[] sumParts(int[] ls) {
        // your code
        if (ls == null) return null;
        int[] result = new int[ls.length + 1];
        for (int i = ls.length - 1; i >= 0; i--) {
            result[i] = ls[i] + result[i + 1];
        }
        return result;
    }
}