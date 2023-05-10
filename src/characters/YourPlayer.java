package characters;

public class YourPlayer extends GameCharacter {
    private int experiencePoints;

    public YourPlayer(String name, int healthPoints, int experiencePoints) {
        super(name, healthPoints);
        this.experiencePoints = experiencePoints;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public void levelUp() {
        // aici trebuie sa bag logica de creștere a nivelului jucătorului
    }
}
