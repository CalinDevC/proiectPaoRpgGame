package ro.unibuc.pao.characters;

public class Enemy extends GameCharacter {
    private int attackPoints;

    public Enemy(String name, int healthPoints, int id, int level, int attackPoints) {
        super(name, healthPoints, id, level);
        this.attackPoints = attackPoints;

    }

    public Enemy(String enemy1, int healthPoints, int id) {
    }


    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }
}
