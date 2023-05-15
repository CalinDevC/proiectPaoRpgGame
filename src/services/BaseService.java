package services;

import persistence.DBConnection;
import persistence.GameDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseService<T> {
    protected GameDao<T> dao;

    protected BaseService(GameDao<T> dao) {
        this.dao = dao;
    }

    public void create(T object) {
        try (Connection connection = DBConnection.getConnection()) {
            dao.create(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public T read(int id) {
        try (Connection connection = DBConnection.getConnection()) {
            return dao.read(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<T> readAll() {
        try (Connection connection = DBConnection.getConnection()) {
            return dao.readAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(T object) {
        try (Connection connection = DBConnection.getConnection()) {
            dao.update(object);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = DBConnection.getConnection()) {
            dao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}