package characters;

public class Enemy extends GameCharacter {
    private int attackPoints;

    public Enemy(String name, int healthPoints, int attackPoints) {
        super(name, healthPoints);
        this.attackPoints = attackPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }
}
