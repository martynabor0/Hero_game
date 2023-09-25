package Walki;

public class TestArmies {
    public static void main(String[] args) {
        Army redTeam = Army.generateRandomArmy(4, "The Red Team");
        redTeam.opis();

        Army blueTeam = Army.generateRandomArmy(5, "The Blue Team");
        blueTeam.opis();


        System.out.println("The winner is: " + redTeam.battle(blueTeam).name);


    }
}
