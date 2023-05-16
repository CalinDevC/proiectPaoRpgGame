package ro.unibuc.pao.services;

import ro.unibuc.pao.characters.GameCharacter;
import ro.unibuc.pao.items.Item;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private List<GameCharacter> characters;
    private List<Item> items;

    public GameService() {
        characters = new ArrayList<>();
        items = new ArrayList<>();
    }

    public void addCharacter(GameCharacter character) {
        characters.add(character);
    }

    public void removeCharacter(GameCharacter character) {
        characters.remove(character);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<GameCharacter> getCharacters() {
        return characters;
    }

    public List<Item> getItems() {
        return items;
    }
}
