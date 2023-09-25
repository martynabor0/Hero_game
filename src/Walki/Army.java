package Walki;

import com.company.*;

import java.util.Arrays;
import java.util.Random;

public class Army {

    String name;
    Hero[] members;

//    private List<Hero> myArmy;


    public Army(int size, String name) {
        this.members = new Hero[size];
        this.name = name;
    }

    public static Army generateRandomArmy(int size, String name) {
        Army newArmy = new Army(size, name);

        for (int i = 0; i < size; i++) {

            switch (new Random().nextInt(3)) {
                case 0:
                    newArmy.members[i] = Warrior.generateRandomWarrior();
                    break;
                case 1:
                    newArmy.members[i] = Nekromanta.generateRandomNekromanta();
                    break;
                case 2:
                    newArmy.members[i] = Wizard.generateRandomWizard();
                    break;
            }
            newArmy.members[i].nameArmy = name; //ustawia na herosie nazwe armii do której przynalezy
        }
        return newArmy;
    }


    public Army battle(Army enemies) {
        int thisMyArmy = this.members.length;
        int enmMyArmy = enemies.members.length;
        int t = 0, e = 0;

        while (true) {
            if (this.members[t].duel(enemies.members[e]) == this.members[t])
                e++;
            else
                t++;

            if (t == thisMyArmy)
                return enemies;
            else if (e == enmMyArmy)
                return this;
        }

    }

    public void opis() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.members.length; i++) {
            System.out.print(members[i].name + " ");
        }
        System.out.println();
    }


}
