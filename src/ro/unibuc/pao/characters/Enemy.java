package ro.unibuc.pao.characters;

public class Enemy extends GameCharacter {
    private int attackPoints;

    // Constructorul clasei Enemy care primeste toate atributele
    public Enemy(String name, int healthPoints, int id, int level, int attackPoints) {
        super(name, healthPoints, id, level); // Apelam constructorul clasei parinte (GameCharacter) cu ajutorul cuvantului cheie "super"
        this.attackPoints = attackPoints; // Setam punctele de atac ale inamicului

    }

    // Constructorul clasei Enemy care primeste doar numele inamicului, hp-ul si id-ul
    public Enemy(String enemy1, int healthPoints, int id) {
    }

    // Metoda getter pentru ATTACKPOINTS
    public int getAttackPoints() {
        return attackPoints;
    }

    // Metoda setter pentru ATTACPOINTS
    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }
}
