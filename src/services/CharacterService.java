package services;

import characters.GameCharacter;

public class CharacterService extends BaseService<Character> {
    public CharacterService(GameCharacter dao) {
        super(dao);
    }
}
