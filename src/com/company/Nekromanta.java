package com.company;

import java.util.Random;

public class Nekromanta extends Wizard {

    private int mana;
    Szkielet szkielet;

    private void createSzkielet() {
        szkielet = new Szkielet((int) (0.4 * this.health), (2 * this.health));
    }

    Nekromanta(String name, int health, int strength, int mana) {
        super(name, health, strength,mana);
        this.mana = mana;
        createSzkielet();
    }


    public static Nekromanta generateRandomNekromanta() {

        Random randoom = new Random();

        int numberOfName = randoom.nextInt(names.length);
        int zdrowie = randoom.nextInt(40, 80) + 25;
        int sila = randoom.nextInt(5, 30) + 5;
        int maana = randoom.nextInt(50, 100);

        Nekromanta newNekromanta = new Nekromanta(names[numberOfName], zdrowie, sila, maana);

        System.out.println("New hero: " + newNekromanta.getClass().getSimpleName() + " name: " + newNekromanta.name + " zdrowie: " + newNekromanta.health + " siła:" + newNekromanta.strength + " mana: " + newNekromanta.mana);

        return newNekromanta;
    }

    public void magicAttack(Hero other) {
        if (other instanceof Magic) {
            System.out.println("Atak " + this.name + " na " + other.name + " nie wywołał obrażeń.");
        } else {
            Random random = new Random();
            float y = random.nextFloat(3);
            int damage = (int) (this.mana * y);
            other.health = other.health - damage;

            System.out.println(this.getClass().getSimpleName() + " " + this.name + " attacks with spell " + other.getClass().getSimpleName() + " " + other.name);
        }
    }


    public void attack(Hero other) {
        if (other instanceof Magic) {
            Random random2 = new Random();
            float y = random2.nextFloat(4);
            int damage = (int) (this.szkielet.strength * y);
            other.health = other.health - damage;
            System.out.println(this.getClass().getSimpleName() + " " + this.name + " attacks " + other.getClass().getSimpleName() + " " + other.name);
        } else {
            this.magicAttack(other);
        }
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


    class Szkielet {
        protected int health;
        protected int strength;

        Szkielet(int health, int strength) {
            this.health = health;
            this.strength = strength;
        }
    }
}
