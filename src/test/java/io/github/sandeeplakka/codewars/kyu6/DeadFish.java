package io.github.sandeeplakka.codewars.kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DeadFish {

    @Test
    public void tests() {
        assertArrayEquals(new int[]{8, 64}, parse("iiisdoso"));
        assertArrayEquals(new int[]{8, 64, 3600}, parse("iiisdosodddddiso"));

    }

    public static int[] parse(String data) {
        // Implement me! :)
        List<Integer> result = new ArrayList<>();
        char[] options = data.toCharArray();
        int val = 0;
        for (char ch : options) {
            switch (ch) {
                case 'i':
                    val++;
                    break;
                case 'd':
                    val--;
                    break;
                case 's':
                    val *= val;
                    break;
                case 'o':
                    result.add(val);
                    break;
            }
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
