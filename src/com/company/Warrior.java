package com.company;

import java.util.Random;

public class Warrior extends Hero {


    Warrior(String name, int health, int strength) {
        super(name, health, strength);
    }

    public static Warrior generateRandomWarrior() {
        Random random = new Random();

        int numberOfName = random.nextInt(names.length);

        int zdrowie = random.nextInt(50, 100);
        int sila = random.nextInt(20, 40);
        Warrior newWarrior = new Warrior(names[numberOfName], zdrowie, sila);
        System.out.println("New hero: " + newWarrior.getClass().getSimpleName() + " name: " + newWarrior.name + " zdrowie: " + newWarrior.health + " siła:" + newWarrior.strength);
        return newWarrior;
    }


   public Hero duel(Hero other) {
        while (this.isAlive() && other.isAlive()) {
            this.attack(other);
            other.attack(this);
        }
        if (this.isAlive()) {
            return this;
        } else {
            return other;
        }
    }

}
