package dk.via.store.dao;

import dk.via.store.*;

public class ItemDAOImpl implements ItemDAO {
    private final BookDAO bookDao;
    private final MusicDAO musicDao;

    public ItemDAOImpl(BookDAO bookDao, MusicDAO musicDao) {
        this.bookDao = bookDao;
        this.musicDao = musicDao;
    }

    private class Saver implements ItemVisitor<Item> {
        @Override
        public Item visit(Book book) {
            bookDao.save(book);
            return book;
        }

        @Override
        public Item visit(Music music) {
            musicDao.save(music);
            return music;
        }

        @Override
        public Item visit(Video video) {
            return video;
        }
    }

    private class Loader implements ItemVisitor<Item> {
        @Override
        public Item visit(Book book) {
            return bookDao.load();
        }

        @Override
        public Item visit(Music music) {
            return musicDao.load();
        }

        @Override
        public Item visit(Video video) {
            //...
            return null;
        }
    }

    @Override
    public void save(Item item) {
        Saver saver = new Saver();
        item.accept(saver);
    }

    public Item reload(Item item) {
        Loader loader = new Loader();
        return item.accept(loader);
    }
}
