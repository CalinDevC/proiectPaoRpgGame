package characters;

public class GameCharacter {
    private String name;
    protected int healthPoints;

    public GameCharacter(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void attack(GameCharacter target) {
        int damage = calculateDamage();

        System.out.println(name + " is attacking " + target.getName() + " with " + damage + " damage.");

        target.takeDamage(damage);
    }

    protected int calculateDamage() {
        // Aici va trebui sa implementez logica de calcul al daunelor
        // in functie de caracteristicile personajului (mai e mult pana departe :)))

        return 20;
    }

    protected void takeDamage(int damage) {
        healthPoints -= damage;

        System.out.println(name + " takes " + damage + " damage.");

        if (healthPoints <= 0) {
            System.out.println(name + " has been defeated.");
        }
    }
}