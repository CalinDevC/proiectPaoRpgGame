package ro.unibuc.pao.persistence;

import java.util.List;

// interfata generica pentru operatii CRUD (lab 5)

public interface GameDao<T> {
    void create(T object);  // Creaza n obiect de tipul specificat in DB
    T read(int id); // Citeste un obiect de tipul specificat in DB
    List<T> readAll(); // Citeste toate obiectele de acelasi tip in DB
    void update(T object); //chiar vrei sa ma schimbi?
    void delete(int id); //serios? vrei sa ma stergi?

}