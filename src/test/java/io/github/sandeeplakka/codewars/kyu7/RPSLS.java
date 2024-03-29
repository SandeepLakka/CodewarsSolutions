package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Rock Paper Scissors Lizard Spock

In this kata, your task is to implement an extended version of the famous rock-paper-scissors game.
The rules are as follows:

    Scissors cut Paper.
    Paper covers Rock.
    Rock crushes Lizard.
    Lizard poisons Spock.
    Spock smashes Scissors.
    Scissors decapitate Lizard.
    Lizard eats Paper.
    Paper disproves Spock.
    Spock vaporizes Rock.
    Rock crushes Scissors.

Task:
Given two values from the above game,
return the Player result as "Player 1 Won!", "Player 2 Won!", or "Draw!".

Inputs: Values will be given as one of "rock", "paper", "scissors", "lizard", "spock".


Categories : Fundamentals, Logic
 */
public class RPSLS {
    @Test
    void player1Wins() {
        assertEquals("Player 1 Won!", rpsls("rock", "lizard"));
        assertEquals("Player 1 Won!", rpsls("paper", "rock"));
        assertEquals("Player 1 Won!", rpsls("scissors", "lizard"));
        assertEquals("Player 1 Won!", rpsls("lizard", "paper"));
        assertEquals("Player 1 Won!", rpsls("spock", "rock"));
    }

    @Test
    void player2Wins() {
        assertEquals("Player 2 Won!", rpsls("lizard", "scissors"));
        assertEquals("Player 2 Won!", rpsls("spock", "lizard"));
        assertEquals("Player 2 Won!", rpsls("paper", "lizard"));
        assertEquals("Player 2 Won!", rpsls("scissors", "spock"));
        assertEquals("Player 2 Won!", rpsls("rock", "spock"));
    }

    @Test
    void draws() {
        assertEquals("Draw!", rpsls("rock", "rock"));
        assertEquals("Draw!", rpsls("spock", "spock"));
    }

    public static String rpsls(String player1, String player2) {

        if (player1.equals(player2)) return "Draw!";

        final String ROCK = "rock";
        final String PAPER = "paper";
        final String SCISSORS = "scissors";
        final String LIZARD = "lizard";
        final String SPOCK = "spock";
        final String RESULT = "Player %d Won!";
        final int PLAYER_1 = 1;
        final int PLAYER_2 = 2;
        Map<String, Set<String>> rules = new HashMap<>();


        rules.put(ROCK, new HashSet<>(Arrays.asList(SCISSORS, LIZARD)));
        rules.put(PAPER, new HashSet<>(Arrays.asList(ROCK, SPOCK)));
        rules.put(SCISSORS, new HashSet<>(Arrays.asList(PAPER, LIZARD)));
        rules.put(LIZARD, new HashSet<>(Arrays.asList(SPOCK, PAPER)));
        rules.put(SPOCK, new HashSet<>(Arrays.asList(SCISSORS, ROCK)));


        return String.format(RESULT,
                rules.get(player1).contains(player2) ?
                        PLAYER_1 :
                        PLAYER_2
        );

    }
}