package dk.via.store.dao;

import dk.via.store.Item;
import dk.via.store.Music;

public interface MusicDAO {
    void save(Music music);

    Music load();
}
