package com.company;

import java.util.Random;

public class Wizard extends Hero implements Magic {

    private int mana;

    Wizard(String name, int health, int strength, int mana) {
        super(name, health, strength);
        this.mana = mana;
    }

    public static Wizard generateRandomWizard() {
        Random random1 = new Random();

        int numberOfName = random1.nextInt(names.length);
        int zdrowie = random1.nextInt(30, 80)+25;
        int sila = random1.nextInt(10, 30)+5;
        int maana = random1.nextInt(60, 100);

        Wizard newWizard = new Wizard(names[numberOfName], zdrowie, sila, maana);

        System.out.println("New hero: " + newWizard.getClass().getSimpleName() + " name: " + newWizard.name + " zdrowie: " + newWizard.health + " siła:" + newWizard.strength + " mana: " + newWizard.mana);

        return newWizard;
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

    @Override
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

//    public void attack(Hero other) {
//        if (other instanceof Magic) {
//            Random random2 = new Random();
//            float y = random2.nextFloat(4);
//            int damage = (int) (this.strength * y);
//            other.health = other.health - damage;
//            System.out.println(this.getClass().getSimpleName() + " " + this.name + " attacks " + other.getClass().getSimpleName() + " " + other.name);
//        } else {
//            this.magicAttack(other);
//        }
//    }

    void attack(Hero other) {
        if (this.isAlive())
            if (!(other instanceof Magic))
                magicAttack(other);
            else {
                super.attack(other);
            }
    }

}
