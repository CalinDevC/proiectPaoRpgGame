package ro.unibuc.pao.characters;

public class GameCharacter {
    private String name;
    protected int healthPoints;
    private int id;
    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GameCharacter(String name, int healthPoints, int id, int level) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.id = id;
        this.level = level;
    }

    public GameCharacter() {

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GameCharacter{");
        sb.append("name='").append(name).append('\'');
        sb.append(", healthPoints=").append(healthPoints);
        sb.append(", id=").append(id);
        sb.append(", level=").append(level);
        sb.append('}');
        return sb.toString();
    }

    protected int calculateDamage() {
        // va trebui sa implementez logica de calcul al daunelor
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