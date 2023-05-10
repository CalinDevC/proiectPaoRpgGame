import characters.Enemy;
import characters.GameCharacter;
import characters.YourPlayer;
import items.Item;
import services.GameService;

public class Main {
    public static void main(String[] args) {
        GameService gameService = new GameService();

        // Exemplu de utilizare a serviciilor
        YourPlayer yourPlayer = new YourPlayer("Player1", 100, 0);
        Enemy enemy = new Enemy("Enemy1", 50, 10);

        gameService.addCharacter(yourPlayer);
        gameService.addCharacter(enemy);

        Item sword = new Item("Sword", 50);
        Item potion = new Item("Health Potion", 20);

        gameService.addItem(sword);
        gameService.addItem(potion);

        // Alte apeluri catre servicii sau logica jocului

        // Exemplu de actiuni/interogari posibile:
        System.out.println("Lista de personaje:");
        for (GameCharacter character : gameService.getCharacters()) {
            System.out.println(character.getName());
        }

        System.out.println("Lista de obiecte:");
        for (Item item : gameService.getItems()) {
            System.out.println(item.getName());
        }

        yourPlayer.attack(enemy);
    }
}
