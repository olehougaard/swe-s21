package dk.via.store;

import java.math.BigDecimal;

public class Book extends Item {
    private final String isbn;
    private final String title;
    private final String[] authors;
    private final int pages;

    public Book(BigDecimal price, String isbn, String title, String[] authors, int pages) {
        super(price);
        this.isbn = isbn;
        this.title = title;
        this.authors = authors.clone();
        this.pages = pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return authors.clone();
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String getItemText() {
        return title;
    }

    @Override
    public<T> T accept(ItemVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
