package persistence;

import java.util.List;

// interfata generica pentru operatii CRUD (lab 5)

public interface GameDao<T> {
    void create(T object);
    T read(int id);
    List<T> readAll();
    void update(T object);
    void delete(int id);
}