package ro.unibuc.pao;

import ro.unibuc.pao.characters.Enemy;
import ro.unibuc.pao.characters.GameCharacter;
import ro.unibuc.pao.characters.YourPlayer;
import ro.unibuc.pao.items.Item;
import ro.unibuc.pao.services.GameService;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Creaza conexiunea la baza de date
       // Connection connection = DBConnection.getConnection();
        GameService gameService = new GameService();

        // Create an instance of CharacterDaoImpl
       /* CharacterDaoImpl characterDao = new CharacterDaoImpl(connection);

        // Call the read() method to retrieve a character's details
        int characterId = 1; // Example character ID
        GameCharacter character = characterDao.read(characterId);

        // Display the character's name
        if (character != null) {
            String characterName = character.getName();
            System.out.println("Character Name: " + characterName);
        } else {
            System.out.println("Character not found.");
        }*/


        // Exemplu de utilizare a serviciilor
        YourPlayer yourPlayer = new YourPlayer("Player1", 100, 0); // Creeaza o instanta a YourPlayer
        Enemy enemy = new Enemy("Enemy1", 50, 10); // Creeaza o instanta a Enemy

        //gameService.addCharacter(yourPlayer); // Adauga YourPlayer in GameService
        //gameService.addCharacter(enemy); // Adauga Enemy in GameService

        Item sword = new Item("Sword", 50); // Creeaza un obiect de tipul sword
        Item potion = new Item("Health Potion", 20); // Creeaza un obiect de tipul potion

        gameService.addItem(sword);
        gameService.addItem(potion);

        // Alte apeluri catre servicii sau logica jocului

        // Exemplu de actiuni:
        System.out.println("Lista de personaje:");
        List<GameCharacter> characters = gameService.getCharacters(); // Obtine lista de personaje
       if (!characters.isEmpty()) {
            for (GameCharacter character : characters) {
                System.out.println(character.getName()); // Afiseaza numele personajului
            }
        } else {
            System.out.println("Nu exista personaje in lista.");
        }

        System.out.println("Lista de obiecte:");
        for (Item item : gameService.getItems()) {
            System.out.println(item.getName()); // Afiseaza numele obiectului
        }

        yourPlayer.attack(enemy); // Ataca un inamic
    }
}
