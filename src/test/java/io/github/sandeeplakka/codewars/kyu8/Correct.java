package io.github.sandeeplakka.codewars.kyu8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Correct the mistakes of the character recognition software

Character recognition software is widely used to digitise printed texts. Thus the texts can be edited, searched and stored on a computer.

When documents (especially pretty old ones written with a typewriter), are digitised character recognition softwares often make mistakes.

Your task is correct the errors in the digitised text. You only have to handle the following mistakes:

    S is misinterpreted as 5
    O is misinterpreted as 0
    I is misinterpreted as 1

The test cases contain numbers only by mistake.

Categories : Fundamentals
 */
public class Correct {
    @Test
    public void testSomething() {
        assertEquals("IF-RUDYARD KIPLING", correct("1F-RUDYARD K1PL1NG"));
        assertEquals("ROBERT MERLE - THE DAY OF THE DOLPHIN", correct("R0BERT MERLE - THE DAY 0F THE D0LPH1N"));
        assertEquals("RICHARD P. FEYNMAN - THE FEYNMAN LECTURES ON PHYSICS", correct("R1CHARD P. FEYNMAN - THE FEYNMAN LECTURE5 0N PHY51C5"));
        assertEquals("RICHARD P. FEYNMAN - STATISTICAL MECHANICS", correct("R1CHARD P. FEYNMAN - 5TAT15T1CAL MECHAN1C5"));
        assertEquals("STEPHEN HAWKING - A BRIEF HISTORY OF TIME", correct("5TEPHEN HAWK1NG - A BR1EF H15T0RY 0F T1ME"));
        assertEquals("STEPHEN HAWKING - THE UNIVERSE IN A NUTSHELL", correct("5TEPHEN HAWK1NG - THE UN1VER5E 1N A NUT5HELL"));
        assertEquals("ERNEST HEMINGWAY - A FARWELL TO ARMS", correct("ERNE5T HEM1NGWAY - A FARWELL T0 ARM5"));
        assertEquals("ERNEST HEMINGWAY - FOR WHOM THE BELL TOLLS", correct("ERNE5T HEM1NGWAY - F0R WH0M THE BELL T0LL5"));
        assertEquals("ERNEST HEMINGWAY - THE OLD MAN AND THE SEA", correct("ERNE5T HEM1NGWAY - THE 0LD MAN AND THE 5EA"));
        assertEquals("J. R. R. TOLKIEN - THE LORD OF THE RINGS", correct("J. R. R. T0LK1EN - THE L0RD 0F THE R1NG5"));
        assertEquals("J. D. SALINGER - THE CATCHER IN THE RYE", correct("J. D. 5AL1NGER - THE CATCHER 1N THE RYE"));
        assertEquals("J. K. ROWLING - HARRY POTTER AND THE PHILOSOPHER'S STONE", correct("J. K. R0WL1NG - HARRY P0TTER AND THE PH1L050PHER'5 5T0NE"));
        assertEquals("J. K. ROWLING - HARRY POTTER AND THE CHAMBER OF SECRETS", correct("J. K. R0WL1NG - HARRY P0TTER AND THE CHAMBER 0F 5ECRET5"));
        assertEquals("J. K. ROWLING - HARRY POTTER AND THE PRISONER OF Azkaban", correct("J. K. R0WL1NG - HARRY P0TTER AND THE PR150NER 0F Azkaban"));
        assertEquals("J. K. ROWLING - HARRY POTTER AND THE GOBLET OF FIRE", correct("J. K. R0WL1NG - HARRY P0TTER AND THE G0BLET 0F F1RE"));
        assertEquals("J. K. ROWLING - HARRY POTTER AND THE ORDER OF PHOENIX", correct("J. K. R0WL1NG - HARRY P0TTER AND THE 0RDER 0F PH0EN1X"));
        assertEquals("J. K. ROWLING - HARRY POTTER AND THE HALF-BLOOD PRINCE", correct("J. K. R0WL1NG - HARRY P0TTER AND THE HALF-BL00D PR1NCE"));
        assertEquals("J. K. ROWLING - HARRY POTTER AND THE DEATHLY HALLOWS", correct("J. K. R0WL1NG - HARRY P0TTER AND THE DEATHLY HALL0W5"));
        assertEquals("URSULA K. LE GUIN - A WIZARD OF EARTHSEA", correct("UR5ULA K. LE GU1N - A W1ZARD 0F EARTH5EA"));
        assertEquals("URSULA K. LE GUIN - THE TOMBS OF ATUAN", correct("UR5ULA K. LE GU1N - THE T0MB5 0F ATUAN"));
        assertEquals("URSULA K. LE GUIN - THE FARTHEST SHORE", correct("UR5ULA K. LE GU1N - THE FARTHE5T 5H0RE"));
        assertEquals("URSULA K. LE GUIN - TALES FROM EARTHSEA", correct("UR5ULA K. LE GU1N - TALE5 FR0M EARTH5EA"));
    }

    public static String correct(String string) {
        StringBuilder builder = new StringBuilder();
        string.chars()
                .map(operand -> operand == '1' ? 'I' : operand == '0' ? 'O' : operand == '5' ? 'S' : operand)
                .forEach(value -> builder.append((char) value));
        return builder.toString();
    }
}