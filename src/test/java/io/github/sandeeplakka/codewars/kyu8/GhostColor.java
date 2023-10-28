package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

/*
Create a class Ghost

Ghost objects are instantiated without any arguments.

Ghost objects are given a random color attribute of "white" or "yellow" or "purple" or "red" when instantiated

Ghost ghost = new Ghost();
ghost.getColor(); //=> "white" or "yellow" or "purple" or "red"

Categories : Object-oriented Programming, Fundamentals
 */
public class GhostColor {

    public String getColor() {
        Random random = new Random();
        String[] colors = {"white", "yellow", "purple", "red"};
        int randomValue = random.nextInt(colors.length);
        return colors[randomValue];
    }


    private List<String> ghostColors = new ArrayList<>();

    public GhostColor() {
        for (int i = 1; i <= 100; i++) {
            ghostColors.add(getColor());
        }
    }

    private boolean ghostColor(List<String> ghostColors, String color) {
        boolean answer = false;

        for (String ghostColor : ghostColors) {
            if (ghostColor.equals(color)) {
                answer = true;
                break;
            }
        }

        return answer;
    }

    @Test
    public void should_sometimes_make_white_ghosts() {
        assertTrue(ghostColor(ghostColors, "white"), "No white ghost found.");
    }

    @Test
    public void should_sometimes_make_yellow_ghosts() {
        assertTrue(ghostColor(ghostColors, "yellow"), "No yellow ghost found.");
    }

    @Test
    public void should_sometimes_make_purple_ghosts() {
        assertTrue(ghostColor(ghostColors, "purple"), "No purple ghost found.");
    }

    @Test
    public void should_sometimes_make_red_ghosts() {
        assertTrue(ghostColor(ghostColors, "red"), "No red ghost found.");
    }
}
