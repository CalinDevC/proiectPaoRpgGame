package ro.unibuc.pao.characters;

public class YourPlayer extends GameCharacter {
    private int experiencePoints;

    public YourPlayer(String name, int healthPoints, int id, int level, int experiencePoints) {
        super(name, healthPoints, id, level);
        this.experiencePoints = experiencePoints;
    }

    public YourPlayer(String player1, int healthPoints, int id) {
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public void levelUp() {
        // aici trebuie sa bag logica de crestere a nivelului jucatorului
    }
}
