package dk.via.store;

public interface ItemVisitor<T> {
    T visit(Book book);
    T visit(Music music);
    T visit(Video video);
}
