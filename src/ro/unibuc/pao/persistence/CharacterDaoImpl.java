package ro.unibuc.pao.persistence;

import ro.unibuc.pao.characters.GameCharacter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CharacterDaoImpl implements CharacterDao {
    private Connection connection;

    public CharacterDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(GameCharacter character) {
        String query = "INSERT INTO characters (id, name, level) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, character.getId());
            statement.setString(2, character.getName());
            statement.setInt(3, character.getLevel());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public GameCharacter read(int id) {
        String query = "SELECT * FROM gamecharacter WHERE id = ?";
        GameCharacter character = null;

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                character = new GameCharacter();
                character.setId(resultSet.getInt("id"));
                character.setName(resultSet.getString("name"));
                character.setLevel(resultSet.getInt("level"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return character;
    }

    @Override
    public List<GameCharacter> readAll() {
        String query = "SELECT * FROM gamecharacter";
        List<GameCharacter>  characters = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(query)) {


            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                GameCharacter character = new GameCharacter();
                character.setId(resultSet.getInt("id"));
                character.setName(resultSet.getString("name"));
                character.setLevel(resultSet.getInt("level"));
                characters.add(character);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return characters;
    }

    @Override
    public void update(GameCharacter character) {
        String query = "UPDATE characters SET name = ?, level = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, character.getName());
            statement.setInt(2, character.getLevel());
            statement.setInt(3, character.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM characters WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}