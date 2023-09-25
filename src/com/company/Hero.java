package com.company;

import java.util.Random;

public abstract class Hero {
    protected static String[] names = {"Henryk", "John", "Marcus", "David", "Amadeusz", "Beniamin", "Cezary", "Eugeniusz"};
    public String name;
    protected int health;
    protected int strength;

    public String getName() {
        return name;
    }

    public String nameArmy;

    Hero(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
//        System.out.printf("Stwożony %s H:(%s) S:[%s]\n", getName(), this.health, this.strength);
    }

    boolean isAlive() {
        return this.health > 0;
    }

    void attack(Hero other) {
        Random random = new Random();
        float y = random.nextFloat(3);
        int damage = (int) (this.strength * y);
        other.health = other.health - damage;
        System.out.println(this.getClass().getSimpleName() + " " + this.name + " attacks " + other.getClass().getSimpleName() + " " + other.name);
    }

    public String getNameArmy() {
        return (this.nameArmy != null) ? this.nameArmy : "";
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

