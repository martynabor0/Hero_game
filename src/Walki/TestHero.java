package Walki;

import com.company.*;

import com.company.Hero;
import com.company.Nekromanta;
import com.company.Warrior;

public class TestHero {
    public static void main(String[] args) {

        //warrior&nekromanta
        Warrior warrior = Warrior.generateRandomWarrior();
        Nekromanta nekromanta = Nekromanta.generateRandomNekromanta();
        Hero winnerA = warrior.duel(nekromanta);
        System.out.println("The winner is: " + winnerA.name);

        //warrior&warrior
//        Warrior warrior1 = Warrior.generateRandomWarrior();
//        Warrior warrior2 = Warrior.generateRandomWarrior();
//        Hero winnerB = warrior1.duel(warrior2);
//        System.out.println("The winner is: " + winnerB.name);

        //nekromanta&nekromanta
//        Nekromanta nekromanta2 = Nekromanta.generateRandomNekromanta();
//        Nekromanta nekromanta3 = Nekromanta.generateRandomNekromanta();
//        Hero winnerC = nekromanta2.duel(nekromanta3);
//        System.out.println("The winner is: " + winnerC.name);


        //warrior&wizard
//        Warrior warrior3 = Warrior.generateRandomWarrior();
//        Wizard wizard = Wizard.generateRandomWizard();
//        Hero winnerD = warrior3.duel(wizard);
//        System.out.println("The winner is: " + winnerD.name);


        //wizard&wizard
//        Wizard wizard2 = Wizard.generateRandomWizard();
//        Wizard wizard3 = Wizard.generateRandomWizard();
//        Hero winnerE = wizard2.duel(wizard3);
//        System.out.println("The winner is: " + winnerE.name);


    }
}
