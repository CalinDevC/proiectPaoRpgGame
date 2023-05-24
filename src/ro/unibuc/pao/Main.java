package ro.unibuc.pao;

import ro.unibuc.pao.characters.Enemy;
import ro.unibuc.pao.characters.GameCharacter;
import ro.unibuc.pao.characters.YourPlayer;
import ro.unibuc.pao.items.Item;
import ro.unibuc.pao.persistence.CharacterDaoImpl;
import ro.unibuc.pao.persistence.DBConnection;
import ro.unibuc.pao.services.GameService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        // Creaza conexiunea la baza de date
        Connection connection = DBConnection.getConnection();
        GameService gameService = new GameService();

        // Creare instanta  CharacterDaoImpl
        CharacterDaoImpl characterDao = new CharacterDaoImpl(connection);

        // Call metoda read() ca sa imi afisesze dertaliile
        int characterId = 1; // Example character ID
        GameCharacter character = characterDao.read(characterId);

        // Afisez numele charului
        if (character != null) {
            String characterName = character.getName();
            System.out.println("Character Name: " + characterName);
        } else {
            System.out.println("Character not found.");
        }

        List<GameCharacter> gameCharacters = characterDao.readAll();
        for (GameCharacter gameCharacter : gameCharacters) {
            gameService.addCharacter(gameCharacter);
        }


        // Exemplu de utilizare a serviciilor

        // instantiere de noi personaje
        YourPlayer yourPlayer = new YourPlayer("Fat-Fricos", 100, 0, 6, 24); // Creeaza o instanta a YourPlayer
        Enemy enemy = new Enemy("Gica-Contra", 50, 4); // Creeaza o instanta a Enemy

        gameService.addCharacter(yourPlayer); // Adauga YourPlayer in GameService
        gameService.addCharacter(enemy); // Adauga Enemy in GameService

        Item sword = new Item("Sword", 50); // Creeaza un obiect de tipul sword
        Item potion = new Item("Health Potion", 20); // Creeaza un obiect de tipul potion

        gameService.addItem(sword);
        gameService.addItem(potion);

        // Alte apeluri catre servicii sau logica jocului

        // Exemplu de actiuni:
        // incarca lista de personaje din baza de date
        System.out.println("Lista de personaje:");
       List<GameCharacter> gamecharacters = gameService.getCharacters(); // Obtine lista de personaje
       if (!gamecharacters.isEmpty()) {
            for (GameCharacter each : gamecharacters) {
                System.out.println(each.getName()); // Afiseaza numele personajului
            }
        } else {
            System.out.println("Nu exista personaje in lista.");
        }
        // afiseaza obiectetele de tip Item instantiate (nu din DB)
        System.out.println("Lista de obiecte:");
        for (Item item : gameService.getItems()) {
            System.out.println(item.getName()); // Afiseaza numele obiectului
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti numele personajului dvs.:");
        String playerName = scanner.nextLine();

        System.out.println("Introduceti numele inamicului:");
        String enemyName = scanner.nextLine();

        //YourPlayer yourPlayer = null;
        //Enemy enemy = null;

       for (GameCharacter gameCharacter : gamecharacters) {
            if (character instanceof YourPlayer && character.getName().equals(playerName)) {
                yourPlayer = (YourPlayer) character;
            } else if (character instanceof Enemy && character.getName().equals(enemyName)) {
                enemy = (Enemy) character;
            }
        }
        if (yourPlayer != null && enemy != null) {
            yourPlayer.attack(enemy);
        } else {
            System.out.println("Personajul sau inamicul nu au fost gasiti.");
        }



        yourPlayer.attack(enemy);
        // personajul meu Ataca un inamic. (trebuie sa rezolv de ce il ia null personajul si inamicul)
        //rezolvat - constructorul la yourPlayer era doar cu 3 parametri
    }
}
