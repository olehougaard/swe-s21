package dk.via.store.dao;

import dk.via.store.Book;
import dk.via.store.Item;

public interface BookDAO {
    void save(Book book);

    Item load();
}
