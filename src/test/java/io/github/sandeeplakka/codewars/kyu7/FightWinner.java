package io.github.sandeeplakka.codewars.kyu7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Two fighters, one winner.

Description:

Create a function that returns the name of the winner in a fight between two fighters.

Each fighter takes turns attacking the other and whoever kills
the other first is victorious. Death is defined as having health <= 0.

Each fighter will be a Fighter object/instance. See the Fighter class below in your chosen language.

Both health and damagePerAttack (damage_per_attack for python)
will be integers larger than 0. You can mutate the Fighter objects.
Example:

public class Fighter {
  public String name;
  public int health, damagePerAttack;
  public Fighter(String name, int health, int damagePerAttack) {
    this.name = name;
    this.health = health;
    this.damagePerAttack = damagePerAttack;
  }
}

Categories : Fundamentals, Games, Algorithms, Classes, Basic Language Features, Object-oriented Programming
 */
public class FightWinner {
    @Test
    public void basicTests() {
        assertEquals("Lew",
                declareWinner(new Fighter("Lew", 10, 2),
                        new Fighter("Harry", 5, 4),
                        "Lew"));
        assertEquals("Harry",
                declareWinner(new Fighter("Lew", 10, 2),
                        new Fighter("Harry", 5, 4),
                        "Harry"));
        assertEquals("Harald",
                declareWinner(new Fighter("Harald", 20, 5),
                        new Fighter("Harry", 5, 4),
                        "Harry"));
        assertEquals("Harald",
                declareWinner(new Fighter("Harald", 20, 5),
                        new Fighter("Harry", 5, 4),
                        "Harald"));
        assertEquals("Harald",
                declareWinner(new Fighter("Jerry", 30, 3),
                        new Fighter("Harald", 20, 5),
                        "Jerry"));
        assertEquals("Harald",
                declareWinner(new Fighter("Jerry", 30, 3),
                        new Fighter("Harald", 20, 5),
                        "Harald"));
    }

    class Fighter {
        public String name;
        public int health, damagePerAttack;

        public Fighter(String name, int health, int damagePerAttack) {
            this.name = name;
            this.health = health;
            this.damagePerAttack = damagePerAttack;
        }

        public String getName() {
            return name;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getDamagePerAttack() {
            return damagePerAttack;
        }
    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        Fighter attacker = fighter1.getName().equals(firstAttacker) ? fighter1 : fighter2;
        Fighter punchingBag = attacker == fighter1 ? fighter2 : fighter1;

        while (fighter1.getHealth() > 0 && fighter2.getHealth() > 0) {
            punchingBag.setHealth(punchingBag.getHealth() - attacker.getDamagePerAttack());
            Fighter temp = attacker;
            attacker = punchingBag;
            punchingBag = temp;
        }
        return fighter1.getHealth() <= 0 ? fighter2.getName() : fighter1.getName();
    }
}

//Helper code

