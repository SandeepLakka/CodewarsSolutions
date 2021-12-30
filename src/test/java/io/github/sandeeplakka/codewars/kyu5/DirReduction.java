package io.github.sandeeplakka.codewars.kyu5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
 * Once upon a time, on a way through the old wild mountainous west,…
 * … a man was given directions to go from one point to another.
 * The directions were "NORTH", "SOUTH", "WEST", "EAST".
 * Clearly "NORTH" and "SOUTH" are opposite, "WEST" and "EAST" too.

 * Going to one direction and coming back the opposite direction right away is a needless effort.
 * Since this is the wild west, with dreadfull weather and not much water, it's important to save yourself some energy, otherwise you might die of thirst!
 * How I crossed a mountainous desert the smart way.
 * The directions given to the man are, for example, the following (depending on the language):
 * ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
 * You can immediatly see that going "NORTH" and immediately "SOUTH" is not reasonable,
 * better stay to the same place! So the task is to give to the man a simplified version of the plan.
 * A better plan in this case is simply:

 * ["WEST"]

 * Other examples:

 * In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH"
 * is going north and coming back right away.

 * The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, therefore,
 * the final result is [] (nil in Clojure).

 * In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH"
 * are not directly opposite but they become directly opposite after the
 * reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].
 * Task

 * Write a function dirReduc which will take an array of strings and returns an array of strings
 * with the needless directions removed (W<->E or S<->N side by side).

 * See more examples in "Sample Tests:"
 * Notes

 * Not all paths can be made simpler. The path ["NORTH", "WEST", "SOUTH", "EAST"] is not reducible.
 * "NORTH" and "WEST", "WEST" and "SOUTH", "SOUTH" and "EAST" are not directly
 * opposite of each other and can't become such.
 * Hence the result path is itself : ["NORTH", "WEST", "SOUTH", "EAST"].
 * if you want to translate, please ask before translating.

 * Categories : Fundamentals
 */
public class DirReduction {

    @Test
    public void testSimpleDirReduc() {
        assertArrayEquals(new String[]{"WEST"},
                dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}),
                "\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"");
        assertArrayEquals(new String[]{},
                dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}),
                "\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"");
        assertArrayEquals(new String[]{"WEST"},
                dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}),
                "\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"");
        assertArrayEquals(new String[]{},
                dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}),
                "\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"");
        assertArrayEquals(new String[]{"NORTH"},
                dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH","NORTH"}),
                "\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\",\"NORTH\"");
        assertArrayEquals(new String[]{"EAST", "NORTH"},
                dirReduc(new String[]{"EAST", "EAST", "WEST", "NORTH", "WEST", "EAST", "EAST", "SOUTH", "NORTH", "WEST"}),
                "\"EAST\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\", \"EAST\", \"EAST\", \"SOUTH\", \"NORTH\", \"WEST\"");
        assertArrayEquals(new String[]{"NORTH", "EAST"},
                dirReduc(new String[]{"NORTH", "EAST", "NORTH", "EAST", "WEST", "WEST", "EAST", "EAST", "WEST", "SOUTH"}),
                "\"NORTH\", \"EAST\", \"NORTH\", \"EAST\", \"WEST\", \"WEST\", \"EAST\", \"EAST\", \"WEST\", \"SOUTH\"");
        assertArrayEquals(new String[]{"NORTH", "WEST", "SOUTH", "EAST"},
                dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}),
                "\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\"");
        assertArrayEquals(new String[]{"WEST", "WEST"},
                dirReduc(new String[]{"EAST", "WEST", "WEST", "WEST"}),
                "\"EAST\", \"WEST\", \"WEST\", \"WEST\"");
    }

    public static String[] dirReduc(String[] arr) {
        final String NORTH = "NORTH";
        final String SOUTH = "SOUTH";
        final String EAST = "EAST";
        final String WEST = "WEST";
        Stack<String> stack = new Stack<>();

        BiConsumer<String,String> popIfMatch = (val, dir) -> {
            if(!stack.isEmpty() && stack.peek().equals(dir)) {
                stack.pop();
            } else {
                stack.push(val);
            }
        };

        for(String val : arr){
            switch (val){
                case EAST:
                    popIfMatch.accept(EAST, WEST);
                    break;
                case WEST:
                    popIfMatch.accept(WEST, EAST);
                    break;
                case NORTH:
                    popIfMatch.accept(NORTH, SOUTH);
                    break;
                case SOUTH:
                    popIfMatch.accept(SOUTH, NORTH);
                    break;
            }
        }
        return  stack.toArray(new String[]{});
    }

}
