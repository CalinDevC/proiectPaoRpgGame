package ro.unibuc.pao.services;

import ro.unibuc.pao.persistence.GameDao;

public class CharacterService extends BaseService<Character> {
    public CharacterService(GameDao<Character> dao) {
        super(dao);
    }
}
