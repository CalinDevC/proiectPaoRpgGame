package ro.unibuc.pao;

import ro.unibuc.pao.characters.Enemy;
import ro.unibuc.pao.characters.GameCharacter;
import ro.unibuc.pao.characters.YourPlayer;
import ro.unibuc.pao.items.Item;
import ro.unibuc.pao.services.GameService;

import java.util.List;

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

        // Exemplu de actiuni:
        System.out.println("Lista de personaje:");
        List<GameCharacter> characters = gameService.getCharacters(); // Obține lista de personaje
        if (!characters.isEmpty()) {
            for (GameCharacter character : characters) {
                System.out.println(character.getName());
            }
        } else {
            System.out.println("Nu există personaje în listă.");
        }

        System.out.println("Lista de obiecte:");
        for (Item item : gameService.getItems()) {
            System.out.println(item.getName());
        }

        yourPlayer.attack(enemy);
    }
}
